package DashEsgApi.DashEsgApi.controllers;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.mapstruct.BeanMapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonMappingException;

import DashEsgApi.DashEsgApi.model.BookModel;
import DashEsgApi.DashEsgApi.model.Books;
import DashEsgApi.DashEsgApi.model.SearchRequest;
import DashEsgApi.DashEsgApi.repository.BooksRepository;
import DashEsgApi.DashEsgApi.service.BookService;


@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;

	@GetMapping("/list")
    public List<Books> listBooks() {
		return bookService.getAllBooks();
    }
	
	@PostMapping("/book/search/{id}")
	public Books searchBook(@RequestParam int id){
		return bookService.getOneBook(id);
	}
	
	@PostMapping("/book/add")
	public Books insertBook(@RequestBody Books book) throws Exception {
		return bookService.createBook(book);
	}
	
	@PostMapping("/book/delete/{id}")
	public int deleteBook(@RequestParam int id) throws Exception{
		int status = bookService.deleteBook(id);
		return status;
	}
	
	@PutMapping("/book/edit/{id}")
	   public int updateBook(@RequestParam int id,@RequestBody Books updatedBook) {
		int status = bookService.updateBook(id, updatedBook);
		return status;
		 
	}
	
	
	
	
	
}
