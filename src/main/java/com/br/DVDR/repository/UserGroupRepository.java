package com.br.DVDR.repository;

import com.br.DVDR.models.UserGroupModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserGroupRepository extends JpaRepository<UserGroupModel, Long> {
}
