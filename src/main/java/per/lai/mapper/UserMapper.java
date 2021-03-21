package per.lai.mapper;

import per.lai.pojo.User;

import java.util.List;

public interface UserMapper {
    int addUser(User user);

    int addAdmin(User user);

    User getUserById(int loginId);

    List<User> getAllUser();

}
