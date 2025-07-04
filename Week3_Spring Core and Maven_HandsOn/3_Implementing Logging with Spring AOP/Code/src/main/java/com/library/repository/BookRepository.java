package com.library.repository;
public class BookRepository {
    private static final String PREFIX = "[LIBRARY] ";
    public void save(String bookName) {
        String saveMessage = PREFIX + "Saved book: " + bookName;
        System.out.println(saveMessage);
    }
    public void delete(String bookName) {
        String deleteMessage = PREFIX + "Deleted book: " + bookName;
        System.out.println(deleteMessage);
    }   
    public String find(String bookName) {
        String findMessage = PREFIX + "Found book: " + bookName;
        System.out.println(findMessage);
        return bookName;
    }
}