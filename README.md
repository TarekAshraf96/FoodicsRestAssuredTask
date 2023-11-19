# Foodics Rest Assured Task
Welcome to the Foodics Rest Assured Task, it is a smiple Rest Assured Project for test APIs

## Prerequisites & Installation
1) Before starting with the project, you need to install Java on your system.
2) Use any IDE you want, I Chose Eclipse
3) Make Sure to install Rest Assured
4) Make Sure to install TestNG
5) While Initiating everything, make sure you have the correct driver. I Used Chrome Drive with the old version (114.0.5735.199)

To Avoid any confusion, refer to the dependencies below and add it to you pom.xml
```eclipse
<dependencies>
	  <!-- https://mvnrepository.com/artifact/io.rest-assured/rest-assured -->
<dependency>
    <groupId>io.rest-assured</groupId>
    <artifactId>rest-assured</artifactId>
    <version>5.3.2</version>
    <scope>test</scope>
</dependency>
<!-- https://mvnrepository.com/artifact/org.testng/testng -->
<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.8.0</version>
    <scope>test</scope>
</dependency>

  </dependencies>
```

## Code and Test Scripts
Now Let's Break down the Code

### The valid Scenarios:

The Test Starts with the main Position Scenarios. The first test is the Login as you can see in the screen below:

![RestAssured1](https://github.com/TarekAshraf96/FoodicsRestAssuredTask/assets/44756402/7660cb13-4f89-4f67-a9fd-a4824018f011)


Then in the next test Function the Who Am I we check we are able to access by passing the Token recived from the login above:

![RestAssured2](https://github.com/TarekAshraf96/FoodicsRestAssuredTask/assets/44756402/498b02f1-aa61-4c15-8ed4-5f4aae790aa9)

### The Invalid Scenarios:

The Below Scenarios are Desined that negative Scenarios of both the Endpoints are well recovered:

![RestAssured3](https://github.com/TarekAshraf96/FoodicsRestAssuredTask/assets/44756402/ac1d7a9c-8fd2-4054-9fb1-cf890943487f)

![RestAssured4](https://github.com/TarekAshraf96/FoodicsRestAssuredTask/assets/44756402/caadf89a-6266-4e7c-b8f8-d5c81d994655)

And That Will be the Quick Tour of what the Code is Doing and how it works. Thank you for your time :D
