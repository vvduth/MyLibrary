package org.mycode.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

    public static final String BOOK_ID_KEY = "bookId";

    private TextView txtShowBookName, txtShowAuthor, txtShowPages, txtShortDecsWord, txtLongDecsWord ;
    private Button btnAddToWantToRead , btnAddToCurrentlyReading, btnAddToFavorite, btnAddToAlreadyRead ;
    private ImageView imgBooks ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initViews();

        /*String longDes = "The Three Musketeers (French: Les Trois Mousquetaires, [le tʁwɑ muskətɛːʁ]) is a French historical adventure novel written in 1844 by French author Alexandre Dumas. It is in the swashbuckler genre, which has heroic, chivalrous swordsmen who fight for justice.\n" +
                "\n" +
                "Set between 1625 and 1628, it recounts the adventures of a young man named d'Artagnan (a character based on Charles de Batz-Castelmore d'Artagnan) after he leaves home to travel to Paris, hoping to join the Musketeers of the Guard. Although d'Artagnan is not able to join this elite corps immediately, he is befriended by three of the most formidable musketeers of the age – Athos, Porthos and Aramis, \"the three musketeers\" or “the three inseparables” – and becomes involved in affairs of state and at court.\n" +
                "\n" +
                "The Three Musketeers is primarily a historical and adventure novel. However, Dumas frequently portrays various injustices, abuses and absurdities of the Ancien Régime, giving the novel an additional political significance at the time of its publication, a time when the debate in France between republicans and monarchists was still fierce. The story was first serialised from March to July 1844, during the July Monarchy, four years before the French Revolution of 1848 violently established the Second Republic.";
        //Todo: get data from recycler  view in here
        Book book = new Book(2, "The Three Musketeers","Alexandre Dumas", 1510,"https://i.ebayimg.com/images/g/350AAOSwm2xZo-RY/s-l1600.jpg",
                "High adventure, royal intrigue, and romance", longDes);*/
        //get data fron rec view
        Intent intent = getIntent(); //going to receive the incoming intent
        if (null != intent){
            int bookId = intent.getIntExtra(BOOK_ID_KEY, -1); // we have either book id or -1 value
            if (bookId != -1) {
                Book incomingBook = Utils.getInstance().getBookById(bookId);
                if (null != incomingBook){
                    setData(incomingBook);

                    handleAlreadyRead(incomingBook);
                    handleWantoReadBooks(incomingBook);
                    handleCurrentlyReadingBooks(incomingBook);
                    handleFavouriteBooks(incomingBook);
                }
            }
        }

        //setData(book);
    }

    private void handleFavouriteBooks(final Book book){
        ArrayList<Book> favoriteBooks = Utils.getInstance().getFavouriteBooks();

        boolean existInFavorBooks= false ;
        for (Book b : favoriteBooks){
            if (b.getId() == book.getId()){
                existInFavorBooks = true ;
            }
        }

        if (existInFavorBooks){
            btnAddToFavorite.setEnabled(false);
        } else {
            btnAddToFavorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance().addToFavourite(book)){
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();
                        //TODO: navigate the user
                        Intent intent = new Intent(BookActivity.this, favoriteBooksActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookActivity.this, "Something went wrong, try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleCurrentlyReadingBooks(final Book book){
        ArrayList<Book> currentlyReadBooks = Utils.getInstance().getCurrentlyReadingBooks();

        boolean existInWantToReadBooks= false ;
        for (Book b : currentlyReadBooks){
            if (b.getId() == book.getId()){
                existInWantToReadBooks = true ;
            }
        }

        if (existInWantToReadBooks){
            btnAddToCurrentlyReading.setEnabled(false);
        } else {
            btnAddToCurrentlyReading.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance().addToCurrentRead(book)){
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();
                        //TODO: navigate the user
                        Intent intent = new Intent(BookActivity.this, currentlyReadingBooksActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookActivity.this, "Something went wrong, try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleWantoReadBooks( final Book book){

        ArrayList<Book> wantToReadBooks = Utils.getInstance().getWantToReadBooks();

        boolean existInWantToReadBooks= false ;
        for (Book b : wantToReadBooks){
            if (b.getId() == book.getId()){
                existInWantToReadBooks = true ;
            }
        }

        if (existInWantToReadBooks){
            btnAddToWantToRead.setEnabled(false);
        } else {
            btnAddToWantToRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance().addToWhistList(book)){
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();
                        //TODO: navigate the user
                        Intent intent = new Intent(BookActivity.this, WantToReadBookActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookActivity.this, "Something went wrong, try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

    private void handleAlreadyRead(Book book){
        ArrayList<Book> alrearyReadBooks = Utils.getInstance().getAlreadyReadBooks();

        boolean existInAlreadyReadBooks = false ;
        for (Book b : alrearyReadBooks){
            if (b.getId() == book.getId()){
                existInAlreadyReadBooks = true ;
            }
        }

        if (existInAlreadyReadBooks){
            btnAddToAlreadyRead.setEnabled(false);
        } else {
            btnAddToAlreadyRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        if (Utils.getInstance().addToAlreadyRead(book)){
                            Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();
                            //TODO: navigate the user
                            Intent intent = new Intent(BookActivity.this, AlreadyReadBookActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(BookActivity.this, "Something went wrong, try again", Toast.LENGTH_SHORT).show();
                        }
                }
            });
        }
    }

    private void setData(Book book) {
        txtShowBookName.setText(book.getName());
        txtShowAuthor.setText(book.getAuthor());
        txtShowPages.setText(String.valueOf(book.getPages()));
        txtLongDecsWord.setText(book.getLongDecs());
        Glide.with(this)
                .asBitmap().load(book.getImageUrl())
                .into(imgBooks); //put image int o img books

    }

    private void initViews(){
        txtShowAuthor = findViewById(R.id.txtShowAuthor);
        txtShowBookName = findViewById(R.id.txtShowBookName);
        txtShowPages = findViewById(R.id.txtShowPages);
        txtShortDecsWord = findViewById(R.id.txtShortDecsWord);
        txtLongDecsWord = findViewById(R.id.txtLongDescWord);

        btnAddToAlreadyRead = findViewById(R.id.btnAddToAleadyRead);
        btnAddToCurrentlyReading = findViewById(R.id.btnAddToCurretlyReading);
        btnAddToFavorite = findViewById(R.id.btnAddToFavorrite);
        btnAddToWantToRead = findViewById(R.id.btnAddToWantToRead);

        imgBooks = findViewById(R.id.imgBooks);
    }
}