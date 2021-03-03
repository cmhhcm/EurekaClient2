package com.cmh.eurekaclient2.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseVO<T> {
    private int code;

    private String message;

    private T data;

    public static ResponseVO success(Object data) {
        return ResponseVO.builder().code(HttpStatus.OK.value()).message("success").data(data).build();
    }

    public static ResponseVO failed(String msg) {
        return ResponseVO.builder().code(HttpStatus.INTERNAL_SERVER_ERROR.value()).message(msg).data(null).build();
    }
}
