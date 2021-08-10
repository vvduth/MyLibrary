package org.mycode.mylibrary;

public class Book {
    private  int id ;
    private String name ;
    private  String author ;
    private int pages ;
    private  String imageUrl ;
    private String shortDecs ;
    private String longDecs ;

    public Book(int id, String name, String author, int pages, String imageUrl, String shortDecs, String longDecs) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.imageUrl = imageUrl;
        this.shortDecs = shortDecs;
        this.longDecs = longDecs;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getShortDecs() {
        return shortDecs;
    }

    public String getLongDecs() {
        return longDecs;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setShortDecs(String shortDecs) {
        this.shortDecs = shortDecs;
    }

    public void setLongDecs(String longDecs) {
        this.longDecs = longDecs;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", imageUrl='" + imageUrl + '\'' +
                ", shortDecs='" + shortDecs + '\'' +
                ", longDecs='" + longDecs + '\'' +
                '}';
    }
}
