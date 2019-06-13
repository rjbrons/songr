package com.rjb888.week3App.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlbumController{

    @Autowired
    AlbumRepo albumRepository;

    @GetMapping("/albums")
    public String getAllAlbums(Model album){
        Iterable<Album> albumSet = albumRepository.findAll();
        album.addAttribute("albumSet", albumSet);
        return "Album";
    }

}
