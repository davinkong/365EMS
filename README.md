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

They can also update their information when they click the save button.

An employee can request time off by entering hours and picking the date. 
This information will be added to their PostgreSQL database. They can have more than one requests.

The admin can approve or deny the request.
Admin can also delete an employee by id with a delete request.

 ```

## 
![Screenshot 2023-02-18 at 12 42 15 PM](https://user-images.githubusercontent.com/80121820/219882845-8d720b44-d230-4a59-acc5-5a2c0aa3e1d1.png)

![Screenshot 2023-02-18 at 12 42 57 PM](https://user-images.githubusercontent.com/80121820/219882875-6a524b82-2998-46d2-b24f-9a3198eb052c.png)

![Screenshot 2023-02-18 at 12 43 47 PM](https://user-images.githubusercontent.com/80121820/219882894-3a533458-256b-45b4-9f76-818ced87af06.png)

![Screenshot 2023-02-18 at 12 48 37 PM](https://user-images.githubusercontent.com/80121820/219883085-f000b723-cd27-414f-be27-88bbab309cb3.png)
![Screenshot 2023-02-18 at 12 49 06 PM](https://user-images.githubusercontent.com/80121820/219883101-42b4b3c8-215b-420d-aca7-68cd1f520b79.png)



## Author:

Davin Kong
