package com.soundhub.aps.playlistservice.model.dto;

import com.soundhub.aps.playlistservice.model.Playlist;
import lombok.Data;
import java.util.List;

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
    
}
