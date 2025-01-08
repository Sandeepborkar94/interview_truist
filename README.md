# interview_truist

**Frequently Asked Questions in Spring Boot**

### 1. **Calling a REST Service from Another REST Service**
To call a REST service from another REST service in a Spring Boot application:
- Use **`RestTemplate`** or **`WebClient`** (for non-blocking calls).
- Create a bean of `RestTemplate` or `WebClient` in your configuration class.
- Inject the bean into your service class and use it to make HTTP calls.

**Example with `RestTemplate`:**
```java
@RestController
public class MyController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/callService")
    public String callAnotherService() {
        String url = "http://example.com/api/service";
        return restTemplate.getForObject(url, String.class);
    }
}
```

**For multiple REST services:**
You can use the same instance of `RestTemplate` or `WebClient`. Configure different base URLs and endpoints dynamically.

---

### 2. **Converting String to Integer from REST Template Call**
To automate the conversion without manual casting:
- Use **`ObjectMapper`** from Jackson for JSON responses.
- For XML responses, use a library like JAXB.

**Example with `ObjectMapper`:**
```java
String response = restTemplate.getForObject("http://example.com/api/service", String.class);
Integer result = new ObjectMapper().readValue(response, Integer.class);
```

Alternatively, define the expected response type in your REST call:
```java
ResponseEntity<Integer> response = restTemplate.exchange(url, HttpMethod.GET, null, Integer.class);
Integer value = response.getBody();
```

---

### 3. **Bean Injection in Spring**
Beans are injected using:
1. **Field Injection** (`@Autowired` on fields).
2. **Setter Injection** (`@Autowired` on setters).
3. **Constructor Injection** (recommended for immutability).

**Example: Constructor Injection:**
```java
@Service
public class MyService {
    private final MyRepository myRepository;

    @Autowired
    public MyService(MyRepository myRepository) {
        this.myRepository = myRepository;
    }
}
```

---

### 4. **Bean Scopes in Spring**

**Types of Bean Scopes:**
1. **Singleton:** Default scope. One instance per Spring container.
   - **Use case:** Stateless services.
2. **Prototype:** New instance for each request.
   - **Use case:** Stateful objects.
3. **Request:** New instance per HTTP request.
   - **Use case:** Web applications with user-specific data.
4. **Session:** New instance per HTTP session.
   - **Use case:** User preferences in a web app.
5. **Application:** One instance per ServletContext.
   - **Use case:** Shared data across sessions.
6. **WebSocket:** One instance per WebSocket.

---

### 5. **Spring Profiling**
Spring profiles allow configuring environments (e.g., dev, test, prod).
- Add `@Profile("profileName")` to beans.
- Use `application.properties` to activate a profile: `spring.profiles.active=dev`.

---

### 6. **Autowiring in Spring Boot**
Autowiring automatically resolves and injects beans into classes. Types:
1. **No:** Manual wiring.
2. **ByName:** Matches property name with bean name.
3. **ByType:** Matches property type with bean type.
4. **Constructor:** Matches constructor parameters.

**Use case for Constructor Autowiring:** When dependencies are mandatory and should be immutable.

---

### 7. **Inversion of Control (IoC)**
IoC shifts the responsibility of object creation and management to a container (Spring IoC Container). The container manages the lifecycle and dependencies of beans.

---

### 8. **Securing Spring Boot Applications**
1. **Authentication and Authorization:** Use Spring Security.
2. **Secure endpoints:** Add `@PreAuthorize` or `@RolesAllowed`.
3. **Encrypt data:** Use HTTPS, TLS, or secure keys.
4. **CORS policies:** Restrict origins using `@CrossOrigin`.

---

### 9. **HTTP Response Codes**
- **200 (OK):** Request succeeded.
- **400 (Bad Request):** Invalid request syntax.
- **401 (Unauthorized):** Authentication required.
- **403 (Forbidden):** No permission despite authentication.
- **404 (Not Found):** Resource unavailable.
- **500 (Internal Server Error):** Server-side issue.
- **503 (Service Unavailable):** Server overload.

---

### 10. **Combining First and Last Name as Primary Key**
Use a **Composite Key** with `@EmbeddedId` or `@IdClass`.

**Example with `@IdClass`:**
```java
@Entity
@IdClass(NameId.class)
public class User {
    @Id
    private String firstName;
    @Id
    private String lastName;
}
```

---

### 11. **Transaction Management**
Annotate service methods with `@Transactional` for atomic operations.

**Example:**
```java
@Service
public class MyService {
    @Transactional
    public void performTransaction() {
        // Business logic
    }
}
```

---

### 12. **HTTP vs HTTPS**
- **HTTP:** Unsecured protocol, plain text data transfer.
- **HTTPS:** Secured with SSL/TLS, encrypted communication.

---


**Java and Spring Boot Interview Questions**

### 1. **Scenario-Based Question: Create a List of Objects and Filter It with a Given Condition (Java 8)**

**Example:**
```java
import java.util.*;
import java.util.stream.Collectors;

class Employee {
    int id;
    String name;
    int age;

    public Employee(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', age=" + age + '}';
    }
}

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", 25),
            new Employee(2, "Bob", 30),
            new Employee(3, "Charlie", 35)
        );

        // Filter employees older than 30
        List<Employee> filteredEmployees = employees.stream()
                .filter(e -> e.age > 30)
                .collect(Collectors.toList());

        filteredEmployees.forEach(System.out::println);
    }
}
```
**Output:**
```
Employee{id=3, name='Charlie', age=35}
```

---

### 2. **How You Will Handle Exceptions in a Spring Boot Application**

Spring Boot provides multiple ways to handle exceptions:

- **Using `@ControllerAdvice` and `@ExceptionHandler`:**
```java
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
```

- **Custom Exception Class:**
```java
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
```

- **Throwing Exception:**
```java
@GetMapping("/employee/{id}")
public Employee getEmployee(@PathVariable int id) {
    return employeeRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
}
```

---

### 3. **HTTP Error Codes**

| Code | Description                          |
|------|--------------------------------------|
| 200  | OK - Request succeeded.             |
| 400  | Bad Request - Invalid input.        |
| 401  | Unauthorized - Authentication failed.|
| 403  | Forbidden - Access denied.          |
| 404  | Not Found - Resource not available. |
| 500  | Internal Server Error.              |

**Example:**
If a resource is not found:
```java
throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not Found");
```

---

### 4. **If a List Is Empty and You Try to Retrieve an Element**

Accessing an empty list does not throw an exception. However, trying to access an index that doesn’t exist will throw `IndexOutOfBoundsException`.

**Example:**
```java
List<String> list = new ArrayList<>();
System.out.println(list.get(0)); // Throws IndexOutOfBoundsException
```

---

### 5. **What Is Spring Security?**

Spring Security is a framework for securing Java applications, providing features like:
- Authentication
- Authorization
- Protection against CSRF, XSS
- Integration with OAuth2 and JWT

---

### 6. **Tokenization and Authentication in Spring Security**

- **Tokenization** involves generating a token (e.g., JWT) for client authentication.

**Steps:**
1. Client sends credentials to `/login`.
2. Server validates credentials and generates a JWT token.
3. Token is sent in subsequent requests in the `Authorization` header.

**Example:**
```java
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.csrf().disable()
        .authorizeRequests()
        .anyRequest().authenticated()
        .and()
        .oauth2ResourceServer().jwt();
    return http.build();
}
```

---

### 7. **What Is Cache Mechanism? How to Implement It?**

Caching stores frequently accessed data in memory for faster retrieval.

**Spring Boot Example:**
1. Add `spring-boot-starter-cache` dependency.
2. Enable caching:
```java
@EnableCaching
@SpringBootApplication
public class Application {}
```
3. Annotate methods with `@Cacheable`:
```java
@Cacheable("employees")
public Employee getEmployeeById(int id) {
    return employeeRepository.findById(id).orElse(null);
}
```

---

### 8. **Flow of Previous Project**

Describe:
- The **business problem** solved.
- The **architecture** (e.g., microservices, REST APIs).
- The **tools** used (Spring Boot, Hibernate, Kafka, etc.).
- Your specific role and tasks.

**Example:**
"I worked on a microservices-based employee management system. I developed REST APIs using Spring Boot, implemented JPA for database interactions, and integrated Kafka for asynchronous messaging."

---

### 9. **How You Did Validation for Your Fixes**

1. Unit tests using JUnit.
2. Integration tests.
3. Testing in lower environments (UAT, QA).
4. Logging to verify runtime behavior.

---

### 10. **How to Troubleshoot a Production Issue Related to Your Fix**

1. **Check Logs:** Analyze logs using tools like Splunk.
2. **Reproduce the Issue:** Simulate in a non-production environment.
3. **Debug:** Use breakpoints or additional logging.
4. **Fix and Deploy:** Apply the fix, test, and redeploy.

---

### 11. **How to Create an Annotation in Java**

**Example:**
```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogExecutionTime {}
```

---

### 12. **How to Consume a Service in Spring Boot**

**Using `RestTemplate`:**
```java
@RestController
public class EmployeeController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getEmployee")
    public Employee getEmployee() {
        return restTemplate.getForObject("http://external-service/api/employee", Employee.class);
    }
}
```

### REST API and Microservices Overview

#### **1. Protocols for Creating REST APIs**
REST APIs rely on the **HTTP/HTTPS protocol** for communication. Key considerations include:
- **HTTP Methods**: Utilize specific methods like `GET`, `POST`, `PUT`, `DELETE`, and `PATCH` for operations.
- **Statelessness**: Each client request must be independent, containing all required information.
- **Resource Identification**: Use URIs (Uniform Resource Identifiers) to identify resources uniquely.
- **Content Negotiation**: Support multiple formats such as JSON, XML, or plain text.
- **HTTP Status Codes**: Return standard status codes like `200 OK`, `201 Created`, `400 Bad Request`, etc.
- **Security**: Ensure secure communication using HTTPS, OAuth2, or JWT.

---

#### **2. Stored Procedure**
A **stored procedure** is precompiled SQL code stored in the database.
- **Advantages**:
  - Reduces network traffic by executing multiple SQL statements at once.
  - Improves performance as it is precompiled.
  - Enhances security by encapsulating logic and avoiding direct SQL execution.
- **Syntax**:
```sql
CREATE PROCEDURE GetEmployeeDetails
    @EmployeeID INT
AS
BEGIN
    SELECT * FROM Employees WHERE EmployeeID = @EmployeeID;
END;
```
- **Execution**:
```sql
EXEC GetEmployeeDetails @EmployeeID = 1;
```

---

#### **3. Communication Between Microservices**
- **Synchronous Communication**:
  - Use **REST APIs** over HTTP/HTTPS.
  - Employ **gRPC** for faster communication with protocol buffers.
- **Asynchronous Communication**:
  - Leverage message brokers like **RabbitMQ**, **Kafka**, or **ActiveMQ**.
  - Example: Service A publishes a message to Kafka; Service B consumes it.

---

#### **4. Securing REST APIs (Spring Security)**
- **Authentication**:
  - Use OAuth2, JWT (JSON Web Token), or Basic Authentication.
- **Authorization**:
  - Implement role-based or permission-based access control.
- **CSRF Protection**:
  - Enable CSRF protection in Spring Security for form-based authentication.
- **HTTPS**:
  - Use HTTPS to encrypt communication.
- **Example Configuration**:
```java
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
            .antMatchers("/public/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .oauth2Login();
    }
}
```

---

#### **5. Difference Between Web Services and REST APIs**
| **Feature**            | **Web Services**                         | **REST APIs**                     |
|-------------------------|------------------------------------------|------------------------------------|
| **Protocol**           | SOAP, XML-RPC                           | HTTP/HTTPS                        |
| **Format**             | XML only                                | JSON, XML, HTML, plain text       |
| **State**              | Stateful or Stateless                   | Stateless                         |
| **Ease of Use**        | Complex (SOAP envelope)                 | Simple (JSON/URI-based)           |
| **Performance**        | Slower due to XML parsing               | Faster due to JSON usage          |

---

#### **6. Spring Data JPA**
- **Definition**: Simplifies database operations by providing a layer on top of JPA.
- **Features**:
  - Supports CRUD operations without boilerplate code.
  - Query methods with `findBy`, `deleteBy`, etc.
  - Pagination and sorting support.
- **Example**:
```java
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByLastName(String lastName);
}
```

---

#### **7. Current or Previous Project Architecture**
A typical architecture includes:
- **Layered Architecture**:
  - **Presentation Layer**: Frontend (Angular/React).
  - **Service Layer**: REST APIs built with Spring Boot.
  - **Persistence Layer**: Spring Data JPA or Hibernate.
  - **Database**: MySQL/PostgreSQL.
  - **Communication**: REST APIs and Kafka for microservices.
  - **Monitoring**: Tools like Splunk or Kibana.

---

#### **8. HTTP Methods**
- **GET**: Retrieve data.
- **POST**: Create new resources.
- **PUT**: Update existing resources.
- **DELETE**: Delete resources.
- **PATCH**: Partially update resources.

---

#### **9. Design Patterns**
- **Singleton**: Ensure a single instance (e.g., `BeanFactory` in Spring).
- **Factory**: Create objects without exposing instantiation logic.
- **Observer**: Notify observers of state changes (e.g., Event Listeners).
- **Builder**: Build complex objects (e.g., creating REST requests).

---

#### **10. About Spring Framework**
- **Modules**:
  - Core Container (Beans, Core, Context, Expression Language).
  - Data Access (JDBC, ORM, Transactions).
  - Web (MVC, WebSocket).
- **Features**:
  - Dependency Injection (DI).
  - Aspect-Oriented Programming (AOP).
  - Integration with databases and messaging systems.

---

#### **11. Dependency Injection and IOC**
- **IOC (Inversion of Control)**: The control of object creation is given to the Spring container.
- **Types of Dependency Injection**:
  - Constructor Injection.
  - Setter Injection.
  - Field Injection.

---

#### **12. Connecting the Database in Spring**
- Use Spring Boot with JDBC or JPA.
- **Steps**:
  1. Add dependencies:
     ```xml
     <dependency>
         <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-starter-data-jpa</artifactId>
     </dependency>
     ```
  2. Configure `application.properties`:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/mydb
     spring.datasource.username=root
     spring.datasource.password=password
     ```
  3. Use a repository:
     ```java
     @Repository
     public interface UserRepository extends JpaRepository<User, Long> {}
     ```


_______________________________________________________________________________________________________________

**Comprehensive Guide on Advanced Spring Boot and AWS Development Practices**

---

### **1. Creating Multi-Module Maven Spring Boot Project**

**Overview:**
A multi-module Maven project organizes a large application into separate modules, enabling modular development and easier maintenance.

**Steps:**
1. **Create Parent Project:** Use the `maven-archetype-quickstart` template to set up a parent project.
2. **Add Child Modules:** Include modules like `core`, `service`, and `web` as subdirectories in the parent project.
3. **Define Parent `pom.xml`:**
   ```xml
   <modules>
     <module>core</module>
     <module>service</module>
     <module>web</module>
   </modules>
   ```
4. **Build Project:** Use Maven commands like `mvn clean install` to build the project.

**Example Directory Structure:**
```
my-app
├── pom.xml (Parent POM)
├── core
│   └── pom.xml
├── service
│   └── pom.xml
└── web
    └── pom.xml
```

---

### **2. Creating Multi-Module Gradle Spring Boot Project**

**Overview:**
Gradle’s multi-module structure is defined using `settings.gradle` and `build.gradle` files.

**Steps:**
1. **Configure Root Project:** Define subprojects in `settings.gradle`.
   ```groovy
   rootProject.name = 'my-app'
   include 'core', 'service', 'web'
   ```
2. **Define Dependencies in Submodules:**
   ```groovy
   dependencies {
       implementation 'org.springframework.boot:spring-boot-starter'
   }
   ```

---

### **3. Using Latest Spring Boot (3.24) with JDK 17**

**Overview:**
Spring Boot 3.x supports Jakarta EE 9+, native application development with GraalVM, and JDK 17.

**Sample `application.yml`:**
```yaml
server:
  port: 8080
spring:
  application:
    name: demo-app
```

**Parent POM Configuration:**
```xml
<parent>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-parent</artifactId>
  <version>3.2.4</version>
</parent>
```

---

### **4. Dockerizing the Spring Boot Application**

**Steps:**
1. Create a `Dockerfile`:
   ```dockerfile
   FROM openjdk:17-jdk-slim
   ARG JAR_FILE=target/demo-app.jar
   COPY ${JAR_FILE} app.jar
   ENTRYPOINT ["java", "-jar", "/app.jar"]
   ```
2. Build and Run Docker Image:
   ```bash
   docker build -t demo-app .
   docker run -p 8080:8080 demo-app
   ```

---

### **5. Dockerizing the Angular Application**

**Steps:**
1. Build Angular App:
   ```bash
   ng build --prod
   ```
2. Create a `Dockerfile`:
   ```dockerfile
   FROM nginx:alpine
   COPY dist/my-app /usr/share/nginx/html
   EXPOSE 80
   ENTRYPOINT ["nginx", "-g", "daemon off;"]
   ```

---

### **6. GitLab CI/CD Pipeline**

**Steps:**
1. Define `.gitlab-ci.yml`:
   ```yaml
   stages:
     - build
     - test
     - deploy

   build:
     stage: build
     script:
       - mvn clean package

   deploy:
     stage: deploy
     script:
       - echo "Deploying application..."
   ```

---

### **7. Connecting to Database with SSL Certificate**

**Steps:**
1. Configure `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://host:port/db?verifyServerCertificate=true&useSSL=true
   spring.datasource.username=user
   spring.datasource.password=pass
   ```
2. Import SSL Certificate to Java Trust Store:
   ```bash
   keytool -import -trustcacerts -file certificate.crt -keystore cacerts -storepass changeit
   ```

---

### **8. Use of Abstract Routing Pattern**

**Overview:**
Abstract routing allows dynamic database connection management based on tenant context.

**Implementation:**
```java
public class MultiTenantDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return TenantContext.getTenantId();
    }
}
```

---

### **9. Multi-Threading and Parallel Processing**

**Example:**
Use `@Async` for asynchronous tasks.
```java
@Async
public CompletableFuture<String> processTask() {
    return CompletableFuture.completedFuture("Task Completed!");
}
```

---

### **10. Use of Caching**

**Overview:**
Spring Cache with Redis improves application performance by reducing database calls.

**Example:**
```java
@Cacheable("users")
public User getUser(Long id) {
    return userRepository.findById(id).orElseThrow();
}
```

---

### **11. SOAP and REST Support**

**Overview:**
Integrate both protocols in the same application by using Spring WS for SOAP and Spring Web for REST.

**Implementation:**
1. Create separate controllers for SOAP and REST endpoints.
2. Configure appropriate request mappings.

---

### **12. Running on AWS Fargate**

**Steps:**
1. Create an ECS Cluster in AWS.
2. Deploy the containerized application using Fargate tasks.

---

### **13. AWS Services Integration**

**Use Cases:**
- **S3 Integration:**
  ```java
  AmazonS3 s3Client = AmazonS3ClientBuilder.defaultClient();
  ```
- **Secrets Manager Integration:**
  Fetch credentials programmatically using AWS SDK.

---

### **14. Terraform for Infrastructure as Code**

**Overview:**
Terraform manages AWS infrastructure declaratively.

**Example:**
- RDS Instance:
  ```hcl
  resource "aws_db_instance" "mydb" {
    allocated_storage = 20
    engine = "mysql"
  }
  ```

**Additional Terraform Use Cases:**
1. **DMS Flow:** Define replication tasks and endpoints.
2. **AWS Glue Jobs:** Automate data processing pipelines.
3. **Route53 DNS Setup:** Configure DNS records for the application.

---




