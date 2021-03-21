package per.lai.service.Impl;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import per.lai.mapper.UserMapper;
import per.lai.pojo.CustomResponse;
import per.lai.pojo.ExcelBean;
import per.lai.pojo.User;
import per.lai.service.UserService;
import per.lai.util.ExcelUtil;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public int addUser(User user) {
        if (isAccountExist(user)) {
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
        if (isChecked) {
            //如果为管理员 返回特殊状态码
            code = userData.isAdmin() ? 201 : 200;
        }
        int uid = user.getLoginId();
        return new CustomResponse(message, code, uid);
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public XSSFWorkbook exportExcelInfo() throws ClassNotFoundException, InvocationTargetException, IntrospectionException, IllegalAccessException {
        List<User> userList = userMapper.getAllUser();
        List<ExcelBean> excel = new ArrayList<>();
        Map<Integer, List<ExcelBean>> map = new LinkedHashMap<>();
        XSSFWorkbook xssfWorkbook = null;
        excel.add(new ExcelBean("账号", "loginId", 0));
        excel.add(new ExcelBean("密码", "loginPassword", 0));
        excel.add(new ExcelBean("用户名", "loginName", 0));
        excel.add(new ExcelBean("管理员", "isAdmin", 0));
        map.put(0, excel);
        String sheetName = "用户信息";
        xssfWorkbook = ExcelUtil.createExcelFile(User.class, userList, map, sheetName);
        return xssfWorkbook;
    }

    @Override
    public boolean isAccountExist(User user) {
        User query = userMapper.getUserById(user.getLoginId());
        return query != null;
    }
}
