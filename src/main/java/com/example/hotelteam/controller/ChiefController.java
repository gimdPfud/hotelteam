package com.example.hotelteam.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@NoArgsConstructor
@RequestMapping("/chief")
public class ChiefController {

    @GetMapping("/view")
    public String chiefView() {
        return "chief/view";
    }

    @GetMapping ("/adddistributor")
    public String addDistributorView() {
        return "chief/adddistributor";
    }

    @PostMapping("/adddistributor")
    public String adddistributorPost() {
        return "redirect:/chief/view";
    }

    @PostMapping("/deletedistributor")
    public String deletedistributorPost() {
        return "redirect:/chief/view";
    }

}
