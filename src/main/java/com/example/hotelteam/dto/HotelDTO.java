package com.example.hotelteam.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class HotelDTO {
    private Long hotelNum;  //pk
    private String hotelName;   //호텔 이름
    private String hotelAddr;   //호텔 주소

    //private Admin admin;  //호텔이 참조하는 본사(총판)
}

