package com.br.DVDR.repository;

import com.br.DVDR.models.ExpenseModel;
import com.br.DVDR.models.GroupModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ExpenseRepository extends JpaRepository<ExpenseModel, Long> {
    @Query("SELECT u FROM ExpenseModel u WHERE u.group.id = :groupModel")
    Optional<List<ExpenseModel>> findByGroup(@Param("groupModel") Long groupModel);
}
