package DashEsgApi.DashEsgApi.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import DashEsgApi.DashEsgApi.model.BookModel;
import DashEsgApi.DashEsgApi.model.Books;
import DashEsgApi.DashEsgApi.repository.BooksRepository;

@Service
public class BookService {
	
	@Autowired
	private final BooksRepository bookRepository;
	
	ObjectMapper objectMapper;
	
	public BookService(BooksRepository bookRepo) {
	    this.bookRepository = bookRepo;
	  }
	
	
	public List<Books> getAllBooks(){
		return bookRepository.findAll();
	}
	
	public Books getOneBook(int id){
		return bookRepository.findById(id);
	}
	
	public Books createBook(Books book) throws Exception {
		if(book.getTitle() == null || book.getPrice() == null || book.getQty() == null) {
			throw new Exception("Preencha todos os campos corretamente!");
		}
		return bookRepository.save(book);
	}
	
	public int deleteBook(int id) {
		Books myBook = bookRepository.findById(id);
		int status;
		if(myBook.getId() == null) {
			status = 0;
		}else {
			status = 1;
			bookRepository.deleteById(id);
		}
		return status;
	}
	
	public int updateBook(int id,Books upBook){
		Books myBook = bookRepository.findById(id);
		Books originalBook = myBook.copy();
		int status;
		
		if(upBook.getTitle() != null) {myBook.setTitle(upBook.getTitle());}
		
		if(upBook.getPrice() != null) {myBook.setPrice(upBook.getPrice());}
		
		if(upBook.getQty() != null) {myBook.setQty(upBook.getQty());}
		
		if(originalBook.equals(myBook)) {
			status = 0;
		}else {
			status = 1;
			bookRepository.save(myBook);
		}
		return status;
		
	}
	
}
