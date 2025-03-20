package com.example.hotelteam.service;

import com.example.hotelteam.dto.HotelDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HotelService {
    public Page<HotelDTO> list(Pageable pageable);
    public void register(HotelDTO hotelDTO);
    public HotelDTO read(Long hotelNum);
    public Long del(Long hotelNum);
}
