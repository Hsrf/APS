package com.soundhub.aps.artistservice.repositories;

import java.util.List;

import com.soundhub.aps.artistservice.model.Artist;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long>{

    List<Artist> findAllByNameContains(String name);
    
}
