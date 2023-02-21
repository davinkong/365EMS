# 365EMS (Employee Management System)



## Tech Stack:
```bash
 Java
 Spring Boot
 PostgreSQL
 Thymeleaf
 JavaScript
 HTML
 Bootstrap
 CSS

```

## Description:

```Java
Register - use BCryptPasswordEncoder as a bean in the configuration
to encode the user’s password to the hash String for better security.

Login - use JpaRepository findByEmail and passwordEncoder.matches
to verify employees’ login information.

The employee can fill out their information and the data will be sent to the server 
and saved in the PostgreSQL database, in the body of the POST request by clicking the Submit button. 

The employee can edit their information, which I implemented the findById from the JPA repository 
to send a PUT request by their employee id to the server, when they click the save button.

An employee can request time off by entering hours and picking the date. 
This information will be added to their PostgreSQL database. They can have more than one requests.

The admin can approve or deny the request.
Admin can also delete an employee by id with a delete request.

 ```

## 
Screenshots:

## Author:

Davin Kong
