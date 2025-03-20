package com.example.hotelteam.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "hotel_num")
    private Long hotelNum;

    @Column(nullable = false)
    private String hotelName;

    @Column(nullable = false)
    private String hotelAddr;

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "admin_num")
    //private Admin admin;
}
