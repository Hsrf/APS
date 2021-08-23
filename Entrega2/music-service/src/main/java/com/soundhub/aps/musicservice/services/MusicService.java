package com.soundhub.aps.musicservice.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.soundhub.aps.musicservice.model.Music;
import com.soundhub.aps.musicservice.model.dto.MusicDTO;
import com.soundhub.aps.musicservice.proxy.ArtistProxy;
import com.soundhub.aps.musicservice.repositories.MusicRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
    }

    public List<Music> getFiles(){
        return repository.findAll();
    }

    public Optional<Music> getFile(Long id){
        return repository.findById(id);
    }

    public List<String> getNames(Long[] ids){
        List<String> names = new ArrayList<String>();
        Optional<Music> music = null;
        for(int i = 0; i< ids.length; i++){
            music = repository.findById(ids[i]);
            // names.add(music.or(new Music()).getName());
            if(music.isPresent()){
                names.add(music.get().getName());
            }
        }
        if(names.size() == 0){
            return null;
        }
        return names;
    }
}
