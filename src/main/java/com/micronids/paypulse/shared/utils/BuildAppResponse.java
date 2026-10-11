package com.micronids.paypulse.shared.utils;

import com.micronids.paypulse.shared.generic.AppResponse;

public class BuildAppResponse {
    private BuildAppResponse(){}

    public static <T>AppResponse<T> buildAppRespnse(String message, T data){
        return AppResponse.<T>builder()
                .success(true)
                .message(message)
                .data(data)
                .build();
    }
}
