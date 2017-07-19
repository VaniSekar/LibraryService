package com.library.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.sample.Book;

public class LibraryServiceLayerDAO {

	static HashMap<Integer, Book> bookMap = new HashMap<Integer, Book>();

	public LibraryServiceLayerDAO() {

	}

	public Book addBook(Book book) {
		int i = bookMap.size() + 1;
		book.setId(i);
		bookMap.put(i, book);
		return book;
	}

	// @Override
	public Book searchBook(int id) {
		return bookMap.get(id);

	}

	// @Override
	public void deleteBook(Book book) {
		int id = book.getId();
		bookMap.remove(id, book);
	}

	// @Override
	public Book updateBook(Book book) {
		int id = book.getId();
		bookMap.replace(id, book);
		return bookMap.get(id);
	}

	// @Override
	public List<Book> addBooks(List<Book> books) {
		List<Book> addedBooks = new ArrayList<Book>();
		int i = 0;
		/*
		 * for (Book book : books) { i = bookMap.size() + 1; bookMap.put(i,
		 * book); addedBooks.add(book); }
		 */

		for (Book book : books) {
			LibraryServiceJDBC librarayServiceJdbc = new LibraryServiceJDBC();
			String book_Name = book.getTitle();
			// String queryString = "SELECT * FROM EMPLOYEE where emp_Name
			// ="+"'"+name+"';";
			String queryString = "insert into Book(book_title) values('" + book_Name + "');";
			librarayServiceJdbc.insertData(queryString);
			addedBooks.add(book);
		}

		return addedBooks;
	}

	// @Override
	public List<Book> searchByTitle(String title) {
		List<Book> matchedBook = new ArrayList<Book>();
		/*
		 * for (Book book : bookMap.values()) { if
		 * (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
		 * //book.getTitle().matches( matchedBook.add(book); } }
		 */

		LibraryServiceJDBC librarayServiceJdbc = new LibraryServiceJDBC();

		String queryString = "SELECT * FROM Book WHERE lower(book_title) LIKE lower('%" + title + "%')";
		ResultSet rs = librarayServiceJdbc.getResult(queryString);
		if (rs != null) {
			try {
				while (rs.next()) {
					Book book = new Book();
					book.setId(rs.getInt(0));
					book.setTitle(rs.getString(1));
					matchedBook.add(book);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return matchedBook;
	}

}
