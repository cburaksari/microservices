# Microservices Application

This repository contains a microservices application built using **Hexagonal Architecture** (on Order Service). The application comprises several independent services that interact with each other to provide a seamless user experience.

## Table of Contents
- [Overview](#overview)
- [Architecture](#architecture)
- [Services](#services)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [Contributing](#contributing)
- [License](#license)

## Overview
The microservices application is designed to handle various operations such as user management, order processing, and product management using a modular and scalable architecture. The services communicate via Kafka for event-driven messaging and are coordinated through an API Gateway.

## Architecture
The application follows **Hexagonal Architecture** principles, emphasizing a clear separation between the business logic and external systems. Each service has its own domain, application, and infrastructure layers.

### High-Level Design
- **Eureka Server**: Service registry for locating microservices.
- **API Gateway**: Acts as a single entry point for clients.
- **Kafka**: Event-driven communication between services.
- **PostgreSQL**: Database for persisting data.

## Services
1. **Eureka Server**: Handles service discovery.
2. **Order Service**: Manages orders, including creation and tracking.
3. **User Service**: Manages user information and authentication.
4. **Product Service**: Manages product catalog and inventory.

## Technologies Used
- **Spring Boot**: For building the microservices.
- **Eureka**: For service registry and discovery.
- **Kafka**: For messaging between services.
- **PostgreSQL**: As the relational database.
- **API Gateway**: For routing and load balancing.
- **Hexagonal Architecture**: For clean separation of concerns.

## Getting Started
To get started with this application:

1. Clone the repository:
   ```bash
   git clone https://cburaksari/microservices.git
   cd microservices
   ```

2. Set up the necessary environment variables for PostgreSQL and Kafka.

3. Run the services using Docker Compose:
   ```bash
   docker-compose up -d
   ```

4. Access the API Gateway at `http://localhost:8080`.

## Contributing
Contributions are welcome! Please fork the repository and create a pull request with your changes.
