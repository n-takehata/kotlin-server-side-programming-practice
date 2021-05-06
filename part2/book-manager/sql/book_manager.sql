CREATE TABLE user (
    id bigint NOT NULL,
    email varchar(256) UNIQUE NOT NULL,
    password varchar(128) NOT NULL,
    name varchar(32) NOT NULL,
    role_type enum('ADMIN', 'USER'),
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE book (
    id bigint NOT NULL,
    title varchar(128) NOT NULL,
    author varchar(32) NOT NULL,
    release_date date NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE rental (
    book_id bigint NOT NULL,
    user_id bigint NOT NULL,
    rental_datetime datetime NOT NULL,
    return_deadline datetime NOT NULL,
    PRIMARY KEY (book_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
