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

package com.hogae.freamwork.core.service;

import com.hogae.freamwork.web.dao.Dao;
import com.hogae.freamwork.web.model.Pagination;

import java.util.List;

public interface Service<K, M> {

    Dao<K, M> getDao();

    default int insert(M model) {
        return getDao().insert(model);
    }

    default int insertSelective(M model) {
        return getDao().insertSelective(model);
    }

    default int insertBatch(List<M> listModel) {
        return getDao().insertBatch(listModel);
    }

    default int update(M model) {
        return getDao().update(model);
    }

    default int updateSelective(M model) {
        return getDao().updateSelective(model);
    }

    default int deleteById(K key){
        return getDao().deleteById(key);
    }
    default int deleteByIds(List<K> listKey){
        return getDao().deleteByIds(listKey);
    }
    default int deleteSelective(M model){
        return getDao().deleteSelective(model);
    }

    default M getById(K key){
        return getDao().getById(key);
    }

    default List<M> getByIds(List<K> listKey){
        return getDao().getByIds(listKey);
    }

    default List<M> queryAll(M model){
        return getDao().queryAll(model);
    }

    default List<M> queryByPagination(Pagination<M> pagination) {
        return getDao().queryByPagination(pagination);
    }

    default int queryCount(M model) {
        return getDao().queryCount(model);
    }

    default List<M> distinctField(M model) {
        return getDao().distinctField(model);
    }

//    default void truncateTable(String tableName){
//        getDao().truncateTable(tableName);
//    }
//    default int select1(){
//        return getDao().select1();
//    }
}
