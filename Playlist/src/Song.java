public class Song {
    private String songTitle;
    private double duration;

    public Song(String songTitle, double duration) {
        this.songTitle = songTitle;
        this.duration = duration;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public double getDuration() {
        return duration;
    }

    public Song createSong(String songTitle,double duration){
        return new Song(songTitle,duration);
    }
}
