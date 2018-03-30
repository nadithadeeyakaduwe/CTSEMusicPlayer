package model;

/**
 * Created by Naditha Harshana on 3/30/2018.
 */

public class Song {

    private static Song songInstant;
    private String name;
    private String singer;
    private int song;

    public Song(String name, String singer, int song) {
        this.name = name;
        this.singer = singer;
        this.song = song;
    }

//    public static Song getSongObj(String name, String singer, int song) {
//        if(songInstant == null) {
//            return songInstant = new Song(name, singer, song);
//        } else {
//            return songInstant;
//        }
//    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public int getSong() {
        return song;
    }

    public void setSong(int song) {
        this.song = song;
    }
}
