package br.com.rodrigobraz.LibraryTddApi.services;

import br.com.rodrigobraz.LibraryTddApi.api.model.Book;

import java.util.Optional;

public interface BookService {


    Book save(Book any);

    Optional<Book> getById(Long id);
}
