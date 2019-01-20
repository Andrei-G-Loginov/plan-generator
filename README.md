# Plan Generator
Plan Generator (Java 8 and Spring Boot 2)

### Installation

Clone repository:

```sh
$ git clone https://github.com/Andrei-G-Loginov/plan-generator.git
```

Build project with Maven:

```sh
$ cd plangenerator
$ mvn clean package
```
### Start application

Start Spring Boot application:

```sh
$ java -jar target/plangenerator-1.0-SNAPSHOT.jar
```
### Generate plan

Execute POST request to the url for generate plan (use any Http client: Postman or other):

```
http://localhost:8080/generate-plan
```

JSON request for example:

```
{
  "loanAmount": "5000",
  "nominalRate": "5.0",
  "duration": 24,
  "startDate": "2018-01-01T00:00:01Z"
}
```
JSON response for example:
```
[
    {
        "borrowerPaymentAmount": 219.36,
        "date": "2018-02-01T00:00:01Z",
        "initialOutstandingPrincipal": 5000,
        "interest": 20.83,
        "principal": 198.53,
        "remainingOutstandingPrincipal": 4801.47
    },
    {
        "borrowerPaymentAmount": 219.36,
        "date": "2018-03-01T00:00:01Z",
        "initialOutstandingPrincipal": 4801.47,
        "interest": 20.01,
        "principal": 199.35,
        "remainingOutstandingPrincipal": 4602.12
    },
    ...
    {
        "borrowerPaymentAmount": 219.36,
        "date": "2020-01-01T00:00:01Z",
        "initialOutstandingPrincipal": 218.37,
        "interest": 0.91,
        "principal": 218.45,
        "remainingOutstandingPrincipal": 0
    }
]
```
### Swagger
Other way to check "/generate-plan" method is "Try it out" on Swagger UI on url:
```
http://localhost:8080/swagger-ui.html#/plan-genegator-controller/generatePlanUsingPOST
```
