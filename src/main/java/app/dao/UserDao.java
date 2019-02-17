package app.dao;

import app.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    void saveUser (User user) throws SQLException;
    User deleteUser (Integer id) throws SQLException;
    void updateUser (User user) throws SQLException;
    User findUserById (Integer id) throws SQLException;
    List<User> findAllUser () throws SQLException;

}
