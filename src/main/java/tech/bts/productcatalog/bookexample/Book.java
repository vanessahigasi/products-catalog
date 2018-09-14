package tech.bts.productcatalog.bookexample;

public class Book {

    /**1- Create 2 programs (classes with main method) in the same project: BookWrite and BookRead.
       2- Also create the class Book with fields title, author and numPages. Add a constructor and the toString method.
3- In BookWrite, create one Book (only one, not a list) and write it to the file "Book.csv"
     4- In BookRead, you read the Book from "Book.csv" and print it to the screen. */

    String title;
    String author;
    int numPages;

    public Book(String title, String author, int numPages){
        this.title = title;
        this.author = author;
        this.numPages = numPages;

    }

    public String toString (){
        return this.title + " of the " + this.author + " has " + this.numPages + " pages ";
    }

}
