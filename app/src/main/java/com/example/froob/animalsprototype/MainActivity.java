package com.example.froob.animalsprototype;

import android.content.Context;
import android.widget.MediaController;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.widget.Toast.*;
import static com.example.froob.animalsprototype.R.id.videoView;

import android.media.MediaPlayer;
import android.widget.VideoView;

import java.io.Console;

public class MainActivity extends AppCompatActivity{

    private MediaPlayer mp = new MediaPlayer();
    private VideoView myVideoView;
    VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /********** Create instances for button **********/
        final Button button = (Button) findViewById(R.id.button);
        final Button button2 = (Button) findViewById(R.id.button2);
        final Button button3 = (Button) findViewById(R.id.button3);
        final Button button4 = (Button) findViewById(R.id.button4);
//        myVideoView = (VideoView) findViewById(videoView);
//        myVideoView.setVideoURI(Uri.parse("android.resource://" +getPackageName()+ "/"+R.raw.puppy));
//        myVideoView.setMediaController(new MediaController(this));
//        myVideoView.requestFocus();
//        myVideoView.start();

        video = (VideoView) findViewById(R.id.videoView);
        String path1 = "https://www.w3schools.com/html/mov_bbb.mp4";
        MediaController mc = new MediaController(this);
        mc.setAnchorView(video);
        mc.setMediaPlayer(video);
        Uri uri = Uri.parse(path1);
        video.setMediaController(mc);

        // You can use an absolute path or an URL
         video.setVideoURI(uri);
//        video.setVideoPath("android.resource://" +getPackageName()+ "/"+R.raw.dog);


        /********** Attach actions for each button here **********/

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Context context = getApplicationContext();
                CharSequence text = "Sound 1 was pressed.";
                int duration = LENGTH_SHORT;
                Toast toast = makeText(context, text, duration);
                toast.show();
                mp =  MediaPlayer.create(MainActivity.this, R.raw.cat_meow);
                mp.start();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mp = MediaPlayer.create(MainActivity.this, R.raw.cow_sound);
                mp.start();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Context context = getApplicationContext();
                CharSequence text = "Sound 3 was pressed.";
                int duration = LENGTH_SHORT;
                Toast toast = makeText(context, text, duration);
                toast.show();
                mp = MediaPlayer.create(MainActivity.this, R.raw.puppy_barking);
                mp.start();
            }
        });


        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                CharSequence text = "Button was pressed.";
                int duration = LENGTH_SHORT;
                Toast toast = makeText(context, text, duration);
                toast.show();
//                mp = MediaPlayer.create(MainActivity.this, R.raw.pic);
//                mp.start();
                video.start();
            }
        });

    }

}
