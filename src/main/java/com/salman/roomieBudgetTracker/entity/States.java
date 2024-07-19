package com.salman.roomieBudgetTracker.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "states")
public class States {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stateId;

    private String name;

    public States() {
    }

    public States(int stateId, String name) {
        this.stateId = stateId;
        this.name = name;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "States{" +
                "stateId=" + stateId +
                ", name='" + name + '\'' +
                '}';
    }
}
