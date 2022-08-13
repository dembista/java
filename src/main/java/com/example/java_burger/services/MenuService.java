package com.example.java_burger.services;

import com.example.java_burger.models.Burger;
import com.example.java_burger.models.Menu;
import com.example.java_burger.repositories.BurgerRepositorie;
import com.example.java_burger.repositories.MenuRepositorie;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log
public class MenuService {
    @Autowired
    private BurgerRepositorie burgerRepositorie;

    @Autowired
    private MenuRepositorie menuRepositorie;

    // ################## service burger ############

    // ####ajouter burger ####
    public Burger ajoutBurger(Burger burger){
        try {
            burgerRepositorie.save(burger);
            return burger;
        }catch (Exception e) {
            log.severe(e.getLocalizedMessage());
            throw e;
        }
    }
    // ####lister burger ####
    public List<Burger> getBurgerList(){
        return burgerRepositorie.findAll();
    }

    // ################## service Menu ############

    // ####ajouter Menu ####
    public Menu ajoutMenu(Menu menu){
        try {
            menuRepositorie.save(menu);
            return menu;
        }catch (Exception e) {
            log.severe(e.getLocalizedMessage());
            throw e;
        }
    }
    // ####lister Menu ####
    public List<Menu> getMenuList(){
        return menuRepositorie.findAll();
    }
}
