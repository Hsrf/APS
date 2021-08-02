package com.aps.aula11;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.aps.aula11.Music;
import java.sql.ResultSet;

public class PlaylistController {

    // @RequestMapping(value = {"/display_all"}, method = RequestMethod.GET)
    public static ModelAndView displayAll() {
        ModelAndView model = new ModelAndView();
        ResultSet collection = RepositoryMusic.findAll("Ludwig van Beethoven - Symphony Number 9");
        // RepositoryMusic.findAll("Ludwig van Beethoven - Symphony Number 9");
        try {
            model.addObject("allAudioFiles", collection.getBytes("FILE"));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        String str = new String("deu ruim");
        model.addObject("allAudioFiles", str);
        int count = 0;

        String countString = "";
        if (count == 1) {
            countString = "There is " + count + " audio file available!";
        } else if (count > 1) {
            countString = "There are " + count + " audio files available!";
        } else {
            countString = "There are no audio files available!";
        }
        // model.addObject("allAudioFilesCountString", countString);
        model.setViewName("display/display_all");
        return model;
    }
}
