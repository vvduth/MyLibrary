package org.mycode.mylibrary;

//this class is singleton pattern: only  1 instance of this class in the entire project

import java.util.ArrayList;

public class Utils {

    private  static Utils instance ;


    private  static ArrayList<Book> allBooks; // all book in the app
    private static ArrayList<Book> alreadyReadBooks ;
    private static ArrayList<Book> wantToReadBooks ;
    private static ArrayList<Book> currentlyReadingBooks;
    private static ArrayList<Book> favouriteBooks ;

    private Utils() {
        if (null == allBooks){
            allBooks = new ArrayList<>();
            initData();
        }
        if (null == alreadyReadBooks){
            alreadyReadBooks = new ArrayList<>();
        }
        if (null == wantToReadBooks){
            wantToReadBooks = new ArrayList<>();
        }
        if (null == currentlyReadingBooks){
            currentlyReadingBooks = new ArrayList<>();
        }
        if (null == favouriteBooks){
            favouriteBooks = new ArrayList<>();
        }
    }

    private void initData(){
        //TODO : add initial data

        allBooks.add(new Book(1, "Harry Potter","JK Rowling", 1570,"https://www.jkrowling.com/wp-content/uploads/2018/01/SorcerersStone_2017.png",
                "A witch story", "Very famous"));
        allBooks.add(new Book(2, "The Three Musketeers","Alexandre Dumas", 1510,"https://i.ebayimg.com/images/g/350AAOSwm2xZo-RY/s-l1600.jpg",
                "High adventure, royal intrigue, and romance", "Very famous"));
        allBooks.add(new Book(3, "Hearts","Edmondo De Amicis", 658,"https://images-na.ssl-images-amazon.com/images/I/51HDX66T9YL._SY291_BO1,204,203,200_QL40_FMwebp_.jpg",
                "A diary form as told by Enrico Bottini", "Enrico's parents and older sister Silvia interact with him as written in his diary. \n" +
                "As well as his teacher who assigns him with homework that deals with several different stories of children throughout the Italian states who should be seen as role models – these stories are then given in the book as Enrico comes upon reading them. Every story revolves around a different moral value, the most prominent of which are helping those in need, having great love and respect for family and friends, and patriotism. These are called 'The Monthly Stories' and appear at the end of every school month."));
        allBooks.add(new Book(4, "Don Quixote","Miguel de Cervantes.", 1589,"https://images-na.ssl-images-amazon.com/images/I/616b+Y4X9WL._SX317_BO1,204,203,200_.jpg",
                "Adventures of a noble.", "The plot revolves around the adventures of a noble (hidalgo) from La Mancha named Alonso Quixano, who reads so many chivalric romances that he loses his mind and decides to become a knight-errant (caballero andante) to revive chivalry and serve his nation, under the name Don Quixote de la Mancha. \n " +
                " He recruits a simple farmer, Sancho Panza, as his squire, who often employs a unique, earthy wit in dealing with Don Quixote's rhetorical monologues on knighthood, already considered old-fashioned at the time. Don Quixote, in the first part of the book, does not see the world for what it is and prefers to imagine that he is living out a knightly story."));
        allBooks.add(new Book(5, "The Fault in Our Stars","John Green", 1510,"https://upload.wikimedia.org/wikipedia/en/a/a9/The_Fault_in_Our_Stars.jpg",
                "Getting hurt in this world is unavoidable, but we do get to choose whom we allow to hurt us", " The story is narrated by Hazel Grace Lancaster, a 16-year-old girl with thyroid cancer that has affected her lungs. Hazel is forced by her parents to attend a support group where she subsequently meets and falls in love with 17-year-old Augustus Waters, an ex-basketball player and amputee."));
    }


    public static Utils getInstance() {
        if ( null != instance){
            return instance ;
        } else {
            instance = new Utils();
            return instance;
        }

    }

    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static ArrayList<Book> getAlreadyReadBooks() {
        return alreadyReadBooks;
    }

    public static ArrayList<Book> getWantToReadBooks() {
        return wantToReadBooks;
    }

    public static ArrayList<Book> getCurrentlyReadingBooks() {
        return currentlyReadingBooks;
    }

    public static ArrayList<Book> getFavouriteBooks() {
        return favouriteBooks;
    }

    public Book getBookById(int id) {
        for (Book b : allBooks){
            if(b.getId()==id){
                return b ;
            }
        }
        return null ;
    }

    public boolean addToAlreadyRead(Book book){
        return alreadyReadBooks.add(book); // return if we have added the book successfully or not
    }
    public boolean addToWhistList(Book book){
        return  wantToReadBooks.add(book);
    }
    public boolean addToCurrentRead(Book book){
        return  currentlyReadingBooks.add(book);
    }
    public boolean addToFavourite(Book book){
        return  favouriteBooks.add(book);
    }

    public boolean removeFromAlreadyReadBook(Book book){
        return alreadyReadBooks.remove(book);
    }

    public boolean removeFromWhistList(Book book){
        return wantToReadBooks.remove(book);
    }

    public boolean removeFromCurrentRead(Book book){
        return currentlyReadingBooks.remove(book);
    }

    public boolean removeFromFavourite(Book book){
        return favouriteBooks.remove(book);
    }
}
