# Decola Tech 2025
API RESTful in Spring boot created for bootcamp Decola Tech 2025 in Digital Innovation One

## Class Diagram

```mermaid
classDiagram
    class Branch {
        +int id
        +string cnpj
        +string phone
        +string name
        +List~Customer~ customers
        +List~Vehicle~ vehicles
    }
    
    class Customer {
        +int id
        +string name
        +string phone
        +string email
        +string cpf
    }
    
    class Vehicle {
        +int id
        +string plate
        +string color
        +string model
        +VehicleType vehicleType
        +List~VLNDocument~ vlnDocuments
    }
    
    class VehicleType {
        +int id
        +string name
    }
    
    class VLNDocument {
        +int id
        +string date
        +float documentValue
        +Vehicle vehicle
        +Customer costumer
    }
    
    Branch "1" -- "*" Vehicle : has
    Branch "1" -- "*" Customer : has
    Vehicle "1" -- "*" VLNDocument : has
    Vehicle "1" -- "1" VehicleType : has
    VLNDocument "1" -- "1" Vehicle : references
    VLNDocument "1" -- "1" Customer : references

