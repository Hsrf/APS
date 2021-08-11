package com.soundhub.aps.musicservice.controllers;

import com.soundhub.aps.musicservice.model.dto.MusicDTO;
import com.soundhub.aps.musicservice.model.Music;
import com.soundhub.aps.musicservice.services.MusicService;
import javax.annotation.Resource;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.multipart.MultipartFile;
import com.soundhub.aps.musicservice.services.MusicService;

// @RestController
// @RequestMapping("/music")
@Controller
public class MusicController {
    
    @Autowired
    private MusicService service; 

    @PostMapping("/upload")
	public String uploadFiles(@RequestParam("files") MultipartFile[] files) {
		for (MultipartFile file: files) {
			service.saveMusic(1L, file);
		}
		return new String("<!DOCTYPE html>        <html xmlns:th=\"http://www.thymeleaf.org\">         <head>      <meta charset=\"UTF-8\">         <title>Admin add new music to system</title>         </head>         <body>            <div>              <h3>Upload Multiple Files</h3>             <form id=\"uploadFiles\" name=\"uploadFiles\" method=\"post\" th:action=@{/uploadFiles} encType=\"multipart/form-data\">                <input type=\"file\" name=\"files\" multiple required />                 <button type=\"submit\">Submit</button>              </form>            </div>                        <div>              <h3>List of Musics in the System</h3>              <table>                 <thead>                  <tr>                    <th>Id</th>                    <th>Name</th>                    <th>Player</th>                  </tr>                </thead>                <tbody>                  <tr th:each=\"doc:${docs}\">                    <td th:text=\"${doc.Id}\" />                    <td th:text=\"${doc.docName}\"/>                    <!-- <td><a th:href=\"@{'/downloadFile/'+${doc.id}}\">Download</a></td> -->                    <audio controls>                      <source th:src=\"@{'/downloadFile/'+${doc.id}}\" type=\"audio/mpeg\">                    </audio>                  </tr>                </tbody>              </table>            </div>         </body>         </html>");
	}

    @GetMapping("/home")
	public ModelAndView get() {
        List<Music> docs = service.getFiles();
        ModelAndView mav = new ModelAndView();
        mav.addObject("docs", docs);
        mav.setViewName("music");
        return mav;
		// return new String("<!DOCTYPE html>        <html xmlns:th=\"http://www.thymeleaf.org\">         <head>      <meta charset=\"UTF-8\">         <title>Admin add new music to system</title>         </head>         <body>            <div>              <h3>Upload Multiple Files</h3>             <form id=\"uploadFiles\" name=\"uploadFiles\" method=\"post\" th:action=@{/uploadFiles} encType=\"multipart/form-data\">                <input type=\"file\" name=\"files\" multiple required />                 <button type=\"submit\">Submit</button>              </form>            </div>                        <div>              <h3>List of Musics in the System</h3>              <table>                 <thead>                  <tr>                    <th>Id</th>                    <th>Name</th>                    <th>Player</th>                  </tr>                </thead>                <tbody>                  <tr th:each=\"doc:${docs}\">                    <td th:text=\"${doc.Id}\" />                    <td th:text=\"${doc.docName}\"/>                    <!-- <td><a th:href=\"@{'/downloadFile/'+${doc.id}}\">Download</a></td> -->                    <audio controls>                      <source th:src=\"@{'/downloadFile/'+${doc.id}}\" type=\"audio/mpeg\">                    </audio>                  </tr>                </tbody>              </table>            </div>         </body>         </html>");	
    }

    // @GetMapping("/{musicId}")
    // public ResponseEntity<MusicDTO> getMusic(@PathVariable Long musicId){
    //     return ResponseEntity.ok().body(service.getMusicById(musicId));
    // }
    
    @GetMapping("/{musicId}")
    public ResponseEntity<MusicDTO> getMusic(@PathVariable Long musicId){
        return ResponseEntity.ok().body(service.getMusicById(musicId));
    }
}

