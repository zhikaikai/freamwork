package com.hogae.freamwork.web.controller;

import com.hogae.freamwork.web.model.JsonResponse;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

    @RequestMapping("/**")
    public JsonResponse<Void> unmappedRequest(HttpRequest request) {
        String uri = request.getURI().toString();
        return JsonResponse.error(new Exception("请求资源不存在！路径:" + uri));
    }
}
