package br.com.rodrigobraz.LibraryTddApi.api.resources;

import br.com.rodrigobraz.LibraryTddApi.api.dto.BookDTO;
import br.com.rodrigobraz.LibraryTddApi.api.model.Book;
import br.com.rodrigobraz.LibraryTddApi.services.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private BookService service;
    private ModelMapper modelMapper;

    public BookController(BookService service, ModelMapper mapper) {
        this.service = service;
        this.modelMapper = mapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO create( @RequestBody @Valid BookDTO dto ){
        Book entity = modelMapper.map( dto, Book.class );
        entity = service.save(entity);
        return modelMapper.map(entity, BookDTO.class);
    }

    @GetMapping("/{id}")
    public BookDTO getById(@PathVariable Long id) {
        Optional<Book> book = service.getById(id);
        return modelMapper.map(book, BookDTO.class);

    }
}
