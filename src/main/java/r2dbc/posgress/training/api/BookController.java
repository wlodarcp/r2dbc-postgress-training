package r2dbc.posgress.training.api;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import r2dbc.posgress.training.domain.Book;
import r2dbc.posgress.training.domain.BookService;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @Bean
    public RouterFunction<ServerResponse> getAllCategoriesRoute() {
        return route(GET("/books"),
                req -> ok().body(bookService.findAll(), Book.class))
                .andRoute(POST("/books"), this::postBook);
    }

    private Mono<ServerResponse> postBook(ServerRequest request) {
        return ServerResponse
                .status(HttpStatus.CREATED)
                .body(mapRequestToBook(request), Book.class);
    }

    private Mono<Book> mapRequestToBook(ServerRequest request) {
        return request.bodyToMono(BookForm.class)
                .flatMap(bookForm -> bookService.saveBook(bookForm.getTitle(), bookForm.getAuthorName(), bookForm.getAuthorSurname()));
    }
}
