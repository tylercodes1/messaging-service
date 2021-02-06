package com.tkapps.social.service.message.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Not sure why, but Exceptions need to be coupled with a status code in order to catch 5xx errors in test cases.
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class TestControllerException extends Exception{
    public TestControllerException() {
        super();
    }

    public TestControllerException(String message) {
        super(message);
    }

    public TestControllerException(String message, Throwable cause) {
        super(message, cause);
    }

    public TestControllerException(Throwable cause) {
        super(cause);
    }

    protected TestControllerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
