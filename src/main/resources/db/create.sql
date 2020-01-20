SET MODE PostgreSQL;



CREATE TABLE IF NOT EXISTS department(
    id SERIAL PRIMARY KEY,
    name VARCHAR,
    description VARCHAR,
    noOfEmployees int
);

CREATE TABLE  IF NOT EXISTS news(
    id SERIAL PRIMARY KEY ,
    content VARCHAR,
    departmentId INTEGER
);

CREATE TABLE  IF NOT EXISTS  users(
    id SERIAL PRIMARY KEY ,
    name VARCHAR,
    position VARCHAR,
    roles VARCHAR
);

CREATE TABLE  IF NOT EXISTS departments_users(
    id SERIAL PRIMARY KEY ,
    usersId INTEGER,
    departmentId INTEGER
);




