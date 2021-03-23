# banking system

## features

- customer creates a 16 digit credit card , with the last number generated as a 'checksum' done by luhn's algorithim. It performs a series of calculations on the 15 numbers to validate its checkdigit (the last number)
- it is for checking for accidental user input for the card number.
- The Luhn algorithm will detect any single-digit error, as well as almost all transpositions of adjacent digits.
- banking system UI (Balance, Add income, Do transfer, close account, create account)
- card information (balance, id, number, pin) are stored in database via SQLite Java with rest methods. 

## what i learned 

- reading documentation of a certain database/library for help 

### relational databases
  database based on the relational model: 
- data stored in tables with columns and rows, generally having each object as their own table (creditcard)
- rows represent instances of type object 
- columns represent instance variables of object, (number, PIN, balance) usually with a unique key (ID) for each row 

#### Relational Database Management System (RDBMS)
- program used to edit/create database (CardDatabase.java)
- SQL language used to communicate with the database.

#### SQL (Structured Query Language)
- method for accessing data in a relational database. (SQL can POST,GET,UPDATE,DELETE...)
- there are many variations of SQL, for different purposes
- particularly SQLite (the one I used) can store an database in a single file. Instead of saving a database to a server, you can just store it locally offline on your PC.
