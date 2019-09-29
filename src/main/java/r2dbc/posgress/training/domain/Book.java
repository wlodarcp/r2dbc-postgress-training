package r2dbc.posgress.training.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@NoArgsConstructor
@Table("books")
public class Book {

    @Id
    private Integer id;
    private String title;
    private Integer authorId;

    Book(String title, Integer authorId) {
        this.id = null;
        this.title = title;
        this.authorId = authorId;
    }
}
