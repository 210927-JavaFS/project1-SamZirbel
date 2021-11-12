# Expense Reimbursement System - (ERS) Javalin Hibernate

## Project Explanation / Overview

The Expense Reimbursement System will manage the process of reimbursing employees for expenses incurred while on company time. All employees in the company can login and submit requests for reimbursement and view their past tickets and pending requests. Finance managers can log in and view all reimbursement requests and history for all employees in the company. Finance managers are authorized to approve and deny requests for expense reimbursement.

## Features Implemented

- Single Page Application (SPA) functionality utilizing JavaScript
- User Registration
- User Login
- Persisted passwords are encrypted
- Two account types ; employee and finance manager
- All accounts can add new reimbursement requests
- All accounts can view their past reimbursement requests and the status of these requests
- Finance managers can view all reimbursement requests
- Finance managers can approve or deny reimbursement requests
- Data is persisted in a PostgreSQL database
- Javalin/Jetty Web Server
- 55% test coverage of Service Layer
- Different levels of logging for Service Layer events
- DAO design pattern
- Three Tier Architecture

## Technologies Used

Java, JUnit, Log4J, Javalin, HTML, CSS, JavaScript, Hibernate, AWS RDS, SQL

## Set Up / Usage Guide

1. Navigate to the desired directory to host the project inside a Terminal or console
2. Use the following command to obtain project files: 
> git clone https://github.com/210927-JavaFS/project1-SamZirbel.git
3. Navigate to project1-SamZirbel / src / main / resources / hibernate.cfg.xml
4. Modify database properties under the comment "JDBC Properties TO Use JDBC In Hibernate"
> - property name="hibernate.connection.username"
> - property name="hibernate.connection.password"
> - property name="hibernate.connection.url"
> _Note : Regarding the connection url - if using a jdbc postgreSQL database you can use the format jdbc:postgresql://\<Host Database URL\>:\<Desired Port\>/\<Database Name\>_
5. Save hibernate.cfg.xml changes
6. Open an IDE such as Eclipse or Spring Tool Suite
7. Run project as a Java Application

## Contributors

Contributor : Samuel Zirbel
