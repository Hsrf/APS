package com.soundhub.aps.playlistservice.model.dto;

import java.util.List;

import com.soundhub.aps.playlistservice.model.Playlist;

import lombok.Data;

@Data
public class PlaylistDTO {
    private Long id;
    private String name;
    private Long ownerId;
    private boolean isPrivate;
    private boolean isAlbum;
    private List<Long>musicIds;

    public PlaylistDTO(Playlist playlist) {
        this.id = playlist.getId();
        this.name = playlist.getName();
        this.isPrivate = playlist.getPrivacy();
        this.musicIds = playlist.getMusics();
        this.ownerId = playlist.getOwnerId();
        this.isAlbum = playlist.getIsAlbum();
    }

    public List<Long> getMusicIds(){
        return this.musicIds;
    }
    
}
