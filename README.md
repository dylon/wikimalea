# Wikimalea

### Database Setup

1. Create the PostgreSQL database in which the Poisson, word count vectors will
be stored:

```shell
$ createdb wikimalea
$ createuser wikimalea
$ psql -d wikimalea -U wikimalea
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

### Download the English, Wikipedia Corpus

1. Ensure that the `resources/` directory is present:

```shell
$ mkdir resources/
```

2. Download the latest archive of the English, Wikipedia corpus:

```shell
$ cd resources/
$ wget -c http://download.wikimedia.org/enwiki/latest/enwiki-latest-pages-articles.xml.bz2
```

3. Unpack the archive:

```shell
$ bunzip2 enwiki-latest-pages-articles.xml.bz2
```

4. That's it!

