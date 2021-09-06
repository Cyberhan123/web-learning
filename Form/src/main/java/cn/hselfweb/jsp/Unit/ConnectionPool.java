package cn.hselfweb.jsp.Unit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ConnectionPool {
    private static String driveName = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
    private static String userName = "root";
    private static String passWord = "";
    private List<Connection> connections = new LinkedList<>();

    public ConnectionPool() {
        for (int i = 0; i < 10; i++) {
            try {
                Class.forName(driveName);
                Connection connection = DriverManager.getConnection(url, userName, passWord);
                connections.add(connection);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public ConnectionPool(Integer totailRequest) {
        try {
            Class.forName(driveName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < totailRequest; i++) {
            try {
                Connection connection = DriverManager.getConnection(url, userName, passWord);
                connections.add(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public Connection getConnection() {
        Connection connection = null;
        synchronized (this) {
            if (connections.size() > 0)
                connection = connections.remove(0);
        }
        return connection;
    }

    public void releaseConnection(Connection connection) {
        if (connection != null)
            synchronized (this) {
                connections.add(connection);
            }
    }

    public void close() {
        for (Connection connection : connections) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

