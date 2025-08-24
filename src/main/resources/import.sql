-- Insert Authors
INSERT INTO author (id, name, bio) VALUES (1, 'J.K. Rowling', 'British author, best known for Harry Potter series.');
INSERT INTO author (id, name, bio) VALUES (2, 'George R.R. Martin', 'American novelist and short story writer.');
INSERT INTO author (id, name, bio) VALUES (3, 'Agatha Christie', 'English writer known for crime novels.');
INSERT INTO author (id, name, bio) VALUES (4, 'Stephen King', 'American author of horror and supernatural fiction.');
INSERT INTO author (id, name, bio) VALUES (5, 'J.R.R. Tolkien', 'English writer, poet, and academic.');
INSERT INTO author (id, name, bio) VALUES (6, 'Isaac Asimov', 'American writer and professor of biochemistry.');
INSERT INTO author (id, name, bio) VALUES (7, 'Arthur Conan Doyle', 'British writer, created Sherlock Holmes.');
INSERT INTO author (id, name, bio) VALUES (8, 'Ernest Hemingway', 'American novelist, short story writer, journalist.');
INSERT INTO author (id, name, bio) VALUES (9, 'Mark Twain', 'American writer, humorist, entrepreneur.');
INSERT INTO author (id, name, bio) VALUES (10, 'Leo Tolstoy', 'Russian writer, best known for War and Peace.');

-- Insert Categories
INSERT INTO category (id, name, description) VALUES (1, 'Fantasy', 'Fantasy books with magical and supernatural elements.');
INSERT INTO category (id, name, description) VALUES (2, 'Science Fiction', 'Books based on futuristic concepts and science.');
INSERT INTO category (id, name, description) VALUES (3, 'Mystery', 'Books involving solving crimes or uncovering secrets.');
INSERT INTO category (id, name, description) VALUES (4, 'Horror', 'Books meant to scare and thrill readers.');
INSERT INTO category (id, name, description) VALUES (5, 'Adventure', 'Exciting stories usually involving exploration and danger.');
INSERT INTO category (id, name, description) VALUES (6, 'Historical Fiction', 'Stories set in past historical periods.');
INSERT INTO category (id, name, description) VALUES (7, 'Romance', 'Books focused on romantic relationships.');
INSERT INTO category (id, name, description) VALUES (8, 'Non-fiction', 'Informative and factual books.');
INSERT INTO category (id, name, description) VALUES (9, 'Classics', 'Well-known and enduring literary works.');
INSERT INTO category (id, name, description) VALUES (10, 'Biography', 'Books about the lives of real people.');

-- Insert Books
INSERT INTO book (id, title, description, price, pages, author_id, category_id) VALUES (1, 'Harry Potter and the Philosopher''s Stone', 'First book in Harry Potter series.', 19.99, 223, 1, 1);
INSERT INTO book (id, title, description, price, pages, author_id, category_id) VALUES (2, 'A Game of Thrones', 'First book in A Song of Ice and Fire series.', 25.50, 694, 2, 1);
INSERT INTO book (id, title, description, price, pages, author_id, category_id) VALUES (3, 'Murder on the Orient Express', 'Famous Hercule Poirot mystery.', 15.00, 256, 3, 3);
INSERT INTO book (id, title, description, price, pages, author_id, category_id) VALUES (4, 'The Shining', 'Horror novel set in isolated hotel.', 18.75, 659, 4, 4);
INSERT INTO book (id, title, description, price, pages, author_id, category_id) VALUES (5, 'The Lord of the Rings: The Fellowship of the Ring', 'Epic fantasy adventure.', 22.99, 423, 5, 1);
INSERT INTO book (id, title, description, price, pages, author_id, category_id) VALUES (6, 'Foundation', 'Sci-fi about the collapse and rebirth of a galactic empire.', 20.00, 255, 6, 2);
INSERT INTO book (id, title, description, price, pages, author_id, category_id) VALUES (7, 'The Adventures of Sherlock Holmes', 'Collection of detective stories.', 14.50, 307, 7, 3);
INSERT INTO book (id, title, description, price, pages, author_id, category_id) VALUES (8, 'The Old Man and the Sea', 'Classic novella about struggle and endurance.', 12.99, 127, 8, 9);
INSERT INTO book (id, title, description, price, pages, author_id, category_id) VALUES (9, 'Adventures of Huckleberry Finn', 'Classic American novel of adventure.', 16.50, 366, 9, 5);
INSERT INTO book (id, title, description, price, pages, author_id, category_id) VALUES (10, 'War and Peace', 'Epic novel set during Napoleonic wars.', 24.99, 1225, 10, 6);

-- Additional books for diversity
INSERT INTO book (id, title, description, price, pages, author_id, category_id) VALUES (11, 'Harry Potter and the Chamber of Secrets', 'Second book in Harry Potter series.', 19.99, 251, 1, 1);
INSERT INTO book (id, title, description, price, pages, author_id, category_id) VALUES (12, 'A Clash of Kings', 'Second book in A Song of Ice and Fire series.', 26.00, 768, 2, 1);
INSERT INTO book (id, title, description, price, pages, author_id, category_id) VALUES (13, 'And Then There Were None', 'Mystery novel.', 17.00, 272, 3, 3);
INSERT INTO book (id, title, description, price, pages, author_id, category_id) VALUES (14, 'It', 'Horror about a malevolent entity.', 22.00, 1138, 4, 4);
INSERT INTO book (id, title, description, price, pages, author_id, category_id) VALUES (15, 'The Lord of the Rings: The Two Towers', 'Second book in LOTR.', 23.50, 352, 5, 1);
INSERT INTO book (id, title, description, price, pages, author_id, category_id) VALUES (16, 'I, Robot', 'Collection of sci-fi short stories.', 18.00, 224, 6, 2);

