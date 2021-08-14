package com.soundhub.aps.musicservice.model.dto;

import com.soundhub.aps.musicservice.model.Music;
import org.springframework.web.multipart.MultipartFile;
import lombok.Data;

@Data
public class MusicDTO {

    private Long id;
    private String name;
    private Long artistId;
    private byte[] data;

    public MusicDTO(Music music, Long artistId, byte[] data) {
        this.id = music.getId();
        this.name = music.getName();
        this.data = music.getData();
        this.artistId = artistId;
    }
}
