package com.br.DVDR.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tb_usergroup")
public class UserGroupModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @OneToOne
    private UserModel user;

    @OneToOne
    private GroupModel group;

    private boolean isAdmin;

    private boolean isReceptor;
}
