package com.soundhub.aps.musicservice.repositories;

import com.soundhub.aps.musicservice.model.Music;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<Music, Long>{
    
}
