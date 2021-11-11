import java.util.LinkedList;

public class Album {

    private String albumName;
    LinkedList<Song> songs;

    public Album(String albumName) {
        this.albumName = albumName;
        this.songs = new LinkedList<>();
    }

    public boolean addSong(String songTitle, double duration) {
        Song newSong = findSong(songTitle);
        if (newSong == null) {
//            newSong.createSong(songTitle, duration);
            this.songs.add(new Song(songTitle, duration));
            return true;
        }
        return false;
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

    public boolean addToPlaylist(LinkedList<Song> playlist, int trackNumber) {
        int position = trackNumber - 1;
        if ((position >= 0) && (position <= this.songs.size())) {
            playlist.add(this.songs.get(position));
            return true;
        }
        System.out.println("The album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlayList(LinkedList<Song> playList, String songTitle) {
        Song song = findSong(songTitle);
        if( song == null){
            System.out.println("The album does not have a song title " + songTitle);
            return false;
        }
        playList.add(song);
        return true;
    }
}