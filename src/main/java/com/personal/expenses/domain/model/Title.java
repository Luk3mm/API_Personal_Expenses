package com.personal.expenses.domain.model;

import com.personal.expenses.domain.enu.TypeTitle;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Title {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTitle")
    private Long id;
    @Column(nullable = false)
    private String description;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    private TypeTitle type;
    @ManyToMany
    private List<CostCenter> costCenters;
    @Column(nullable = false)
    private double valor;
    private Date registerDate;
    private Date referenceDate;
    private Date maturityDate;
    private Date paymentDate;
    @Column(columnDefinition = "TEXT")
    private String observation;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TypeTitle getType() {
        return type;
    }

    public void setType(TypeTitle type) {
        this.type = type;
    }

    public List<CostCenter> getCostCenters() {
        return costCenters;
    }

    public void setCostCenters(List<CostCenter> costCenters) {
        this.costCenters = costCenters;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Date getReferenceDate() {
        return referenceDate;
    }

    public void setReferenceDate(Date referenceDate) {
        this.referenceDate = referenceDate;
    }

    public Date getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
}
