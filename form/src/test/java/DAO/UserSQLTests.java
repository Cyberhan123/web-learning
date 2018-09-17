package DAO;

import cn.hselfweb.jsp.DAO.UserSQL;
import cn.hselfweb.jsp.VO.User;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.sql.Connection;
import java.util.List;

public class UserSQLTests {
    @Test
    @DisplayName("测试是否能连接上数据库")
    public void connectionTest() {
        UserSQL userSQL = new UserSQL();
        Connection connection = userSQL.openConnection();
        System.out.print(connection);
    }

    @Test
    @DisplayName("测试插入语句")
    public void insertTest() {
        System.out.print(String.valueOf(System.currentTimeMillis()));
        UserSQL userSQL = new UserSQL();
        User user = new User();
        user.setUsername("123");
        user.setPassword("233");
        user.setAgree("345");
        user.setSex("111");
        user.setAgree("yes");
        userSQL.insert(user);
    }

    @Test
    @DisplayName("测试输出所有的SQL是否好使")
    public void queryAllTest() {
        UserSQL userSQL = new UserSQL();
        List<User> users = userSQL.queryAll();
        System.out.print(users);
    }

    @Test
    @DisplayName("测试通过ID 和 用户名查找数据")
    public void searchUserTest() {
        UserSQL userSQL = new UserSQL();
        User user = userSQL.queryById("1536901208165");
        List<User> users = userSQL.queryByName("1");
        System.out.print(user);
    }

    @Test
    @DisplayName("测试User类为空会怎么样")
    public void userEmptyTest() {
        User user = new User();
        String name = user.getUsername();
        String pw = user.getPassword();
    }

    @Test
    @DisplayName("测试delete和update")
    public void updateDelete() {
        User user = new User("1536898224890", "1", "233", "111", "yes");
        UserSQL userSQL = new UserSQL();
        userSQL.delete(user);
//        userSQL.update(user);
    }
}
