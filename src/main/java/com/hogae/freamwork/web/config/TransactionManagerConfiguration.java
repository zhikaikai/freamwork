/*
 * Copyright [2020] [hogae.com]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hogae.freamwork.web.config;

import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.interceptor.*;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
public class TransactionManagerConfiguration {

    @Autowired
    private DataSource dataSource;

    @Bean("txManager")
    public DataSourceTransactionManager txManager() {
        return new DataSourceTransactionManager(dataSource);
    }

    /*事务拦截器*/
    @Bean("txAdvice")
    public TransactionInterceptor txAdvice(DataSourceTransactionManager txManager) {

        NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();

        RuleBasedTransactionAttribute readOnly = new RuleBasedTransactionAttribute();
        readOnly.setReadOnly(true);
        readOnly.setPropagationBehavior(TransactionDefinition.PROPAGATION_NOT_SUPPORTED);

        RuleBasedTransactionAttribute required = new RuleBasedTransactionAttribute();
        required.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
        required.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        required.setTimeout(TransactionDefinition.TIMEOUT_DEFAULT);

        Map<String, TransactionAttribute> txMap = new HashMap<>();
        txMap.put("add*", required);
        txMap.put("save*", required);
        txMap.put("insert*", required);
        txMap.put("update*", required);
        txMap.put("delete*", required);
        txMap.put("get*", readOnly);
        txMap.put("query*", readOnly);
        txMap.put("find*", readOnly);
        txMap.put("select*", readOnly);
        source.setNameMap(txMap);
        return new TransactionInterceptor(txManager, source);
    }

    /**
     * 切面拦截规则 参数会自动从容器中注入
     */
    @Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisor(TransactionInterceptor txAdvice) {
        DefaultPointcutAdvisor pointcutAdvisor = new DefaultPointcutAdvisor();
        pointcutAdvisor.setAdvice(txAdvice);
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* com.hogae.*.service.impl.*.*(..))");
        pointcutAdvisor.setPointcut(pointcut);
        return pointcutAdvisor;
    }

}