package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {
        abstractClassMain();
    }


    //ABSTRACT CLASS EXERCISE MAIN
    public static void abstractClassMain() {
        SearchTree tree = new SearchTree(null);
        tree.traverse(tree.getRoot());
        // Create a string data array to avoid typing loads of addItem instructions:
        String stringData = "5 7 3 9 8 2 1 0 4 6";
//        String stringData = "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Canberra";


        String[] data = stringData.split(" ");
        for (String s : data) {
            tree.addItem(new Node(s));
        }


        tree.traverse(tree.getRoot());
        tree.removeItem(new Node("3"));
        tree.traverse(tree.getRoot());

        tree.removeItem(new Node("5"));
        tree.traverse(tree.getRoot());

        tree.removeItem(new Node("0"));
        tree.removeItem(new Node("4"));
        tree.removeItem(new Node("2"));
        tree.traverse(tree.getRoot());

        tree.removeItem(new Node("9"));
        tree.traverse(tree.getRoot());
        tree.removeItem(new Node("8"));
        tree.traverse(tree.getRoot());
        tree.removeItem(new Node("6"));
        tree.traverse(tree.getRoot());
        tree.removeItem(tree.getRoot());
        tree.traverse(tree.getRoot());
        tree.removeItem(tree.getRoot());
        tree.traverse(tree.getRoot());
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
        int choice = 0;
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
                        System.out.println("Playing the last song.");
                        System.out.println("Now playing --> "+ songName);
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
                        System.out.println("Playing the first song.");
                        System.out.println("Now playing --> "+ songName);
                    }
                    break;
                default:
                    System.out.println("Enter a valid choice.");
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

    //METHOD TO READ THE LIST OF INPUTS GIVEN
    public static ArrayList<String> readValues() {

        ArrayList<String> values = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("\nChoose, " +
                "\n\t 0 -> To Quit" +
                "\n\t 1 -> To add a String ");

        while (!quit) {
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    System.out.println("Quitting");
                    break;
                case 1:
                    System.out.println("Enter a string:");
                    String string = scanner.nextLine();
                    values.add(index, string);
                    index++;
                    break;
                default:
                    System.out.println("Invalid choice!");
                    System.out.println("\nChoose, " +
                            "\n\t 0 -> To Quit" +
                            "\n\t 1 -> To add a String ");
            }
        }
        return values;
    }

    public static void saveObject (ISavable objectToSave) {
        for (int i = 0; i < objectToSave.write().size(); i++) {
            System.out.println("Saving " + objectToSave.write().get(i) + " to storage device...");
        }
    }

    public static void loadObject (ISavable objectToLoad) {
        ArrayList<String> values = readValues();
        objectToLoad.read(values);
    }
}
