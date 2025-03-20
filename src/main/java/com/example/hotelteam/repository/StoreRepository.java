package com.example.hotelteam.repository;

import com.example.hotelteam.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long> {
    //정확한 가게 이름으로 찾기
    public List<Store> findByStoreBrand (String brandName);

    //가게 이름으로 찾기
    public List<Store> findByStoreBrandContaining (String Keyword);

    //호텔pk로 찾기
    public List<Store> findByHotel_HotelNum(Long hotelNum);

    //호텔pk와 상태(가맹,직영)로 찾기
    public List<Store> findByHotel_HotelNumAndStoreStatus(Long hotelNum, String storeStatus);
}