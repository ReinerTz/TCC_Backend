package com.br.DVDR.repository;

import com.br.DVDR.models.FriendshipModel;
import com.br.DVDR.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FriendshipRepository extends JpaRepository<FriendshipModel, Long> {
    @Query("SELECT u FROM FriendshipModel u WHERE u.user = :user")
    Optional<List<FriendshipModel>> findByUser(@Param("user")String user);
}
