package com.interview.truist.interview_truist.rest_soap;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingRestController {

    @GetMapping("/rest/greet")
    public String greet(@RequestParam(defaultValue = "World") String name) {
        return "<h1>Hello, " + name + "! </h1>";
    }
   
    @GetMapping(value = "/hello")
    public String helloWorld()
    {
    	return "<h1>Welcome to Spring Boot Application!</h1>";
    	
    }
    
    
}
