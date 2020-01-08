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

package com.hogae.freamwork.web.controller;

import com.hogae.freamwork.core.api.model.Model;
import com.hogae.freamwork.web.api.web.DeleteController;
import com.hogae.freamwork.web.api.web.InsertController;
import com.hogae.freamwork.web.api.web.QueryController;
import com.hogae.freamwork.web.api.web.UpdateController;
import com.hogae.freamwork.web.model.JsonResponse;
import com.hogae.freamwork.web.model.Pagination;
import com.hogae.freamwork.web.service.WebService;
import com.hogae.freamwork.web.validator.KeyCheck;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;
import java.util.List;

public interface WebController<K, M extends Model<K>> extends InsertController<K, M>, UpdateController<K, M>, QueryController<K, M>, DeleteController<K, M> {

    WebService<K, M> getService();

    @PostMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    default JsonResponse<List<M>> list(@RequestBody(required = false) Pagination<M> body) {
        if (body == null) body = new Pagination<M>();
        List<M> list = getService().queryByPagination(body);
        return JsonResponse.sucess().setData(list);
    }


    @GetMapping(value = "/{id}")
    default JsonResponse<M> getEntity(@Validated @PathVariable("id") K id) {
        M t = getService().getById(id);
        if (t == null) {
            return JsonResponse.error(new Exception("请输入正确的ID"));
        }
        return JsonResponse.sucess().setData(t);
    }

    @DeleteMapping(value = "/del", produces = MediaType.APPLICATION_JSON_VALUE)
    default JsonResponse<Void> delete(@RequestBody List<@NotNull K> ids) {
        getService().deleteByIds(ids);
        return JsonResponse.sucess();
    }


    @GetMapping(value = "/del/{id}")
    default JsonResponse<Void> delete(@PathVariable("id") K id) {
        int result = getService().deleteById(id);
        if (result == 0) {
            JsonResponse.error(new Exception("请输入正确的ID"));
        }
        return JsonResponse.sucess().setMsg("删除成功!ID:" + id);
    }


    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    default JsonResponse<Void> update(@Validated({KeyCheck.class, Default.class}) @RequestBody M t) {
        getService().updateSelective(t);
        return JsonResponse.sucess();
    }


    @PutMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    default JsonResponse<Void> create(@Validated @RequestBody M t) {
        getService().insertSelective(t);
        return JsonResponse.sucess();
    }
}
