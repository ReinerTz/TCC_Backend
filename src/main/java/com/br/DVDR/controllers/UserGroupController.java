package com.br.DVDR.controllers;

import com.br.DVDR.models.UserGroupModel;
import com.br.DVDR.repository.UserGroupRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api")
@Api(value = "API para integrar usuário e grupos")
@CrossOrigin(origins = "*")
public class UserGroupController {
    @Autowired
    UserGroupRepository userGroupRepository;

    @PostMapping("/usergroup")
    @ApiOperation(value = "Salva um usuário em um grupo")
    public UserGroupModel save(@RequestBody UserGroupModel user){
        return userGroupRepository.save(user);
    }
}
