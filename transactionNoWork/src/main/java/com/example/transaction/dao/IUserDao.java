package com.example.transaction.dao;

import com.example.transaction.domin.User;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface IUserDao extends JpaRepositoryImplementation<User, String> {
}
