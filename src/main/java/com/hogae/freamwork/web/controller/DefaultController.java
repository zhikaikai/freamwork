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

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.server.ServerRequest;


public interface DefaultController {
	
	@RequestMapping("/**")
    default void unmappedRequest(ServerRequest request) throws Exception {
        String uri = request.path();
        throw new Exception("请求资源不存在！路径:"+uri);
    }
	

}

