package com.example.hotelteam.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ChiefDTO {

    private Long chiefNum;
    private String chiefName;

}
