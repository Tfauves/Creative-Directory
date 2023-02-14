# Creative Directory 
Full stack application built with Java utilizing Spring Boot. User authentication via Spring Security. SQL persistent. 

The Creative Directory is a one-stop portal for creatives, makers, and jack of all trades.
Members of the community will have access to helpful resources, from doing your own taxes, finding show spaces, grant opportunities, posting ads, and workshops.
Browse profiles and find your next collaborator or just find a creative business to support.


Clone the project

```
git clone https://github.com/Tfauves/Creative-Directory.git
```

Open project

### Application.Properties:

Spring Configs:
```
Spring.jpa.hibernate.ddl-auto=update
Spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

MySQL Configs: 
```
Spring.datasource.url=jdbc:mysql://localhost:3306/<database_name>
Spring.datasource.username=<username>
Spring.datasource.password=<password>
```

JWT Configs:
```
application properties
<app name here>.app.jwtSecret=<secret_string>
```
##  Authentication

#### Sign Up

```
 POST /api/auth/signup
```
Logging in will grant access to the authenticated routes.

| Body      | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `signup_request` | `object` | **Required** {username: <username>, password: <password>} |


#### Sign in

```
 POST /api/auth/signin
```

Returns JWT Token used as a Bearer to access authenticated routes

| Body | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `signin_request` | `object` | **Required** {username: <username>, password: <password>} |
