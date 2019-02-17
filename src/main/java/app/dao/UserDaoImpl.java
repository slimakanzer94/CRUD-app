package app.dao;

import app.entities.User;
import app.utils.HibernateSessionFactoryUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;
import java.sql.SQLException;
import java.util.List;

@SuppressWarnings("JpaQlInspection")
@Repository
public class UserDaoImpl implements UserDao{

    public UserDaoImpl() {
    }

    @Override
    public void saveUser (User user) throws SQLException {
        Session session = null;
        try {
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        Transaction tx1 = session.beginTransaction();
        user.setframeworksList();
        session.save(user);
        tx1.commit();
        session.close();
    }
    @Override
    public User deleteUser (Integer id) throws  SQLException
    {
        Session session = null;
        try {
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        Transaction tx1 = session.beginTransaction();
        User user = session.get(User.class,id);
        session.delete(user);
        tx1.commit();
        session.close();
        return user;
    }
    @Override
    public void updateUser (User user) throws SQLException {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        user.setframeworksList();
        session.update(user);
        tx1.commit();
        session.close();
    }
    @Override
    public List<User> findAllUser () throws SQLException {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Query query = session.createQuery("from User");
        List<User> users = query.list();
        tx1.commit();
        session.close();
        return users;
    }
    @Override
    public User findUserById (Integer id) throws SQLException {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        User user = (User) session.get(User.class, id);
        tx1.commit();
        session.close();
        return user;
    }
}
