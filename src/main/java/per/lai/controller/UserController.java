package per.lai.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
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


    @RequestMapping(path = "/user/{id}/{name}/{password}", method = RequestMethod.POST)
    public int register(@PathVariable("id") int loginId, @PathVariable("name") String loginName, @PathVariable("password") String loginPassword) {

        return userService.addUser(new User(loginId, loginPassword, loginName,false));

    }



    @RequestMapping(path = "/user", method = RequestMethod.POST)
    public ResponseEntity<Void> addUser(@RequestBody User user, UriComponentsBuilder uriComponentsBuilder) {
        System.out.println("Creating user..." + user.getLoginName());
        if (userService.isAccountExist(user)) {
            System.out.println("An account with id" + user.getLoginId() + " is already exist.");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        userService.addUser(user);


        return new ResponseEntity<Void>(HttpStatus.CONFLICT);

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
