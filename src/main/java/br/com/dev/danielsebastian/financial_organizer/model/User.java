package br.com.dev.danielsebastian.financial_organizer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "T_USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = false)
    private String name;

    @Column(nullable = true)
    private Double total_Money;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Money> money = new HashSet<>();

    public User(){}

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

    public Double getTotal_Money() {
        return total_Money;
    }

    public void setTotal_Money(Double total_Money) {
        this.total_Money = total_Money;
    }

    public Set<Money> getMoney() {
        return money;
    }

    public void setMoney(Set<Money> money) {
        this.money = money;
    }
}
