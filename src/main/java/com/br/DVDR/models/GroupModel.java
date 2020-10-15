package com.br.DVDR.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_Group")
@Data
@Getter
@Setter
public class GroupModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "shared_key")
    private String sharedKey;

    private Integer size;

    @Column(name = "created_at")
    private LocalDate createdAt;



}
