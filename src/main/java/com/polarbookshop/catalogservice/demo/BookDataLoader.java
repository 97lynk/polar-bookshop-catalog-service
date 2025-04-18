package com.polarbookshop.catalogservice.demo;

import com.polarbookshop.catalogservice.domain.Book;
import com.polarbookshop.catalogservice.domain.BookRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("testdata")
@Log4j2
public class BookDataLoader {

    private final BookRepository bookRepository;

    public BookDataLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadData() {
        log.info("Loading data...");
        bookRepository.deleteAll();
        var book1 = Book.of("1234567891", "Northern Lights", "Lyra Silverstar", 9.90, "Polarsophia");
        var book2 = Book.of("1234567892", "Polar Journey", "Iorek Polarson", 12.90, "Polarsophia");
        var book3 = Book.of("9876543210", "Java Programming for Beginners", "John Doe", 29.99, "Tech Publishing");
        var book4 = Book.of("1122334455", "The Deep Sea", "Maria Walker", 15.50, "Oceanic Books");
        var book5 = Book.of("6677889900", "Space Odyssey", "David Bowman", 18.75, "Galactic Publishing");
        bookRepository.saveAll(List.of(book1, book2, book3, book4, book5));
        log.info("load data complete.");
    }
}
