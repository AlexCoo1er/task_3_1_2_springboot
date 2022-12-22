package com.alexanderkulishov.spring.springboot.task_3_1_2_springboot.serviсe;


import com.alexanderkulishov.spring.springboot.task_3_1_2_springboot.dao.UserDao;
import com.alexanderkulishov.spring.springboot.task_3_1_2_springboot.dao.UserDaoImpl;
import com.alexanderkulishov.spring.springboot.task_3_1_2_springboot.models.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl() {
        this.userDao = new UserDaoImpl();
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDao.getAllUsers();

    }
    @Override
    @Transactional
    public void saveUser(User user) {
    userDao.saveUser(user);
    }

    @Override
    @Transactional
    public User getUser(int id) {

        return userDao.getUser(id);
    }

    @Override
    @Transactional
    public void removeUser(int id) {
        userDao.removeUser(id);
    }

    @Override
    @Transactional
    public void updateUser(User updateUser, int id) {
        userDao.updateUser(updateUser, id);
    }

}
