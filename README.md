# social-media
A Demo Project, for the purpose of exploring the users and their friends

To Migrate The DB Entities to Desired Schema, Just go to db folder and execute the file **dump.sql**.

To start and run the application:
1. Import the project in eclipse, and Build it (Right Click -> Run As -> Maven Install)
2. Start the server in Spring Boot Mode (Right Click -> Run As -> Spring boot Application)
3. Access the page using http://localhost:8081/index.html

There are three APIs at backend:
1. /users?pageNumber=<Page_Number>&pageLength=<Page_Size>
2. /users/<User_Id>/friends
3. /users/<User_Id>/friendsoffriends

For testing the APIs, open the Postman and execute the above urls by replacing the respective fields enclosed in <>. All Urls are in GET type.

Possible test cases for the APIs:
1. Providing valid input for each API - valid response
2. Providing invalid input like the one which cannot be parsed to integer - exception from backend (handled by alert popup)
