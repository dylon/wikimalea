# Wikimalea

### Download the English, Wikipedia Corpus

### Database Setup
1. Create the PostgreSQL database in which the Poisson, word count vectors will
be stored:
```shell
$ createdb en.wikipedia.org
$ psql -d en.wikipedia.org
```
2. Initialize the database schema:
```sql
CREATE TABLE terms (
	id serial PRIMARY KEY,
	term varchar(255) NOT NULL UNIQUE
);

CREATE TABLE documents (
	id serial PRIMARY KEY,
	title varchar(256) NOT NULL UNIQUE,
	redirect varchar(256) REFERENCES documents (title) ON DELETE CASCADE,
	text text
);

CREATE TABLE term_frequencies (
	document_id integer NOT NULL REFERENCES documents (id) ON DELETE CASCADE,
	term_id integer NOT NULL REFERENCES terms (id) ON DELETE CASCADE,
	frequency integer NOT NULL DEFAULT 0,
	PRIMARY KEY (document_id, term_id),
	CHECK (frequency >= 0)
);
```
