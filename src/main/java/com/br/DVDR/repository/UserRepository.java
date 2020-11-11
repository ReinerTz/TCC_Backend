package com.br.DVDR.repository;

import com.br.DVDR.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, String> {
    @Query("SELECT u FROM UserModel u WHERE UPPER(u.exclusive_user_name) like %:exclusiveUserName%")
    Optional<List<UserModel>> findByExclusiveUserName(@Param("exclusiveUserName")String exclusiveUserName);

    @Query("SELECT u FROM UserModel u WHERE UPPER(u.exclusive_user_name) = UPPER(:exclusiveUserName)")
    Optional<UserModel> findUserOneExclusiveUserName(@Param("exclusiveUserName")String exclusiveUserName);

}
