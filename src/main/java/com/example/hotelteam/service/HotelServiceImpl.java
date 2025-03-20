package com.example.hotelteam.service;

import com.example.hotelteam.dto.HotelDTO;
import com.example.hotelteam.entity.Hotel;
import com.example.hotelteam.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService{

    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public Page<HotelDTO> list(Pageable pageable) {
        Page<Hotel> hotelPage = hotelRepository.findAll(pageable);
        Page<HotelDTO> hotelDTOPage = hotelPage.map(hotel -> modelMapper.map(hotel, HotelDTO.class));

        return hotelDTOPage;
    }

    @Override
    public void register(HotelDTO hotelDTO) {
        Hotel hotel = new Hotel();
        hotelRepository.save(hotel);
    }
}
