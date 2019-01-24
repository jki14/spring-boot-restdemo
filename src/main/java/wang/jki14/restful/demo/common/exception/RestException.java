package wang.jki14.restful.demo.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class RestException extends Exception {

    private static final long serialVersionUID = 5502342451532475639L;

    public class ExceptionBody {
        public class ExceptionBodyContent {
            private Integer code;
            private String message;

            public ExceptionBodyContent(Integer code, String message) {
                this.code = code;
                this.message = message;
            }

            public Integer getCode() {
                return this.code;
            }

            public String getMessage() {
                return this.message;
            }
        }

        private ExceptionBodyContent exception;

        public ExceptionBody(Integer code, String message) {
            this.exception = new ExceptionBodyContent(code, message);
        }

        public ExceptionBodyContent getException() {
            return this.exception;
        }

    }

    private ExceptionBody body;
    private HttpStatus httpStatus;

    public RestException(Integer code, String message, HttpStatus httpStatus) {
        super();
        this.body = new ExceptionBody(code, message);
        this.httpStatus = httpStatus;
    }

    public ResponseEntity<ExceptionBody> generateResponseEntity() {
        return new ResponseEntity<>(this.body, this.httpStatus);
    }

}