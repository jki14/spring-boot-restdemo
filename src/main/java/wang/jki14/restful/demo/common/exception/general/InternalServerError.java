package wang.jki14.restful.demo.common.exception.general;

import org.springframework.http.HttpStatus;

import wang.jki14.restful.demo.common.exception.RestException;

public class InternalServerError extends RestException {

    private static final long serialVersionUID = 9009511292275793657L;

    public InternalServerError() {
        super(500, "InternalServerError", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public InternalServerError(String message) {
        super(500, message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}