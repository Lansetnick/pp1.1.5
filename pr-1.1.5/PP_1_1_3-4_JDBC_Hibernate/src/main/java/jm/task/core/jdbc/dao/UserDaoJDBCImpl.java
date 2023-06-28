package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl extends Util implements UserDao {
    Connection connection = getConnection();

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() throws SQLException {
        Statement statement = null;
        String sql = "CREATE TABLE User (id INT PRIMARY KEY AUTO_INCREMENT NOT NULL, name VARCHAR(120), lastName VARCHAR(120), age TINYINT(1))";
        try {
            statement = connection.prepareStatement(sql);
            statement.executeUpdate(sql);
        } catch (SQLException e) {
        }
    }

    public void dropUsersTable() throws SQLException {
        Statement statement = null;
        String sql = "DROP TABLE User";
        try {
            statement = connection.prepareStatement(sql);
            statement.executeUpdate(sql);
        } catch (SQLException e) {
        }
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO User (name, lastName, age) VALUES (?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }

    }

    public void removeUserById(long id) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM USER WHERE ID = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
        } catch (SQLException e) {
        }
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> userList = new ArrayList<>();
        Statement statement = null;
        String sql = "SELECT * FROM User";
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                User user = new User();
                user.setId((resultSet.getLong("id")));
                user.setName((resultSet.getString("name")));
                user.setLastName((resultSet.getString("LastName")));
                user.setAge((resultSet.getByte("age")));

                userList.add(user);
            }
        } catch (SQLException e) {
        }
        return userList;
    }

    public void cleanUsersTable() throws SQLException {
        Statement statement = null;
        String sql = "TRUNCATE User";
        try {
            statement = connection.prepareStatement(sql);
            statement.executeUpdate(sql);
        } catch (SQLException e) {
        }
    }
}
