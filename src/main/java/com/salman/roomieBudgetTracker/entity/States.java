package com.salman.roomieBudgetTracker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "states")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class States {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stateId;

    private String name;


}
