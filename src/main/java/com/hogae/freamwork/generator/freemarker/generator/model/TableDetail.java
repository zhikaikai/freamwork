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

package com.hogae.freamwork.generator.freemarker.generator.model;

import java.util.ArrayList;
import java.util.List;

public class TableDetail {

//	public String dataBaseName;

    public String tableName;

    public List<ColumnDetail> columnList = new ArrayList<ColumnDetail>();

    public void add(ColumnDetail columnDetail) {
        columnList.add(columnDetail);
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<ColumnDetail> getColumnList() {
        return columnList;
    }

    public void setColumnList(List<ColumnDetail> columnList) {
        this.columnList = columnList;
    }


}
