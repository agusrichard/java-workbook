# Learning Notes for Microservice Architecture Patterns

## Notes:
**1. Microservice Architecture and Design Patterns for Microservices**
- Principles of microservice architecture
    - Scalability
    - Availability
    - Resiliency
    - Flexibility
    - Independent, autonomous
    - Decentralized governance
    - Failure isolation
    - Auto-provisioning
    - Continous delivery through DevOps
- Five design patterns of microservice architecture:
    - Decomposition Patterns
    - Integration Patterns
    - Database Patterns
    - Observability Patterns
    - Cross-Cutting Concern Patterns
- Decomposition Patterns:
  - Decompose by Business Capability. Order management is responsible for orders.
  - Strangler patterns: bit by bit replaces the legacy codebase. With these steps:
    - Transform: Create a parallel new site with modern approches
    - Coexist:  Leave the existing site where it is for a time. Redirect from the existing site to the new one so the functionality is implemented incrementally.
    - emove the old functionality from the existing site.
- Integration Patterns:
  - API Gateway
    - Serves as the single point of entry for any microservice call
    - It can work as a proxy service
    - Aggregate the result to send back to the user

## Resources:
- https://medium.com/@madhukaudantha/microservice-architecture-and-design-patterns-for-microservices-e0e5013fd58a