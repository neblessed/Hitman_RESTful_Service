package com.hitmans.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "weapons")
public class Weapon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="weapon_name")
    private String weaponName;
    @Column(name="quantity")
    private int weaponQuantity;
    @Column(name="hitman_id")
    private int hitmanLinkId;
}
