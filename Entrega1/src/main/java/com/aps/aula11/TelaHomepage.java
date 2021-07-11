package com.aps.aula11;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.aps.aula11.RepositorioUser;
import com.aps.aula11.Date;

@Controller
public class TelaHomepage {

    @GetMapping("/homepage")
    public String loadPage(Model model) {
        model.addAttribute("User", new User("teste@teste.com", "123", "testinho", 0, new Date(31,12,2021)));
        return "homepage";
    }

    @RequestMapping("/homepage")
    public void doLogin(@RequestParam("email") String email, @RequestParam("password") String password){
        RepositorioUser RU = new RepositorioUser();
        boolean retorno = RU.getUser(email, password);
        System.out.printf("Tentei fazer login"+ email + password + retorno + "\n\n\n\n\n\n\n\n");
        return;
    }
}