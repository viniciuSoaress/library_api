CREATE TABLE book(
    id UUID PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description TEXT,
    isbn VARCHAR(50) UNIQUE NOT NULL,
    number_page INTEGER,
    date TEXT,
    author_id UUID,

    FOREIGN KEY(author_id) REFERENCES author(id) ON DELETE CASCADE

);