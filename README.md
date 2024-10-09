# MELI Test Challenge
# Introduction

This is a code challenge for MercadoLibre. It contains an API where you can get data from a given IP and also you can get stats of the API Usage
# Features

- SpringBoot usage
- Clean Architecture implementation
- Dependency Injection
- SOLID principles and best practices
- Design patterns like Singleton and Provider
- Basic cache implementation with concurrency
- Unit Tests

# Decitions Made 
 - I decided to choose a Clean Architecture implementation taking into account that we can change the API providers or in the future we can need a database with a Clean Architecture we can easily change our provders and keep all the logic into the core project
 - I decided to use an In Memory cache using Singleton pattern to hold the logs with a concurrent implementation of a List (CopyOnWriteArrayList). With that, we can follow the requirement of multiple requests at the same time (Between 1 to 1 million of requests per second). With that implemntation we take an snapshot of the list when the information is given and the object is available to receive new records. I though about use the database for those logs but taking into account the amount of requests it will affect the performance, mantainability and availability of the database. For that reason, the best approach is the cache
 - I decided to use SpringBoot to make all the beans and project management easier
 - I did not include the currency data requirement because the endpoint that provides countries data did not retrieve currency information.
 - I decided to use adapter pattern to adapt the API Response to the domain entity and make it usable to follow all the clean architecture principles

# How To Use?

## Image creation
```Docker build /t ipinfo .```

## Run image
```Docker run -p 8080:8080 ipinfo```

# Endpoints
## General IP information
This endpoint shows general IP information according to the country it belongs to.
```curl --location 'http://localhost:8080/v1.0/ipInfo/83.44.196.93'```

## Furthest distance
This endpoint shows the furthest distance to Buenos Aires of the queries made according to the information stored in the cache.
```curl --location 'http://localhost:8080/v1.0/ipInfo/stats/maxDistance```

## Closest distance
This endpoint shows the closest distance to Buenos Aires of the queries made according to the information stored in the cache.
```curl --location 'http://localhost:8080/v1.0/ipInfo/stats/minDistance```

## Average distance
This endpoint shows the average distance of all executions of the service.
```curl --location 'http://localhost:8080/v1.0/ipInfo/stats/average'```

# Improvement Opportunities
- Increase the unit testing code coverage of the application
- Find a way to get the currencies maybe using another API
- Improve the way to store the access token. We can think on use a vault or a cloud key storage like SSM
- If the program will be used for a lot of users we can think on migrate the Cache like Redis
