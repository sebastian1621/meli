# MELI Test Challenge
# Introduction

This is a Code Challenge where you can parse a sentence with the following rules:

* Each word will be replaced with the following: first letter, number of distinct characters between first and
  last character, and last letter.
* Words are separated by spaces or non-alphabetic characters and these separators should be
  maintained in their original form and location in the answer.

# Features

- SpringBoot usage
- Clean Architecture implementation
- Dependency Injection for the service usage
- SOLID principles and best practices
- Design patterns
- Unit Tests

## Examples

* Input 1: It was many and many a year ago <br> 
Output 1: I0t w1s m2y a1d m2y a y2r a1o
* Input 2: Copyright,Microsoft:Corporation <br>
Output 2: C7t,M6t:C6n

## How To Use?

You have two ways to use the program:

1. You can pass your sentence as the first argument to the program, and it will parse that word.
2. You can omit the arguments, and the program will display a UI in the console where you can enter your input.

## Improvement Opportunities

- Different implementations for the countDistinctCharacters method


### Image creation
Docker build /t ipinfo .

## Run image
Docker run -p 8080:8080 ipinfo


## General IP information
This endpoint shows general IP information according to the country it belongs to.
curl --location 'http://localhost:8080/v1.0/ipInfo/83.44.196.93'

## Furthest distance
This endpoint shows the furthest distance to Buenos Aires of the queries made according to the information stored in the cache.
curl --location 'http://localhost:8080/v1.0/ipInfo/stats/maxDistance

## Closest distance
This endpoint shows the closest distance to Buenos Aires of the queries made according to the information stored in the cache.
curl --location 'http://localhost:8080/v1.0/ipInfo/stats/minDistance

## Average distance
This endpoint shows the average distance of all executions of the service.
curl --location 'http://localhost:8080/v1.0/ipInfo/stats/average'



