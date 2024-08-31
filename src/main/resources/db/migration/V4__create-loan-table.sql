CREATE TABLE loan (
    id UUID PRIMARY KEY,
    name_user VARCHAR(50),
    data TIMESTAMP,
    book_id UUID,

    FOREIGN KEY(book_id) REFERENCES book(id) ON DELETE CASCADE
);