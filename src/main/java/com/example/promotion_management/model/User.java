package com.example.promotion_management.model;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    private String name;
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Redemption> redemptions;

  
}