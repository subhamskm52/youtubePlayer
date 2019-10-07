package com.oggy.youtubeplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class youtubePlayer extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    static final String GOOGLE_API_KEY="AIzaSyCg4Y6M83auegD7nuCQ7BSsxq4mKhdn_rU";

    static final String sia_playlist="OLAK5uy_nPPoCWlK-EK0eYMe13bZfVFTIIlmMYY8E";
    static final String eminem_playlist="OLAK5uy_mAmMlzPVVHfI6qRMQI-nWyUsqi7RhWTVI";
    static final String linkin_park_playlist="OLAK5uy_kGYjZGHZ3rIs9XU09I--lWG9urK7YUbg8";
    static final String mixed_playlist1="RDiFiNlLt8sJw";
    static final String mixed_playlist2="PL4o29bINVT4EG_y-k5jGoOu3-Am8Nvi10";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ConstraintLayout layout = (ConstraintLayout)getLayoutInflater().inflate(R.layout.activity_youtube_player,null);
        setContentView(layout);

        YouTubePlayerView playerView =new YouTubePlayerView(this);
        playerView.setLayoutParams(new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        layout.addView(playerView);
        playerView.initialize(GOOGLE_API_KEY,this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {

        if(!wasRestored)
        {
            youTubePlayer.cuePlaylist(sia_playlist);
        }

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

        if(youTubeInitializationResult.isUserRecoverableError())
        {
            youTubeInitializationResult.getErrorDialog(this,1).show();
        }
        else
        {
            String error="unknown error occurs";
            Toast.makeText(this,error,Toast.LENGTH_LONG).show();
        }

    }
}
