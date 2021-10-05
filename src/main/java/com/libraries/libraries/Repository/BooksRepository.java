package com.libraries.libraries.Repository;

import com.libraries.libraries.models.Book;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BooksRepository extends ReactiveCrudRepository<Book, Long> {

}
