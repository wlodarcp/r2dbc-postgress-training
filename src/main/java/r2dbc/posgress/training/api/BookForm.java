package r2dbc.posgress.training.api;

import lombok.Value;

@Value
class BookForm {
    String title;
    String authorName;
    String authorSurname;
}
