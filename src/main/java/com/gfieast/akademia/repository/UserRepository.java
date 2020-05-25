package com.gfieast.akademia.repository;

import java.util.List;

import com.gfieast.akademia.model.User;

public interface UserRepository {

    List<User> findAllByLoginStartsWithOrderByIdAsc(String login);
}
