package com.br.DVDR.repository;

import com.br.DVDR.models.GroupModel;
import com.br.DVDR.models.UserGroupModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserGroupRepository extends JpaRepository<UserGroupModel, Long> {
    @Query(value = "SELECT u.* FROM tb_usergroup u WHERE u.group_id = :group", nativeQuery = true)
    Optional<List<UserGroupModel>> findUsersByGroup(@Param("group")Long group);
}
