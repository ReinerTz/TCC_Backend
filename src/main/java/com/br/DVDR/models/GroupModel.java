package com.br.DVDR.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_Group")
@Data
public class GroupModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "shared_key")
    private String sharedKey;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name="tb_user_group",
            joinColumns=@JoinColumn(name = "id_group"),
            inverseJoinColumns=@JoinColumn(name = "uid_user")
    )
    private List<UserModel> users;

}
