package com.example.hotelteam.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Chief {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chiefNum;
    private String chiefName;
}
