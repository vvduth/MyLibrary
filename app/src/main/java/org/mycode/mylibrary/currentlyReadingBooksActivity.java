package org.mycode.mylibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class currentlyReadingBooksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currently_reading_books);


        RecyclerView recyclerView = findViewById(R.id.currentReadRecView);
        //to crated Recview adapter previously, we can reuse it
        BooksRecViewAdapter adapter = new BooksRecViewAdapter(this, "currentlyReading");
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter.setBooks(Utils.getCurrentlyReadingBooks()); //can use getAlreadyReadBooks directly
        //In naim activity put Utils.getInstance to avoid Null pointer
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        //when we switch to another screen in our app, a stack was created save all the step, use the flag to clear the stack
        // using two above flag, after the switch, the app will clear the stack and save only 2 screen: old one and new one, so if we press the back button twice
        // the app will come to home screen
        startActivity(intent);
    }
}