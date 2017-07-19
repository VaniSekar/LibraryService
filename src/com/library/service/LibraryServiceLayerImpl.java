package com.library.service;

import java.util.List;

import com.sample.Book;

public class LibraryServiceLayerImpl implements ILibraryService{

	public LibraryServiceLayerImpl() {
		// TODO Auto-generated constructor stub
	}
	
	LibraryServiceLayerDAO accessLibraryServiceDao = new LibraryServiceLayerDAO();
	
	
	public Book addBook(Book book){
		//return accessLibraryServiceDao.LibraryServiceLayerDAO();
		return accessLibraryServiceDao.addBook(book);
	}


	@Override
	public List<Book> addBooks(List<Book> books) {
		// TODO Auto-generated method stub
		return accessLibraryServiceDao.addBooks(books) ;
	}


	@Override
	public Book searchBook(int id) {
		// TODO Auto-generated method stub
		return accessLibraryServiceDao.searchBook(id);
	}


	@Override
	public List<Book> searchByTitle(String title) {
		// TODO Auto-generated method stub
		return accessLibraryServiceDao.searchByTitle(title);
	}


	@Override
	public void deleteBook(Book book) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Book updateBook(Book book) {
		// TODO Auto-generated method stub
		return accessLibraryServiceDao.updateBook(book);
	}

}
