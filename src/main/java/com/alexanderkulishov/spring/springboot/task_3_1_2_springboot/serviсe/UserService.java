package com.alexanderkulishov.spring.springboot.task_3_1_2_springboot.serviсe;


import com.alexanderkulishov.spring.springboot.task_3_1_2_springboot.models.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void saveUser(User user);

    User getUser(int id);

    void removeUser(int id);

    void updateUser(User user, int id);
}
