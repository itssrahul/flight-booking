# Flight Booking API Application

SpringBoot Application that demonstrates REST API Development using Spring MVC, Spring Data JPA using Java 8 features

## Features

This application has following REST end-points that provide flight-booking. 

1. POST /findFlightsByCode
2. POST /findFlightsByCityName
3. POST /booking
4. POST /getFlightOfferByAirportCodes

## Technologies used

1. Java (Programming Language)
2. Spring Boot (Application Platform)
3. Spring Data JPA (Data persistence)
4. H2 (Database)


## Getting Started

The source code can be checked out to your local and then build and run the application either from your IDE after importing to it as a maven project, or just from a command line. Follow these steps for the command-line option:  

### Prerequisites
1. Java 8
2. Maven 3
3. Git


### Installing & Running

####  Build using maven 
	
```
mvn clean install
```
	
#### Start the app
	
```
mvn spring-boot:run
```
		
#### Test the URLs
	
    1. [http://localhost:8080/findFlightsByCode?from=FRA&to=CWL)
    2. [http://localhost:8080/booking?flightId=4&from=FRA&passengerName=Rahul&to=CWL]
    3. [http://localhost:8080/findFlightsByCityName?from=Frankfurt&to=Cardiff]
    4. [http://localhost:8080/getFlightOfferByAirportCodes?from=FRA&to=CWL]
    
## API Documentation and Integration Testing 

API documentation can be accessed via [Swagger UI](http://localhost:8080/swagger-ui.html) 


## Database

This application is using H2 in-memory database, which (database as well as data) will be removed from memory when the application goes down.


## Data pre-loading

Sample data is pre-loaded from the demonstration purpose by [DataLoader.java]. In a production-grade application, this will be done through a database upgrade script/task.
