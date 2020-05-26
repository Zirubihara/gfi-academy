package com.gfieast.akademia.repository;

import com.gfieast.akademia.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
