package per.lai.mapper;

import per.lai.pojo.User;

public interface UserMapper {
    int addUser(User user);
    int addAdmin(User user);
    User getUserById(int loginId);

}
