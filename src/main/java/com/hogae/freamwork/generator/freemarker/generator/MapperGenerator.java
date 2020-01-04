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
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

@Component
public class MapperGenerator extends AbstractGenerator {

    public Map<String, Object> dataModel;

    public String fileName = "Mapper.ftl";

    @Override
    public void process() throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
        // TODO Auto-generated method stub
        Template temp = getTemplate(fileName);
        Writer out = new OutputStreamWriter(System.out);
        temp.process(dataModel, out);
    }


    public MapperGenerator setDataModel(Map<String, Object> dataModel) {
        this.dataModel = dataModel;
        return this;
    }


}
