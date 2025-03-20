package com.example.hotelteam.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeNum;/*pk*/

    @Column(nullable = false)
    private String storeStatus;/*가맹점인지 직영점인지?*/

    @Column(nullable = false)
    private String storeBrand;/*프랜차이즈 이름*/

    private String storeName;/*가게 이름*/

    @Column(nullable = false)
    private String storeManagerName;/*가게 담당자 이름 : 가맹이면 사장, 직영이면 담당자..*/

    @Column(nullable = false)
    private String storeManagerContact;/*가게 담당자 연락처*/

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_num")
    private Hotel hotel;
}