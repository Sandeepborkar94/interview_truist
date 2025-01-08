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

