package per.lai.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import per.lai.pojo.CustomResponse;
import per.lai.pojo.User;
import per.lai.service.UserService;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    @Qualifier("userServiceImpl")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    /*
        登录接口
        状态码
            code：   200登录成功
                    100登录失败

     */
    @RequestMapping(path = "/login",method = RequestMethod.POST)
    public ResponseEntity<CustomResponse> login(@RequestBody User userSubmit) {
        return new ResponseEntity<>(userService.login(userSubmit),HttpStatus.OK);
    }

    /*
        注册接口：
        code：
            210 注册成功
            110 注册失败 重复id
     */
    @RequestMapping(path = "/user", method = RequestMethod.POST)
    public ResponseEntity<CustomResponse> addUser(@RequestBody User user) {
        int backCode =  userService.addUser(user);
        String message = (backCode == 1) ? "注册成功，请登录" : "账号名已存在，请重新注册";
        int code = (backCode == 1) ? 210 : 110;
        boolean data = (backCode == 1);
        return new ResponseEntity<>(new CustomResponse(message,code,data) , HttpStatus.OK);
    }




    @RequestMapping("/test")
    public String test() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(new User(1222,"testing","name",false));
    }

    @RequestMapping("/testReturn")
    public ResponseEntity<Void> test2() {
        return new ResponseEntity<Void>(HttpStatus.CONFLICT);
    }
}
