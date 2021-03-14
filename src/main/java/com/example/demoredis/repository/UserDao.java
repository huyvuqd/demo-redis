package com.example.demoredis.repository;

import com.example.demoredis.model.User;

import java.util.List;

public interface UserDao {
    boolean saveUser(User user);

    List<User> fetchAllUser();

    User fetchUserById(Long id);

    boolean deleteUser(Long id);
}
