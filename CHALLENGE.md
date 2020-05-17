# Problems / Assumptions

## Problems Identified

1. It would be good if the API requirements specified for the POST upload via JSON API are clear enough.
The document didn't give the details about dealer and dealer-provider relationship. 
This leads to following problems

- This leaves in confusion whether the dealer id should be considered as mandatory field to API.
- How the API should handle if the dealer not registered at HeyCar
- The documents says `Provider - the platform the dealers already use to manage their own listings`
  What if a single dealer is registered at multiple providers with different dealer IDs. This leads to duplicate
   entries.
- Lack of dealer and provider relationship restricts to improper design of relational tables


2. The requirements for Search API are too minimum. Here are the problems related to that.

- The document did not specify about the mandatory fields in search criteria. Do this need to be treated as to
  query all the records of Vehicles those are ready to be sold from the database which is not a good practice.
- Generally, there should be sorting functionality for a search API which is not provided in the document.


3. Some clarifications needed on POST Upload API via CSV file

- How do we deal if the some of the records in the CSV file are invalid and failed to process? Do the process need
   abort or continue


## Run tests

Running the unit tests can be done like this

`make unit-tests` or `mvn clean test`

Running the integration tests can be done like this

`make integration-tests` or `mvn clean integration-test`

## How to contribute?

Create a new branch, implement the feature and don't forget to add docs and tests. Create a pull request and assign reviewers and labels.

## Challenge Problems/Details

All the challenge related assumptions and points have been placed in the [heycar-backend-challenge/blob/master/CHALLENGE.md](CHALLENGE.md) file.
