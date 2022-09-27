package com.nasltudio.graphQL.repository;

import com.nasltudio.graphQL.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Integer> {
    Iterable<Author> findAllByBookId(Integer booId);
}
