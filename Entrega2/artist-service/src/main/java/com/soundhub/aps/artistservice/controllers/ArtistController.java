package com.soundhub.aps.artistservice.controllers;

import java.util.List;

import com.soundhub.aps.artistservice.services.ArtistService;
import com.soundhub.aps.artistservice.model.Artist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artist")
public class ArtistController {
    
    @Autowired
    private ArtistService service;

    // @GetMapping("/list")
    // public String getArtists(Model model) {
    //     System.out.println(service.listArtists().size());
    //     model.addAttribute("artistList", service.listArtists());
    //     return "listArtists";
    // }

    @GetMapping("/list")
    public List<Artist> getArtists() {
        return service.listArtists();
    }


    // @GetMapping(value = "/{id}")
    // public Resource getArtistName(@PathVariable Long id){
    //     return new ClassPathResource("/1.mp3");
    //     // return repository.findById(id).get().getName();
    // }

    @PostMapping
    public void saveArtist(@RequestBody String artistName){
        service.saveArtist(artistName);
        // return repository.findById(id).get().getName();
    }

}
