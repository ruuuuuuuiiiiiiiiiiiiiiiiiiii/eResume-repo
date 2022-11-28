# cgi_demo-repo
 Demo Application

# Features
- Authentication (login)
- CRUD projects for Career Objectives
- Dashboard
- Profile page
- Authentication (logout)

# Setup 
Now, run the queries in the [data.sql](./src/main/resources/data.sql) file.  

There no actual data save on the database for Login, so please Sign up (Can also be found on login page) to get an access to the website.

Also there were no actual data save on the database for Career Objectives, so please add data on Career Objectives tab to test finctionalities that was included to the app.

```java on application properties
private final String URL = "jdbc:mysql://<ip>:<port>/<database_name>";
private final String USERNAME = "<username>";
private final String PASSWORD = "<password>";
```

The app starts running here: [localhost:8080](http://localhost:8080/)


## Template
I used [THIS](https://github.com/BootstrapDash/corona-free-dark-bootstrap-admin-template) awesome template for this project.