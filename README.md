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
![Screenshot 2023-02-20 at 5 46 38 PM](https://user-images.githubusercontent.com/80121820/220214295-a4c371a6-958a-4ff0-888d-c96add157e7f.png)
![Screenshot 2023-02-20 at 5 47 31 PM](https://user-images.githubusercontent.com/80121820/220214304-cbc44326-61ec-4ed0-961b-4892795e9f87.png)


https://user-images.githubusercontent.com/80121820/220214329-a9543722-182c-454d-a690-1ea99e36a895.mov

![Screenshot 2023-02-20 at 5 53 00 PM](https://user-images.githubusercontent.com/80121820/220214574-837ac442-2b66-4c5e-91d2-9f897846c866.png)
![Screenshot 2023-02-20 at 5 56 52 PM](https://user-images.githubusercontent.com/80121820/220214890-705fbda1-46fd-4391-96f1-453b9cd496e8.png)

![Screensho![Screenshot 2023-02-20 at 5 55 03 PM](https://user-images.githubusercontent.com/80121820/220214712-c29bd0e8-50ea-4840-8a15-e3764b11da13.png)
![Screenshot 2023-02-20 at 5 57 37 PM](https://user-images.githubusercontent.com/80121820/220214933-09a14cdc-da50-4971-9baf-c4f5f0a3516d.png)
![Screenshot 2023-02-20 at 5 58 16 PM](https://user-images.githubusercontent.com/80121820/220214984-88fbe117-3fe5-4d6e-b32a-a69eebb95c8f.png)
![Screenshot 2023-02-20 at 6 05 47 PM](https://user-images.githubusercontent.com/80121820/220215553-e58b5204-7068-4572-8820-b771e247b76b.png)

![Screenshot 2023-02-20 at 6 01 15 PM](https://user-images.githubusercontent.com/80121820/220215227-da6c0456-b27e-49ee-a0ad-6b93c1192e57.png)


![Screenshot 2023-02-20 at 10 52 27 PM](https://user-images.githubusercontent.com/80121820/220250878-3a3a1257-b06c-44d3-9231-de44eb11397d.png)



![Screenshot 2023-02-20 at 6 02 25 PM](https://user-images.githubusercontent.com/80121820/220215308-50d256e5-914a-4d29-84a8-752c2c2db6dc.png)
![Screenshot 2023-02-20 at 6 02 53 PM](https://user-images.githubusercontent.com/80121820/220215331-c3a33d53-81a5-43e7-9a04-822432cbea1a.png)

## Author:

Davin Kong
