package com.example.hotelteam.service;

import com.example.hotelteam.dto.StoreDTO;

import java.util.List;

public interface StoreService {
    //가맹직영점 등록
    public Long registerStore(StoreDTO storeDTO);

    //가맹직영점 수정(담당자 정보 수정?)
    public Long modifyStore(StoreDTO storeDTO);

    //가맹직영점 삭제
    public void deleteStore(Long storeNum);

    //가맹직영점 상세보기
    public StoreDTO detailStore (Long storeNum);

    //가맹직영점 목록 보기
    public List<StoreDTO> listStore (String storeName);
    public List<StoreDTO> listStore (Long hotelNum);
    public List<StoreDTO> listStore (Long hotelNum, String storeStatus);
    public List<StoreDTO> listStore ();
}