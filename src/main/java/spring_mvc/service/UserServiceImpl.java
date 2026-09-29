package spring_mvc.service;

import java.util.List;
import org.springframework.stereotype.Service;
import spring_mvc.dao.UserDao;
import spring_mvc.model.User;

@Service
public class UserServiceImpl implements UserService{

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public User getUser(User user) {
        return userDao.getUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

    @Override
    public boolean existsByEmail(String email, Long excludeId) {
        return userDao.existsByEmail(email, excludeId);
    }
}
