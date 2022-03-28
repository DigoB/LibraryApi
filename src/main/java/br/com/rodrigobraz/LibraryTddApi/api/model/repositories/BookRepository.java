package br.com.rodrigobraz.LibraryTddApi.api.model.repositories;

import br.com.rodrigobraz.LibraryTddApi.api.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
