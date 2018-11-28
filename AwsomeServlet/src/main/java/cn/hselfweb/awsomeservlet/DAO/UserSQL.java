package cn.hselfweb.awsomeservlet.DAO;

import cn.hselfweb.awsomeservlet.Unit.ConnectionPool;
import cn.hselfweb.awsomeservlet.VO.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserSQL implements UserSQLInterface {
    private static Connection CONNECTION;
    private static ConnectionPool connectionPool;
    private static final String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
    private static final String username = "root";
    private static final String password = "";

    public UserSQL() {
        connectionPool = new ConnectionPool(url, username, password);
        CONNECTION = connectionPool.getConnection();
    }

    private List<User> resultLoop(ResultSet resultSet) {
        List<User> users = new ArrayList<>();
        try {
            while (resultSet.next()) {

                User user = new User(resultSet.getLong("userid"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("phone"),
                        resultSet.getString("sex")
                );
                users.add(user);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    private ResultSet getResultSet(Long userID, String SQL) {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = CONNECTION.prepareStatement(SQL);
            preparedStatement.setLong(1, userID);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
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
     * @param name 传递User类的username
     * @return List<User>
     */
    @Override
    public List<User> queryByName(String name) {
        String SQL = "SELECT * FROM userdata WHERE username=?";
        PreparedStatement preparedStatement = null;
        List<User> users;
        ResultSet resultSet = null;
        try {
            preparedStatement = CONNECTION.prepareStatement(SQL);
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        users = resultLoop(resultSet);
        return users;
    }

    /**
     * 函数queryById返回所有用户名是userID的User对象
     *
     * @param ID 传递User类的userID
     * @return User
     */
    @Override
    public User queryById(Long ID) {
        String SQL = "SELECT * FROM userdata WHERE userid=?";
        List<User> users;
        ResultSet resultSet;
        resultSet = getResultSet(ID, SQL);
        users = resultLoop(resultSet);
        return users.get(0);
    }

    /**
     * insert函数是插入一个User对象到数据库中
     *
     * @param user 传递单个的User类
     */
    @Override
    public void insert(User user) {
        String SQL = "INSERT INTO userdata (userid, username, password, phone, sex) VALUES (?, ?, ?, ?,?) ";

        try {
            PreparedStatement preparedStatement = CONNECTION.prepareStatement(SQL);
            preparedStatement.setString(1, System.currentTimeMillis() + "");
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setString(5, user.getSex());
            preparedStatement.executeUpdate();
            preparedStatement.close();
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
        String SQL = "UPDATE userdata SET username=?,password=?,phone=?,sex=? WHERE userid=?";
        try {
            PreparedStatement preparedStatement = CONNECTION.prepareStatement(SQL);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getPhone());
            preparedStatement.setString(4, user.getSex());
            preparedStatement.setLong(5, user.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * delete函数是删除一个数据库对应的User对象
     *
     * @param user
     */
    @Override
    public void delete(User user) {
        String SQL = "DELETE FROM userdata WHERE userid = ?";
        try {
            PreparedStatement preparedStatement = CONNECTION.prepareStatement(SQL);
            preparedStatement.setLong(1, user.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        connectionPool.releaseConnection(CONNECTION);
    }
}
