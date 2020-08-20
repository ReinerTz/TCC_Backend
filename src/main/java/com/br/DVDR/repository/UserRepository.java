package com.br.DVDR.repository;

import com.br.DVDR.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, String> {

}
