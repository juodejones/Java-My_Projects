import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

   private static ArrayList<Album> albums = new ArrayList<Album>();

   public static void main(String[] args) {
      playListMain();
   }

   public static void myPlayListMain() {

      Album album = new Album("Rahman-hits");
      album.addSong("Enthira logathu sundari", 3.46);
      album.addSong("Jai Ho", 4.25);
      album.addSong("Rajali", 3.46);
      album.addSong("Sevandu pochu nenju", 4.26);
      album.addSong("Punnagi", 3.46);
      album.addSong("Mayakama", 3.46);
      albums.add(album);

      LinkedList<Song> playlist = new LinkedList<>();
      albums.get(0).addToPlaylist(playlist, 1);
      albums.get(0).addToPlaylist(playlist, 2);
      albums.get(0).addToPlaylist(playlist, 5);

      albums.get(0).addToPlayList(playlist, "Sevandu pochu nenju");
      albums.get(0).addToPlayList(playlist, "Mayakama");

      printChoice();
      int choice = 0, i =0;
      Scanner scanner = new Scanner(System.in);
      boolean exitApplication = false;
      boolean forward = true;
      ListIterator<Song> listIterator = playlist.listIterator();
      while (!exitApplication) {
         System.out.println("Enter the choice: ");
         choice = scanner.nextInt();
         switch (choice) {
            case 0:
               System.out.println("Exiting  application.....");
               exitApplication = true;
               break;
            case 1:
               playSongs(playlist);
               i++;
               break;
            case 2:
               if (!forward) {
                  if (listIterator.hasNext()) {
                     listIterator.next();
                  }
                  forward = true;
               }
               nextSong(playlist, listIterator);
               if (i < playlist.size()) {
                  i++;
               }
               break;
            case 3:
               if (forward) {
                  if (listIterator.hasPrevious()) {
                     listIterator.previous();
                  }
                  forward = false;
               }
               previousSong(playlist, listIterator);
               if (i > 0) {
                  i--;
               }
               break;
            default:
               printChoice();

         }
         listIterator = playlist.listIterator(i);
      }
   }

   public static void playListMain() {

      Album album = new Album("Rahman-hits");
      album.addSong("Enthira logathu sundari", 3.46);
      album.addSong("Jai Ho", 4.25);
      album.addSong("Rajali", 3.46);
      album.addSong("Sevandu pochu nenju", 4.26);
      album.addSong("Punnagi", 3.46);
      album.addSong("Mayakama", 3.46);
      albums.add(album);

      LinkedList<Song> playlist = new LinkedList<>();
      albums.get(0).addToPlaylist(playlist, 1);
      albums.get(0).addToPlaylist(playlist, 2);
      albums.get(0).addToPlaylist(playlist, 5);

      albums.get(0).addToPlayList(playlist, "Sevandu pochu nenju");
      albums.get(0).addToPlayList(playlist, "Mayakama");

      printChoice();
      int choice = 0, i =0;
      Scanner scanner = new Scanner(System.in);
      boolean exitApplication = false, forward = true, playing = false;
      String songName = playlist.get(0).getSongTitle();
      ListIterator<Song> listIterator = playlist.listIterator();
      while (!exitApplication) {
         System.out.println("Enter the choice: ");
         choice = scanner.nextInt();
         switch (choice) {
            case 0:
               System.out.println("Exiting  application.....");
               exitApplication = true;
               break;
            case 1:
               if (!playing) {
                  System.out.println("Now playing --> " + songName);
                  listIterator.next();
                  playing = true;
               } else {
                  System.out.println("Paused --> " + songName);
                  playing = false;
               }
               break;
            case 2:
               if (!forward) {
                  if (listIterator.hasNext()) {
                     listIterator.next();
                  }
                  forward = true;
               }
               System.out.println("Loading next song.....");

               if(listIterator.hasNext()){
                  songName = listIterator.next().getSongTitle();
                  System.out.println("Now playing --> "+ songName);
               }else {
                  System.out.println("Playing the last song. \nNow playing -->" + songName);
               }
               break;
            case 3:
               if (forward) {
                  if (listIterator.hasPrevious()) {
                     listIterator.previous();
                  }
                  forward = false;
               }
               System.out.println("Loading previous song.....");

               if( listIterator.hasPrevious()){
                  songName = listIterator.previous().getSongTitle();
                  System.out.println("Now playing --> "+ songName);
               }else{
                  System.out.println("Playing the first song.\n Now playing -->" + songName);
               }
               break;
            default:
               printChoice();

         }
      }
   }

    private static void printChoice(){
       System.out.println("0 --> Exit application\n" +
               "1 --> Pause/Play song\n"
               +"2 --> Play next song\n" +
               "3 --> Play previous song");
    }

    private static void playSongs(LinkedList<Song> playlist) {
       if (playlist.size() == 0) {
          System.out.println("No songs in playlist.");
       } else {
          System.out.println("Now playing " + playlist.get(0).getSongTitle());
       }
    }

    private static void nextSong(LinkedList<Song> playlist, ListIterator<Song> listIterator){
       if( playlist.size() == 0){
          System.out.println("No song in playlist");
          return;
       }else{
          System.out.println("Loading next song.....");

          if(listIterator.hasNext()){
             System.out.println("Now playing --> "+ listIterator.next().getSongTitle());
          }else {
             System.out.println("Playing the last song.");
          }
       }
    }

   private static void previousSong(LinkedList<Song> playlist, ListIterator<Song> listIterator){
      if( playlist.size() == 0){
         System.out.println("No song in playlist");
         return;
      }else{
         System.out.println("Loading previous song.....");
         if( listIterator.hasPrevious()){
            System.out.println("Now playing --> "+ listIterator.previous().getSongTitle());
         }else{
            System.out.println("Playing the first song.");
         }
      }
   }
}
