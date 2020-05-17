# HeyCar Vehicle Services

Repository for HeyCar Vehicle Services

## How to get started

1. Clone the repository and change the directory

`git clone https://github.com/gowthamt4/heycar-backend-challenge.git`

`cd heycar-backend-challenge`

2. a) Run the app from IDE

`mvn spring-boot:run`

		OR

b) Run the app by by creating a docker container

`docker-compose up`

4. Postman Collection

`curl --location --request GET 'http://localhost:8080/v1/scoring-processes'
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhcHBfbmFtZSI6IjE0MTQ1YjE2LWVhNjMtNDE5NS04ZGY4LTMyZmVlMzk0YWI5OCIsImN1c3RvbV9jbGllbnRfaWRlbnRpZmljYXRpb24iOlsiYXRobG9uLW5sIl0sImlhdCI6MTU4NDY5NDkzMn0.g-2_y3c6g28oDkha8izI-KIRUN1LSj4L-cqI_hovatc'`

## Run tests

Running the unit tests can be done like this

`make unit-tests` or `mvn clean test`

Running the integration tests can be done like this

`make integration-tests` or `mvn clean integration-test`

## How to contribute?

Create a new branch, implement the feature and don't forget to add docs and tests. Create a pull request and assign reviewers and labels.

## Challenge Problems/Details

All the challenge related assumptions and points have been placed in the [heycar-backend-challenge/blob/master/CHALLENGE.md](CHALLENGE.md) file.
