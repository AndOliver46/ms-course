# Microservices in Practice

Microservices in Practice is a project aimed at demonstrating the implementation of microservices architecture using Spring Boot. The project focuses on building two microservices: User and Email, along with implementing asynchronous communication between them using RabbitMQ and email sending functionality using Gmail's SMTP.

## Project Objective

The primary goal of this project is to showcase the development of microservices while incorporating asynchronous messaging and integration with external services like Gmail. Key highlights of the project include:

- Configuration and utilization of RabbitMQ for asynchronous communication between microservices.
- Implementation of REST endpoints for user management and email sending.
- Utilization of Gmail's SMTP for sending emails.
- Usage of PostgreSQL databases for data storage.

## Prerequisites

Before working with this project, ensure you have the following prerequisites installed in your development environment:

- JDK 17
- Maven
- Postman
- PgAdmin (PostgreSQL)
- An IDE (IntelliJ, STS, Eclipse, etc)

## Environment Setup

To set up the development environment, follow these steps:

1. Clone the project repository.
2. Import the project into your IDE.
3. Ensure you have a RabbitMQ server configured. We recommend using CloudAMQP, which can be found [here](https://www.cloudamqp.com/).
4. Configure the RabbitMQ connection information and Gmail SMTP credentials in the `application.properties` file.
5. Run the User and Email microservices in your IDE.

## Project Execution

After configuring the environment, run the User and Email microservices in your IDE. You can use Postman to test the REST endpoints provided by the project.
