# Many-to-One Spring Boot Project

This project is a Spring Boot application that demonstrates a many-to-one relationship between categories and products. Each category can have multiple products. The application uses Spring Boot, Spring Data JPA, and Hibernate for database operations.

## Features

- **CRUD Operations**:
  - Create, Read, Update, and Delete (CRUD) for Categories.
  - Create, Read, Update, and Delete (CRUD) for Products.
- **Many-to-One Relationship**:
  - A single category can contain multiple products.
- **Pagination**:
  - Server-side pagination for fetching categories and products.
- **REST API**:
  - Exposes endpoints for interacting with categories and products.
- **Database Integration**:
  - Uses relational database configured with JPA and Hibernate.

## Prerequisites

- Java 17 or higher.
- Maven 3.6 or higher.
- Relational Database (e.g., MySQL).
- IDE or text editor (e.g., IntelliJ, Eclipse, VS Code).

## Project Structure

- `src/main/java`: Contains the Java source code.
  - `Entity`: Defines JPA entity classes for `Category` and `Product`.
  - `Repository`: Interfaces for database operations.
  - `Service`: Business logic implementation.
  - `Controllers`: REST controllers for handling HTTP requests.
- `src/main/resources`: Contains application properties and other resources.
  - `application.properties`: Configures database connection.

## Setup Instructions

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-username/many-to-one-spring-project.git
   cd many-to-one-spring-project
   ```

2. **Configure the Database**:
   - Update the `src/main/resources/application.properties` file with your database details:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/your_database
     spring.datasource.username=your_username
     spring.datasource.password=your_password
     spring.jpa.hibernate.ddl-auto=update
     ```

3. **Build the Project**:
   ```bash
   ./mvnw clean install
   ```

4. **Run the Application**:
   ```bash
   ./mvnw spring-boot:run
   ```

5. **Access the API**:
   - Base URL: `http://localhost:8080/api`
   - Example Endpoints:
     - `GET /categories?page=0`: Fetch paginated list of categories.
     - `POST /categories`: Create a new category.
     - `GET /products?page=0`: Fetch paginated list of products.
     - `POST /products`: Create a new product.

## API Endpoints

### Category Endpoints

- `GET /categories?page={pageNumber}`: Retrieve paginated list of categories.
- `POST /categories`: Create a new category.
- `GET /categories/{id}`: Retrieve a category by ID.
- `PUT /categories/{id}`: Update a category by ID.
- `DELETE /categories/{id}`: Delete a category by ID.

### Product Endpoints

- `GET /products?page={pageNumber}`: Retrieve paginated list of products.
- `POST /products`: Create a new product.
- `GET /products/{id}`: Retrieve a product by ID.
- `PUT /products/{id}`: Update a product by ID.
- `DELETE /products/{id}`: Delete a product by ID.

## Technologies Used

- **Spring Boot**: Framework for building the application.
- **Spring Data JPA**: For database interaction.
- **Hibernate**: ORM tool for managing relational data.
- **MySQL**: Relational database.
- **Maven**: Build automation tool.
!

