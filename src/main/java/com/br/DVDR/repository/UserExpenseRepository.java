package com.br.DVDR.repository;

import com.br.DVDR.models.UserExpenseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserExpenseRepository extends JpaRepository<UserExpenseModel, Long> {
    @Query(value = "SELECT u.* FROM tb_userexpense u WHERE u.expense_id = :expense", nativeQuery = true)
    Optional<List<UserExpenseModel>> findUsersByExpense(@Param("expense")Long expense);

    @Query(value = "SELECT u.* FROM tb_userexpense u WHERE u.user_group_id = :id", nativeQuery = true)
    Iterable<? extends UserExpenseModel> findItemsByUsers(@Param("id")Long id);

    @Query(value = "SELECT u.* FROM tb_userexpense u WHERE u.expense_id = :expense", nativeQuery = true)
    Iterable<? extends UserExpenseModel> getUsersByExpense(@Param("expense")Long expense);
}
