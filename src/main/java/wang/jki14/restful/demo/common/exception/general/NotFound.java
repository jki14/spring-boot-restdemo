package wang.jki14.restful.demo.common.exception.general;

import org.springframework.http.HttpStatus;

import wang.jki14.restful.demo.common.exception.RestException;

public class NotFound extends RestException {

    private static final long serialVersionUID = 1754142060649823357L;

    public NotFound() {
        super(404, "Not Found", HttpStatus.NOT_FOUND);
    }

}