package wang.jki14.restful.demo.common.exception.general;

import org.springframework.http.HttpStatus;

import wang.jki14.restful.demo.common.exception.RestException;

public class Unauthorized extends RestException {

    private static final long serialVersionUID = 6165761688016626186L;

    public Unauthorized() {
        super(401, "Unauthorized", HttpStatus.UNAUTHORIZED);
    }

}