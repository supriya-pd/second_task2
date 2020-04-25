package com.example.second_task;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BestActivity extends AppCompatActivity {
    TextView game_score;
    int last_score;
    int best_score;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_best);
        game_score=(TextView)findViewById(R.id.score);
        SharedPreferences preferences=getSharedPreferences("PREFS",0);
        last_score=preferences.getInt("lastScore",0);
        best_score=preferences.getInt("bestScore",0);
        if(last_score>best_score){
            best_score=last_score;
            SharedPreferences.Editor editor=preferences.edit();
            editor.putInt("last score" , last_score);
            editor.apply();

        }
  game_score.setText("Last Score: " + last_score+"/n" + "Best Score: "+best_score);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent =new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        finish();
    }
}
