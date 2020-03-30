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

package com.hogae.cms.service.impl;

import com.hogae.cms.mapper.MenuMapper;
import com.hogae.cms.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MenuService implements IMenuService {

	@Autowired
	MenuMapper menuDao;

	@Override
	public MenuMapper getDao() {
		return menuDao;
	}


	@Override
	public List<String> getTables() throws Exception {
		return getDao().getTables();
	}

	@Override
	public List<Map<String, Object>> getTableColumns(String tableName) throws Exception {
		return getDao().getTableColumns(tableName);
	}

	@Override
	public int deleteById(Integer key) {
		getDao().deleteById(key);
		return 1 / 0;
	}
}
