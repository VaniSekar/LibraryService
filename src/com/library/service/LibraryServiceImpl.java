package com.library.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 
 * @author Vani
 *
 */
public class LibraryServiceImpl implements ILibraryService {

	static HashMap<Integer, Book> bookMap = new HashMap<Integer, Book>();
	// Book book = new Book();
	// bookhm.put(2, book2);
	// bookhm.put(3, book3);
	// bookhm.put(4, book4);

	/*
	 * public static void main(String[] args) { TestToday tst = new TestToday();
	 * List<Book> books = new ArrayList<>(); Book book = new Book(); Book book1
	 * = new Book(); Book book2 = new Book(); Book book3 = new Book(); Book
	 * book4 = new Book(); Book book5 = new Book();
	 * 
	 * book.setTitle("");
	 * 
	 * List<String> titles = new ArrayList<>();
	 * titles.add("the beautiful mind"); titles.add("pride versus prejudice");
	 * titles.add("Hardy boys"); titles.add("Jeronimo stilton");
	 * titles.add("ugly the duckling");
	 * System.out.println(tst.searchString(titles, "ugly")); String checkinDate
	 * = "10/15/2016"; SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yyyy");
	 * Calendar c = Calendar.getInstance(); try { Date date1 =
	 * sd.parse(checkinDate); Date todate = c.getTime(); c.setTime(date1);
	 * c.add(Calendar.DATE, 14); String duedateStr = sd.format(c.getTime());
	 * Date dueDate = sd.parse(duedateStr); // Object book = new Object();
	 * book.setCheckoutDate(date1); book.setDueDate(dueDate);
	 * book.setTodate(todate); book1.setTitle("11");
	 * book1.setCheckoutDate(date1); book1.setDueDate(dueDate);
	 * book1.setTodate(todate); book2.setTitle("22");
	 * book2.setCheckoutDate(date1); book2.setDueDate(dueDate);
	 * book2.setTodate(todate); book3.setTitle("33");
	 * book3.setCheckoutDate(date1); book3.setDueDate(dueDate);
	 * book3.setTodate(todate); book4.setTitle("44");
	 * book4.setCheckoutDate(date1); book4.setDueDate(dueDate);
	 * book4.setTodate(todate); book5.setTitle("11");
	 * book5.setCheckoutDate(date1); book5.setDueDate(dueDate);
	 * book5.setTodate(todate); books.add(book1); books.add(book2);
	 * books.add(book3); books.add(book4); books.add(book5);
	 * System.out.println(tst.calculateFine(books)); } catch (ParseException e)
	 * { // TODO Auto-generated catch block e.printStackTrace(); }
	 * 
	 * }
	 */

	public static void main(String[] args) {
		Book book1 = new Book();
		Book book2 = new Book();
		Book book3 = new Book();
		Book book4 = new Book();
		Book book5 = new Book();

		/*
		 * HashMap<Integer, Object> bookhm = new HashMap<Integer, Object>();
		 * LibraryServiceImpl libs = new LibraryServiceImpl();
		 * 
		 * bookhm.put(1, book1); bookhm.put(2, book2); bookhm.put(3, book3);
		 * bookhm.put(4, book4); libs.addBook(5, book5, bookhm);
		 * System.out.println("the book found"+libs.findBook(5,bookhm));
		 * libs.deleteBook(5, bookhm);
		 * System.out.println("the book found"+libs.findBook(5,bookhm));
		 */

	}

	/**
	 * This method checks if a number is prime
	 * 
	 * @param input
	 *            number to be checked
	 * @return returns whether boolean or not
	 */
	public boolean isPrime(int n) {
		if (n == 1) {
			return false;
		}
		if (n == 2) {
			return true;
		}
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}

		}
		return true;

	}

	public List<String> searchString(List<String> titles, String term) {
		List<String> matchingTitle = new ArrayList<>();
		for (String title : titles) {
			if (title.contains(term)) {
				matchingTitle.add(title);
			}
		}
		return matchingTitle;
	}

	public Double calculateFine(List<Book> books) {

		int diffInDays;
		Double fine = 0.0;
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yyyy");
		Date todate = c.getTime();

		for (Book book : books) {
			c.setTime(book.getCheckoutDate());
			c.add(Calendar.DATE, 14);
			String duedateStr = sd.format(c.getTime());
			try {
				Date dueDate = sd.parse(duedateStr);
				book.setDueDate(dueDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			diffInDays = (int) ((todate.getTime() - (book.getDueDate()).getTime()) / (1000 * 60 * 60 * 24));
			fine += diffInDays * (0.50);
		}
		return fine;
	}

	/*
	 * public Double calculateFineSample(List<Book> books) { int diffInDays;
	 * Double fine = 0.0; for (int i = 0; i < books.size(); i++) { diffInDays =
	 * (int) ((((books.get(i)).getTodate()).getTime() -
	 * ((books.get(i)).getDueDate()).getTime()) / (1000 * 60 * 60 * 24)); fine
	 * += (diffInDays * (0.50)); } return fine; }
	 */

	public String checkDate() {
		String s = "";
		// https://www.tutorialspoint.com/java8/java8_datetime_api.htm
		// Long noOfDays=ChronoUnit.DAYS.between(toDate,duedate);
		return s;
	}

	public Book addBook(Book book) {
		int i = bookMap.size() + 1;
		book.setId(i);
		bookMap.put(i, book);
		return book;
	}

	@Override
	public Book searchBook(int id) {
		return bookMap.get(id);

	}

	@Override
	public void deleteBook(Book book) {
		int id = book.getId();
		bookMap.remove(id, book);
	}

	@Override
	public Book updateBook(Book book) {
		int id = book.getId();
		bookMap.replace(id, book);
		return bookMap.get(id);
	}

	@Override
	public List<Book> addBooks(List<Book> books) {
		List<Book> addedBooks = new ArrayList<Book>();
		int i = 0;
		for (Book book : books) {
			i = bookMap.size() + 1;
			bookMap.put(i, book);
			addedBooks.add(book);
		}
		return addedBooks;
	}

	@Override
	public List<Book> searchByTitle(String title) {
		List<Book> matchedBook = new ArrayList<Book>();
		for (Book book : bookMap.values()) {
			if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
				//book.getTitle().matches(
				matchedBook.add(book);
			}
		}
		return matchedBook;
	}

}
