### Database Access

- **URL**: [http://localhost:8080/h2-console/](http://localhost:8080/h2-console/)
- **Driver Class**: `org.h2.Driver`
- **JDBC URL**: `jdbc:h2:mem:bankexercise`
- **User Name**: `example`
- **Password**: No password required



### API Specification

The API specification is located at `api/src/main/resources/api-spec.yaml`.

---

#Solution:

Database Structure

| Customer        |
|-----------------|
| first name      |
| last name       |
| customer number |
| address         |
| phone number    |

(other details could include phone #, address, password, last logged in... etc)

| Account     |
|-------------|
| account id  |
| customer id |
| type        |
| name        |
debating if balance should be stored here or if there will is concurrency/discrepancy issues

| Transaction |
|-------------|
| transact id |
| date/time   |
| details     |
| amount      |
| from        |



###Assumptions:

- Customer is already logged in

### APIs required:
- GET customer info
- GET account
- GET transactions
- POST transaction
