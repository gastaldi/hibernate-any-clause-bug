# Support for ANY clause in Hibernate native queries 

This project reproduces the `ERROR: op ANY/ALL (array) requires array on right side` error when using the `ANY` clause with Hibernate.

## Testing

Use the following command to run the tests, make sure you have Docker installed (to start the PostgreSQL DB) :

```bash
mvn test
```