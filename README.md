# WorldExplorer System Documentation

Welcome to WorldExplorer, a comprehensive platform designed to facilitate global exploration through a robust system of interconnected services. This documentation provides an in-depth overview of the architecture, technologies, and Dockerised deployment procedures associated with the WorldExplorer project.

## Overview:

WorldExplorer is a distributed system comprising three distinct services:

1. **UserService:**
   - Responsible for user registration and authentication.
   - Implements JWT (JSON Web Token) for secure and efficient user authentication.
   - Entry point: `src/main/java/com/explorer/userservice/UserserviceApplication.java`.

2. **FavService:**
   - Empowers users to maintain curated lists of favorite attractions and holidays.
   - Centralizes user-specific data management.
   - Entry point: `src/main/java/com/explorer/favservice/FavServiceApplication.java`.

3. **FetchCountryAttractionService:**
   - Integrates with third-party APIs to retrieve detailed information about countries, including attractions and public holidays.
   - Enhances the global experience by providing rich, up-to-date data.
   - Entry point: `src/main/java/com/explorer/fetchcountryattractionservice/FetchcountryattractionserviceApplication.java`.

## Technologies Utilized:

- **Java 8**, **Spring Boot:** Facilitating rapid development and deployment of microservices.
- **MySQL**, **Spring JPA:** Enables simplified data access through the Java Persistence API.
- **Maven:** The project management and comprehension tool for handling dependencies and building the worldexplorer project.

## Docker Deployment:

The WorldExplorer services have been Dockerised for seamless deployment. Below are the container names and ports associated with each service:

1. **UserService Container:**
   - Container Name: `worldexplorer-userservice`
   - Exposed Port: `2212`

2. **FavService Container:**
   - Container Name: `worldexplorer-favservice`
   - Exposed Port: `2213`

3. **FetchCountryAttractionService Container:**
   - Container Name: `worldexplorer-fetchcountryattractionservice`
   - Exposed Port: `2215`

## MySQL Database Configuration:

- **Database Name:** `worldexplorerdb`
- **User:** `****`
- **Password:** `****`
- **Connection URL:** `jdbc:mysql://localhost:3306/worldexplorerdb?createDatabaseIfNotExist=true&user=****&password=****&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC`

## Deployment Instructions:

1. **Clone the Repository:**
   
   ```bash
   git clone https://github.com/YourUsername/WorldExplorer.git
   ```

2. Build and Install dependencies

   ```ba
   mvn clean install
   ```

3. Run Docker containers

   ```bash
   docker build -t worldexplorer-userservice ./UserServiceDirectory
   docker run -p 2212:2212 worldexplorer-userservice
   
   docker build -t worldexplorer-favservice ./FavServiceDirectory
   docker run -p 2213:2213 worldexplorer-favservice
   
   docker build -t worldexplorer-fetchcountryattractionservice ./FetchCountryAttractionServiceDirectory
   docker run -p 2215:2215 worldexplorer-fetchcountryattractionservice
   ```

   