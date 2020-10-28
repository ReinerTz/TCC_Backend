package com.br.DVDR.controllers;

import com.br.DVDR.models.UserExpenseModel;
import com.br.DVDR.repository.UserExpenseRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api")
@Api(value = "API da divisão de despesas por usuários")
@CrossOrigin(origins = "*")
public class UserExpenseController {
    @Autowired
    UserExpenseRepository userExpenseRepository;

    @PostMapping("/userexpense")
    @ApiOperation(value = "Salva um usuário em um grupo")
    public UserExpenseModel save(@RequestBody UserExpenseModel user) {
        return userExpenseRepository.save(user);
    }

    @PostMapping("/userexpenses")
    @ApiOperation(value = "Salva um usuário em um grupo")
    public List<UserExpenseModel> saveAll(@RequestBody List<UserExpenseModel> users) {
        List<UserExpenseModel> list = new ArrayList<>();
        for (UserExpenseModel user : users) {
            list.add(userExpenseRepository.save(user));
        }
        return users;
    }

    @GetMapping("/userexpense/expense/{id}")
    @ApiOperation(value = "Retorna todos os usuários que pertencem a uma determinada despesa")
    public Optional<List<UserExpenseModel>> findUsers(@PathVariable(value = "id") Long id) {
        return userExpenseRepository.findUsersByExpense(id);
    }

    @GetMapping("/userexpenses")
    @ApiOperation(value = "Retorna todos os registros")
    public List<UserExpenseModel> allUsersExpenses() {
        return userExpenseRepository.findAll();
    }
}