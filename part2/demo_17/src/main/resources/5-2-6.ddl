create table user (
    id int(10) NOT NULL,
    name varchar(16) NOT NULL,
    age int(10) NOT NULL,
    profile varchar(64) NOT NULL,
    primary key (id)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 insert into user values (100, 'Alice', 18, 'hello'), (101, 'Bob', 19, 'hi'), (102, 'Carol', 20, 'bye');