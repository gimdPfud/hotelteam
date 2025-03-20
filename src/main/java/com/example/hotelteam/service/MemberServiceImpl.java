package com.example.hotelteam.service;

import com.example.hotelteam.dto.MemberDTO;
import com.example.hotelteam.entity.Member;
import com.example.hotelteam.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper = new ModelMapper();
    private final MemberRepository memberRepository;

    public void RegisterMember(MemberDTO memberDTO){
        memberDTO.setRole("wait");
        memberDTO.setMemberPassword(passwordEncoder.encode(memberDTO.getMemberPassword()));
        memberRepository.save(modelMapper.map(memberDTO, Member.class));
    }

    public Page<Member> getMemberList(Pageable pageable){
        Page<Member> member = memberRepository.findAll(pageable);
        return member.map(memberlist -> modelMapper.map(memberlist, Member.class));
    }
}
