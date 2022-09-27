package com.nasltudio.graphQL.queryresolvers;

import com.nasltudio.graphQL.domain.Author;
import com.nasltudio.graphQL.domain.Book;
import com.nasltudio.graphQL.repository.AuthorRepository;
import com.nasltudio.graphQL.repository.BookRepository;
import com.nasltudio.graphQL.types.BookFilter;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.Comparator;
import java.util.List;

@Controller
@AllArgsConstructor
public class BookQuery {

    BookRepository bookRepository;
    AuthorRepository authorRepository;

    @QueryMapping
    public Iterable<Book> allBook() {
        return bookRepository.findAll();
    }

    @QueryMapping
    public Book getBookByName(@Argument("filter") BookFilter bookFilter){
        return bookRepository.findBookByName(bookFilter.getName());
    }

    @QueryMapping
    public Iterable<Author> allAuthor(){
        return authorRepository.findAll();
    }

    enum ListOrder {
        ASC,
        DESC
    }

    @SchemaMapping(typeName="Book", field="author")
    public Iterable<Author> getAuthor(Book book, @Argument ListOrder order) {
        List<Author> allAuthors = (List<Author>) authorRepository.findAllByBookId(book.getId());
        if (order != null) {
            switch (order) {
                case ASC:
                    allAuthors.sort(Comparator.comparingInt(Author::getStarRating));
                case DESC:
                    allAuthors.sort(Comparator.comparingInt(Author::getStarRating).reversed());
            }
        }
        return allAuthors;
    }
}
