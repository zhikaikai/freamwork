package com.hogae.cms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hogae.cms.dao.MenuMapper;
import com.hogae.cms.entities.Menu;
import com.hogae.cms.service.IMenuService;
import com.hogae.core.dao.ICrudDao;

@Service
public class MenuService implements IMenuService
<Menu,String> {

@Autowired
MenuMapper mapper;

@Override
public ICrudDao
<Menu,String> getDao() {
return mapper;
}


}
