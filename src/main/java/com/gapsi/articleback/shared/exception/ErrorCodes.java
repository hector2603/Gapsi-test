package com.gapsi.articleback.shared.exception;

import lombok.Getter;

@Getter
public enum ErrorCodes {
    NOT_FOUND("ERR-404", "Not Found"),
    INTERNAL_SERVER_ERROR("ERR-500", "Internal Server Error"),
    BAD_REQUEST("ERR-400", "Invalid Request"),;

    @Getter
    private final String code;
    private final String message;

    ErrorCodes(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
