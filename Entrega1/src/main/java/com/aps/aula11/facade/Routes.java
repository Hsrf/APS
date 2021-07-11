package com.aps.aula11;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.aps.aula11.RepositoryUser;
import com.aps.aula11.Date;

@Controller
public class Routes {

    @GetMapping("/homepage")
    public String loadPage(Model model) {
        return "homepage";
    }

    @RequestMapping("/homepage")
    public String doLogin(@RequestParam("email") String email, @RequestParam("password") String password){
        RepositoryUser RU = new RepositoryUser();
        boolean retorno = RU.getUser(email, password);
        String answer = (retorno ? "redirect:dashboard" : "homepage" );
        return answer;
    }

    @GetMapping("/dashboard")
    public String loadPageDashboard() {
        return "dashboard";
    }
    
}