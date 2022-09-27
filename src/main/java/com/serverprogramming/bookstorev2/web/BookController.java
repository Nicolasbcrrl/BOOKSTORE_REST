package com.serverprogramming.bookstorev2.web;

import com.serverprogramming.bookstorev2.domain.Book;
import com.serverprogramming.bookstorev2.domain.BookRepository;
import com.serverprogramming.bookstorev2.domain.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class BookController {
    @Autowired
    private BookRepository repository;
    @Autowired
    private CategoryRepository crepository;

    // Show all books
    @RequestMapping(value = {"/", "/bookList"})
    public String bookList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "bookList";
    }
    // RESTFUL service to get all books
    @RequestMapping(value = "/bookListing", method = RequestMethod.GET)
    public @ResponseBody List<Book> studentListRest() {
        return (List<Book>) repository.findAll();
    }

    // RESTFUL service to get book by id
    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Optional<Book> findBookRest(@PathVariable("id") String isbn) {
        return repository.findById(isbn);
    }
    // Add new book
    @RequestMapping(value="/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", crepository.findAll());
        return "addBook";
    }
    // Save new book
    @RequestMapping(value="/save", method=RequestMethod.POST)
    public String save(Book book) {
        repository.save(book);
        return "redirect:bookList";
    }

    // Delete book
    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public String deleteBook(@PathVariable("id") String bookId, Model model) {
        repository.deleteById(bookId);
        return "redirect:../bookList";
    }
    
    // Edit book
    @RequestMapping(value="/edit", method=RequestMethod.GET)
    public String editBook(@RequestParam(name="isbn") String isbn, Model model) {
        model.addAttribute("book", repository.findById(isbn));
        model.addAttribute("categories", crepository.findAll());
        System.out.println("---------------------------------------------------------------------------------");
        return "bookEdit";
    }
}
