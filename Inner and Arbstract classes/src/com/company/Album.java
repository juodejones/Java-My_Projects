package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String albumName;
    private SongList songs;

    public Album(String albumName) {
        this.albumName = albumName;
        this.songs = new SongList();
    }

    public boolean addSong(String songTitle, double duration) {
        return this.songs.addSong(new Song(songTitle, duration));
    }

    public boolean addToPlaylist(LinkedList<Song> playlist, int trackNumber) {
        Song checkSong = this.songs.findSong(trackNumber);
        if (checkSong != null) {
            playlist.add(checkSong);
            return true;
        }
        System.out.println("The album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlayList(LinkedList<Song> playList, String songTitle) {
        Song song = this.songs.findSong(songTitle);
        if( song == null){
            System.out.println("The album does not have a song title " + songTitle);
            return false;
        }
        playList.add(song);
        return true;
    }

    private class SongList {

        private ArrayList<Song> songs;

        public SongList() {
            this.songs = new ArrayList<>();
        }

        private boolean addSong(Song song) {
            if (songs.contains(song)) {
                return false;
            }
            this.songs.add(song);
            return true;
        }

        private Song findSong(String songTitle) {
            for (int i = 0; i < this.songs.size(); i++) {
                Song songs = this.songs.get(i);
                if (songs.getSongTitle().equals(songTitle)) {
                    return songs;
                }
            }
            return null;
        }

        private Song findSong(int trackNumber) {
            int index = trackNumber - 1;
            if (index >= 0 && index < songs.size()) {
                return this.songs.get(index) ;
            }
            return null;
        }
    }
}