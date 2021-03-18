# banking system

## features

- customer creates a 16 digit credit card , with the last number generated as a 'checksum' done by luhn's algorithim. It performs a series of calculations on the 15 numbers to validate its checkdigit (the last number)
- it is for checking for accidental user input for the card number.
- The Luhn algorithm will detect any single-digit error, as well as almost all transpositions of adjacent digits.
- banking system UI (Balance, Add income, Do transfer, close account, create account)
- card information (balance, id, number, pin) are stored in database via SQLite Java with rest methods. 

