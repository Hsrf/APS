package com.soundhub.aps.playlistservice.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Playlist implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "owner_id", nullable = false)
    private Long ownerId;

    @Lob
    private List<Long> musicIds;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setArtistId(Long ownerId) {
        this.ownerId = ownerId;
    }
    public List<Long> getMusics(){
        return musicIds;
    }
    public void insertMusic(Long music){
        this.musicIds.add(music);
    }
    public void deleteMusic(Long music){
        this.musicIds.remove(this.musicIds.indexOf(music));
    }
}
