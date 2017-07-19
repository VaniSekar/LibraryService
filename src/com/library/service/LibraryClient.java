package com.library.service;

import java.util.ArrayList;
import java.util.List;

import com.sample.Book;

public class LibraryClient {

	public LibraryClient() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		//ILibraryService libservimp = new LibraryServiceImpl();
		ILibraryService libservimp = new  LibraryServiceLayerImpl();
		//Book bookInput = new Book();
		
		List<Book> booksInput = new ArrayList<Book>();
		Book book1 = new Book();
		book1.setTitle("beautiful mind");
		booksInput.add(book1);
		
		Book book2 = new Book();
		book2.setTitle("Mindfulness");
		booksInput.add(book2);
		
		Book book3 = new Book();
		book3.setTitle("600 Pictures");
		booksInput.add(book3);
		
		Book book4 = new Book();
		book4.setTitle("Hardy boy adventures");
		booksInput.add(book4);
		
		List<Book> booksOutput = libservimp.addBooks(booksInput);
		System.out.println("the added List"+booksOutput);
		for(Book book: booksOutput){
			System.out.println(book.getTitle());
		}
		List<Book> booksMatchedOutput = libservimp.searchByTitle("mind");
		for(Book book:booksMatchedOutput){
			
			System.out.println("Client....>"+book.getTitle());
		}
		
		
		/*bookInput.setTitle("can't u sleep little bear");
		Book bookOutput = libservimp.addBook(bookInput);
		System.out.println("book added"+bookOutput.getTitle());
		libservimp.searchBook(1);
		System.out.println("book searched1"+libservimp.searchBook(1));
		libservimp.deleteBook(bookOutput);
		libservimp.searchBook(1);
		System.out.println("book searched2"+libservimp.searchBook(1));
		libservimp.addBook(bookInput);
		
		bookOutput.setTitle("can sleep little bear");
		Book bookOutput2 = libservimp.updateBook(bookOutput);
		System.out.println("book added"+bookOutput2.getTitle());
		ILibraryService newLibservice = new LibraryServiceImpl();
		System.out.println("another client searching for book 1 " + newLibservice.searchBook(1).getTitle());
		*/
	}

}
