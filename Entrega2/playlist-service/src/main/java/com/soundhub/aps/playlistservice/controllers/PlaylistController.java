package com.soundhub.aps.playlistservice.controllers;

import java.util.List;

import com.soundhub.aps.playlistservice.model.Playlist;
import com.soundhub.aps.playlistservice.model.dto.PlaylistDTO;
import com.soundhub.aps.playlistservice.services.PlaylistService;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

@RequestMapping("/playlist")
@Controller
public class PlaylistController {

    Logger log = org.slf4j.LoggerFactory.getLogger(Logger.class);
    
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
    @PostMapping("/uploadMusic")
    public void uploadMusic(
        @RequestParam("musicList") List<Long> musicList,
        @RequestParam("ownerId") Long ownerId,
        @RequestParam("playlistId") Long playId
    ){
            service.insertMusic(playId,ownerId,musicList);
    }

    @GetMapping("/list")
    public String getPlaylistData(Model model){
        model.addAttribute("playlists", service.getListPlaylist(1L));
        return "list";
    }

    @GetMapping("/{id}/musics")
    public String getPlaylistData(Model model,
        @PathVariable Long id
    ){
        
        PlaylistDTO playlistMusics = service.getPlaylistById(id);
        if(playlistMusics != null){
            List<Long> musicIds = playlistMusics.getMusicIds();
            model.addAttribute("musicsIds", musicIds);
            log.info(musicIds.toString());  
            model.addAttribute("musicNames", service.listMusicsPlaylist(musicIds));
    
        }
        return "playlistMusics";
    }
}
