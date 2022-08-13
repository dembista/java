package com.example.java_burger.fixtures;

import com.example.java_burger.models.Burger;
import com.example.java_burger.services.MenuService;
import org.springframework.stereotype.Component;

@Component
public class BurgerFixeture {
    private MenuService ms;

    public void load() {
        Burger burger = new Burger();

        burger.setDescription("fdqvdgchdv");
        burger.setNom("Burger thease");
        burger.setPrix(2000);
        ms.ajoutBurger(burger);
    }
}
