package wang.jki14.restful.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import wang.jki14.restful.demo.common.RestResult;
import wang.jki14.restful.demo.common.exception.RestException;
import wang.jki14.restful.demo.common.principal.Principal;
import wang.jki14.restful.demo.common.principal.general.BasicAuthenticationPrincipal;

@RestController
public class HelloWorld {

    @Autowired
    private JdbcTemplate sql;

    @RequestMapping("/helloworld")
    public ResponseEntity<RestResult> helloWorld(@RequestParam Map<String, Object> getParam, @RequestBody(required = false) Map<String, Object> postParam) throws RestException {
        Principal principle = new BasicAuthenticationPrincipal(sql, true);
        Map<String, Object> result = new HashMap<String, Object>();
        if (principle.getUserId() != null) {
            result.put("greetings", String.format("Hello, %d", principle.getUserId()));
        } else {
            result.put("greetings", "Hello, Anonymous");
        }
        result.put("getParam", getParam);
        result.put("postParam", postParam);
        return new ResponseEntity<>(new RestResult(result), HttpStatus.OK);
    }

}