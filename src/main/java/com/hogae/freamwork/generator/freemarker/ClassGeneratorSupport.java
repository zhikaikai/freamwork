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

package com.hogae.freamwork.generator.freemarker;

import com.hogae.freamwork.generator.freemarker.generator.*;
import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class ClassGeneratorSupport {

	@Autowired
	ControllerGenerator controllerGenerator;

	@Autowired
	DaoxmlGenerator daoxmlGenerator;

	@Autowired
	EntityGenerator entityGenerator;

	@Autowired
	IServiceGenerator iServiceGenerator;

	@Autowired
	MapperGenerator mapperGenerator;

	@Autowired
	ServiceImplGenerator serviceImplGenerator;

	@Autowired
	DaoGenerator daoGenerator;


	public void createFile(Map<String, Object> dataModel) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
//		controllerGenerator.setDataModel(dataModel).process();
		entityGenerator.setDataModel(dataModel).process();
//		daoxmlGenerator.setDataModel(dataModel).process();
//		iServiceGenerator.setDataModel(dataModel).process();
//		mapperGenerator.setDataModel(dataModel).process();
//		serviceImplGenerator.setDataModel(dataModel).process();
//		daoGenerator.setDataModel(dataModel).process();

	}
}
