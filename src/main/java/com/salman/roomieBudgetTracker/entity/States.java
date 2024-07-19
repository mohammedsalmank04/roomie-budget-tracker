package com.salman.roomieBudgetTracker.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "states")
public class States {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stateId;

    private String stateName;

    public States() {
    }

    public States(int stateId, String stateName) {
        this.stateId = stateId;
        this.stateName = stateName;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    @Override
    public String toString() {
        return "States{" +
                "stateId=" + stateId +
                ", stateName='" + stateName + '\'' +
                '}';
    }
}
