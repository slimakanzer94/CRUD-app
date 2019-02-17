package app.services;

import app.dao.UserDao;
import app.dao.UserDaoImpl;
import app.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService{

    UserDao userDao;

    @Autowired
    public void setUserDao (UserDao userDao){
        this.userDao = userDao;
    }

    private UserServiceImpl() {
    }

    public void save(User user) throws SQLException{
        userDao.saveUser(user);
    }

    public User delete(Integer id) throws SQLException{
        return userDao.deleteUser(id);
    }

    public void update(User user) throws SQLException{
        userDao.updateUser(user);
    }

    public User findUserById(Integer id) throws SQLException{
        return userDao.findUserById(id);
    }

    public List<User> findAllUser() throws SQLException{
        return userDao.findAllUser();
    }
}
