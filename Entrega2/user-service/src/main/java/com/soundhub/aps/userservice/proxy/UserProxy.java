package com.soundhub.aps.userservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "user-service")
public interface UserProxy {

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<String> getUserName(@PathVariable Long id);

    @PostMapping("/user")
    public void saveUser(String artistName);
}
