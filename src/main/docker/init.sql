CREATE TABLE if not exists authors (
                                       id               SERIAL PRIMARY KEY,
                                       name             varchar(40),
                                       surname          varchar(40)
);

CREATE TABLE if not exists books (
                                     id               SERIAL PRIMARY KEY,
                                     title             varchar(40),
                                     author_id integer REFERENCES authors(id)
);
