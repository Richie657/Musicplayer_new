package com.example.android.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create an array of songs
        final ArrayList<Song> songs = getSongs();


        // Create an {@link SongAdapter}, whose data source is a list of {@link Songs}s. The
        // adapter knows how to create list items for each item in the list.
        SongAdapter adapter = new SongAdapter(this, songs);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // list_view.xml layout file.
        final ListView listView = (ListView) findViewById(R.id.list_view);

        // Make the {@link ListView} use the {@link SongAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Song} in the list.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Song song = (Song) listView.getItemAtPosition(position);
                Intent nowPlaying = new Intent(view.getContext(), NowPlayingActivity.class);
                nowPlaying.putExtra("SONG_NAME", song.getmSongName());
                nowPlaying.putExtra("ARTIST_NAME", song.getmArtistName());
                startActivity(nowPlaying);

            }
        });
    }

    public ArrayList<Song> getSongs() {
        ArrayList<Song> songs = new ArrayList<Song>();

        for (int i = 0; i <= 10; i++) {
            songs.add(new Song("Song_Name " + "_" + i, "Artist" + "_" + i));
        }

        return songs;
    }
}

