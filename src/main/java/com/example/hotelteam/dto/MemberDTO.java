package com.example.hotelteam.dto;

import lombok.*;

import javax.management.relation.Role;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MemberDTO {
    private Long memberNum;
    private String memberEmail;
    private String memberName;
    private String memberPassword;
    private String role;
}
