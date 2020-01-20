
CREATE DATABASE organisation;

\c organisation;


CREATE TABLE department(
    id SERIAL PRIMARY KEY,
    name VARCHAR,
    description VARCHAR,
    noOfEmployees INTEGER
);

CREATE TABLE news(
    id SERIAL PRIMARY KEY ,
    content VARCHAR,
    departmentId INTEGER
);

CREATE TABLE users(
    id SERIAL PRIMARY KEY ,
    name VARCHAR,
    position VARCHAR,
    roles VARCHAR
);

CREATE TABLE departments_users(
    id SERIAL PRIMARY KEY ,
    usersId INTEGER,
    departmentId INTEGER
);

CREATE DATABASE organisation_test WITH TEMPLATE organisation;




