package com.example.hotelteam.service;

import com.example.hotelteam.dto.AdminDTO;
import com.example.hotelteam.dto.ChiefDTO;
import com.example.hotelteam.entity.Admin;
import com.example.hotelteam.entity.Chief;
import com.example.hotelteam.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;
    private final ModelMapper modelMapper =  new ModelMapper();

    //Chief pk받아서 Chief가 갖고있는 본사(총판)를 보여주는 목록인지
    //뭐하는 목록이지 뭐하는 목록이세요
    //Chief가 갖고있는 본사(총판), 호텔, 가게,게시판 다 볼 수 있는건가 다 참조하고있으니까
    //그럼 Chief의 entity, pk를 갖고와서 Chief의 DTO로 변환을 해야하는가

    //목록 진쯔 모루겟어요 ~ ,, 뭐를 보여줘야하는거임? ㅋ ㅋ   ㅋ ㅋ
//    @Override
//    public List<ChiefDTO> adminList(Chief cheifNum) {   //Cheif cheifNum맞나 ?
//        //entity를 DTO로 변환(List로 받는다.)
//
//        //entity List를 가져온다.
//        List<Chief> chiefs = adminRepository.findAll();
//
//        //DTOList를 만든다.
//        List<ChiefDTO> chiefDTOList = new ArrayList<>();
//
//        for (Chief cheif : chiefs) {
//            //entity DTO로 변환
//            ChiefDTO cheifDTO = modelMapper.map(cheif, ChiefDTO.class);
//            //DTO로 변환한 거 DTOList에 추가
//            chiefDTOList.add(cheifDTO);
//        }
//
//        //DTOList 반환
//        return chiefDTOList;
//    }


//    @Override
//    public List<ChiefDTO> adminList(Chief cheifNum) {
//        return List.of();
//    }

    @Override
    public AdminDTO adminRead(Long adminNum) {

        //pk로 entitiy 찾아서 DTO로 변환
        Admin admin = adminRepository.findById(adminNum).orElseThrow();

        return modelMapper.map(admin, AdminDTO.class);
    }

    //본사(총판) 등록 ? ? ? ?
    @Override
    public void adminRegister(AdminDTO adminDTO) {
        log.info("등록 페이지에 들어온 값 : " + adminDTO);

        //DTO를 entity로 변환
        Admin admin = modelMapper.map(adminDTO, Admin.class);
        adminRepository.save(admin);
    }

    //본사(총판) 정보 업데이트 ? ? ?
    @Override
    public void adminUpdate(AdminDTO adminDTO) {
        log.info("수정 페이지에 들어온 값 : " + adminDTO);

        //들어온 DTO를 entity로 변환
        Admin admin = modelMapper.map(adminDTO, Admin.class);
        adminRepository.save(admin);

    }

    //본사(총판) 삭제 ? ? ?
    @Override
    public void adminDelete(Long adminNum) {
        log.info("삭제 페이지에 들어온 값 : " + adminNum);

        //pk로 삭제
        adminRepository.deleteById(adminNum);

    }



}
