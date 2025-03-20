package com.example.hotelteam.repository;

import com.example.hotelteam.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    public Admin findByChief_ChiefName(String chiefName);


}
