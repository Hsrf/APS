package com.soundhub.aps.artistservice.services;

import com.soundhub.aps.artistservice.model.Artist;
import com.soundhub.aps.artistservice.repositories.ArtistRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ArtistService {
    @Autowired
    private ArtistRepository repository;
    
    public void saveArtist(@RequestBody String artistName){
        Artist newArtist = new Artist();
        newArtist.setName(artistName);
        repository.save(newArtist);
        System.out.println("Qntd artistas no banco: "+ repository.count());
    
    }
}
