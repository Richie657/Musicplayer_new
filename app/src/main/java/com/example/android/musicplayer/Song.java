package com.example.android.musicplayer;

/**
 * Created by Rich on 04/04/2018.
 */

class Song {

    private String mArtistName;

    private String mSongName;


    Song(String artistName, String songName) {
        mArtistName = artistName;
        mSongName = songName;

    }

    String getmArtistName() {
        return mArtistName;
    }

    String getmSongName() {
        return mSongName;
    }

}


