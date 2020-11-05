package com.br.DVDR.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "tb_User")
@Data
public class UserModel implements Serializable {
    @Id
    @Column(name = "uid", nullable = false, unique = true)
    private String UID;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "exclusive_user_name")
    private String exclusive_user_name;

    @Column(name = "phone")
    private String phone;


}
