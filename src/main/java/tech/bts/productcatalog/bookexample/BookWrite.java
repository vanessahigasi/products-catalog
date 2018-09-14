package tech.bts.productcatalog.bookexample;

import com.google.gson.Gson;

import java.io.PrintWriter;

public class BookWrite {

    public static void main(String[] args) throws Exception {

        Book b = new Book("Lord of the Rings","JRR Tolkien", 150 );

        writesJSON(b);
    }

    public static void writesJSON (Book book) throws Exception {
        Gson gson = new Gson();
        String json = gson.toJson(book);
        PrintWriter writer = new PrintWriter("book.json");

        writer.println(json);

        writer.close();


    }



}
