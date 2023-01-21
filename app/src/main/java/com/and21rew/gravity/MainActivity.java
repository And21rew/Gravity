package com.and21rew.gravity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.and21rew.a2dgamecore.LoopCore;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoopCore loop = new LoopCore();
        loop.StartGame();
    }
}