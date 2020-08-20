package com.br.DVDR.controllers;

import com.br.DVDR.models.UserGroupModel;
import com.br.DVDR.repository.UserGroupRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class UserGroupController {
    @Autowired
    UserGroupRepository userGroupRepository;

    @GetMapping("/usergroups")
    @ApiOperation(value = "Retorna todos os usuários")
    public List<UserGroupModel> allUsers(){
        return userGroupRepository.findAll();
    }

    @GetMapping("/usergroup/{id}")
    @ApiOperation(value = "Retorna um usuário")
    public Optional<UserGroupModel> findUser(@PathVariable(value = "id") Long id){
        return userGroupRepository.findById(id);
    }

    @PostMapping("/usergroup")
    @ApiOperation(value = "Salva um usuário")
    public UserGroupModel save(@RequestBody UserGroupModel user){
        return userGroupRepository.save(user);
    }

    @DeleteMapping("/usergroup")
    @ApiOperation(value = "Deleta um usuário")
    public void delete(@RequestBody UserGroupModel user){
        userGroupRepository.delete(user);
    }

    @PutMapping("/usergroup")
    @ApiOperation(value = "Atualiza um usuário")
    public UserGroupModel update(@RequestBody UserGroupModel user){
        return userGroupRepository.save(user);
    }
}
