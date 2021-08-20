package com.soundhub.aps.playlistservice.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "music-service")
public interface MusicProxy {
    
    @GetMapping(value = "/music/musicsByIds")
    public List<String> UP (1) - 192.168.50.201:artist-service:8200
    MUSIC-SERVICE	n/a (1)	(1)	UP (1) - 192.168.50.201:music-service:8100
    PLAYLIST-SERVICE	n/a (1)	(1)	UP (1) - 192.168.50.201:playlist-service:8500
    USER-SERVICE	n/a (1)	(1)	UP (1) - 192.168.50.201:user-service:8090UP (1) - 192.168.50.201:artist-service:8200
    MUSIC-SERVICE	n/a (1)	(1)	UP (1) - 192.168.50.201:music-service:8100
    PLAYLIST-SERVICE	n/a (1)	(1)	UP (1) - 192.168.50.201:playlist-service:8500
    USER-SERVICE	n/a (1)	(1)	UP (1) - 192.168.50.201:user-service:8090getMusicsList(Long[] ids);
}
