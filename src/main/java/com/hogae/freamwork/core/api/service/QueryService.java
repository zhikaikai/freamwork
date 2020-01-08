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

package com.hogae.freamwork.core.api.service;

import com.hogae.freamwork.core.api.Service;
import com.hogae.freamwork.web.model.Pagination;

import java.util.List;

public interface QueryService<K, M> extends Service {

    M getById(K key);

    List<M> getByIds(List<K> listKey);

    List<M> queryAll(M model);

    List<M> queryByPagination(Pagination<M> pagination);

    int queryCount(M model);

    List<M> distinctField(String fieldName, M model);

}
