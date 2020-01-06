package ${ClassDetail.packageStr}.dao;

<#list ClassDetail.attributeList as attribute>
    import static ${ClassDetail.packageStr}.dao.${ClassDetail.className}DynamicSqlSupport.${attribute.attributeName};
</#list>