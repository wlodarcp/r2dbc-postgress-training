package r2dbc.posgress.training.domain;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.r2dbc.repository.query.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface AuthorRepository extends R2dbcRepository<Author, Integer> {

    @Query("SELECT * from authors WHERE name LIKE :name AND surname LIKE :surname")
    Mono<Author> findByNameAndSurname(String name, String surname);
}
