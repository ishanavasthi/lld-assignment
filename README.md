# Amazon Top 50 Bestselling Books (2009-2019) Java Project

This project reads and analyzes Amazon's Top 50 bestselling books from 2009 to 2019 using a CSV dataset. It provides a menu-driven console application to answer queries about books, authors, ratings, and prices.

## Directory Structure
```
booksdatabase/
  bestsellers with categories.csv
  src/
    main/
      java/
        com/
          ishan/
            books/
              Book.java
            utils/
              DatasetReader.java
              Driver.java
  out/ (created after compilation)
  README.md
```

## How to Compile and Run

### 1. Open a terminal and navigate to the `booksdatabase` directory:
```
cd path/to/booksdatabase
```

### 2. Compile the Java source files
This will create the `out` directory with the correct package structure:
```
javac -d out src/main/java/com/ishan/books/Book.java src/main/java/com/ishan/utils/DatasetReader.java src/main/java/com/ishan/utils/Driver.java
```

### 3. Run the program
Make sure you are still in the `booksdatabase` directory and run:
```
java -cp out com.ishan.utils.Driver
```

#### **Note for Linux/Mac users:**
- The above commands work the same, but if you have issues with the classpath separator, use `:` instead of `;` (for example, `-cp out:...`).

## CSV File Location
- The program expects the CSV file to be named `bestsellers with categories.csv` and to be present in the `booksdatabase` directory (the same directory where you run the `java` command).

## Troubleshooting
- **Error: Could not find or load main class ...**
  - Ensure you compiled with `-d out` and your `out` directory contains `com/ishan/utils/Driver.class`.
  - Make sure you are running the `java` command from the correct directory.
- **Error reading file: ... (The system cannot find the path specified)**
  - Make sure `bestsellers with categories.csv` is in the same directory where you run the `java` command.
  - If you change the CSV path in the code, update it to match the actual location.

## Features
- Total number of books by an author
- List all authors in the dataset
- List all books by an author
- List all books with a specific user rating
- List names and prices of all books by an author

---

If you have any issues, please check the troubleshooting section or contact the project maintainer.
