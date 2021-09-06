package cn.hselfweb.jsp.homework;

import cn.hselfweb.jsp.Unit.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class StudentSQL {
    private Connection connection;
    private ConnectionPool connectionPool = new ConnectionPool();

    public StudentSQL() {
        connection = connectionPool.getConnection();
    }

    private List<Student> resultLoop(@org.jetbrains.annotations.NotNull ResultSet resultSet) {
        List<Student> students = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Student student = new Student(
                        resultSet.getString("userid"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("agree"),
                        resultSet.getString("sex"),
                        resultSet.getString("studentId"),
                        resultSet.getString("studentClass")
                );
                students.add(student);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public List<Student> queryAll() {
        String SQL = "SELECT * FROM studentdata";
        ResultSet resultSet = null;
        List<Student> students;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        students = resultLoop(resultSet);
        return students;
    }

    public void insert(Student student) {
        String SQL = "INSERT INTO userdata (userid, username, password, agree, sex, studentId, studentClass) VALUES (?, ?, ?, ?,?) ";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, System.currentTimeMillis() + "");
            preparedStatement.setString(2, student.getUsername());
            preparedStatement.setString(3, student.getPassword());
            preparedStatement.setString(4, student.getAgree());
            preparedStatement.setString(5, student.getSex());
            preparedStatement.setString(5, student.getStudentId());
            preparedStatement.setString(5, student.getStudentClass());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Student student) {
        String SQL = "UPDATE userdata SET username=?,password=?,agree=?,sex=? WHERE userid=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, student.getUsername());
            preparedStatement.setString(2, student.getPassword());
            preparedStatement.setString(3, student.getAgree());
            preparedStatement.setString(4, student.getSex());
            preparedStatement.setString(5, student.getUserid());
            preparedStatement.setString(4, student.getStudentId());
            preparedStatement.setString(5, student.getStudentClass());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private ResultSet getResultSet(String userID, String SQL) {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, userID);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public List<Student> queryByName(String username) {
        String SQL = "SELECT * FROM userdata WHERE username=?";
        List<Student> students;
        ResultSet resultSet = getResultSet(username, SQL);
        students = resultLoop(resultSet);
        return students;
    }


    public void delete(Student student) {
        String SQL = "DELETE FROM userdata WHERE userid = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, student.getUserid());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        connectionPool.releaseConnection(connection);
        connectionPool.close();
    }
}
