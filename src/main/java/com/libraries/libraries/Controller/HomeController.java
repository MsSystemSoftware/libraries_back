package com.libraries.libraries.Controller;

import com.libraries.libraries.Repository.BooksRepository;
import com.libraries.libraries.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/books")
public class HomeController {
    @Autowired
    BooksRepository bookRepository;

    @GetMapping("")
    public Flux<Book> getHome() {

        return bookRepository.findAll();

    }

    @PostMapping("")
    public Mono<Book> postBook(@RequestBody Book book) {

        return bookRepository.save(book);
    }

    @PutMapping("/{id}")
    public Mono<Book> updateBook(@RequestBody Book book) {

        return bookRepository.save(book);

    }

    @DeleteMapping("")
    public boolean deleteBook(@RequestBody Book book) {

        try {
            bookRepository.deleteById(book.getId()).block(); // Note this!
            return true;

        } catch (Exception e) {

            return false;
        }
    }

}
