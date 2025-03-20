package com.example.hotelteam.service;

import com.example.hotelteam.dto.AdminDTO;
import com.example.hotelteam.dto.ChiefDTO;
import com.example.hotelteam.entity.Admin;
import com.example.hotelteam.entity.Chief;

import java.util.List;

public interface AdminService {

    //admin ? chief ? 목록 (entity를 DTO로 변환) 이거 뭔 목록인지 모루겟음 ㅋ
    //public List<ChiefDTO> adminList(Chief cheifNum);




    //admin 상세보기 (entity를 DTO를 변환)
    public AdminDTO adminRead(Long adminNum);

    //admin 등록 (DTO를 entity로 변환)
    public void adminRegister(AdminDTO adminDTO);

    //admin 수정 (DTO를 entity로 변환)
    public void adminUpdate(AdminDTO adminDTO);

    //admin 삭제
    public void adminDelete(Long adminNum);

}
