package per.lai.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import per.lai.pojo.CustomResponse;
import per.lai.pojo.User;
import per.lai.service.UserService;

import java.util.List;

@RestController
public class TestController {
    private UserService userService;

    @Autowired
    @Qualifier("userServiceImpl")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/construct", produces = "application/json;charset=UTF-8")
    public String Test() throws JsonProcessingException {
        String message = "信息测试";
        User user = new User(123456, "loginPassword", "loginName", false);
        int code = 12;
        CustomResponse customResponse = new CustomResponse(message, code, user);

        return new ObjectMapper().writeValueAsString(customResponse);
    }

    @RequestMapping(path = "/logintest", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    public String login(@RequestBody User userGet) throws JsonProcessingException {
        String message = "登录测试";
        User user = new User(123456, "loginPassword", "loginName", false);
        int code = 12;
        CustomResponse customResponse = new CustomResponse(message, code, userGet);
        System.out.println("testStart");
        System.out.println(userGet.toString());
        System.out.println("testEnd");
        return new ObjectMapper().writeValueAsString(customResponse);

    }

    @RequestMapping(path = "/login2")
    public ResponseEntity<CustomResponse> login2() {
        String message = "ResponseEntity登录测试";
        User user = new User(88888, "loginIng", "loginName", false);
        int code = 12;
        CustomResponse customResponse = new CustomResponse(message, code, user);
        return new ResponseEntity<CustomResponse>(customResponse, HttpStatus.OK);
    }

    @RequestMapping(path = "/users")
    public ResponseEntity<List<User>> allUser() {
        List<User> users = userService.getAllUser();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
}
