package com.example.hotelteam.service;

import com.example.hotelteam.dto.ChiefDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.security.Principal;
import java.util.List;

public interface ChiefService {

    public List<ChiefDTO> getChiefList(Principal principal, Pageable pageable);

    public void addChief(ChiefDTO chiefDTO, Principal principal);

    public void updateChief(ChiefDTO chiefDTO);

    public void deleteChief(Long chiefNum);

}
