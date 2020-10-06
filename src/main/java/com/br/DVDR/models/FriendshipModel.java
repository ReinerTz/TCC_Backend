package com.br.DVDR.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tb_friendship")
@NoArgsConstructor
public class FriendshipModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private UserModel user;

    @OneToOne(fetch = FetchType.LAZY)
    private UserModel friend;

    private boolean pending;

    private boolean received;


}
