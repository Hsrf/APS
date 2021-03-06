package com.soundhub.aps.musicservice.controllers;

import com.soundhub.aps.musicservice.services.MusicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Controller;
import org.springframework.http.MediaType;


// @RestController
@RequestMapping("/music")
@Controller
public class MusicController {
    
    @Autowired
    private MusicService service; 

    @GetMapping("/js/player.js")
	public String getPlayer() {
		return "/js/player.js";
	}

    @GetMapping("/dashboard")
	public String getDashboard() {
		return "dashboard";
	}

    @PostMapping("/upload")
	public String uploadFiles(@RequestParam("files") MultipartFile[] files, @RequestParam("artistName") String artistName, Model model) {
		for (MultipartFile file: files) {
			service.saveMusic(1L, file, artistName);
		}
        model.addAttribute("docs", service.getFiles());
        return "list";
	}
    
    @GetMapping("/list")
	public String uploadFiles(Model model) {
        model.addAttribute("docs", service.getFiles());
		return "list";
	}
    
    @GetMapping("/{musicId}")
    public ResponseEntity<ByteArrayResource> getMusic(@PathVariable String musicId){
        Long id = Long.valueOf(musicId).longValue();
        return ResponseEntity.ok().contentType(MediaType.parseMediaType("audio/mp3")).body(new ByteArrayResource(service.getMusicById(id).getData()));
    }
}
