package com.br.DVDR.controllers;

import com.br.DVDR.models.GroupModel;
import com.br.DVDR.repository.GroupRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api")
@Api(value = "API dos grupos")
@CrossOrigin(origins = "*")
public class GroupController {
    @Autowired
    GroupRepository groupRepository;

    @GetMapping("/groups")
    @ApiOperation(value = "Retorna todos os grupos")
    public List<GroupModel> allGroups() {
        return groupRepository.findAll();
    }

    @GetMapping("/group/{id}")
    @ApiOperation(value = "Retorna o grupo pelo id")
    public Optional<GroupModel> findGroup(@PathVariable(value = "id") Long id) {
        return groupRepository.findById(id);
    }

    @GetMapping("/group/user/{id}")
    @ApiOperation(value = "Retorna o grupo pelo id")
    public Optional<List<GroupModel>> findGroupsByUser(@PathVariable(value = "id") String id) {
        return groupRepository.findByUser(id);
    }

    @PostMapping("/group")
    @ApiOperation(value = "Salva um grupo")
    public GroupModel saveGroup(@RequestBody GroupModel group) {
        if (group.getId() == null){
            group.setCreatedAt(LocalDate.now());
        }

            return groupRepository.save(group);
    }

    @DeleteMapping("/group")
    @ApiOperation(value = "Deleta um grupo")
    public void deleteGroup(@RequestBody GroupModel group) {
        groupRepository.delete(group);
    }
}
