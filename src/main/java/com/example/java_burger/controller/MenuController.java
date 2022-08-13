package com.example.java_burger.controller;

import com.example.java_burger.models.Burger;
import com.example.java_burger.models.Menu;
import com.example.java_burger.repositories.BurgerRepositorie;
import com.example.java_burger.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.List;

@Controller
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("/catalogue")
    public String getViewAllBurger(Model model) {
        List<Burger> burgers = menuService.getBurgerList();
        model.addAttribute("burgers", burgers);
        return "index";
    }

    //Ajouter burger
    @GetMapping("/burger-add")
    public String getViewAddBurger(Model model) {
        Burger burger = new Burger();

        model.addAttribute("burger", burger);
        return "catalogue/categorie-add";
    }

    @Autowired
    private BurgerRepositorie repo;
    //Post mapping

    @PostMapping("/burger-add")
    public String ajouterBurger(@ModelAttribute("burger") Burger burger, Model model) throws IOException {

        if (burger == null || burger.getNom() == null || burger.getNom().equals("")) {
            model.addAttribute("errorNom", "Champ obligatoire");
            return "categorie/categorie-add";
        }

      /*  String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

        burger.setImage(fileName);

        Burger savedBuger = repo.save(burger);

        String uploadDir = "images/" + savedBuger.getId();

        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);*/
        menuService.ajoutBurger(burger);
        if (burger.getId() != null) {
            return "redirect:/burger-add";
        } else {
            model.addAttribute("error", "Echec de l'operation");
            return "catalogue/categorie-add";
        }
    }

    // Get menu
    @GetMapping("/menu-add")
    public String getMenuAdd(Model model){
        Menu menu = new Menu();
        model.addAttribute("menu", menu);
        return "catalogue/menu-add";
    }

    //Post menu
    @PostMapping("/menu-add")
    public String ajouterMenu(@ModelAttribute("menu") Menu menu, Model model){
        if (menu == null || menu.getNom() == null || menu.getNom().equals("")) {
            model.addAttribute("errorNom", "Champ obligatoire");
            return "catalogue/menu-add";
        }
        menuService.ajoutMenu(menu);
        if (menu.getId() != null) {
            return "redirect:/menu-add";
        } else {
            model.addAttribute("error", "Echec de l'operation");
            return "catalogue/menu-add";
        }
    }
}
