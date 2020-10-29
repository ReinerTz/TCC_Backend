package com.br.DVDR.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "tb_usergroup")
public class UserGroupModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne
    private UserModel user;

    @OneToOne
    private GroupModel group;

    private boolean isAdmin;

    private boolean isReceptor;

    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany( mappedBy = "userGroup", cascade = CascadeType.ALL, orphanRemoval=true)
    private List<UserExpenseModel> userExpenses;
}
