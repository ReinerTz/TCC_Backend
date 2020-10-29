package com.br.DVDR.controllers;

import com.br.DVDR.models.ExpenseModel;
import com.br.DVDR.models.GroupModel;
import com.br.DVDR.models.UserExpenseModel;
import com.br.DVDR.repository.ExpenseRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api")
@Api(value = "API das despesas")
@CrossOrigin(origins = "*")
public class ExpenseController {
    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private UserExpenseController userExpenseController;

    @GetMapping("/expenses")
    @ApiOperation(value = "Retorna todas as despesas")
    public List<ExpenseModel> allExpenses() {
        return expenseRepository.findAll();
    }

    @GetMapping("/expense/{id}")
    @ApiOperation(value = "Retorna uma despesa")
    public Optional<ExpenseModel> findExpense(@PathVariable(value = "id") Long id) {
        return expenseRepository.findById(id);
    }

    @PostMapping("/expense")
    @ApiOperation(value = "Salva uma despesa")
    public ExpenseModel save(@RequestBody ExpenseModel expense) {
        return expenseRepository.save(expense);
    }

    @DeleteMapping("/expense")
    @ApiOperation(value = "Deleta uma despesa")
    public void delete(@RequestBody ExpenseModel expense) {
        userExpenseController.deleteAll(expense);
        expenseRepository.delete(expense);
    }

    @PutMapping("/expense")
    @ApiOperation(value = "Atualiza uma despesa")
    public ExpenseModel update(@RequestBody ExpenseModel expense) {
        return expenseRepository.save(expense);
    }

    @GetMapping("/expense/group/{id}")
    @ApiOperation(value = "Retorna a lista de despesas de um determinado grupo")
    public Optional<List<ExpenseModel>> findExpensesByGroup(@PathVariable(value = "id") Long id){
        return expenseRepository.findByGroup(id);
    }
}
