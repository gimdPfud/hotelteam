package com.example.hotelteam.controller;

import com.example.hotelteam.dto.StoreDTO;
import com.example.hotelteam.service.StoreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

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
    public String registerPost(@Valid StoreDTO storeDTO, BindingResult bindingResult, Model model){
        log.info("등록 포스트 : "+storeDTO);
        if(bindingResult.hasErrors()){
            log.info("실패");
            model.addAttribute("msg", "상점을 등록할 수 없습니다. 다시 작성해주세요.");
            return "store/register";
        } else {
            storeService.registerStore(storeDTO);
            return "redirect:/store/list?hotelNum="+storeDTO.getHotelNum();
        }
    }

    /*가맹직영점 목록*/
    @GetMapping("/list")
    public String listGet(Long hotelNum, Model model){
        log.info("목록 진입");
        List<StoreDTO> storeDTOList= storeService.listStore(hotelNum);
        model.addAttribute("storeDTOList", storeDTOList);
        return "store/list";
    }

    /*가맹직영점 상세보기*/
    @GetMapping("/read")
    public String readGet(Long storeNum, Model model){
        log.info("상세 진입");
        StoreDTO storeDTO = storeService.detailStore(storeNum);
        model.addAttribute("storeDTO", storeDTO);
        return "store/read";
    }

    /*가맹직영점 수정*/
    @GetMapping("/modify")
    public String modifyGet(Long storeNum, Model model){
        log.info("수정 진입");
        StoreDTO storeDTO = storeService.detailStore(storeNum);
        model.addAttribute("storeDTO", storeDTO);
        return "store/modify";
    }
    @PostMapping("/modify")
    public String modifyPost(@Valid StoreDTO storeDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        log.info("수정 포스트");
        if(bindingResult.hasErrors()){
            log.info("실패");
            redirectAttributes.addAttribute("msg", "상점을 등록할 수 없습니다. 다시 작성해주세요.");
            return "redirect:/store/modify?storeNum="+storeDTO.getStoreNum();
        } else {
            storeService.modifyStore(storeDTO);
            return "redirect:/store/read?storeNum="+storeDTO.getStoreNum();
        }
    }

    /*가맹직영점 삭제*/
    @GetMapping("/delete")
    public String deleteGet(Long storeNum){
        log.info("삭제 진입 : "+storeNum);
        StoreDTO storeDTO = storeService.detailStore(storeNum);
        storeService.deleteStore(storeNum);
        return "redirect:/store/list?hotelNum="+storeDTO.getHotelNum();
    }
}
