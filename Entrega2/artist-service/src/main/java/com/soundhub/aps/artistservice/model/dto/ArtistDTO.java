package com.soundhub.aps.artistservice.model.dto;

import com.soundhub.aps.artistservice.model.Artist;
import lombok.Data;

@Data
public class ArtistDTO {
    private Long id;
    private String name;

    public ArtistDTO(Artist artist, Long artistId) {
        this.id = artist.getId();
        this.name = artist.getName();
    }
    
}
