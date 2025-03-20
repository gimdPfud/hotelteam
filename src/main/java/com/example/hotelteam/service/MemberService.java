package com.example.hotelteam.service;

import com.example.hotelteam.dto.MemberDTO;
import com.example.hotelteam.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberService {
    void RegisterMember(MemberDTO memberDTO);

    public Page<Member> getMemberList(Pageable pageable);
}
