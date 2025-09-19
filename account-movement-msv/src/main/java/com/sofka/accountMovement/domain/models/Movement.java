package com.sofka.accountMovement.domain.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "movements")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Movement {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(name = "movement_type", nullable = false, length = 20)
    private String movementType;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal value;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal balance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    public Movement(String movementType, BigDecimal value, BigDecimal balance, Account account) {
        this.date = LocalDateTime.now();
        this.movementType = movementType;
        this.value = value;
        this.balance = balance;
        this.account = account;
    }
}
