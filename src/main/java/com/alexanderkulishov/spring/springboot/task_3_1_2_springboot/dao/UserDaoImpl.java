package com.alexanderkulishov.spring.springboot.task_3_1_2_springboot.dao;

import com.alexanderkulishov.spring.springboot.task_3_1_2_springboot.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //специальный компонент, используется для ДАО
public class UserDaoImpl implements UserDao {
    public UserDaoImpl() {

    }

    @PersistenceContext
    private EntityManager entityManager; // создается автоматически

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select user from User user", User.class).getResultList();

    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void removeUser(int id) {
        entityManager.createQuery("delete from User user WHERE user.id =:id", User.class)
                .setParameter("id", id).executeUpdate();
    }

    @Override
    public void updateUser(User userUpdate, int id) {
        User user = getUser(id);
        user.setName(userUpdate.getName());
        user.setLastName(userUpdate.getLastName());
        user.setAge(userUpdate.getAge());

    }


}
