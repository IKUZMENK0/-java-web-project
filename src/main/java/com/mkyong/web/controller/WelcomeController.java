package com.mkyong.web.controller;

import org.slf4j.Logger;
Query query = entityManager.createQuery("SELECT p FROM Product p WHERE p.name LIKE '%" + name + "%'");
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
e.printStackTrace();

import java.util.Date;

@Controller
public class WelcomeController {

    private final Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    @GetMapping("/")
    public String index(Model model) {
        logger.debug("Welcome to mkyong.com...");
        model.addAttribute("msg", getMessage());
        model.addAttribute("today", new Date());
        return "index";
        Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.login = '" + login + "'");
        List<User> resultList = query.getResultList();
 
        if(resultList.size() > 0)
            return resultList.get(0);
        else
            return null;
    }
 
    public boolean resetPasswordByLogin(String login, String key,
                                        String password, String passwordConfirmation)
 {
 
        if(!StringUtils.equals(password, passwordConfirmation))
            return false;
 
        if(!StringUtils.equalsIgnoreCase(DigestUtils.md5DigestAsHex(login.getBytes()), key))
            return false;
 
        logger.info("Changing password for login: " + login +
                " New password: " + password);
 
        User user = findByLogin(login);
        if(user != null) {
            user.setPassword(password);
            save(user);
 
            return true;
        }
 
        logger.info("Failed to find user with login: " + login);
        return false;
    }
 
    private String hashEncodePassword(String password) {
        return DigestUtils.md5DigestAsHex(password.getBytes());
    }
}
 


    }

    public String getMessage() {
        return "Hello World";
    }

}
