package com.bkr;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {
        Album album1= new Album("Rated R","QOTSA");
        Album album2 = new Album("Mescalero","ZZ TOP");
        album1.addSongs1();
        album2.addSongs2();
        albums.add(album1);
        albums.add(album2);


       Album.SongList playlist2 = album2.new SongList();

        LinkedList<Song> playList = new LinkedList<Song>();



        album1.addToPlaylist(1,playList);
        album1.addToPlaylist(3,playList);

        musicPlayer(playList);


    }
    public static void printOptions(){
        System.out.println("-------------------------------");
        System.out.println("-----------> MENU <------------");
        System.out.println("\t"+" 0 "+"--> QUIT <----------");
        System.out.println("\t"+" 1 "+"--> >>| <-----------");
        System.out.println("\t"+" 2 "+"--> |<< <-----------");
        System.out.println("\t"+" 3 "+"--> REPLAY <--------");
        System.out.println("\t"+" 4 "+"--> SONGS <---------");
        System.out.println("\t"+" 5 "+"--> ADD to Playlist <----------");
        System.out.println("\t"+" 6 "+"--> REMOVE from Playlist <----------");
        System.out.println("\t"+" 7 "+"--> MENU <----------");
        System.out.println("-----------> MUSIC <-----------");
        System.out.println("-------------------------------");
    }
    public static void musicPlayer( LinkedList<Song> playList){
        Scanner in = new Scanner(System.in);
        boolean quit = false;
        boolean forward=true;
        printOptions();
        ListIterator<Song> listIterator= playList.listIterator();
        if (playList.size()==0){
            System.out.println("No Songs in Playlist");
        } else {
            System.out.println("Now playing: "+listIterator.next().toString());
        }
        while(!quit){
            int action = in.nextInt();
            in.nextLine();
            switch (action){
                case 0:
                    System.out.println("Goodbye and thank you for listening!");
                    quit=true;
                    break;
                case 1:
                    if(!forward) {
                        if(listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("We have reached the end of the playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward=false;
                    }
                    if (listIterator.hasPrevious()){
                        System.out.println("Now playing: "+listIterator.previous().toString());
                    } else {
                        System.out.println("At the start of the Playlist");
                        forward=true;
                    }
                    //TODO: skip back one track
                    break;
                case 3:
                    //TODO: Replay current song
                    if (forward){
                        if (listIterator.hasPrevious()){
                            System.out.println("Now re-playing: "+listIterator.previous().toString());
                            forward=false;
                        } else {
                            System.out.println("At the start of the Playlist");
                        }
                    } else{
                        if (listIterator.hasNext()){
                            System.out.println("Now re-playing "+listIterator.next().toString());
                            forward = true;
                        }else{
                            System.out.println("We have reached the end of the list");
                        }
                    }
                    break;
                case 4:
                    //TODO: Show songs
                    for (int j = 0; j < playList.size(); j++) {
                        System.out.println(playList.get(j).getTitle());
                    }
                    break;
                case 5:
                    //TODO: Add Song to Playlist
                    System.out.println("Enter Song Title to add to Playlist: ");
                    String songToBeAdded = in.nextLine();
                    for (int i=0; i<albums.size();i++){
                        albums.get(i).addToPlaylist(songToBeAdded,playList);
                    }
                    break;
                case 6:
                    //TODO: Remove song from playlist
                    System.out.println("Enter Song Title to be removes from Playlist ");
                    String songToBeRemoved = in.nextLine();
                    for (int i = 0; i < albums.size() ; i++) {
                        albums.get(i).removeFromPlaylist(songToBeRemoved, playList);
                        listIterator.next();

                    }
                    listIterator.remove();
                    break;
                case 7:
                    //TODO: Print Control
                    printOptions();
                    break;
            }
        }

    }
}