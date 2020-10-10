package com.br.DVDR.models;

import com.br.DVDR.enums.FriendshipStatusEnum;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tb_friendship")
@NoArgsConstructor
public class FriendshipModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    private UserModel user;

    @OneToOne(fetch = FetchType.EAGER)
    private UserModel friend;

    @Enumerated(EnumType.STRING)
    private FriendshipStatusEnum status;



}
