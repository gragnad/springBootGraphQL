package com.nasltudio.graphQL.repository;

import com.nasltudio.graphQL.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
    Book findBookByName(String name);
}
