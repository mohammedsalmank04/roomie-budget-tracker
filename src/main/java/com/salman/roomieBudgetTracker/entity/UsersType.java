package com.salman.roomieBudgetTracker.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users_type")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UsersType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userTypeId;

    private String userTypeName;

    /*@OneToMany(targetEntity = Accounts.class, mappedBy = "usersTypeId")
    private List<Accounts> accounts;*/

}
