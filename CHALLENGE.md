# Problems / Assumptions

## Problems Identified

1. It would be good if the API requirements specified for the POST upload via JSON API are clear enough.
The document didn't give the details about dealer and dealer-provider relationship. 
This leads to following problems

- This leaves in confusion whether the dealer id should be considered as mandatory field to API.
- Datatype of dealer_id
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
   abort or continue?


## Executed Test and Results

Because of limited time, only the unittest cases for controller and services are covered.


## Ideas you would like to implement if you had time - explain how you would implement them

1. Search API - Would implement sorting and pagination. Will pick the default search fields in order to sort the results.
   For example, by price or by most recent
2. Implement a Dealer API in order to be used by a dealer to get registered at HeyCar. Will create a POST API for Dealer.
3. Implement a Provider API and relationship between Dealer and Provider. Make sure no vehicles are duplicated from same dealer.
   We can achieve this by performing Normalization of the relation tables


## Decisions you had to take and why

1. Database tables: Decided to go with only one table `Vehicles` as there is no clear relationship between dealer and provider.
   and no more details of dealer except dealer_id.
2. As this is a challenge, considered the database with `H2` in memory database
3. No creation of `new dealer_id` as the requirements are not clear.
4. CSV POST call upload: Processing all the records if valid and returning `201 response code with no errors`. But if there are any errors
   the response code would still be `201 but returns the failed records`.
5. Search API: only implemented the basic search with the fields mentioned as the default sorting techniques are not clear.