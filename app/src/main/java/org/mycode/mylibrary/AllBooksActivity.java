package org.mycode.mylibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {

    private RecyclerView booksRecView ;
    private BooksRecViewAdapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);

        adapter = new BooksRecViewAdapter(this);
        booksRecView = findViewById(R.id.booksRecyclerView);

        booksRecView.setAdapter(adapter);
        booksRecView.setLayoutManager(new GridLayoutManager(this,2));

        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(1, "Harry Potter","JK Rowling", 1570,"https://www.jkrowling.com/wp-content/uploads/2018/01/SorcerersStone_2017.png",
                "A witch story", "Very famous"));
        adapter.setBooks(books);
    }
}