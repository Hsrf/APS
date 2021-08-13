package com.soundhub.aps.playlistservice.repositories;

import com.soundhub.aps.playlistservice.model.Playlist;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist, Long>{
    
}
