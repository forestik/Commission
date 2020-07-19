# Commission
This project is a REST-service that processes various types of requests (Get, Post, Put, Delete, Putch).  
System **Commission**. The **Abiturient** registers for one of the **Faculties** with a fixed enrollment plan, enters points in the relevant **Subjects** and certificate. 
The results are registered by the Administrator in the **Statement**. The system calculates the amount of points and determines the entrants enrolled in the educational institution.

The project is built on the one built on the Spring Framework assembled using Maven.  
The project consists of 5 microsersers:  
+ Abiturient - [Abiturient](https://github.com/forestik/Commission/tree/master/Abiturient)
+ Administrator - [Administrator](https://github.com/forestik/Administrator)
+ Faculty - [Faculty](https://github.com/forestik/Commission/tree/master/Faculty)
+ Mark - [Mark](https://github.com/forestik/Commission/tree/master/Mark)
+ Statement - [Statement](https://github.com/forestik/Commission/tree/master/Statement)

Example of all running modules  
![modules](https://github.com/forestik/Commission/blob/master/images/Spring.png)

**RestTemplate** is used for communication between microservices. 
![resttemplate](https://github.com/forestik/Commission/blob/master/images/RestTemplate.png)

**MySQL** databases were also used in this project.  
![database](https://github.com/forestik/Commission/blob/master/images/DB.png)

For example, using Postman called the Get method for abiturient with id = 11.
![abiturient](https://github.com/forestik/Commission/blob/master/images/Abiturient.png)
