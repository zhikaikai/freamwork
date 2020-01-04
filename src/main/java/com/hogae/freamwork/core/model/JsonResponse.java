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

package com.hogae.freamwork.core.model;


public class JsonResponse<T> {


    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private static final int SUCCESS_CODE = 1;

    private static final String SUCCESS_MSG = "成功";

    private static final int ERROR_CODE = -1;

    private static final String ERROR_MSG = "错误";


    private int code = SUCCESS_CODE;

    private String msg = SUCCESS_MSG;

    private T data;


    public JsonResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public JsonResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public JsonResponse() {

    }

    public static JsonResponse sucess() {
        return new JsonResponse(SUCCESS_CODE,SUCCESS_MSG);
    }

    public static JsonResponse error() {
        return new JsonResponse(ERROR_CODE,ERROR_MSG);
    }

    public static JsonResponse error(Exception ex) {
        return new JsonResponse(ERROR_CODE,ex.getMessage());
    }

    public int getCode() {
        return code;
    }

    public JsonResponse setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public JsonResponse setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getData() {
        return data;
    }

    public JsonResponse setData(T data) {
        this.data = data;
        return this;
    }

}
