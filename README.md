
# Spring Boot Interceptor Demo

A simple Spring Boot project demonstrating how to use `HandlerInterceptor` to intercept and process HTTP requests before they reach the controller.

## 🚀 Features

- Request logging using `HandlerInterceptor`
- Authentication interceptor
- Authorization interceptor
- Centralized interceptor configuration
- Request pre-processing using `preHandle()`
- REST API implementation

## 🛠️ Technologies Used

- Java
- Spring Boot
- Spring Web MVC
- HandlerInterceptor
- Maven
- REST APIs
- IntelliJ IDEA

## 📁 Project Structure

```text
src
└── main
    ├── java
    │   └── com.exp.InterceptorDemo
    │       ├── InterceptorDemoApplication.java
    │       │
    │       ├── config
    │       │   └── WebConfig.java
    │       │
    │       ├── controller
    │       │   └── StudentController.java
    │       │
    │       └── interceptor
    │           ├── AuthenticationInterceptor.java
    │           ├── AutherisationInterceptor.java
    │           └── LoggingInterceptor.java
    │
    └── resources
        └── application.properties
