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
public class Chief {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chief_num")
    private Long chiefNum;

    private String chiefName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberNum")
    private Member member;

}
