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

package com.hogae.freamwork.generator.freemarker.generator;

import freemarker.core.ParseException;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public abstract class AbstractGenerator {

	@Autowired
	public Configuration configuration;

	public Template getTemplate(String fileName) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException {
		return configuration.getTemplate(fileName);
	}

	public abstract void process() throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException;


}
