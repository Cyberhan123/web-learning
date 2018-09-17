package cn.hselfweb.jsp.DAO;

import cn.hselfweb.jsp.VO.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserSQL implements UserSQLInterface {
    private static Connection CONNECTION;

    public UserSQL() {

        CONNECTION = openConnection();
    }

    public Connection openConnection() {
        Connection connection = null;
        try {
            String driveName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driveName);
            String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
            String userName = "root";
            String passWord = "";
            connection = DriverManager.getConnection(url, userName, passWord);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private List<User> resultLoop(@org.jetbrains.annotations.NotNull ResultSet resultSet) {
        List<User> users = new ArrayList<>();
        try {
            while (resultSet.next()) {
                User user = new User();
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setAgree(resultSet.getString("agree"));
                user.setSex(resultSet.getString("sex"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    /**
     * 函数queryAll返回数据库所有的User对象
     *
     * @return List<User>
     */
    @Override
    public List<User> queryAll() {
        String SQL = "SELECT * FROM userdata";
        ResultSet resultSet = null;
        List<User> users;

        try {
            Statement statement = CONNECTION.createStatement();
            resultSet = statement.executeQuery(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        users = resultLoop(resultSet);
        return users;
    }

    /**
     * 函数queryAll返回所有用户名是username的User对象
     *
     * @param username 传递一个User类的username参数
     * @return List<User>
     */
    @Override
    public List<User> queryByName(String username) {
        String SQL = "SELECT * FROM userdata WHERE username=?";
        List<User> users;
        ResultSet resultSet = getResultSet(username, SQL);
        users = resultLoop(resultSet);
        return users;
    }

    /**
     * 函数queryById返回所有用户名是userID的User对象
     *
     * @param userID 传递User类的userID
     * @return User
     */
    @Override
    public User queryById(String userID) {
        String SQL = "SELECT * FROM userdata WHERE userid=?";
        List<User> users;
        ResultSet resultSet;
        resultSet = getResultSet(userID, SQL);
        users = resultLoop(resultSet);
        return users.get(0);
    }

    private ResultSet getResultSet(String userID, String SQL) {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = CONNECTION.prepareStatement(SQL);
            preparedStatement.setString(1, userID);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    /**
     * insert函数是插入一个User对象到数据库中
     *
     * @param user 传递单个的User类
     */
    @Override
    public void insert(User user) {
        String SQL = "INSERT INTO userdata (userid, username, password, agree, sex) VALUES (?, ?, ?, ?,?) ";

        try {
            PreparedStatement preparedStatement = CONNECTION.prepareStatement(SQL);
            preparedStatement.setString(1, System.currentTimeMillis() + "");
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getAgree());
            preparedStatement.setString(5, user.getSex());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * update函数是更新一个User对象到数据库中
     *
     * @param user 传递单个的User类
     */
    @Override
    public void update(User user) {
        String SQL = "UPDATE userdata SET username=?,password=?,agree=?,sex=? WHERE userid=?";
        try {
            PreparedStatement preparedStatement = CONNECTION.prepareStatement(SQL);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getAgree());
            preparedStatement.setString(4, user.getSex());
            preparedStatement.setString(5, user.getUserid());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * delete函数是删除一个数据库对应的User对象
     *
     * @param user 传递单个的User类
     */
    @Override
    public void delete(User user) {
        String SQL = "DELETE FROM userdata WHERE userid = ?";
        try {
            PreparedStatement preparedStatement = CONNECTION.prepareStatement(SQL);
            preparedStatement.setString(1, user.getUserid());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
