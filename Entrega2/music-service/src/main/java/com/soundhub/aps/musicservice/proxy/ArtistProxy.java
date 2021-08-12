package com.soundhub.aps.musicservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "artist-service")
public interface ArtistProxy {

    @GetMapping(value = "/artist/{id}")
    public ResponseEntity<String> getArtistName(@PathVariable Long id);

    @PostMapping("/artist")
    public void saveArtist(String artistName);
}
