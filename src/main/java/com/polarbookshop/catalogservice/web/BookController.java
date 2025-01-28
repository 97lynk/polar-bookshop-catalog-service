package com.polarbookshop.catalogservice.web;

import com.polarbookshop.catalogservice.domain.Book;
import com.polarbookshop.catalogservice.domain.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * Get all the books in the catalog.
     *
     * @return
     */
    @GetMapping
    public Iterable<Book> getAllBookInTheCatalog() {
        return bookService.viewBookList();
    }

    /**
     * Add a new book to the catalog.
     *
     * @param book
     * @return new book
     * @apiNote return status 422 when a book with the same ISBN already exists.
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book addNewBookToTheCatalog(@Valid @RequestBody Book book) {
        return bookService.addBookToCatalog(book);
    }

    /**
     * Get the book with the given ISBN.
     *
     * @param isbn
     * @return a book
     * @apiNote return status 404 when No book with the given ISBN exists.
     */
    @GetMapping("/{isbn}")
    public Book getBookByIsbn(@PathVariable String isbn) {
        return bookService.viewBookDetails(isbn);
    }

    /**
     * Update the book with the given ISBN.
     *
     * @param isbn
     * @return
     */
    @PutMapping("/{isbn}")
    public Book updateBookByIsbn(@PathVariable String isbn, @Valid @RequestBody Book book) {
        return bookService.editBookDetails(isbn, book);
    }

    /**
     * Delete the book with the given ISBN.
     *
     * @param isbn
     * @return
     */
    @DeleteMapping("/{isbn}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBookByIsbn(@PathVariable String isbn) {
        bookService.removeBookFromCatalog(isbn);
    }
}
