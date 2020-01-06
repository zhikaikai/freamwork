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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.ServerRequest;

import javax.validation.Valid;
import java.util.List;

public interface WebController<K, M extends Model<K>> extends InsertController<K, M>, UpdateController<K, M>, QueryController<K, M>, DeleteController<K, M> {

    WebService<K, M> getService();

    @RequestMapping("/**")
    default JsonResponse<Void> unmappedRequest(ServerRequest request) {
        String uri = request.path();
        return JsonResponse.error(new Exception("请求资源不存在！路径:" + uri));
    }

    @PostMapping("/list")
    default JsonResponse<List<M>> list(@RequestBody(required = false) Pagination<M> body) {
        if (body == null) body = new Pagination<M>();
        List<M> list = getService().queryByPagination(body);
        return JsonResponse.sucess().setData(list);
    }


    @GetMapping("/{id}")
    default JsonResponse<M> getEntity(@PathVariable("id") K id) {
        M t = getService().getById(id);
        if (t == null) {
            JsonResponse.error(new Exception("请输入正确的ID"));
        }
        return JsonResponse.sucess().setData(t);
    }

    @DeleteMapping("/del")
    default JsonResponse<Void> delete(@RequestBody List<K> ids) {
        getService().deleteByIds(ids);
        return JsonResponse.sucess();
    }


    @DeleteMapping("/del/{id}")
    default JsonResponse<Void> delete(@PathVariable("id") K id) {
        int result = getService().deleteById(id);
        if (result == 0) {
            JsonResponse.error(new Exception("请输入正确的ID"));
        }
        return JsonResponse.sucess().setMsg("删除成功!ID:" + id);
    }


    @PutMapping("/update")
    default JsonResponse<Void> update(@RequestBody M t) {
        getService().updateSelective(t);
        return JsonResponse.sucess();
    }


    @PutMapping("/create")
    default JsonResponse<Void> create(@Valid @RequestBody M t) {
        getService().insertSelective(t);
        return JsonResponse.sucess();
    }

}
