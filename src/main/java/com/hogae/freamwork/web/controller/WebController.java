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

import com.hogae.freamwork.core.model.Model;
import com.hogae.freamwork.core.service.Service;
import com.hogae.freamwork.web.model.JsonResponse;
import com.hogae.freamwork.web.model.Pagination;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface WebController<K, M extends Model<K>> extends DefaultController {

    Service<K, M> getService();

    @PostMapping("/list")
    default JsonResponse<List<M>> list(@RequestBody(required = false) Pagination<M> body) throws Exception {
        if (body == null) body = new Pagination<M>();
        List<M> list = getService().queryByPagination(body);
        return JsonResponse.sucess().setData(list);
    }


    @GetMapping("/{id}")
    default JsonResponse<M> getEntity(@PathVariable("id")K id) throws Exception {
        M t = getService().getById(id);
        if(t==null){
            throw new Exception("请输入正确的ID");
        }
        return JsonResponse.sucess().setData(t);
    }

    @DeleteMapping("/del")
    default JsonResponse<Void> add(@RequestBody List<K> ids) throws Exception {
        getService().deleteByIds(ids);
        return JsonResponse.sucess();
    }


    @DeleteMapping("/del/{id}")
    default JsonResponse<Void> add(@PathVariable("id")K id) throws Exception {
        int result = getService().deleteById(id);
        if(result==0){
            throw new Exception("请输入正确的ID");
        }
        return JsonResponse.sucess().setMsg("删除成功!ID:"+id);
    }


    @PutMapping("/update")
    default JsonResponse<Void> update(@RequestBody M t) throws Exception {
        getService().updateSelective(t);
        return JsonResponse.sucess();
    }


    @PutMapping("/create")
    default JsonResponse<Void> create(@Valid @RequestBody M t) throws Exception {
        getService().insertSelective(t);
        return JsonResponse.sucess();
    }

}
