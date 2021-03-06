# HeyCar Vehicle Services

Repository for HeyCar Vehicle Services

## How to get started

1. Clone the repository and change the directory

   `git clone https://github.com/gowthamt4/heycar-backend-challenge.git`

   `cd heycar-backend-challenge`

2. Through IDE or as a Docker container
 a) Run the app from IDE

   `mvn spring-boot:run`


 b) Run the app by by creating a docker container

  `docker-compose up`

4. Postman Collection
   [heycar-backend-challenge/blob/master/HeyCarCollection.postman_collection](HeyCarCollection.postman_collection)

## Run tests

Running the unit tests can be done like this

`make unit-tests` or `mvn clean test`

Running the integration tests can be done like this

`make integration-tests` or `mvn clean integration-test`

## How to contribute?

Create a new branch, implement the feature and don't forget to add docs and tests. Create a pull request and assign reviewers and labels.

## Challenge Problems/Details

All the challenge related assumptions and points have been placed in the [heycar-backend-challenge/blob/master/CHALLENGE.md](CHALLENGE.md) file.
