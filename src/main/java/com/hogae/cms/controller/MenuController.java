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

package com.hogae.cms.controller;

import com.hogae.cms.model.Menu;
import com.hogae.cms.service.IMenuService;
import com.hogae.freamwork.web.controller.WebController;
import com.hogae.freamwork.web.model.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerRequest;

/**
 * 菜单
 */
@RestController
@RequestMapping("/menu")
public class MenuController implements WebController<Integer, Menu> {

    @Autowired
    public IMenuService service;

    public IMenuService getService() {
        return service;
    }




}
