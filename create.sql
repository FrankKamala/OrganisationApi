CREATE DATABASE org_api;
\c org_api;

CREATE TABLE  departments(
    id SERIAL PRIMARY KEY,
    name VARCHAR,
    description VARCHAR,
    noOfEmployees int
);

CREATE TABLE news(
    id SERIAL PRIMARY KEY ,
    content VARCHAR,
    departmentId INTEGER
);

CREATE TABLE  users(
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

CREATE DATABASE org_api_test WITH TEMPLATE org_api;



