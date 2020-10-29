package com.br.DVDR.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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

    @OneToOne
    private UserModel createdBy;

    @ManyToOne
    private GroupModel group;

    @JsonIgnore
    @OneToMany( cascade = CascadeType.ALL, mappedBy = "expense")
    private List<UserExpenseModel> userExpenses;
}
