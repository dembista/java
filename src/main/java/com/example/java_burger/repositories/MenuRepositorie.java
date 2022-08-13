package com.example.java_burger.repositories;

import com.example.java_burger.models.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepositorie extends JpaRepository<Menu, Long> {
}
