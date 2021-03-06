package com.soundhub.aps.musicservice.services;

import java.util.Optional;
import java.util.List;
import com.soundhub.aps.musicservice.model.Music;
import com.soundhub.aps.musicservice.model.dto.MusicDTO;
import com.soundhub.aps.musicservice.proxy.ArtistProxy;
import com.soundhub.aps.musicservice.repositories.MusicRepository;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicService {
    
    @Autowired
    private MusicRepository repository;

    @Autowired
    private ArtistProxy proxy;

    public MusicDTO getMusicById(Long id){
        Music music = repository.getById(id);
        // String artistName = proxy.getArtistName(music.getArtistId()).getBody();
        return new MusicDTO(music, 1L, music.getData());
    }

    public void saveMusic(Long artistId, MultipartFile file, String  artistName){
        System.out.println(artistName);
        proxy.saveArtist(artistName);
        Music newMusic = new Music();
        newMusic.setName(file.getOriginalFilename());
        newMusic.setArtistId(artistId);
        // newMusic.setId(1L);
        // newMusic.setArtistId(1L);
        try {
            newMusic.setData(file.getBytes());
        } catch (Exception e){
            e.printStackTrace();
        }
        repository.save(newMusic);
        System.out.println("Qntd musicas no bando: "+ repository.count());
        
        System.out.printf("%s %d %d", newMusic.getName(), newMusic.getArtistId(), newMusic.getId());
    }

    public List<Music> getFiles(){
        return repository.findAll();
    }

    public Optional<Music> getFile(Long id){
        return repository.findById(id);
    }
}
