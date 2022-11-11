DROP TABLE IF EXISTS plums_main_db;
DROP TABLE IF EXISTS libraries_books;
DROP TABLE IF EXISTS libraries;
DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS readers;

CREATE TABLE readers (
  readerid_pk int unsigned NOT NULL AUTO_INCREMENT,
  readerid_id varchar(40) NOT NULL,
  booknumber_fk int unsigned NOT NULL,
  first_name varchar(26) NOT NULL, 
  last_name varchar(42) NOT NULL,
  phone varchar(15),
  email varchar(32),
  PRIMARY KEY (readerid_pk),
  FOREIGN KEY (booknumnber_fk) REFERENCES books (booknumber_pk) ON DELETE CASCADE
);

CREATE TABLE books (
  booknumber_pk int unsigned NOT NULL AUTO_INCREMENT,
  isbn varchar(30) NOT NULL,
  genre enum('ADVENTURE', 'CYBERSECURITY', 'RECIPES', 'EDUCATION', 'FICTION', 'JAVA', 'SCIFI', 'THRILLER') NOT NULL,
  title varchar(26) NOT NULL,
  book_authors varchar(128) NOT NULL,
  notes text(52),
  UNIQUE KEY (isbn)
);

CREATE TABLE libraries (
  libraryid_pk int unsigned NOT NULL AUTO_INCREMENT,
  booknumber_fk int unsigned NOT NULL,
  PRIMARY KEY (libraryid_pk),
  FOREIGN KEY (booknumber_fk) REFERENCES books (booknumber_pk) ON DELETE CASCADE
);

CREATE TABLE libraries_books (
  librarybookid_id int unsigned NOT NULL AUTO_INCREMENT,
  libraryid_fk int (4) NOT NULL,
  booknumber_fk int (4) NOT NULL,
  PRIMARY KEY (librarybook_id),
  FOREIGN KEY (libraryid_fk) REFERENCES libraries (libraryid_pk) ON DELETE CASCADE,
  FOREIGN KEY (booknumber_fk) REFERENCES books (booknumber_pk) ON DELETE CASCADE
);

CREATE TABLE plums_main_db (
  plumsid_pk int unsigned NOT NULL AUTO_INCREMENT,
  readerid_fk int (4) NOT NULL,
  libraryid_fk int (4) NOT NULL,
  booknumber_fk int (4) NOT NULL,
  PRIMARY KEY (plumsid_pk),
  FOREIGN KEY (readerid_fk) REFERENCES readers (readerid_pk) ON DELETE CASCADE,
  FOREIGN KEY (libraryid_fk) REFERENCES libraries (libraryid_pk) ON DELETE CASCADE,
  FOREIGN KEY (booknumber_fk) REFERENCES books (booknumber_pk) ON DELETE CASCADE
);