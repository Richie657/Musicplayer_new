package com.example.android.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class NowPlayingActivity extends AppCompatActivity {

    TextView nowPlaying_Artist;

    TextView nowPlaying_Song;

    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        Intent incoming = getIntent();

        nowPlaying_Artist = (TextView) findViewById(R.id.nowPlaying_text_view);

        nowPlaying_Artist.setText(incoming.getStringExtra("ARTIST_NAME"));

        nowPlaying_Song = (TextView) findViewById(R.id.nowPlaying_song);

        nowPlaying_Song.setText(incoming.getStringExtra("SONG_NAME"));

        backButton = (Button) findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NowPlayingActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


}

