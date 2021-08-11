package com.soundhub.aps.musicservice.model.dto;

import com.soundhub.aps.musicservice.model.Music;
import org.springframework.web.multipart.MultipartFile;
import lombok.Data;

@Data
public class MusicDTO {

    private Long id;
    private String name;
    private String artistName;
    private byte[] data;

    public MusicDTO(Music music, String artistName) {
        this.id = music.getId();
        this.name = music.getName();
        this.artistName = artistName;
    }
}
