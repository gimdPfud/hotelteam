package com.example.hotelteam.controller;

import com.example.hotelteam.service.StoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/store")
public class StoreController {
    private final StoreService storeService;

    /*가맹직영점 등록*/
    @GetMapping("/register")
    public String registerGet(){
        log.info("등록 진입");
        return "store/register";
    }
    @PostMapping("/register")
    public String registerPost(){
        log.info("등록 포스트");
        return "store/list";
    }

    /*가맹직영점 목록*/
    @GetMapping("/list")
    public String listGet(){
        log.info("목록 진입");
        return "store/list";
    }

    /*가맹직영점 상세보기*/
    @GetMapping("/read")
    public String readGet(Long storeNum){
        log.info("상세 진입");
        return "store/read";
    }

    /*가맹직영점 수정*/
    @GetMapping("/modify")
    public String modifyGet(Long storeNum){
        log.info("수정 진입");
        return "store/modify";
    }
    @PostMapping("/modify")
    public String modifyPost(){
        log.info("수정 포스트");
        return "store/modify";
    }

    /*가맹직영점 삭제*/
    @GetMapping("/delete")
    public String deleteGet(Long storeNum){
        log.info("삭제 진입 : "+storeNum);
        storeService.deleteStore(storeNum);
        return "store/list";
    }
}
