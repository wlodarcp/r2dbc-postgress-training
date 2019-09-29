package r2dbc.posgress.training.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public Flux<Book> findAll() {
        return bookRepository.findAll();
    }

    public Mono<Book> saveBook(String title, String authorName, String authorSurname) {
        return authorRepository.findByNameAndSurname(authorName, authorSurname)
                .switchIfEmpty(authorRepository.save(new Author(authorName, authorSurname)))
                .flatMap(it -> bookRepository.save(new Book(title, it.getId())));
    }
}

