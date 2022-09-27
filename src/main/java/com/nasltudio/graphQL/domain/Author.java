package com.nasltudio.graphQL.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Author", schema = "BOOK_API_DATA")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "firstName")
    String firstName;
    @Column(name = "lastName")
    String lastName;
    @Column(name = "starRating")
    Integer starRating;
    @Column(name = "bookId")
    Integer bookId;
}
