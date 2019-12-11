package per.lai.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import per.lai.pojo.User;
import per.lai.service.Impl.UserServiceImpl;

public class UserServiceImplTest  {
    @Test
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = context.getBean("userServiceImpl", per.lai.service.Impl.UserServiceImpl.class);
        userService.addUser(new User(333,"abc","王五",false));
    }
}
