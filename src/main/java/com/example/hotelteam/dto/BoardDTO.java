package com.example.hotelteam.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDTO {
    private Long boardNum;
    private String boardTitle;
    private String boardContent;
}
