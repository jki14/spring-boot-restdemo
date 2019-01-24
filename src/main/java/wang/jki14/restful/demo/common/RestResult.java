package wang.jki14.restful.demo.common;

public class RestResult {

    private Object result;

    public RestResult() {
        this.result = null;
    }

    public RestResult(Object foo) {
        this.result = foo;
    }

    public Object getResult() {
        return this.result;
    }

}