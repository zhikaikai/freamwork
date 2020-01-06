package com.hogae.freamwork.web.controller;

import com.hogae.freamwork.web.model.JsonResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerRequest;

@RestController
public class DefaultController {

    @RequestMapping("/**")
    public JsonResponse<Void> unmappedRequest(ServerRequest request) {
        String uri = request.path();
        return JsonResponse.error(new Exception("请求资源不存在！路径:" + uri));
    }
}
