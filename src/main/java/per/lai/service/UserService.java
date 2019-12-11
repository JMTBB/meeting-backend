package per.lai.service;

import per.lai.pojo.User;

public interface UserService {
    int addUser(User user);
    User getUserById(int loginId);

    boolean checkAccount(User user, String password);
    boolean isAccountExist(User user);
}
