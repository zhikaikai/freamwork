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

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class DruidConfiguration {


    /**
     * 默认实现 com.alibaba.druid.spring.boot.autoconfigure.stat.DruidStatViewServletConfiguration
     * 默认实现配置 spring.datasource.druid.stat-view-servlet.enabled=true
     * 默认值为 true，所以不用配置就可以访问管理界面 http://localhost:8080/druid/index.html
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        // IP白名单
        servletRegistrationBean.addInitParameter("allow", "*");
        // IP黑名单(共同存在时，deny优先于allow)
//        servletRegistrationBean.addInitParameter("deny", "192.168.1.201");
        //控制台管理用户
        servletRegistrationBean.addInitParameter("loginUsername", "admin");
        servletRegistrationBean.addInitParameter("loginPassword", "admin");
        //是否能够重置数据 禁用HTML页面上的“Reset All”功能
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        return servletRegistrationBean;
    }

    /**
     * 默认实现 com.alibaba.druid.spring.boot.autoconfigure.stat.DruidWebStatFilterConfiguration
     * 默认实现配置 spring.datasource.druid.web-stat-filter.enabled=true
     * 默认值为 true，所以不用配置就可以用
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
//        exclusions配置
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
//        sessionStatMaxCount配置，缺省sessionStatMaxCount是1000个。你可以按需要进行配置
//        filterRegistrationBean.addInitParameter("sessionStatMaxCount","1000");
//        sessionStatEnable配置，session统计功能
//        filterRegistrationBean.addInitParameter("sessionStatEnable","false");
//        principalSessionName配置，你可以配置principalSessionName，使得druid能够知道当前的session的用户是谁
//        根据需要，把其中的xxx.user修改为你user信息保存在session中的sessionName。
//        注意：如果你session中保存的是非string类型的对象，需要重载toString方法。
//        filterRegistrationBean.addInitParameter("principalSessionName","xxx.user");
//        principalCookieName配置，如果你的user信息保存在cookie中，你可以配置principalCookieName，
//        使得druid知道当前的user是谁
//        根据需要，把其中的xxx.user修改为你user信息保存在cookie中的cookieName
//        filterRegistrationBean.addInitParameter("principalCookieName","xxx.user");
//        druid 0.2.7版本开始支持profile，配置profileEnable能够监控单个url调用的sql列表。
        filterRegistrationBean.addInitParameter("profileEnable", "true");
        return filterRegistrationBean;
    }

    /**
     * Filter 默认提供stat,config,encoding,slf4j,log4j,log4j2,commons-log,wall过滤器，
     *
     *  #属性类型是字符串，通过别名的方式配置扩展插件，常用的插件有：
     *       #监控统计用的filter:stat
     *       #日志用的filter:log4j
     *       #防御sql注入的filter:wall
     *       #config [java -cp druid-1.0.16.jar com.alibaba.druid.filter.config.ConfigTools you_password]
     *       #生成一下三行，并配置启用config
     *       #privateKey:MIIBVgIBADANBgkqhkiG9w0BAQEFAASCAUAwggE8AgEAAkEA4D9/Qbkl6PKJ5jutUYlWkifM2l4KCtq1nDZugxrgCfPbPmaW99mg3lQtnJkF9vGrIVd0FWCcMF+0J7K4HAZJ6wIDAQABAkEA3l6Y9rd+3E0GagRrjhs+eZh2D2SJWNIgnVNsqx2PZM1MvOxmlSJSiHbLl/t43LOReuv8pIgn2WsPsCR40r+YoQIhAPrw7ekUVTK5P9Hlltc3JrOgZYBSS8NcYCO5bjko4UQfAiEA5MTO/yfyAQi6VvYOE1z/DNAR3IDGG+X/LoFxYhIa4LUCIBqUtr6/tp6e3NHA/g9h+imAzf+fuALDoDNoivJnECWFAiEAtDo01aHzr0rf+sioeCrIqKB3od81tB7zdgD2gYu/7w0CIQDAKzpgOqhqOqPwBzLl2GIXWc3KahvqfItPOfhm8E6EzA==
     *       #publicKey:MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAOA/f0G5JejyieY7rVGJVpInzNpeCgratZw2boMa4Anz2z5mlvfZoN5ULZyZBfbxqyFXdBVgnDBftCeyuBwGSesCAwEAAQ==
     *       #password:3W2Eiw9QU3jdVy5/3RqCNICkY8O7iKzDuV+HIC0OTbv9x+3tZclWS+fKCRNtQOtfgJpMFXPZGcpYRsYJ+gndSA==
     *       #mergeStat 统计sql合并
     *       #wall 防火墙
     *       #stat统计sql的执行时常，如果wall配置在stat之前，则stat不统计wall的时常，反之则统计时常中包含拦截检查时常
     *
     * spring boot 配置中，默认关闭，其他需要手动开启
     *     spring.datasource.druid.filter.stat.enabled=false
     *     spring.datasource.druid.filter.config.enabled=false
     *     spring.datasource.druid.filter.encoding.enabled=false
     *     spring.datasource.druid.filter.slf4j.enabled=false
     *     spring.datasource.druid.filter.log4j.enabled=false
     *     spring.datasource.druid.filter.log4j2.enabled=false
     *     spring.datasource.druid.filter.commons-log.enabled=false
     *     spring.datasource.druid.filter.wall.enabled=false
     *
     *
     *
     */

    /**
     * 拦截器  Druid提供了Spring和Jdbc的关联监控。
     * com.alibaba.druid.support.spring.stat.DruidStatInterceptor是一个标准的Spring MethodInterceptor
     * 默认方法拦截
     * spring boot 默认配置类 com.alibaba.druid.spring.boot.autoconfigure.stat.DruidSpringAopConfiguration
     *
     * 如果要使用方法名正则匹配拦截，直接配置即可 spring.datasource.druid.aop-patterns
     */


}