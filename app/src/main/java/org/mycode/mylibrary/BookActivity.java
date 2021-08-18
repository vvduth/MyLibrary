package org.mycode.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class BookActivity extends AppCompatActivity {
    private TextView txtShowBookName, txtShowAuthor, txtShowPages, txtShortDecsWord, txtLongDecsWord ;
    private Button btnAddToWantToRead , btnAddToCurrentlyReading, btnAddToFavorite, btnAddToAlreadyRead ;
    private ImageView imgBooks ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initViews();

        String longDes = "The Three Musketeers (French: Les Trois Mousquetaires, [le tʁwɑ muskətɛːʁ]) is a French historical adventure novel written in 1844 by French author Alexandre Dumas. It is in the swashbuckler genre, which has heroic, chivalrous swordsmen who fight for justice.\n" +
                "\n" +
                "Set between 1625 and 1628, it recounts the adventures of a young man named d'Artagnan (a character based on Charles de Batz-Castelmore d'Artagnan) after he leaves home to travel to Paris, hoping to join the Musketeers of the Guard. Although d'Artagnan is not able to join this elite corps immediately, he is befriended by three of the most formidable musketeers of the age – Athos, Porthos and Aramis, \"the three musketeers\" or “the three inseparables” – and becomes involved in affairs of state and at court.\n" +
                "\n" +
                "The Three Musketeers is primarily a historical and adventure novel. However, Dumas frequently portrays various injustices, abuses and absurdities of the Ancien Régime, giving the novel an additional political significance at the time of its publication, a time when the debate in France between republicans and monarchists was still fierce. The story was first serialised from March to July 1844, during the July Monarchy, four years before the French Revolution of 1848 violently established the Second Republic.";
        //Todo: get data from recycler  view in here
        Book book = new Book(2, "The Three Musketeers","Alexandre Dumas", 1510,"https://i.ebayimg.com/images/g/350AAOSwm2xZo-RY/s-l1600.jpg",
                "High adventure, royal intrigue, and romance", longDes);

        setData(book);
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