# Automating API tests with REST Assured


## What is an API?
* Application
* Programming
* Interface

## The API Contract
* Request<br>
. Endpoint<br>
. Headers<br>
. Body<br>
* Response<br>
. Status Code<br>
. Headers<br>
. Body<br>

# REST Assured Feature
* Parameterization and data driven testing
* Verifying response headers and bodies
* Optimizing your test code through reuse
* (De-) serializing request and response bodies
* Java DSL for writing tests for RESTful APIs
* Runs on top of JUnit or TestNG
* Supports all HTTP methods (GET, POST, PUT, DELETE, ...)
* Supports Gherkin syntax (Given/When/Then)
* Uses Hamcres matchers for checks
* Uses JsonPath/Gpath and XmlPath for selecting elements from response
* Developed and maintained by Johan Haleby
* Source: https://rest-assured.io/

Configuring REST Assured
* Maven
```
        <!-- https://mvnrepository.com/artifact/io.rest-assured/rest-assured -->
        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>rest-assured</artifactId>
            <version>4.4.0</version>
            <scope>test</scope>
        </dependency>
```
* TestNG
```
        <!-- https://mvnrepository.com/artifact/org.testng/testng -->
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>7.4.0</version>
            <scope>test</scope>
        </dependency>
```
# API Test
Website: https://www.zippopotam.us/
* Supplies location data related to given country and zip code

<p align="center">
   <td><img src="https://user-images.githubusercontent.com/75911392/181996245-3ba96d8f-a719-4ca5-90ca-f17736bb0e7d.PNG" /></td>
</p>

* An example request and response
<br>Structure: api.zippopotam.us/country/postal-code
```
api.zippopotam.us/us/90210
```
* JSON Result
```
{
   "post code": "90210",
   "country": "United States",
   "country abbreviation": "US",
   "places": [
       {
           "place name": "Beverly Hills",
           "longitude": "-118.4065",
           "state": "California",
           "state abbreviation": "CA",
           "latitude": "34.0901"
       }
   ]
}

```

# Tests Result

![restassured](https://user-images.githubusercontent.com/75911392/182031988-606f0e95-9334-48cf-aaf8-27500f70134c.PNG)

# How to create a parameterized REST Assured test?
* Step 1: Create a test data collection 
* Step 2: Feed data collection to your test method
* Step 3: Use path parameters to parameterize REST Assured tests
* Step 4: Update the specified test data

![parameterizing](https://user-images.githubusercontent.com/75911392/182033924-bd2b2a92-577e-427e-9003-1446d5cb3211.PNG)


# Optimizing REST Assured code
1- Reusable request specifications<br>
2- Reusable response checks<br>
3- Extracting response values for reuse<br>

![optimizing](https://user-images.githubusercontent.com/75911392/182036760-1d86b560-87c0-4b38-b37e-b311e07d90d6.PNG)

