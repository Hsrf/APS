package com.soundhub.aps.artistservice.controllers;

import com.soundhub.aps.artistservice.services.ArtistService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController; 

@RestController
@RequestMapping("/artist")
public class ArtistController {
    
    @Autowired
    private ArtistService service;

    // @GetMapping(value = "/{name}")
    // public List<Artist> getArtistByName(@PathVariable String name){
    //     return repository.findAllByNameContains(name);
    // }

    @GetMapping(value = "/{id}")
    public Resource getArtistName(@PathVariable Long id){
        return new ClassPathResource("/1.mp3");
        // return repository.findById(id).get().getName();
    }

    @PostMapping()
    public void saveArtist(@RequestBody String artistName){
        service.saveArtist(artistName);
        // return repository.findById(id).get().getName();
    }

}
