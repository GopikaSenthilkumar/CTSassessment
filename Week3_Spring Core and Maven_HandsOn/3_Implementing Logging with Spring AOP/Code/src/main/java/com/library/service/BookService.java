package com.library.service;
import com.library.repository.BookRepository;
public class BookService {
    private BookRepository bookRepository;
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }   
    public void addBook(String bookName) {
        bookRepository.save(bookName);
    }   
    public void removeBook(String bookName) {
        bookRepository.delete(bookName);
    } 
    public String getBook(String bookName) {
        return bookRepository.find(bookName);
    }
}