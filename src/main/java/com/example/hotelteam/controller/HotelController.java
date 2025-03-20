package com.example.hotelteam.controller;

import com.example.hotelteam.dto.HotelDTO;
import com.example.hotelteam.service.HotelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/hotel")
public class HotelController {
    private final HotelService hotelService;

    @GetMapping("/list")
    public String list(Pageable pageable, Model model){
        Page<HotelDTO> hotelDTOPage = hotelService.list(pageable);
        model.addAttribute("hotelDTOPage", hotelDTOPage);
        return "/hotel/list";
    }

    @GetMapping("/register")
    public String register(){
        return "/hotel/register";
    }

    @PostMapping("/register")
    public String registerPost(HotelDTO hotelDTO){
        hotelService.register(hotelDTO);
        return "redirect:/hotel/list";
    }

    @GetMapping("/read")
    public String read(HotelDTO hotelDTO){
        return "/hotel/read";
    }


}
