package com.br.DVDR.repository;

import com.br.DVDR.models.FriendshipModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FriendshipRepository extends JpaRepository<FriendshipModel, Long> {
    @Query(value = "SELECT u.id, u.user_uid, u.friend_uid, u.status FROM tb_friendship u WHERE (u.user_uid = :user) and (u.status <> 'SENT')", nativeQuery = true)
    Optional<List<FriendshipModel>> findByUser(@Param("user")String user);

    @Query(value = "SELECT u.id, u.user_uid, u.friend_uid, u.status FROM tb_friendship u WHERE (u.user_uid = :user)", nativeQuery = true)
    Optional<List<FriendshipModel>> findAllFriendsByUser(@Param("user")String user);

    @Query(value = "SELECT * FROM tb_friendship u WHERE ((u.user_uid = :user) and (u.friend_uid = :friend)) or ((u.user_uid = :friend) and (u.friend_uid = :user))", nativeQuery = true)
    Optional<List<FriendshipModel>> findFriendship(@Param("user")String user, @Param("friend") String friend);
}
