package com.rjb888.week3App.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

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

    @GetMapping("/albums/add")
    public String addAlbum(){
        return "AddAlbum";
    }

    @PostMapping("/albums/add")
    public RedirectView addAlbumToDB(@RequestParam String title, @RequestParam String artist, @RequestParam int songCount, @RequestParam int length, @RequestParam String imageUrl){
        Album newAlbum = new Album(title, artist, songCount, length, imageUrl);
        albumRepository.save(newAlbum);
        return new RedirectView("/albums");
    }

}
