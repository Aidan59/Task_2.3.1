package spring_mvc.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring_mvc.model.User;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<User> findAll() {
        return entityManager
                .createQuery("FROM User", User.class)
                .getResultList();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public User getUser(User user) {
        return entityManager.find(User.class, user.getId());
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        User existingUser = entityManager.find(User.class, user.getId());

        existingUser.setName(user.getName());
        existingUser.setSurname(user.getSurname());
        existingUser.setAge(user.getAge());
        existingUser.setEmail(user.getEmail());
        existingUser.setSalary(user.getSalary());
        existingUser.setPosition(user.getPosition());
        existingUser.setEmploymentType(user.getEmploymentType());
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        entityManager.createQuery("delete User u where u.id = :id")
                .setParameter("id", user.getId())
                .executeUpdate();
    }

    @Override
    @Transactional
    public boolean existsByEmail(String email, Long excludeId) {
        Long count = entityManager.createQuery(
                        "select count(u) from User u where u.email = :email and u.id <> :id",
                        Long.class)
                .setParameter("email", email)
                .setParameter("id", excludeId)
                .getSingleResult();
        return count > 0;
    }

}
