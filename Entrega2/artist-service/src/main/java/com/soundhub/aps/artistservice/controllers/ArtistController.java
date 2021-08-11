package com.soundhub.aps.artistservice.controllers;

import com.soundhub.aps.artistservice.repositories.ArtistRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils; 

@RestController
@RequestMapping("/artist")
public class ArtistController {
    
    @Autowired
    private ArtistRepository repository;

    // @GetMapping(value = "/{name}")
    // public List<Artist> getArtistByName(@PathVariable String name){
    //     return repository.findAllByNameContains(name);
    // }

    @GetMapping(value = "/{id}")
    public Resource getArtistName(@PathVariable Long id){
        return new ClassPathResource("/1.mp3");
        // return repository.findById(id).get().getName();
    }

}
