package com.library.service;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.library.service.LibraryServiceImpl;
import com.sample.Animal;
import com.sample.Book;

public class LibraryServiceTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCalculateFine() {
		try {
			LibraryServiceImpl test = new LibraryServiceImpl();
			List<Book> books = new ArrayList<Book>();
			SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
			
			Book book = new Book();			
			book.setCheckoutDate(dateformat.parse("01/25/2017"));
			books.add(book);
			Book book1 = new Book();			
			book1.setCheckoutDate(dateformat.parse("01/27/2017"));
			books.add(book1);
			Double fineVal= 3.00;
			assertEquals(fineVal, test.calculateFine(books));
			System.out.println("fine :" + test.calculateFine(books));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//fail("Not yet implemented");
	}

}
