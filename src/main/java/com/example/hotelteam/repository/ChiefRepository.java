package com.example.hotelteam.repository;

import com.example.hotelteam.entity.Chief;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChiefRepository extends JpaRepository<Chief, Long> {

    List<Chief> findByMember_MemberEmail(String memberEmail);

//    @Query("SELECT c FROM Chief c JOIN FETCH c.member WHERE c.member.memberEmail = :memberEmail")
//    List<Chief> findByMemberEmail(String memberEmail);


}
