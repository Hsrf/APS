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
public class PlaylistController {
    
    @Autowired
    private PlaylistService service; 

    @PostMapping("/{id}/edit")
	public void uploadPlaylist(
        @RequestParam("playlistName") String playlistName,
        @RequestParam("isPrivate") boolean isPrivate,
        @RequestParam("ownerId") Long ownerId,
        @PathVariable String id
        ){
            Long playlistId = Long.valueOf(id).longValue();
            service.updatePlaylist(playlistId, playlistName, isPrivate, ownerId);
	}

    @PostMapping("/upload")
	public void uploadPlaylist(
        @RequestParam("playlistName") String playlistName,
        @RequestParam("isPrivate") boolean isPrivate,
        @RequestParam("ownerId") Long ownerId
        ){
            service.createPlaylist(playlistName, isPrivate, ownerId);
	}

    @GetMapping("/list")
    public List<Playlist> getPlaylistData(
    ){
        return service.getListPlaylist(1L);
    }
    @GetMapping("/{id}/musics")
    public List<Long> getPlaylistData(
        @PathVariable String id
    ){
        Long playlistId = Long.valueOf(id).longValue();
        PlaylistDTO play = service.getPlaylistById(playlistId);
        if(play != null){
            List<Long> musics = play.getMusicIds();
            if(musics.size() != 0){
                return musics;
            }
        }
        return null;
    }
}
