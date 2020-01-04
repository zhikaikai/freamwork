package ${ClassDetail.packageStr}.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.hogae.cms.entities.${ClassDetail.className};
import com.hogae.cms.service.I${ClassDetail.className}Service;
import com.hogae.core.service.ICrudService;
import com.hogae.core.web.CrudController;

public class MenuController extends CrudController<${ClassDetail.className},<#list ClassDetail.attributeList as attribute><#if attribute.attributeName==ClassKey>${attribute.attributeType}</#if></#list>>{

@Autowired
public I${ClassDetail.className}Service<${ClassDetail.className},<#list ClassDetail.attributeList as attribute><#if attribute.attributeName==ClassKey>${attribute.attributeType}</#if></#list>> service;

@Override
public ICrudService<${ClassDetail.className}, <#list ClassDetail.attributeList as attribute><#if attribute.attributeName==ClassKey>${attribute.attributeType}</#if></#list>> getService() {
return service;
}


}
