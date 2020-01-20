# Organisation API
 


### Author 
Francis Kamala Albert

 ## Description
A custom made organisation Api that contains data on DEpartments,Users and News .

# ROUTES
    DEPARTMENT
    
	-"/departments/new" - creates a new depatrtment
	-"/departments" - gets all departments
	-"/departments/:departmentId/news/new" - creates news in department specified by departmentId
	-"/departments/:id" - Shows department by Id
    -"/departments/:id/news" - gets news in specific department
    -"/departments/:departmentId/users/:usersId"-adds a user to a department
    -/departments/:id/users - gets users of a specific department
	
	USER ROUTES
	-"/users/new" - creates new user
	-"/users" - gets all users
	
	NEWS ROUTES
    -"/news/new" - creates news
    -"/news" - retreives News
	
	

## Technologies Used
* Java 10
* Postgress Database
* Spark

 ## Setup
 
`git clone https://github.com/FrankKamala/OrganisationApi.git` 

Unzip the folder contents and run App.java class file on any IDE 
ensure gradle is installed and run `gradle build ` then `gradle run`
On your browser type localhost:4567/ to view the application

## DB Schema

CREATE DATABASE organisation;

\c organisation;

* `CREATE TABLE department( id SERIAL PRIMARY KEY, name VARCHAR,description VARCHAR,
noOfEmployees INTEGER);`
* `CREATE TABLE news(
      id SERIAL PRIMARY KEY ,
      content VARCHAR,
      departmentId INTEGER
  );`
* `CREATE TABLE users(
       id SERIAL PRIMARY KEY ,
       name VARCHAR,
       position VARCHAR,
       roles VARCHAR
   );`
   
*




### Contact Info
Drop your suggestions via **Email** :<frankkamala@gmail.com>

## License
Licenced under [MIT License ](LICENSE)

Copyright (c) 2019 **Frank Kamala**