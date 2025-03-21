# Vehicle Allocation System
The Vehicle Allocation System is a Spring Boot application designed to streamline vehicle allocation and management across multiple branches. It provides a structured way to manage branches, customers, vehicles, and rental transactions, ensuring efficient operations for car rental companies or fleet management services.

Key Features:
Branch Management: Each branch has a unique CNPJ, contact information, and a list of associated customers and vehicles.
Customer Records: Maintains customer data, linking each customer to a specific branch.
Vehicle Management: Supports vehicle registration with attributes such as plate, color, model, and vehicle type.
Vehicle Type Classification: Organizes vehicles based on their type (e.g., Sedan, SUV, Truck).
VLN Document Tracking: Records rental transactions with details like date and document value.
Technologies Used:
Spring Boot – Core framework for building the application.
Spring Data JPA – ORM for database management.
Spring WebFlux – Enables reactive, non-blocking API communication.
H2 Database – In-memory database for local development and testing.
PostgreSQL – Relational database for production environments.
Jackson Databind – Handles JSON serialization and deserialization.
Project Reactor – Supports reactive programming for high-performance operations.
JUnit & Reactor Test – Ensures application reliability through testing.
This system provides a scalable and reactive architecture, making it ideal for high-demand environments requiring real-time vehicle and customer management.

## Class Diagram

```mermaid
classDiagram
    class Branch {
        +Long id
        +String cnpj
        +String phone
        +String name
        +Lis<Customer> customers
        +List<Vehicle> vehicles
    }
    
    class Customer {
        +Long id
        +String name
        +String phone
        +String email
        +String cpf
        +Branch branch
        +List<VLNDocument> vlnDocuments
    }
    
    class Vehicle {
        +Long id
        +String plate
        +String color
        +String model
        +VehicleType vehicleType
        +Branch branch
        +List<VLNDocument> vlnDocuments
    }
    
    class VehicleType {
        +Long id
        +String name
        +List<Vehicle> vehicles
    }
    
    class VLNDocument {
        +Long id
        +Date date
        +Double documentValue
        +Vehicle vehicle
        +Customer costumer
    }
    
    Branch "1" -- "*" Vehicle : has
    Branch "1" -- "*" Customer : has
    Vehicle "1" -- "1" VehicleType : has
    Vehicle "1" -- "*" VLNDocument : has
    Customer "1" -- "*" VLNDocument : has
    VLNDocument "1" -- "1" Vehicle : references
    VLNDocument "1" -- "1" Customer : references


