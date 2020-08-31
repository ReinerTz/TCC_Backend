package com.br.DVDR.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "tb_User")
@Getter
@Setter
public class UserModel implements Serializable {
    @Id
    @Column(name = "uid", nullable = false, unique = true)
    private String UID;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "exclusive_user_name", unique = true)
    private String exclusive_user_name;

    @Column(name = "phone")
    private String phone;
}
