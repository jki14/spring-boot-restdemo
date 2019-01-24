package wang.jki14.restful.demo.common.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(RestException.class)
    public final ResponseEntity<RestException.ExceptionBody> restException(RestException restException) {
        return restException.generateResponseEntity();
    }

}