package com.br.DVDR.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_expense")
@Data
@NoArgsConstructor
public class ExpenseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String title;

    private double price;

    private int quantity;

    private LocalDate date;

    @ManyToOne
    private GroupModel group;
}
