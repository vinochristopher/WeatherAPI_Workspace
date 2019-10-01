About this API : 
This API has been built on Angualr 8 CLI(front end, where user can enter the postal code) and Sprint Boot application with Restful service. 

1) User enter postal code and click the submit button.
2) By clicking Reset button,user can give other postal code.
2) Controller will receive the request from user(postalcode) and pass to service layer.
3) Service will call existing external weather api (https://api.openweathermap.org/data/2.5/forecast) to get the response for next 5 days weather prediction, based on service will filter for OneDay next to current day.

Front end:
Angular CLI_8.0.2

Backend:
spring boot v2.1.8.RELEASE   
JDK 1.8

IDE Used:
Spring boot - Spring Tool Suite
Angular - Visual studio code

In built Tomcat server and application can be accessed from Tomcat port : 1212
Application root context : external-weather-api

Request:
Application URL: http://localhost:1212/external-weather-api/

Response : 
Response is populated Angular UI page, based on the city associated with user input (postal code) as weather results.