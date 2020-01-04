package ${ClassDetail.packageStr}.entities;

<#list EntityImport as import>
    <#if import=='Date'>
        import java.util.Date;
    <#elseif import=='Map' >
        import java.util.Map;
    <#elseif import=='List' >
        import java.util.List;
    </#if>
</#list>
import com.hogae.core.entities.BaseEntity;

public class ${ClassDetail.className} extends BaseEntity{
/**
*
*/
private static final long serialVersionUID = 1L;

<#list ClassDetail.attributeList as attribute>

    private    ${attribute.attributeType} ${attribute.attributeName};
</#list>

<#list ClassDetail.attributeList as attribute>

    public    ${attribute.attributeType} get${attribute.attributeName?cap_first}(){
    return ${attribute.attributeName};
    }

    public void set${attribute.attributeName?cap_first}(${attribute.attributeType} ${attribute.attributeName}) {
    <#if attribute.attributeType=='String'>
        this.${attribute.attributeName} = ${attribute.attributeName} == null ? null : ${attribute.attributeName}.trim();
    <#else>
        this.${attribute.attributeName} = ${attribute.attributeName};
    </#if>
    }
</#list>

}
