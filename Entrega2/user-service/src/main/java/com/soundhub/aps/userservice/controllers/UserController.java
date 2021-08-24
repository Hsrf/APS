package com.soundhub.aps.userservice.controllers;

import com.soundhub.aps.userservice.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


// @RestController
@RequestMapping("/user")
@Controller
public class UserController {
    
    @Autowired
    private UserService service; 

    @GetMapping("/homepage")
	public String getHomepage() {
		return "homepage";
	}

    @GetMapping("/new")
	public String createAccount() {
		return "new";
	}

    @GetMapping("/change_email")
	public String changeEmail() {
		return "change_email";
	}

	@GetMapping("/recover")
	public String recoverAccount() {
		return "recover";
	}

    // @PostMapping("/upload")
	// public String uploadFiles(@RequestParam("files") MultipartFile[] files, @RequestParam("artistName") String artistName, Model model) {
	// 	for (MultipartFile file: files) {
	// 		service.saveMusic(1L, file, artistName);
	// 	}
    //     model.addAttribute("docs", service.getFiles());
    //     return "list";
	// }
    
}
