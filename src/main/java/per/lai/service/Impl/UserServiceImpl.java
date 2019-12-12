package per.lai.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import per.lai.mapper.UserMapper;
import per.lai.pojo.CustomResponse;
import per.lai.pojo.User;
import per.lai.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public int addUser(User user) {
        if(isAccountExist(user)) {
            return 0;
        }
        return userMapper.addUser(user);
    }

    public User getUserById(int loginId) {
        return userMapper.getUserById(loginId);
    }

    public boolean checkAccount(User user, String password) {
        User query = userMapper.getUserById(user.getLoginId());
        return (query != null) && query.getLoginPassword().equals(user.getLoginPassword());
    }

    @Override
    public CustomResponse login(User user) {
        User userData = userMapper.getUserById(user.getLoginId());
        boolean isChecked = (!(userData == null) && user.getLoginPassword().equals(userData.getLoginPassword()));
        String message = isChecked ? "登录成功" : "登录失败，检查账号或密码";
        int code = isChecked ? 200 : 100;
        return new CustomResponse(message,code,isChecked);
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public boolean isAccountExist(User user) {
        User query = userMapper.getUserById(user.getLoginId());
        return query != null;
    }
}
