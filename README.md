# Spring Boot REST API Using MongoDB

This application starts on port 6066.

The technologies used in this application are:

1. Spring Boot Web
2. Spring Boot Devtools
3. Lombok
4. MongoDB Atlas
5. Spring Boot Actuator
6. Swagger 3 (OpenAPI)
7. Pagination

The REST endpoint exposed by this application are:
1. POST Person : http://localhost:6066/api/v1/persons
2. GET Person Start With FirstName : http://localhost:6066/api/v1/persons (Provide request param in body using "form-data" and key as firstName and value as {firstName})
3. GET Person By Age : http://localhost:6066/api/v1/persons/ages (Provide request param in body using "form-data" and 1. key as minAge and value as {minAge} and 2. key as maxAge and value as {maxAge})
4. DELETE Person : http://localhost:6066/api/v1/persons/{person_Id}
5. GET Search Person : http://localhost:6066/api/v1/persons/search 

(Note: For 5th REST endpoint, these are optional request params that can be provided in body using "form-data" and below:
1. key as firstName and value as {firstName}
2. key as minAge and value as {minAge}
3. key as maxAge and value as {maxAge}
4. key as city and value as {city}
5. key as page and value as {page}
6. key as size and value as {size}

Swagger 3 (OpenAPI) URI : http://localhost:6066/swagger-ui/index.html

Sample Post REST API payload:

{

    "personId": "3",
    "firstName": "Zubair",
    "lastName": "Khan",
    "age": 18,
    "hobbies": [
      "Paintng"
    ],
    "addressList": [
      {
        "address_Id": "1",
        "address1": "Gardner Blvd",
        "address2": "Unit 18",
        "city": "Arlington"
      }
    ]
}
