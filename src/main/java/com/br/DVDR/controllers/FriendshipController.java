package com.br.DVDR.controllers;

import com.br.DVDR.models.FriendshipModel;
import com.br.DVDR.models.UserModel;
import com.br.DVDR.repository.FriendshipRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api")
@Api(value = "API das amizades")
@CrossOrigin(origins = "*")
public class FriendshipController {
    @Autowired
    private FriendshipRepository friendshipRepository;

    @GetMapping("/friend/{id}")
    @ApiOperation(value = "Retorna a lista de contatos do usuário")
    public Optional<List<FriendshipModel>> findFriendship(@PathVariable(value = "id") String uid){
        return friendshipRepository.findByUser(uid);
    }

    @GetMapping("/friendsByUser/{id}")
    @ApiOperation(value = "Retorna a lista de contatos do usuário")
    public Optional<List<FriendshipModel>> findAllFriendsByUser(@PathVariable(value = "id") String uid){
        return friendshipRepository.findAllFriendsByUser(uid);
    }

    @PostMapping("/friend")
    @ApiOperation(value = "Salva um grupo")
    public FriendshipModel saveFriendship(@RequestBody FriendshipModel friendship){
        return friendshipRepository.save(friendship);
    }

    @PutMapping("/friend")
    @ApiOperation(value = "Atualiza um grupo")
    public FriendshipModel updateFriendship(@RequestBody FriendshipModel friendship){
        return friendshipRepository.save(friendship);
    }

    @DeleteMapping("/friend")
    @ApiOperation(value = "Deleta um grupo")
    public void deleteFriendship(@RequestBody FriendshipModel friendship){
        friendshipRepository.delete(friendship);
    }


    @PostMapping("/find-friendship")
    @ApiOperation(value = "Retorna o relacionamento de amizade entre dois usuários")
    public Optional<List<FriendshipModel>> searchFriendship(@RequestBody List<UserModel> friendship){
        return friendshipRepository.findFriendship(friendship.get(0).getUID(), friendship.get(1).getUID());
    }
}
