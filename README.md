# Spring ORM

This is a small Spring application showing how ORM works. 
We can make the standard CRUD operations on locally hosted H2 database: add people info to a list, change and remove them.

## src/main/java/people/model/Person.java

This class describes model `Person` with typical fields `id`, `firstName` and `lastName` and Lombok generated setters.

## build.gradle

Liquibase is used in the project for migrations.

## src/main/java/people/repository/PersonRepository.java

This class is extended from `CrudRepository` to use necessary methods for data processing

## src/main/java/people/controller/PeopleController.java

The main class for CRUD operations
