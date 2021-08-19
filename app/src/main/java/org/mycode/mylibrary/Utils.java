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
