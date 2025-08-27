# transaction-service
Simple Spring Boot microservice for transactions (example).

Endpoints:
- GET  /api/transactions              -> list all
- GET  /api/transactions/{id}         -> get by id
- GET  /api/transactions/account/{a}  -> transactions for account
- POST /api/transactions              -> create transaction (JSON body)

Build:
mvn clean package
java -jar target/transaction-service-0.0.1-SNAPSHOT.jar
