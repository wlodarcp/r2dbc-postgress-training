package r2dbc.posgress.training.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@NoArgsConstructor
@Table("authors")
public class Author {

    @Id
    private Integer id;
    private String name;
    private String surname;

    Author(String name, String surname) {
        this.id = null;
        this.name = name;
        this.surname = surname;
    }
}
