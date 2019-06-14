package com.rjb888.week3App.songr;


import javax.persistence.*;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int songId;

    String title;
    int length;
    int track;

    @ManyToOne
    Album album;

    public Song(){}

    public Song(String title, int length, int track, Album album){
        this.title = title;
        this.length = length;
        this.track = track;
        this.album = album;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getTrack() {
        return track;
    }

    public void setTrack(int track) {
        this.track = track;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

}
