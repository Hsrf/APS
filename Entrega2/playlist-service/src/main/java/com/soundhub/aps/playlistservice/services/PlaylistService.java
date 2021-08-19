package com.soundhub.aps.playlistservice.services;

import java.util.Optional;
import java.util.List;
import com.soundhub.aps.playlistservice.model.dto.PlaylistDTO;
// import com.soundhub.aps.playlistservice.proxy.ArtistProxy;
import com.soundhub.aps.playlistservice.repositories.PlaylistRepository;
import com.soundhub.aps.playlistservice.model.Playlist;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaylistService {
    
    @Autowired
    private PlaylistRepository repository;

    // @Autowired
    // private ArtistProxy proxy;

    public PlaylistDTO getPlaylistById(Long id){
        Playlist playlist = repository.getById(id);
        return new PlaylistDTO(playlist);
    }

    public void insertMusic(Long playlistId, Long ownerId,List<Long> musicId){
         Playlist playlist = repository.getById(playlistId);
         playlist.insertMusics(musicId);
         repository.save(playlist);
    }

    public void createPlaylist(String newName, boolean isPrivate, Long ownerId){
        Playlist play = new Playlist();
        play.setName(newName);
        play.setPrivacy(isPrivate);
        play.setOwner(ownerId);
        repository.save(play);
    }

    public void updatePlaylist(Long playlistId, String newName, boolean isPrivate, Long ownerId){
        Playlist playlist = repository.getById(playlistId);
        if(ownerId == playlist.getId()){
            playlist.setName(newName);
            playlist.setPrivacy(isPrivate);
            repository.save(playlist);
        }
    }
    public List<Playlist> getListPlaylist(Long id){
        return repository.findByownerId(id);
    }

    // public Optional<Playlist> getPlaylist(Long id){
    //     return repository.findById(id);
    // }
}