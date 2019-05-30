# hotel_system
Spring Cloud project example

## Getting Started

### 1. We need External Configuration
    Why External Configuration?
    - Uses 12-factor methodologies
    - increases portability and scalability
    - Removes need for environment variables

    Why use Config Server?
    - Version control on configuration
    - Easier management and staging
    - Centralized management of variables

### 1.1 Create 'config' folder and put it on Desktop or another location.

### 1.2 Put into folder next files:
#### - guestservice.properties
- server.port=8102
- management.security.enabled=false

#### - reservationapp.properties
- server.port=8600
- management.security.enabled=false

#### - reservationbusinessservice.properties
- server.port=8500
- management.security.enabled=false

#### - reservationservice.properties
- server.port=8103
- management.security.enabled=false

#### - roomservice.properties
- server.port=8101
- management.security.enabled=false

### 1.3 Run next git commands: git init -> git add . -> git commit -m 'comment'

### 1.4 Specify path to Config Server within application.properties file of config-server app

### 1.5 Run sequence
- configuration
- eureka-server
- room-service
- guest-service
- reservation-service
- reservation-business-service
- reservation-webapp

### Links for access
- Configuration Server http://localhost:9000/roomservice/default
- Guest Service http://localhost:8102/guests
- Reservation Service http://localhost:8600/reservations
- Service discovery (Eureka) http://localhost:8761
- Room Service
  http://localhost:8500/rooms, http://localhost:8500/roomReservations/2017-01-01
- Swagger http://localhost:8500/swagger-ui.html

#### Feign is a declarative web service client. It makes writing web service clients easier.

#### To check circuit breaker fallback -> stop guest service and try http://localhost:8600/reservations again

#### Hystrix Dashboard
- http://localhost:8500/hystrix.html and input http://localhost:8500/hystrix.stream
