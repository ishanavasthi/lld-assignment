package com.ishan.utils;

import java.io.*;
import java.util.*;

import com.ishan.books.Book;

public class DatasetReader {
    public static List<Book> readBooksFromCSV(String filePath) {
        List<Book> books = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false; // skip header
                    continue;
                }
                String[] tokens = parseCSVLine(line);
                if (tokens.length != 7) continue; // skip malformed lines
                try {
                    String title = tokens[0];
                    String author = tokens[1];
                    double userRating = Double.parseDouble(tokens[2]);
                    int reviews = Integer.parseInt(tokens[3]);
                    int price = Integer.parseInt(tokens[4]);
                    int year = Integer.parseInt(tokens[5]);
                    String genre = tokens[6];
                    books.add(new Book(title, author, userRating, reviews, price, year, genre));
                } catch (Exception e) {
                    // skip malformed lines
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return books;
    }

    // Handles quoted fields with commas
    private static String[] parseCSVLine(String line) {
        List<String> tokens = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean inQuotes = false;
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '"') {
                inQuotes = !inQuotes;
            } else if (c == ',' && !inQuotes) {
                tokens.add(sb.toString().trim());
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }
        tokens.add(sb.toString().trim());
        return tokens.toArray(new String[0]);
    }
}
