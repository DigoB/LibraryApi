package br.com.rodrigobraz.LibraryTddApi.services;

import br.com.rodrigobraz.LibraryTddApi.api.model.Book;
import br.com.rodrigobraz.LibraryTddApi.api.model.repositories.BookRepository;
import br.com.rodrigobraz.LibraryTddApi.services.impl.BookServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class BookServiceTest {

    BookService service;

    @MockBean
    BookRepository repository;

    @BeforeEach
    public void setUp() {
        this.service = new BookServiceImpl(repository);
    }

    @Test
    @DisplayName("Deve salvar um livro")
    public void shouldSaveBookTest() {
        Book book = Book.builder().isbn("123").author("Alguem").title("As aventuras").build();
        when(repository.save(book)).thenReturn(
                        Book.builder()
                                .id(1L)
                                .isbn("123")
                                .title("As aventuras")
                                .author("Alguem").build());

        Book newBook = service.save(book);

        assertThat(newBook.getId()).isNotNull();
        assertThat(newBook.getIsbn()).isEqualTo("123");
        assertThat(newBook.getTitle()).isEqualTo("As aventuras");
        assertThat(newBook.getAuthor()).isEqualTo("Alguem");
    }


}
