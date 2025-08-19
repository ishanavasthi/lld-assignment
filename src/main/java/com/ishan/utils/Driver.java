package com.ishan.utils;

import java.util.*;

import com.ishan.books.Book;

public class Driver {
    public static void main(String[] args) {
        String csvPath = "bestsellers with categories.csv";
        List<Book> books = DatasetReader.readBooksFromCSV(csvPath);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Amazon Bestsellers Menu ---");
            System.out.println("1. Total number of books by an author");
            System.out.println("2. All the authors in the dataset");
            System.out.println("3. Names of all the books by an author");
            System.out.println("4. Classify with a user rating");
            System.out.println("5. Price of all the books by an author");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch (choice) {
                case 1:
                    System.out.print("Enter author name: ");
                    String author1 = scanner.nextLine();
                    long count = books.stream().filter(b -> b.getAuthor().equalsIgnoreCase(author1)).count();
                    System.out.println("Total books by " + author1 + ": " + count);
                    break;
                case 2:
                    Set<String> authors = new TreeSet<>();
                    for (Book b : books) authors.add(b.getAuthor());
                    System.out.println("Authors in dataset:");
                    for (String a : authors) System.out.println(a);
                    break;
                case 3:
                    System.out.print("Enter author name: ");
                    String author3 = scanner.nextLine();
                    System.out.println("Books by " + author3 + ":");
                    books.stream().filter(b -> b.getAuthor().equalsIgnoreCase(author3))
                        .forEach(b -> System.out.println(b.getTitle()));
                    break;
                case 4:
                    System.out.print("Enter user rating: ");
                    double rating = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Books with user rating " + rating + ":");
                    books.stream().filter(b -> b.getUserRating() == rating)
                        .forEach(Book::printDetails);
                    break;
                case 5:
                    System.out.print("Enter author name: ");
                    String author5 = scanner.nextLine();
                    System.out.println("Books and prices by " + author5 + ":");
                    books.stream().filter(b -> b.getAuthor().equalsIgnoreCase(author5))
                        .forEach(b -> System.out.println(b.getTitle() + " - $" + b.getPrice()));
                    break;
                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
