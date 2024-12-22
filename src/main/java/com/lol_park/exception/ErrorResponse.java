package com.lol_park.exception;


import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor


public class ErrorResponse {

    private final String errorCode;
    private final String errorMessage;

}
