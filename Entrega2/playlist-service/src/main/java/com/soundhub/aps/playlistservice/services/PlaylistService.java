package com.soundhub.aps.playlistservice.services;

import java.util.Optional;
import java.util.List;
import com.soundhub.aps.playlistservice.model.dto.PlaylistDTO;
import com.soundhub.aps.playlistservice.proxy.ArtistProxy;
import com.soundhub.aps.playlistservice.repositories.PlaylistRepository;
import com.soundhub.aps.playlistservice.model.Playlist;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaylistService {
    
    @Autowired
    private PlaylistRepository repository;

    @Autowired
    private ArtistProxy proxy;

    public PlaylistDTO getPlaylistById(Long id){
        Playlist playlist = repository.getById(id);
        Long ownerId = 1L;
        boolean isPrivate = false;
        return new PlaylistDTO(playlist, ownerId, isPrivate);
    }

    public void insertMusic(Long playlistId,List<Long> musicId){
        Playlist playlist = repository.getById(playlistId);
        playlist.insertMusics(musicId);
        repository.save(playlist);
        // repository.update(playlist);
    }

    public List<Playlist> getFiles(){
        return repository.findAll();
    }

    public Optional<Playlist> getFile(Long id){
        return repository.findById(id);
    }
}
