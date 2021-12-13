package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.User;
import com.example.demo.enums.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryDao extends JpaRepository<User, Integer> {
    List<User> findByUserTypeAndUserRemovedIsFalse(UserType userType);
    List<User> findByUserRemovedIsFalse();
    User findByUsernameAndUserPassword(String username, String userPassword);
}
