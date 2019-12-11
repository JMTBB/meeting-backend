package per.lai.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import per.lai.mapper.UserMapper;
import per.lai.pojo.User;
import per.lai.service.UserService;

public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public int addUser(User user) {
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
    public boolean isAccountExist(User user) {
        User query = userMapper.getUserById(user.getLoginId());
        return query != null;
    }
}
