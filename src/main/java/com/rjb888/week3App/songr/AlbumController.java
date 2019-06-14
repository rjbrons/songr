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

    @Autowired
    SongRepo songRepository;

    @GetMapping("/albums")
    public String getAllAlbums(Model album){
        Iterable<Album> albumSet = albumRepository.findAll();
        album.addAttribute("albumSet", albumSet);
        return "Albums";
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


    //Dealing with Viewing and adding Songs.

    //Get request to /songs will render the SongList template
    @GetMapping("/songs")
    public String getAllSongs(Model song){
        Iterable<Song> songList = songRepository.findAll();
        song.addAttribute("songList", songList);
        return "SongList";
    }

    //Get request to /albums/addSong will render the add song form page.
    @GetMapping("/albums/addSong")
    public String addSong(){ return "AddSongs"; }

    //Post request to /albums/addSong will take the form fields as params and create a new song and put it in the DB and redirect to all Songs page
    @PostMapping("albums/addSong")
    public RedirectView addSongToAlbum(@RequestParam String title, @RequestParam int length, @RequestParam int track, @RequestParam Album album){
        Song newSong = new Song(title, length, track, album);
        songRepository.save(newSong);
        return new RedirectView("/songs");
    }

}
