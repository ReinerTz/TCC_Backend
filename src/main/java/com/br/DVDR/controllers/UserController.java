package com.br.DVDR.controllers;

import com.br.DVDR.models.UserModel;
import com.br.DVDR.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api")
@Api(value = "API usuário")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    @ApiOperation(value = "Retorna todos os usuários")
    public List<UserModel> allUsers(){
        return userRepository.findAll();
    }
    
    @GetMapping("/user/{id}")
    @ApiOperation(value = "Retorna um usuário")
    public Optional<UserModel> findUser(@PathVariable(value = "id") String id){
        return userRepository.findById(id);
    }

    @PostMapping("/user")
    @ApiOperation(value = "Salva um usuário")
    public UserModel save(@RequestBody UserModel user){
        return userRepository.save(user);
    }

    @DeleteMapping("/user")
    @ApiOperation(value = "Deleta um usuário")
    public void delete(@RequestBody UserModel user){
        userRepository.delete(user);
    }

    @PutMapping("/user")
    @ApiOperation(value = "Atualiza um usuário")
    public UserModel update(@RequestBody UserModel user){
        return userRepository.save(user);
    }

    @GetMapping("/username/{user}")
    @ApiOperation(value = "Retorna uma lista de usuarios")
    public Optional<List<UserModel>> findUserByExclusiveUserName(@PathVariable(value = "user") String user){
        return userRepository.findByExclusiveUserName(user.toUpperCase());
    }

    @GetMapping("/user/exclusivename/{user}")
    @ApiOperation(value = "Retorna o usuário exclusivo pesquisado")
    public Optional<UserModel> findUserOneExclusiveUserName(@PathVariable(value = "user") String user){
        return userRepository.findUserOneExclusiveUserName(user);
    }
}
