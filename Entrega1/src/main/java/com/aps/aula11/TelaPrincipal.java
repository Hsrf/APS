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
import com.aps.aula11.RepositorioUser;
import com.aps.aula11.Date;

public class TelaPrincipal {
    
    @GetMapping("/telaprincipal")
    public String loadPage(Model model) {
        return "telaprincipal";
    }
    
}