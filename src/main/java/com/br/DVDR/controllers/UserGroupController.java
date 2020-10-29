package com.br.DVDR.controllers;

import com.br.DVDR.models.UserGroupModel;
import com.br.DVDR.models.UserModel;
import com.br.DVDR.repository.UserGroupRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api")
@Api(value = "API para integrar usuário e grupos")
@CrossOrigin(origins = "*")
public class UserGroupController {
    @Autowired
    UserGroupRepository userGroupRepository;

    @Autowired
    UserExpenseController userExpenseController;

    @PostMapping("/usergroup")
    @ApiOperation(value = "Salva um usuário em um grupo")
    public UserGroupModel save(@RequestBody UserGroupModel user){
        return userGroupRepository.save(user);
    }

    @GetMapping("/usergroups")
    @ApiOperation(value = "Retorna todos os usuários")
    public List<UserGroupModel> allUsers(){
        return userGroupRepository.findAll();
    }

    @GetMapping("/usergroup/group/{id}")
    @ApiOperation(value = "Retorna todos os usuários que pertencem a um determinado grupo")
    public Optional<List<UserGroupModel>> findUser(@PathVariable(value = "id") Long id){
        return userGroupRepository.findUsersByGroup(id);
    }

    @DeleteMapping("/usergroup")
    @ApiOperation(value = "Deleta um usuário do grupo")
    public void delete(@RequestBody UserGroupModel user){
        userExpenseController.deleteAll(user);
        userGroupRepository.delete(user);
    }


}
