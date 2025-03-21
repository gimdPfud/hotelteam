package com.example.hotelteam.service;

import com.example.hotelteam.dto.ChiefDTO;
import com.example.hotelteam.entity.Chief;
import com.example.hotelteam.repository.ChiefRepository;
import com.example.hotelteam.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@ToString
@Log4j2
@Service
@RequiredArgsConstructor
public class ChiefServiceImpl implements ChiefService {

    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper = new ModelMapper();
    private final ChiefRepository chiefRepository;

    public List<ChiefDTO> getChiefList(Principal principal, Pageable pageable) {
        log.info("맴버메일 : {}" , principal.getName());
        List<Chief> chiefList = chiefRepository.findByMember_MemberEmail(principal.getName());
        List<ChiefDTO> chiefDTOList = new ArrayList<>();
         for (Chief chief : chiefList) {
             chiefDTOList.add(modelMapper.map(chief, ChiefDTO.class));
         }
        return chiefDTOList;
    }

    public void addChief(ChiefDTO chiefDTO, Principal principal) {

        if (chiefRepository.findByMember_MemberEmail(principal.getName()).size() >= 3) {
        } else {
            Chief chieft = modelMapper.map(chiefDTO, Chief.class);
            chiefRepository.save(chieft);
        }
    }

    public void updateChief(ChiefDTO chiefDTO) {
        Chief chief = modelMapper.map(chiefDTO, Chief.class);
        chiefRepository.save(chief);
    }

    public void deleteChief(Long chiefNum) {
        chiefRepository.deleteById(chiefNum);
    }
}


