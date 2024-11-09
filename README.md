 # Job Posting App
* Overview
The Job Posting App is a web application that allows employers to post job listings and job seekers to search and apply for jobs. 
This application is built using Spring Boot for the backend and MySQL for the database. It provides a simple and efficient way to connect employers with potential candidates.

## Features
### User Authentication:
* Secure login and registration for both employers and job seekers.
### Job Listings: 
* Employers can post, edit, and delete job listings.
### Search Functionality: 
* Job seekers can search for jobs based on various criteria (e.g., job title, location, company).
### Application Submission: 
Job seekers can apply for jobs directly through the app.

### User Profiles: 
Both employers and job seekers can manage their profiles.
### Admin Dashboard: Admins can manage users and job listings.
## Technology Stack
* Backend: Spring Boot
* Database: MySQL
* Build Tool: Maven
* Security: Spring Security
* API Documentation: Swagger
* Testing: JUnit, Mockito
Requirements
Java 11 or higher
MySQL Server
Maven
### Installation
1. Clone the Repository

```sh
git clone https://github.com/yourusername/job-posting-app.git
cd job-posting-app
```
2. Set Up MySQL Database

Create a new MySQL database for the application.
Update the application.properties file with your database credentials.
properties

```sh
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
```

3. Build the Project

```sh
mvn clean install
```


You can run the application using the following command:

```sh 
mvn spring-boot:run
Access the Application
```

Open your web browser and navigate to http://localhost:8080.

### API Endpoints
#### Authentication
* POST /api/auth/register: Register a new user
* POST /api/auth/login: Log in a user
#### Job Listings
* GET /api/jobs: Get all job listings
* POST /api/jobs: Create a new job listing
* GET /api/jobs/{id}: Get a job listing by ID
* PUT /api/jobs/{id}: Update a job listing
* DELETE /api/jobs/{id}: Delete a job listing
#### User Profiles
* GET /api/users/{id}: Get user profile by ID
* PUT /api/users/{id}: Update user profile
Testing
To run the tests, use the following command:

```sh
mvn test
```
### Contributing
Contributions are welcome! Please fork the repository and submit a pull request with your changes.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement". Don't forget to give the project a star! Thanks again!
1. Fork the Project
2. Create your Feature Branch (```git checkout -b feature/AmazingFeature```)
3. Commit your Changes (```git commit -m 'Add some AmazingFeature```)
4. Push to the Branch (```git push origin feature/AmazingFeature```)
### License
This project is licensed under the MIT License - see the LICENSE file for details.

Contact
For any questions or inquiries, please contact kinuthiaJohn122@gmail.com.

