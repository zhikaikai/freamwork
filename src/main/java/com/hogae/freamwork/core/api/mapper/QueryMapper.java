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

package com.hogae.freamwork.core.api.mapper;

import com.hogae.freamwork.core.api.Mapper;
import com.hogae.freamwork.web.model.Pagination;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface QueryMapper<K, M> extends Mapper {
    @Validated
    @NotNull M getById(K key);

    List<M> getByIds(List<K> listKey);

    List<M> queryAll(M model);

    <S extends M> List<M> queryByPagination(Pagination<S> pagination);

    <S extends M> long queryCount(S model);

    List<M> distinctField(String fieldName, M model);
}
