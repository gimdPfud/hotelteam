package com.example.hotelteam.dto;

import com.example.hotelteam.entity.Chief;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AdminDTO {

    Long adminNum;

    String adminName;

    String adminAddr;

    private Chief chief;

}
