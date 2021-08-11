package org.mycode.mylibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
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
        booksRecView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(1, "Harry Potter","JK Rowling", 1570,"https://www.jkrowling.com/wp-content/uploads/2018/01/SorcerersStone_2017.png",
                "A witch story", "Very famous"));
        books.add(new Book(2, "The Three Musketeers","Alexandre Dumas", 1510,"https://pictures.abebooks.com/inventory/424641162.jpg",
                "High adventure, royal intrigue, and romance", "Very famous"));
        adapter.setBooks(books);
    }
}