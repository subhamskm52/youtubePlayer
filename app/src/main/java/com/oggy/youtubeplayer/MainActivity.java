package com.oggy.youtubeplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubeStandalonePlayer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sia = (Button)findViewById(R.id.sia_playlist);
        Button eminem =(Button)findViewById(R.id.eminem_palylist);
        Button linkin_park = (Button)findViewById(R.id.linkin_park_playlist);
        Button mix_one = (Button)findViewById(R.id.mix_one);
        Button mix_two= (Button)findViewById(R.id.mix_two);

        sia.setOnClickListener(this);
        eminem.setOnClickListener(this);
        linkin_park.setOnClickListener(this);
        mix_one.setOnClickListener(this);
        mix_two.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent =null;
        switch (v.getId())
        {
            case R.id.sia_playlist:
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this,youtubePlayer.GOOGLE_API_KEY,youtubePlayer.sia_playlist);
                break;
            case R.id.eminem_palylist:
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this,youtubePlayer.GOOGLE_API_KEY,youtubePlayer.eminem_playlist);
                break;
            case R.id.linkin_park_playlist:
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this,youtubePlayer.GOOGLE_API_KEY,youtubePlayer.linkin_park_playlist);
                break;
            case R.id.mix_one:
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this,youtubePlayer.GOOGLE_API_KEY,youtubePlayer.mixed_playlist1);
                break;
            case R.id.mix_two:
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this,youtubePlayer.GOOGLE_API_KEY,youtubePlayer.mixed_playlist2);
                break;
            default:

        }
        if(intent!=null)
        {
            startActivity(intent);
        }

    }
}
