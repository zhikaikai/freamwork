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

package com.hogae.freamwork.core.model;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class Pagination<M> {

    final static int DEFAULT_PAGE_SIZE = 10;

    final static int DEFAULT_PAGE_NUMBER = 1;

    private M model;
    /**
     * 总条数
     */
    private int count;
    /**
     * 当前页数
     */
    private int pageNumber = DEFAULT_PAGE_NUMBER;
    /**
     * 显示条数
     */
    private int pageSize = DEFAULT_PAGE_SIZE;
    /**
     * 分页总数
     */
    private int pageCount;

    public Pagination() {

    }

    public Pagination(int count, int pageNumber, int pageSize) {
        super();
        this.count = count;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.pageCount = (count + pageSize - 1) / pageSize;
    }

    public Pagination(int count, int pageNumber) {
        super();
        this.count = count;
        this.pageCount = (count + pageSize - 1) / pageSize;
        if (this.pageCount < pageNumber) {
            this.pageNumber = 1;
        } else {
            this.pageNumber = pageNumber <= 0 ? 1 : pageNumber;
        }
    }

    public Pagination(int count) {
        super();
        this.count = count;
        this.pageCount = (count + pageSize - 1) / pageSize;
    }

}
