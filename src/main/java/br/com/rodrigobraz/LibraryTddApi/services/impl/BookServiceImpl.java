package br.com.rodrigobraz.LibraryTddApi.services.impl;

import br.com.rodrigobraz.LibraryTddApi.api.model.Book;
import br.com.rodrigobraz.LibraryTddApi.exceptions.BusinessException;
import br.com.rodrigobraz.LibraryTddApi.repositories.BookRepository;
import br.com.rodrigobraz.LibraryTddApi.services.BookService;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository repository;

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public Book save(Book book) {
        if( repository.existsByIsbn(book.getIsbn()) ){
            throw new BusinessException("Isbn já cadastrado.");
        }
        return repository.save(book);
    }

    @Override
    public Optional<Book> getById(Long id) {
        return repository.findById(id);
    }
}