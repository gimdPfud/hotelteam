package com.example.hotelteam.controller;

import com.example.hotelteam.dto.HotelDTO;
import com.example.hotelteam.service.HotelService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/update/{hotelNum}")
    public String update(@PathVariable("hotelNum") Long hotelNum, Model model){
        HotelDTO hotelDTO = hotelService.read(hotelNum);
        model.addAttribute("hotelDTO", hotelDTO);
        return "/hotel/update";
    }

    @PostMapping("/update/{hotelNum}")
    public String updatePost(@PathVariable("hotelNum")Long hotelNum, HotelDTO hotelDTO){
        hotelService.register(hotelDTO);
        return "redirect:/hotel/read/{hotelNum}";
    }

    @GetMapping("/read/{hotelNum}")
    public String read(@PathVariable("hotelNum") Long hotelNum, Model model){
        HotelDTO hotelDTO = hotelService.read(hotelNum);
        model.addAttribute("hotelDTO", hotelDTO);
        return "/hotel/read";
    }

    @GetMapping("/del/{hotelNum}")
    public String del(HotelDTO hotelDTO){
        hotelService.del(hotelDTO.getHotelNum());
        return "redirect:/hotel/list";
    }


}
