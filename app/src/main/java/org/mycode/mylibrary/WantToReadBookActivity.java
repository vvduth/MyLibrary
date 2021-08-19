package org.mycode.mylibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class WantToReadBookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_want_to_read_book);


        RecyclerView recyclerView = findViewById(R.id.wantToReadRecView);
        //to crated Recview adapter previously, we can reuse it
        BooksRecViewAdapter adapter = new BooksRecViewAdapter(this, "wantToRead");
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter.setBooks(Utils.getWantToReadBooks()); //can use getAlreadyReadBooks directly
        //In naim activity put Utils.getInstance to avoid Null pointer exception when user click directly
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