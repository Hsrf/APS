package com.soundhub.aps.musicservice.controllers;

import java.util.List;

import com.soundhub.aps.musicservice.model.Music;
import com.soundhub.aps.musicservice.model.dto.MusicDTO;
import com.soundhub.aps.musicservice.services.MusicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/music")
// @Controller
public class PlaylistController {
    
    @Autowired
    private PlaylistService service; 

    @PostMapping("/upload")
	public String uploadFiles(@RequestParam("files") MultipartFile[] files, @RequestParam("artistName") String artistName) {
		for (MultipartFile file: files) {
			service.saveMusic(1L, file, artistName);
		}
		return new String(
            "<!DOCTYPE html>"+
            "<html xmlns:th=\"http://www.thymeleaf.org/%22%3E%22%3E\">"+
            "<head>"+
            "<meta charset=\"UTF-8\">"+
            "<title>Admin add new music to system</title>"+
            "</head>"+
            "<body>"+
            "<div>"+
            "<h3>Upload Multiple Files</h3>"+
            "<form id=\"uploadFiles\" name=\"uploadFiles\" method=\"post\" th:action=@{/uploadFiles} encType=\"multipart/form-data\">"+
            "<input type=\"file\" name=\"files\" multiple required />"+
            "<input type=\"text\" name=\"artistName\"/>"+
            "<button type=\"submit\">Submit</button> "+
            "</form>"+
            "</div>"+
            "<div>"+
            "<h3>List of Musics in the System</h3>"+
            "<table>"+
            "<tr>"+
            "<th>Id</th>"+
            "<th>Name</th>"+
            "<th>Player</th>"+
            "</tr>"+
            "<tr th:each=\"doc:${docs}\">"+
            "<td th:text=\"${doc.Id}\"></td>"+
            "<td th:text=\"${doc.docName}\"></td>"+
            "<td>" + 
            "<audio controls>"+
            "<source th:src=\"@{'/downloadFile/'+${doc.id}}\" type=\"audio/mpeg\">"+
            "</audio>"+
            "</td>"+
            "</tr>"+
            "</table>"+
            "</div>"+
            "</body>"+
            "</html>"
        );
	}
    
    @GetMapping("/upload")
	public String uploadFiles() {

		return new String(
            "<!DOCTYPE html>"+
            "<html xmlns:th=\"http://www.thymeleaf.org/%22%3E%22%3E\">"+
            "<head>"+
            "<meta charset=\"UTF-8\">"+
            "<title>Admin add new music to system</title>"+
            "</head>"+
            "<body>"+
            "<div>"+
            "<h3>Upload Multiple Files</h3>"+
            "<form id=\"uploadFiles\" name=\"uploadFiles\" method=\"post\" th:action=@{/uploadFiles} encType=\"multipart/form-data\">"+
            "<input type=\"file\" name=\"files\" multiple required />"+
            "<input type=\"text\" name=\"artistName\"/>"+
            "<button type=\"submit\">Submit</button> "+
            "</form>"+
            "</div>"+
            "<div>"+
            "<h3>List of Musics in the System</h3>"+
            "<table>"+
            "<tr>"+
            "<th>Id</th>"+
            "<th>Name</th>"+
            "<th>Player</th>"+
            "</tr>"+
            "<tr th:each=\"doc:${docs}\">"+
            "<td th:text=\"${doc.Id}\"></td>"+
            "<td th:text=\"${doc.docName}\"></td>"+
            "<td>" + 
            "<audio controls>"+
            "<source th:src=\"@{'/downloadFile/'+${doc.id}}\" type=\"audio/mpeg\">"+
            "</audio>"+
            "</td>"+
            "</tr>"+
            "</table>"+
            "</div>"+
            "</body>"+
            "</html>"
            );
	}

    @GetMapping("/home")
	public ModelAndView get() {
        List<Playlist> docs = service.getFiles();
        ModelAndView mav = new ModelAndView();
        mav.addObject("docs", docs);
        mav.setViewName("music");
        return mav;
    }

    // @GetMapping("/{musicId}")
    // public ResponseEntity<MusicDTO> getMusic(@PathVariable Long musicId){
    //     return ResponseEntity.ok().body(service.getMusicById(musicId));
    // }
    
    @GetMapping("/{musicId}")
    public ResponseEntity<PlaylistDTO> getMusic(@PathVariable String musicId){
        Long id = Long.valueOf(musicId).longValue();
        return ResponseEntity.ok().body(service.getMusicById(id));
    }
}

