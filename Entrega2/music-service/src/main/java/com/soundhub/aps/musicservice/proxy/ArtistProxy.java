package com.soundhub.aps.musicservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "artist-service", url = "localhost:8000/artist")
public interface ArtistProxy {

    @GetMapping(value = "/{id}")
    public ResponseEntity<String> getArtistName(@PathVariable Long id);
}
