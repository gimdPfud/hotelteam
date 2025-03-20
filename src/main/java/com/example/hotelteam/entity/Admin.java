package com.example.hotelteam.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_num")
    Long adminNum;

    @Column(length = 20)
    String adminName;

    @Column(length = 100)
    String adminAddr;

    //@ManyToOne
    //@JoinColumn(name = "chiefNum")
    //private Chief chief;

}
