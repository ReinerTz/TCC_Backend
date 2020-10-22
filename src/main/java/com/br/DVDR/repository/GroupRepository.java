package com.br.DVDR.repository;

import com.br.DVDR.models.FriendshipModel;
import com.br.DVDR.models.GroupModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface GroupRepository extends JpaRepository<GroupModel, Long> {
    @Query(value = "SELECT u.* FROM tb_group u WHERE u.id in (select group_id from tb_usergroup where user_uid = :user)", nativeQuery = true)
    Optional<List<GroupModel>> findByUser(@Param("user")String user);

}
