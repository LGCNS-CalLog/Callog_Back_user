package com.callog.callog_user.common.dto;

import com.callog.callog_user.common.exception.ApiError;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ApiResponseDto<T> {
    private String code;
    private String message;
    private T data;

    private ApiResponseDto(String code, String message) {
        this.code = code;
        this.message = message;
    }
    private ApiResponseDto(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public static <T> ApiResponseDto<T> createOk(T data) {
        return new ApiResponseDto<>("OK", "요청이 성공하였습니다.", data);
    }

    public static ApiResponseDto<String> defaultOk() {
        return createOk(null);
    }

    public static <T> ApiResponseDto<T> createError(String errorCode, String errorMessage) {
        return new ApiResponseDto<>(errorCode, errorMessage, null);
    }
}
