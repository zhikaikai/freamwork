package com.hogae.freamwork.core.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.server.ServerRequest;


public interface DefaultController {
	
	@RequestMapping("/**")
    default void unmappedRequest(ServerRequest request) throws Exception {
        String uri = request.path();
        throw new Exception("请求资源不存在！路径:"+uri);
    }
	

}

