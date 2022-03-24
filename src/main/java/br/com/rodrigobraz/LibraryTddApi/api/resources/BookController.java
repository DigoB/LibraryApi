package br.com.rodrigobraz.LibraryTddApi.api.resources;

import br.com.rodrigobraz.LibraryTddApi.api.dto.BookDTO;
import br.com.rodrigobraz.LibraryTddApi.api.model.Book;
import br.com.rodrigobraz.LibraryTddApi.services.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private BookService service;
    private ModelMapper mapper;

    public BookController(BookService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO create(@RequestBody BookDTO dto) {

        Book entity = mapper.map(dto, Book.class);
        entity = service.save(entity);

        return mapper.map(entity, BookDTO.class);


    }
}
