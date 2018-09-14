package tech.bts.productcatalog;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductCatalog1 {

    /**
     * This program can read products from keyboard and store them in a file (products.json).
     *
     * When the program starts it will ask "What do you want to do?".
     * You can say "add" (add product) or "list" (display products).
     *
     * If you say "add" the program will ask for the product data (name, price, units).
     *
     * > What do you want to do? add
     * > Tell me the product name: iPhone
     * > Price: 1000
     * > Units: 5
     * > Product added
     * > What do you want to do? list
     * iPhone - 1000€ - 5 units
     * ....
     * > What do you want to do?
     */


    public static void main(String[] args) throws Exception{

        Scanner input = new Scanner(System.in);//scanner can read from keyboard

        //read the products from the file
        //prepare reader to read from the .json file
        BufferedReader reader = new BufferedReader(new FileReader("products.json"));
        String  json = reader.readLine(); // read the file
        Gson gson = new Gson(); // create gson
        Type type = new TypeToken<List<Product>>(){}.getType(); // specify the type
        List<Product> products = gson.fromJson(json, type); //converting json in list of products


        //how can I put this into a variable?"

        while (true) {


            System.out.print("What do you want to do? ");

            String line = input.nextLine();


            if (line.equals("exit")) {

                writesJSON(products);//store the product in a file

                break;

            } else if (line.equals("add")) {

                if (line.equals("add")) {

                    System.out.print("Product name? ");
                    String name = input.nextLine();

                    System.out.print("Price? ");
                    Double price = Double.parseDouble(input.nextLine());

                    System.out.print("Units? ");
                    int units = Integer.parseInt(input.nextLine());

                    Product product = new Product(name, price, units);

                    products.add(product);

                    System.out.println("Product added: " + product);

                }

            } else if (line.equals("list")){

                //print the list of product I have added

                for (int i = 0; i < products.size(); i++) {
                    Product product = products.get(i);
                    System.out.println(product);

                //for (Product product : products)
                   // sout  (product);

                }

            }


        }

    }

    public static void writesJSON (List<Product> products) throws Exception {

        Gson gson = new Gson();
        String json = gson.toJson(products); //serializing (object to string)

        PrintWriter writer = new PrintWriter("products.json");

        writer.println(json);

        writer.close();
    }


}
