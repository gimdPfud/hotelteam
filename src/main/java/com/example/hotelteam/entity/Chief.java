package com.example.hotelteam.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Chief {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long chiefNum;

    String chiefame;

}
