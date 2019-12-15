package per.lai.service;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import per.lai.pojo.CustomResponse;
import per.lai.pojo.User;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface UserService {
    int addUser(User user);
    User getUserById(int loginId);

    boolean checkAccount(User user, String password);
    boolean isAccountExist(User user);

    List<User> getAllUser();

    CustomResponse login(User user);
    XSSFWorkbook exportExcelInfo() throws ClassNotFoundException, InvocationTargetException, IntrospectionException, IllegalAccessException;
}
