package per.lai.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.lai.pojo.CustomResponse;
import per.lai.pojo.User;

@RestController
public class TestController {

    @RequestMapping(path = "/construct", produces = "application/json;charset=UTF-8")
    public String Test() throws JsonProcessingException {
        String message = "信息测试";
        User user = new User(123456, "loginPassword", "loginName",false);
        int code = 12;
        CustomResponse customResponse = new CustomResponse(message,code,user);

        return new ObjectMapper().writeValueAsString(customResponse);
    }

    @RequestMapping(path = "/login", produces = "application/json;charset=UTF-8")
    public String login() throws JsonProcessingException {
        String message = "登录测试";
        User user = new User(123456, "loginPassword", "loginName",false);
        int code = 12;
        CustomResponse customResponse = new CustomResponse(message,code,user);

        return new ObjectMapper().writeValueAsString(customResponse);

    }
}
