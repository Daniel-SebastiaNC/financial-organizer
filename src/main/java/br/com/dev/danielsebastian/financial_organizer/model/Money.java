package br.com.dev.danielsebastian.financial_organizer.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "TB_MONEY")
public class Money {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = false)
    private String name;

    @Column(nullable = true)
    private Double money;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private boolean isPositive;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Money(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isPositive() {
        return isPositive;
    }

    public void setPositive(boolean positive) {
        isPositive = positive;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
