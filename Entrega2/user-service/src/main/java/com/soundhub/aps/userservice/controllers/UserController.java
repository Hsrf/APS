package com.soundhub.aps.userservice.controllers;

import java.util.List;

import com.soundhub.aps.userservice.model.User;
import com.soundhub.aps.userservice.model.dto.UserDTO;
import com.soundhub.aps.userservice.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.io.IOUtils;
import java.nio.charset.StandardCharsets;
import java.io.InputStream;
import java.io.IOException;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Controller;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;


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