package com.example.demo.repository;

import com.example.demo.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OneToOne extends JpaRepository<UserProfile,Integer> {
}
