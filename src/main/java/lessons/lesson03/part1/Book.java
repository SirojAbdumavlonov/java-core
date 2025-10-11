package lessons.lesson03.part1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {
    private String isbn;
    private String name;
    private String author;
    private int year;
    private boolean status; // true = доступна, false = зарезервирована

    private static List<Book> books = new ArrayList<Book>();

    public String getBookingInfo(){
        return String.format("isbn: %s, name: %s, author: %s, year: %d, status: %s",
            isbn, name, author, year, status ? "available" : "not available");
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void reserveBook(Book book){
        if (book.status){ // true = available
            book.status = false;
            System.out.println("Book reserved");
        } else {
            System.out.println("Already booked");
        }
    }
}
