package ${ClassDetail.packageStr}.dao;

import static ${ClassDetail.packageStr}.dao.${ClassDetail.className}DynamicSqlSupport.${ClassDetail.className?uncap_first};
<#list ClassDetail.attributeList as attribute>
    import static ${ClassDetail.packageStr}.dao.${ClassDetail.className}DynamicSqlSupport.${attribute.attributeName};
</#list>
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualToWhenPresent;
import static org.mybatis.dynamic.sql.SqlBuilder.isIn;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.delete.DeleteDSL;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.BatchInsert;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.render.RenderingStrategy;
import org.mybatis.dynamic.sql.select.SelectDSL;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

import ${ClassDetail.packageStr}.entities.${ClassDetail.className};
import com.hogae.core.dao.ICrudDao;
import com.hogae.core.entities.Page;
import com.hogae.core.paging.LimitAndOffsetAdapter;

@Mapper
public interface ${ClassDetail.className}Mapper extends ICrudDao<${ClassDetail.className},<#list ClassDetail.attributeList as attribute><#if attribute.attributeName==ClassKey>${attribute.attributeType}</#if></#list>>{

@SelectProvider(type=SqlProviderAdapter.class, method="select")
long count(SelectStatementProvider selectStatement);

@UpdateProvider(type=SqlProviderAdapter.class, method="update")
int update(UpdateStatementProvider updateStatement);

@DeleteProvider(type=SqlProviderAdapter.class, method="delete")
int delete(DeleteStatementProvider deleteStatement);

@InsertProvider(type=SqlProviderAdapter.class, method="insert")
int insert(InsertStatementProvider<${ClassDetail.className}> insertStatement);

@SelectProvider(type=SqlProviderAdapter.class, method="select")
@ResultMap("${ClassDetail.className}Result")
${ClassDetail.className} selectOne(SelectStatementProvider selectStatement);

@SelectProvider(type=SqlProviderAdapter.class, method="select")
@Results(id="${ClassDetail.className}Result", value = {
<#list ClassDetail.attributeList as attribute>
    <#if attribute.attributeName==ClassKey>
        @Result(column="_${attribute.attributeName?replace("([a-z])([A-Z]+)","$1_$2","r")?lower_case}", property="${attribute.attributeName}", jdbcType=JdbcType.<#if attribute.attributeType=='String'>VARCHAR</#if>, id=true)
    <#else>
        ,@Result(column="${attribute.attributeName?replace("([a-z])([A-Z]+)","$1_$2","r")?lower_case}", property="${attribute.attributeName}", jdbcType=JdbcType.VARCHAR),
    </#if>
</#list>

@Result(column="_id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
@Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
@Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
@Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
@Result(column="memo", property="memo", jdbcType=JdbcType.VARCHAR),
@Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
@Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
})
List<${ClassDetail.className}> selectMany(SelectStatementProvider selectStatement);


default Long count() {
return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
.from(${ClassDetail.className?uncap_first}).build().execute();
}

default Long count(${ClassDetail.className} record) {
return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
.from(${ClassDetail.className?uncap_first}).where(${ClassKey}, isEqualToWhenPresent(record::getId))
<#list ClassDetail.attributeList as attribute>
    <#if attribute.attributeName!=ClassKey>.and(${attribute.attributeName}, isEqualToWhenPresent(record::get${attribute.attributeName?cap_first}))</#if>
</#list>
.build().execute();
}


default int insert(${ClassDetail.className} record) {
return insert(SqlBuilder.insert(record)
.into(${ClassDetail.className?uncap_first})
<#list ClassDetail.attributeList as attribute>
    .map(${attribute.attributeName}).toProperty("${attribute.attributeName}")
</#list>
.build()
.render(RenderingStrategy.MYBATIS3));
}


default int insertSelective(${ClassDetail.className} record) {
return insert(SqlBuilder.insert(record)
.into(${ClassDetail.className?uncap_first})
<#list ClassDetail.attributeList as attribute>
    .map(${attribute.attributeName}).toPropertyWhenPresent("${attribute.attributeName}", record::get${attribute.attributeName?cap_first})
</#list>
.build()
.render(RenderingStrategy.MYBATIS3));
}


default int insertBatchSelective(List<${ClassDetail.className}> records) {
BatchInsert<${ClassDetail.className}> batchInsert = SqlBuilder.insert(records)
.into(${ClassDetail.className?uncap_first})
<#list ClassDetail.attributeList as attribute>
    .map(${attribute.attributeName}).toProperty("${attribute.attributeName}")
</#list>
.build()
.render(RenderingStrategy.MYBATIS3);
batchInsert.insertStatements().stream().forEach(this::insert);
return 0;
}

default int updateByPrimaryKey(${ClassDetail.className} record) {
return UpdateDSL.updateWithMapper(this::update, ${ClassDetail.className?uncap_first})
<#list ClassDetail.attributeList as attribute>
    <#if attribute.attributeName!=ClassKey>
        .set(${attribute.attributeName}).equalTo(record::get${attribute.attributeName?cap_first})
    </#if>
</#list>
.where(${ClassKey}, isEqualTo(record::getId))
.build()
.execute();
}


default int updateByPrimaryKeySelective(${ClassDetail.className} record) {
return UpdateDSL.updateWithMapper(this::update, ${ClassDetail.className?uncap_first})
<#list ClassDetail.attributeList as attribute>
    <#if attribute.attributeName!=ClassKey>
        .set(${attribute.attributeName}).equalToWhenPresent(record::get${attribute.attributeName?cap_first})
    </#if>
</#list>
.where(${ClassKey}, isEqualTo(record::getId))
.build()
.execute();
}

default int deleteByPrimaryKey(<#list ClassDetail.attributeList as attribute><#if attribute.attributeName==ClassKey>${attribute.attributeType}</#if></#list> id_) {
return DeleteDSL.deleteFromWithMapper(this::delete, ${ClassDetail.className?uncap_first})
.where(${ClassKey}, isEqualTo(id_))
.build()
.execute();
}

default int deleteByPrimaryKeys(List<<#list ClassDetail.attributeList as attribute><#if attribute.attributeName==ClassKey>${attribute.attributeType}</#if></#list>> ids) {
return DeleteDSL.deleteFromWithMapper(this::delete, ${ClassDetail.className?uncap_first})
.where(${ClassKey}, isIn(ids))
.build()
.execute();
}

default int delete(${ClassDetail.className} record) {
return DeleteDSL.deleteFromWithMapper(this::delete, ${ClassDetail.className?uncap_first})
<#list ClassDetail.attributeList as attribute>
    <#if attribute.attributeName!=ClassKey>
        <#if attribute_index==1>
            .where(${attribute.attributeName}, isEqualToWhenPresent(record::get${attribute.attributeName?cap_first}))
        <#else>
            .and(${attribute.attributeName}, isEqualToWhenPresent(record::get${attribute.attributeName?cap_first}))
        </#if>
    </#if>
</#list>
.build().execute();
}

default ${ClassDetail.className} selectByPrimaryKey(<#list ClassDetail.attributeList as attribute><#if attribute.attributeName==ClassKey>${attribute.attributeType}</#if></#list> id_) {
return SelectDSL.selectWithMapper(this::selectOne<#list ClassDetail.attributeList as attribute>, ${attribute.attributeName}</#list>)
.from(${ClassDetail.className?uncap_first})
.where(${ClassKey}, isEqualTo(id_))
.build()
.execute();
}

default List<${ClassDetail.className}> selectByPrimaryKeys(List<<#list ClassDetail.attributeList as attribute><#if attribute.attributeName==ClassKey>${attribute.attributeType}</#if></#list>> ids) {
return SelectDSL.selectWithMapper(this::selectMany <#list ClassDetail.attributeList as attribute>, ${attribute.attributeName}</#list>)
.from(${ClassDetail.className?uncap_first})
.where(${ClassKey}, isIn(ids))
.build()
.execute();
}

default List<${ClassDetail.className}> select() {
return SelectDSL.selectWithMapper(this::selectMany<#list ClassDetail.attributeList as attribute>, ${attribute.attributeName}</#list>)
.from(${ClassDetail.className?uncap_first}).build().execute();
}

default List<${ClassDetail.className}> select(${ClassDetail.className} record) {
return SelectDSL.selectWithMapper(this::selectMany<#list ClassDetail.attributeList as attribute>, ${attribute.attributeName}</#list>)
.from(${ClassDetail.className?uncap_first})
<#list ClassDetail.attributeList as attribute>
    <#if attribute.attributeName!=ClassKey>
        <#if attribute_index==1>
            .where(${attribute.attributeName}, isEqualToWhenPresent(record::get${attribute.attributeName?cap_first}))
        <#else>
            .and(${attribute.attributeName}, isEqualToWhenPresent(record::get${attribute.attributeName?cap_first}))
        </#if>
    </#if>
</#list>
.build().execute();
}

default List<${ClassDetail.className}> selectByPaging(${ClassDetail.className} record,Page page) {
return SelectDSL.select(selectModel -> LimitAndOffsetAdapter.of(selectModel, this::selectMany, (page.getPageNum()-1)*page.getPageSize(), page.getPageSize())
<#list ClassDetail.attributeList as attribute>, ${attribute.attributeName}</#list>)
.from(${ClassDetail.className?uncap_first})
<#list ClassDetail.attributeList as attribute>
    <#if attribute.attributeName!=ClassKey>
        <#if attribute_index==1>
            .where(${attribute.attributeName}, isEqualToWhenPresent(record::get${attribute.attributeName?cap_first}))
        <#else>
            .and(${attribute.attributeName}, isEqualToWhenPresent(record::get${attribute.attributeName?cap_first}))
        </#if>
    </#if>
</#list>
.build().execute();
}
}