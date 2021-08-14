package com.soundhub.aps.playlistservice.controllers;

import java.util.List;

import com.soundhub.aps.playlistservice.model.Playlist;
import com.soundhub.aps.playlistservice.model.dto.PlaylistDTO;
import com.soundhub.aps.playlistservice.services.PlaylistService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/playlist")
// @Controller
public class PlaylistController {
    
    @Autowired
    private PlaylistService service; 

    @PostMapping("/upload")
	public void uploadPlaylist(
        @RequestParam("playlistName") String playlistName,
        @RequestParam("isPrivate") boolean isPrivate,
        @RequestParam("ownerId") Long ownerId
        )
        {
		for (MultipartFile file: files) {
			service.saveMusic(1L, file, artistName);
		}
	}
}

