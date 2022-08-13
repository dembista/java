package com.example.java_burger.repositories;

import com.example.java_burger.models.Burger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BurgerRepositorie extends JpaRepository<Burger, Long> {
}
