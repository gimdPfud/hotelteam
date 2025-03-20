package com.example.hotelteam.controller;

import com.example.hotelteam.dto.AdminDTO;
import com.example.hotelteam.entity.Admin;
import com.example.hotelteam.entity.Chief;
import com.example.hotelteam.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    //어드민리스트ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 가 필요한가
    //뭐하는?
    //url 정리 나중에 해야 ㅠ
    @GetMapping("/list")
    public String adminList(AdminDTO adminDTO, Model model){

        //서비스에서 ChiefDTO 받아옴
        //뭐로 받아야하는거ㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓ지

        //ChiefDTO 변환된 걸 불러와서 모델을 통해 보여주먄 됨
        adminService.adminList(adminDTO);
        model.addAttribute("");

        return "/adminlist";
    }

    @GetMapping("/register")
    public String adminRegister(){


        return "/adminregister";
    }

    @PostMapping("/register")
    public String adminRegister(AdminDTO adminDTO) {

        adminService.adminRegister(adminDTO);

        return "redirect:/admin/list";  //등록 완료하면 목록으로 보내기
    }

    @GetMapping("/update")
    public String adminUpdate(Long adminNum, Model model) {

        //entity를 dto로 변환 후 모델에서 보여줌
        AdminDTO adminDTO = adminService.adminRead(adminNum);
        model.addAttribute("adminDTO", adminDTO);

        return "adminupdate";
    }

    @PostMapping("/{bno}")
    public String adminUpdate(AdminDTO adminDTO) {

        adminService.adminUpdate(adminDTO);

        return "redirect:/admin/list";  //수정 완료하면 목록으로 보내기
    }

    @GetMapping("/delete")
    public String adminDelete(Long adminNum) {

        adminService.adminDelete(adminNum);

        return "redirect:/admin/list";  //삭제 완료하면 목록으로 보내기
    }



}
