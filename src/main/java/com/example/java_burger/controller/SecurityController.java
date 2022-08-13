package com.example.java_burger.controller;

import com.example.java_burger.models.Client;
import com.example.java_burger.models.User;
import com.example.java_burger.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecurityController {
    @Autowired
    private UserService userService;

    // Mapping login
    @GetMapping("/login")
    public String getLoginView() {
        return "security/login";
    }

    // Mapping admin
    @GetMapping("/admin/home")
    public String home(Model model){
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        model.addAttribute("msg", "Bonjour " + user.getNom() + " " + user.getPrenom());
        return "admin/commande";
    }

    // Mapping inscription client get
    @GetMapping("/inscription")
    public String inscription(Model model){
       // ModelAndView modelAndView = new ModelAndView();
        Client user = new Client();
        model.addAttribute("user", user);
        return "security/inscription";
    }

    // Mapping inscription post client

    @RequestMapping(value = "/inscription", method = RequestMethod.POST)
    public ModelAndView createNewUser( Client user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        Client userExists = (Client) userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("userName", "error.user",
                            "There is already a user registered with the user name provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("inscription");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new Client());
            modelAndView.setViewName("inscription");

        }
        return modelAndView;
    }

}
