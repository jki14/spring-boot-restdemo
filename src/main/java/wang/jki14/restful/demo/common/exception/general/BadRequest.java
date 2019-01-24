package wang.jki14.restful.demo.common.exception.general;

import org.springframework.http.HttpStatus;

import wang.jki14.restful.demo.common.exception.RestException;

public class BadRequest extends RestException {

    private static final long serialVersionUID = -7674607977848660502L;

    public BadRequest() {
        super(400, "Bad Request", HttpStatus.BAD_REQUEST);
    }

}