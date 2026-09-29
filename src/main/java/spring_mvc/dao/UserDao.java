package spring_mvc.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import spring_mvc.model.User;

public interface UserDao {
    List<User> findAll();
    void addUser(User user);
    User getUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
    boolean existsByEmail(String email, Long excludeId);
}
