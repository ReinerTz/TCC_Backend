package com.br.DVDR.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tb_userexpense")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserExpenseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private UserGroupModel userGroup;

    @OneToOne
    private ExpenseModel expense;

    private boolean checked;

    private double price;

    private double percent;
}
