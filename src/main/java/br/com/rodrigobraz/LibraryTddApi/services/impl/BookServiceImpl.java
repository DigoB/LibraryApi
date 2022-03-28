package br.com.rodrigobraz.LibraryTddApi.services.impl;

import br.com.rodrigobraz.LibraryTddApi.api.model.Book;
import br.com.rodrigobraz.LibraryTddApi.api.model.repositories.BookRepository;
import br.com.rodrigobraz.LibraryTddApi.services.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository repository;

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public Book save(Book book) {
        return repository.save(book);
    }
}
