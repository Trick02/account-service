package com.trick02.accountservice.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(name = "customer_mobile", nullable = false)
    private String customerMobile;

    @Column(name = "customer_email", unique = true, nullable = false)
    private String customerEmail;

    @Column(name = "address_1", nullable = false)
    private String address1;

    @Column(name = "address_2")
    private String address2;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, columnDefinition = "ENUM('S', 'C') default 'S'", name = "account_type", nullable = false)
    private AccountType accountType;

    @Builder.Default
    @JsonManagedReference(value = "account-savings")
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "account")
    private Set<Savings> savings = new HashSet<>();

    public enum AccountType {
        S("Savings"),
        C("Checking");

        private String type;

        AccountType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }
}
