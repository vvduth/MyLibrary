package org.mycode.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnAllBooks, btnAlreadyRead, btnWantToRead, btnCurrentlyReading, btnFavorite, btnAbout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        btnAllBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AllBooksActivity.class); // change from main activity to allbooks activity
                 startActivity(intent);  //intent is an object, kind of similar to navigator in React
            }
        });
    }

    private void initViews(){
        btnAllBooks = findViewById(R.id.btnAllBooks);
        btnAlreadyRead = findViewById(R.id.btnAlreadyRead);
        btnWantToRead = findViewById(R.id.btnWantToRead);
        btnCurrentlyReading = findViewById(R.id.btnCurrentlyReading);
        btnFavorite = findViewById(R.id.btnFavourite);
        btnAbout = findViewById(R.id.btnAbout);
    }
}