package app.services;

import app.entities.User;

import java.sql.SQLException;
import java.util.List;


public interface UserService {
    void save (User user) throws SQLException;
    User delete (Integer id) throws SQLException;
    void update (User user) throws SQLException;
    User findUserById (Integer id) throws SQLException;
    List<User> findAllUser () throws SQLException;
}
