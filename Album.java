package com.bkr;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String title;
    private String band;
    private SongList songs;

    public Album(String title, String band) {
        this.title = title;
        this.band = band;
        this.songs=new SongList();
    }

    public boolean addSong(String title, double duration){
        return this.songs.addSong(new Song(title, duration));
    }

    private Song findSong(String title){
        for (Song checkedSong: songs.songs){
            if (checkedSong.getTitle().equals(title)){
                return checkedSong;
            }
        } return null;
    }

    public boolean addToPlaylist(int trackNumber, LinkedList<Song> playList){
       Song checkedSong = this.songs.findSong(trackNumber);
       if (checkedSong != null){
           playList.add(checkedSong);
           return true;
       }

        return false;
    }

    public boolean addToPlaylist(String title, LinkedList<Song> playList){
        Song checkedSong = findSong(title);
        if (checkedSong != null){
            playList.add(checkedSong);
            System.out.println("Song "+title+" added to playlist");
            return true;
        }
        System.out.println("The Song "+title+" is not in this Album.");
        return false;
    }

    public boolean removeFromPlaylist(String title, LinkedList<Song> playList){
        Song checkedSong = findSong(title);
        if (checkedSong!=null){
            playList.remove(checkedSong);
            return true;
        }
        return false;
    }


    public void addSongs1(){
         songs.addSong(new Song("Burn the Witch",2.52));
         songs.addSong(new Song("Broken Box",3.12));
         songs.addSong(new Song("In the Fade",3.57));
         songs.addSong(new Song("Tension Head",4.34));
         songs.addSong(new Song("Monster in the Parasol",7.41));
         songs.addSong(new Song("Quick and to the Pointless",2.51));
         songs.addSong(new Song("Auto Pilot",4.55));
         songs.addSong(new Song("Leg Of Lamb",1.11));
    }
    public void addSongs2(){
        songs.addSong(new Song("Waitin' for the Bus",2.52));
        songs.addSong(new Song("La Grange",3.57));
        songs.addSong(new Song("A Fool for your Stockings",4.34));
        songs.addSong(new Song("Cheap Sunglasses",7.41));
        songs.addSong(new Song("Mescalero",2.51));
        songs.addSong(new Song("Two way to play",4.55));
        songs.addSong(new Song("Buck Nekkid",1.11));
    }

    public class SongList {
        private ArrayList<Song> songs;

        public SongList() {
            this.songs=new ArrayList<Song>();
        }

        private Song findSong(String title){
            for (Song checkedSong: this.songs){
                if (checkedSong.getTitle().equals(title)){
                    return checkedSong;
                }
            } return null;
        }

        public Song findSong(int trackNumber){
            int index = trackNumber-1;
            if ((index>=0) && index<songs.size()){
                return songs.get(index);
            }
            return null;
        }

        public boolean addSong(Song song){
            if (songs.contains(song)){
                return false;
            }
            this.songs.add(song);
            return true;
        }
    }
}
