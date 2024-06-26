package com.personal.expenses.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cost_center")
public class CostCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "costCenterId")
    private Long id;
    @Column(nullable = false)
    private String description;
    @Column(columnDefinition = "TEXT")
    private String observation;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    @ManyToMany
    @JsonBackReference
    private List<Title> titles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

   public List<Title> getTitles() {
        return titles;
    }

    public void setTitles(List<Title> titles) {
       this.titles = titles;
    }
}
