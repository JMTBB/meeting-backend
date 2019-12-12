package per.lai.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import per.lai.pojo.User;
import per.lai.service.Impl.UserServiceImpl;

public class UserServiceImplTest  {
    @Test
    public  void aaa() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = context.getBean("userServiceImpl", per.lai.service.Impl.UserServiceImpl.class);
        userService.addUser(new User(333,"abc","王五",false));
    }

    @Test
    public void addUser() {
        //重复id测试
        User test = new User(112,"abc","张三",false);
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = context.getBean("userServiceImpl",per.lai.service.Impl.UserServiceImpl.class);
        int number = userService.addUser(test);
        System.out.println(number);
    }
}
