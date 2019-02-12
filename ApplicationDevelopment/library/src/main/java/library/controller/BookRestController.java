package library.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import library.model.Book;
import library.model.repositories.BookJpaRepository;

@RestController
@RequestMapping("/books")
public class BookRestController {

	@Autowired
	private BookJpaRepository repo;
	
	@RequestMapping(path="", method=RequestMethod.POST)
	public Integer createBook(
			@RequestBody Book book) {
		
		repo.saveAndFlush(book);
		return book.getId();
	}
	
	@RequestMapping(path="/{bookId}", method=RequestMethod.DELETE)
	public void deleteBook(
			@PathVariable Integer bookId) {
		repo.delete(bookId);
	}
	
	@RequestMapping(path="/{bookId}", method=RequestMethod.PUT)
	public void updateBook(
			@PathVariable Integer bookId,
			@RequestBody Book updates) {
		
		Book existing = repo.findOne(bookId);
		existing.setTitle(updates.getTitle());
		existing.setWhoHasIt(updates.getWhoHasIt());
		repo.saveAndFlush(existing);
	}
	
	@RequestMapping(path="/{bookId}", method=RequestMethod.GET)
	public Book getBook(
			@PathVariable Integer bookId) {
		
		return repo.findOne(bookId);
	}
	
	@RequestMapping(path="", method=RequestMethod.GET)
	public List<Book> getBooks() {
		return repo.findAll();
	}
}













