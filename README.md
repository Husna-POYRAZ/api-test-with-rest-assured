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
* RUns on top of JUnit or TesyNG
* Abstracts away a lot of boilerplate code
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


