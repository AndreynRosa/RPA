package com.api.rpa.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ParamRequestException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ParamRequestException(String message) {
        super(message);
    }

}
