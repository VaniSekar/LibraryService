package com.library.service;

import java.util.List;

import com.sample.Book;

public interface ILibraryService {
	public Book addBook(Book book);
	public List<Book> addBooks(List<Book> books);
	public Book searchBook(int id);
	public List<Book> searchByTitle(String title);
	public void deleteBook(Book book);
	public Book updateBook(Book book);
	
}
