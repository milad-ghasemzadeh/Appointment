# Appointment
The aim of the project is to manage the information of appointments in a JSON format.



It takes information as a JSON type and it contains appointments'properties such as id, start dates, end dates and ..., and we want to add appointments to our database with DAO design pattern.
However it is important to check these conditions and we should make sure that: 
1-	The appointment does not already exist, return an error message if the Requested time range is not available.
2-	The data is valid, otherwise return an error message.
3-	Update the previous appointment data if the same ID is received with updated information, while keeping the historical data.
4-	you always keep the latest updated information while keeping the historical data.
5-	your application can handle multiple concurrent requests correctly.
