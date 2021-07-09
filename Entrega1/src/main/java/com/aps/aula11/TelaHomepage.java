package com.aps.aula11;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.aps.aula11.IRepositorioUser;
import com.aps.aula11.RepositorioUser;

@Controller
public class TelaHomepage {

    @GetMapping("/homepage")
    public String doLogin(Model model) {
        // IRepositorioUser IRU = new RepositorioUser();
        // RU.getUsers(); 
        // Provavelmente não deve ser chamada a interface: java avisa que interfaces não podem ser instaciadas
        RepositorioUser RU = new RepositorioUser();
        RU.getUsers();
        return "homepage";
    }

}