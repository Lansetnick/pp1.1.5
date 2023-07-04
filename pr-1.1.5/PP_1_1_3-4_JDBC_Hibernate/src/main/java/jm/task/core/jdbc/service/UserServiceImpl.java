package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDao userD = new UserDaoHibernateImpl();

    @Override
    public void createUsersTable() throws SQLException {
        userD.createUsersTable();
    }

    @Override
    public void dropUsersTable() throws SQLException {
        userD.dropUsersTable();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) throws SQLException {
        userD.saveUser(name, lastName, age);
    }

    @Override
    public void removeUserById(long id) throws SQLException {
        userD.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        return userD.getAllUsers();
    }

    @Override
    public void cleanUsersTable() throws SQLException {
        userD.cleanUsersTable();
    }
}
