package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book idiot = new Book("Idiot", 450);
        Book master = new Book("Master and Margarita", 500);
        Book code = new Book("Clean code", 370);
        Book eugene = new Book("Eugene Onegin", 250);
        Book[] books = new Book[4];
        books[0] = idiot;
        books[1] = master;
        books[2] = code;
        books[3] = eugene;
        System.out.println("Books list:");
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getTitle() + " - " + book.getCount());
        }
        System.out.println("\nBooks list replaced:");
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getTitle() + " - " + book.getCount());
        }
        System.out.println("\nBooks list with title \"Clean code\":");
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            if ("Clean code".equals(books[i].getTitle())) {
                System.out.println(book.getTitle() + " - " + book.getCount());
            }
        }
    }
}
