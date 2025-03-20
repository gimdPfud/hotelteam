package com.example.hotelteam.controller;

import com.example.hotelteam.dto.ChiefDTO;
import com.example.hotelteam.dto.MemberDTO;
import com.example.hotelteam.service.ChiefService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/chief")
@Log4j2
public class ChiefController {

    private final ChiefService chiefService;
    @GetMapping("/view")
    public String chiefView(Principal principal, Pageable pageable, Model model) {

        Page<ChiefDTO> chiefDTOList = chiefService.getCheifList(principal, pageable);

        model.addAttribute("chiefList", chiefDTOList);
        return "chief/view";
    }

    @GetMapping ("/adddistributor")
    public String addDistributorView() {

        return "chief/adddistributor";
    }

    @PostMapping("/adddistributor")
    public String adddistributorPost(ChiefDTO chiefDTO, Principal principal) {
        chiefService.addChief(chiefDTO, principal);
        return "redirect:/chief/view";
    }

    @PostMapping("/updatedistributor")
    public String updateDistributorView(ChiefDTO chiefDTO) {
        chiefService.updateChief(chiefDTO);
        return "chief/updatedistributor";
    }

    @PostMapping("/deletedistributor")
    public String deletedistributorPost(Long chiefNum) {
        chiefService.deleteChief(chiefNum);
        return "redirect:/chief/view";
    }

}
