package com.example.hotelteam.controller;

import com.example.hotelteam.dto.MemberDTO;
import com.example.hotelteam.entity.Member;
import com.example.hotelteam.service.MemberService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@ToString
@Log4j2
@Controller
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/login")
    public String login() {
        return "member/login";
    }

    @GetMapping("/main")
    public String main() {
        return "main";
    }

    @PostMapping("/login")
    public void login(String memberEmail, String memberPassword) {

    }

    @PostMapping("/signup")
    public String signup(MemberDTO memberDTO) {
        memberService.RegisterMember(memberDTO);
        return "redirect:/main";
    }

    @GetMapping("/permission")
    public String memberPermission(Pageable pageable, Model model) {
        Page<Member> memberList = memberService.getMemberList(pageable);

        model.addAttribute("memberList", memberList);
        return "member/permission";
    }
}
