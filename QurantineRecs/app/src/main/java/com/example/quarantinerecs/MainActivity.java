package com.example.quarantinerecs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn;
    ImageView img;
    TextView tv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.blackLives);
        img = findViewById(R.id.movies);
        img = findViewById(R.id.tvShows);
        img = findViewById(R.id.games);
        img = findViewById(R.id.books);
        img = findViewById(R.id.gym);

    }


    public void goToMovies(View view) {
        Intent toMovies = new Intent(this,MovieActivity.class);
        startActivity(toMovies);
    }

    public void goToScreen3() {
        Intent toRes = new Intent(this, blmActivity.class);
        startActivity(toRes);

    }

    public void goToRes(View view) {
        goToScreen3();
    }


    public void gotToScreen4(){
        Intent toBooks = new Intent (this,BooksActivity.class);
        startActivity(toBooks);
    }


    public void goToBooks(View view) {
        gotToScreen4();
    }
}

