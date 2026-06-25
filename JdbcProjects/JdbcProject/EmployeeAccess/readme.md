# 👔 Employee Management System with Authentication

A command-line employee management system built with Core Java and PostgreSQL, demonstrating JDBC connectivity, user authentication, and comprehensive employee operations. This application provides secure login functionality and complete employee record management with advanced features like department filtering and salary sorting.

[![Java](https://img.shields.io/badge/Java-ED8B00?logo=openjdk&logoColor=white)](https://www.java.com/)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?logo=postgresql&logoColor=white)](https://www.postgresql.org/)
[![JDBC](https://img.shields.io/badge/JDBC-Database_Connectivity-blue)]()

---

## 📋 Project Overview

This Employee Management System is a console-based Java application that combines user authentication with comprehensive employee record management. The project showcases proficiency in JDBC programming, database design, user authentication, and building secure, multi-module applications with proper separation of concerns.

**Key Highlights:**
- Secure user authentication system with registration and login
- Complete CRUD operations for employee management
- Advanced features (department filtering, salary sorting)
- PreparedStatement for SQL injection prevention
- Modular architecture with separate login and employee modules
- Clean separation of concerns and reusable code

---

## 🛠️ Technologies & Concepts

### Core Technologies
- **Java SE 8+** - Core Java programming language
- **JDBC API** - Database connectivity and operations
- **PostgreSQL 12+** - Relational database management system
- **Scanner Class** - User input handling

### Programming Paradigms & Patterns
- **Database Programming**
  - JDBC connectivity (DriverManager, Connection)
  - PreparedStatement (parameterized queries)
  - ResultSet processing (data retrieval)
  - Try-catch exception handling
- **Authentication System** - Username/password validation
- **Modular Design** - Separate packages for login and employee management
- **Code Reusability** - Shared connection and methods
- **Security** - Password verification and SQL injection prevention

---

## ✨ Features & Functionality

### Core Features

#### 1. **User Authentication System**
- New user registration with unique username
- Secure login with password verification
- Database-backed credential storage
- Session management after successful login
- Exit functionality with graceful shutdown

#### 2. **Employee Management**
- Add new employees with ID, name, salary, and department
- View complete employee list with all details
- Update employee salary by ID
- Delete employee records permanently
- Advanced search and filtering capabilities

#### 3. **Advanced Operations**
- Filter employees by department
- Sort employees by salary (descending order)
- Formatted display with aligned columns
- Row count feedback on all operations
- Comprehensive error handling

#### 4. **Data Security**
- PreparedStatement prevents SQL injection
- Password verification before granting access
- Secure credential management
- Input validation at multiple levels

#### 5. **Application Control**
- Menu-driven navigation for both modules
- Graceful exit with cleanup
- Thread-based exit animations
- Automatic connection management

### Technical Highlights

- **Two-Table Architecture**: Separate tables for login credentials and employee records
- **Authentication Flow**: Registration → Login → Employee Access
- **PreparedStatement Usage**: All queries use parameterized statements
- **Modular Package Structure**: `loginSystem` and `EmployeeDetails` packages
- **Code Reusability**: `EmployeeDetails` methods called from both modules
- **Exception Handling**: Comprehensive try-catch blocks
- **Connection Management**: Shared database connection across modules

---

## 🎯 Database Design

### Table Schemas

#### 1. LoginSystem Table
```sql
CREATE TABLE LOGINSYSTEM (
    USERNAME VARCHAR(20) PRIMARY KEY,
    PASSWORD VARCHAR(30)
);
```

#### 2. EmployeeRecord Table
```sql
CREATE TABLE EMPLOYEERECORD (
    id INT PRIMARY KEY,
    empname VARCHAR(20),
    salary INT,
    department VARCHAR(20)
);
```

### Connection Configuration

```java
private static final String DB_URL = "jdbc:postgresql://localhost:5432/studentdatabase";
private static final String DB_USER = "giri";
private static final String DB_PASSWORD = "root";
```

---

## 🚀 How to Run the Project

### Prerequisites
```bash
- Java Development Kit (JDK) 8 or higher
- PostgreSQL 12+ database server
- PostgreSQL JDBC driver (postgresql-42.7.0.jar)
- Command line terminal or IDE (optional: IntelliJ IDEA, Eclipse, VS Code)
```

### Database Setup

#### Step 1: Create Database
```bash
# Login to PostgreSQL
psql -U postgres

# Create database
CREATE DATABASE studentdatabase;

# Connect to database
\c studentdatabase
```

#### Step 2: Create Tables
```sql
-- Login System Table
CREATE TABLE LOGINSYSTEM (
    USERNAME VARCHAR(20) PRIMARY KEY,
    PASSWORD VARCHAR(30)
);

-- Employee Record Table
CREATE TABLE EMPLOYEERECORD (
    id INT PRIMARY KEY,
    empname VARCHAR(20),
    salary INT,
    department VARCHAR(20)
);
```

#### Step 3: Insert Sample Data (Optional)
```sql
-- Sample employee data
INSERT INTO employeerecord (id, empname, salary, department) VALUES
(1, 'Arun Kumar', 35000, 'HR'),
(2, 'Priya Sharma', 42000, 'Finance'),
(3, 'Rahul Verma', 50000, 'IT'),
(4, 'Sneha Reddy', 38000, 'Marketing'),
(5, 'Vikram Singh', 60000, 'IT');
-- (more sample data in schema.sql file)
```

### Application Setup

#### Method 1: Command Line

1. **Update Database Credentials**
   ```java
   // In Main.java and mainOfEmployee.java
   private static final String DB_USER = "your_username";
   private static final String DB_PASSWORD = "your_password";
   ```

2. **Compile with JDBC Driver**
   ```bash
   javac -cp .:postgresql-42.7.0.jar com/g1rix/javalearning/**/*.java
   ```

3. **Run the Application**
   ```bash
   java -cp .:postgresql-42.7.0.jar com.g1rix.javalearning.loginSystem.Main
   ```

#### Method 2: Using IDE

1. **Import as Java Project**
   - Open IDE (IntelliJ IDEA, Eclipse, VS Code)
   - Import/Open the project folder

2. **Add JDBC Driver**
   - Add `postgresql-42.7.0.jar` to project libraries
   - Configure build path

3. **Update Database Credentials**
   - Modify `DB_USER` and `DB_PASSWORD` in both Main classes

4. **Run Main.java**
   - Locate `com.g1rix.javalearning.loginSystem.Main`
   - Right-click → Run

---

## 📖 User Guide

### Initial Menu

```
Choose Operation ->
1. New Registration
2. Login
3. Exit
```

### Registration Flow

```
Choose: 1
Enter a Unique Username: john_admin
Enter a Strong Password: Admin@123
1 rows affected
```

### Login Flow

```
Choose: 2
Enter the Username: john_admin
Enter the Password: Admin@123
Login Successful

[Employee Management Menu appears]
```

### Employee Management Menu

```
1. Add Employee
2. View Employee List
3. Update Salary
4. Delete Employee
5. Display Employees By Department
6. Sort by Salary
7. Exit
Choose:
```

### Usage Examples

#### Add Employee
```
Choose: 1
Insert Employee details
Enter Employee ID: 101
Enter Employee Name: Rajesh
Enter Employee Salary: 55000
Enter Department: IT
1 record inserted!
```

#### View All Employees
```
Choose: 2
Id: 1 | EMPName: Arun Kumar | Salary: 35000 | Department: HR
Id: 2 | EMPName: Priya Sharma | Salary: 42000 | Department: Finance
Id: 3 | EMPName: Rahul Verma | Salary: 50000 | Department: IT
...
```

#### Update Salary
```
Choose: 3
Enter Employee ID: 101
Enter updated salary: 60000
1 row(s) affected
```

#### Filter by Department
```
Choose: 5
Enter department name: IT
Id: 3 | Name: Rahul Verma | Salary: 50000 | Department: IT
Id: 5 | Name: Vikram Singh | Salary: 60000 | Department: IT
Id: 101 | Name: Rajesh | Salary: 60000 | Department: IT
```

#### Sort by Salary
```
Choose: 6
Employees sorted by salary:
Id: 19 | Name: Nitin Jain | Salary: 62000 | Department: IT
Id: 5 | Name: Vikram Singh | Salary: 60000 | Department: IT
Id: 101 | Name: Rajesh | Salary: 60000 | Department: IT
...
```

---

## 📁 Project Structure

```
EmployeeAccess/
│
├── loginSystem/                           # Authentication module
│   ├── Main.java                          # Entry point
│   │   ├── Database connection
│   │   ├── Registration/Login menu
│   │   └── Method delegation
│   │
│   └── LoginSystem.java                   # Authentication logic
│       ├── userRegistration()             # New user signup
│       ├── loginValidation()              # Password verification
│       ├── EmployeeAccess()               # Post-login menu
│       └── ExitProgram()                  # Graceful exit
│
└── EmployeeDetails/                       # Employee management module
    ├── mainOfEmployee.java                # Direct employee access
    │   ├── Database connection
    │   ├── Employee management menu
    │   └── Method delegation
    │
    └── EmployeeDetails.java               # Employee operations
        ├── addEmployee()                  # Insert new employee
        ├── viewEmployee()                 # Display all employees
        ├── updateSalary()                 # Modify salary
        ├── deleteEmployee()               # Remove employee
        ├── displayByDepartment()          # Filter by dept
        ├── sortBySalary()                 # Sort by salary
        └── exitProgram()                  # Exit function
```

---

## 💡 Key Java Concepts Demonstrated

### 1. User Authentication

**Registration:**
```java
public static void userRegistration(Connection connect, Scanner scan) {
    System.out.println("Enter a Unique Username");
    String name = scan.next();
    System.out.println("Enter a Strong Password");
    String password = scan.next();
    
    String Query = "INSERT INTO LOGINSYSTEM VALUES(?,?)";
    PreparedStatement ps = connect.prepareStatement(Query);
    ps.setString(1, name);
    ps.setString(2, password);
    
    int row = ps.executeUpdate();
}
```

**Login Validation:**
```java
public static void loginValidation(Connection connect, Scanner scan) {
    String Query = "SELECT PASSWORD FROM LOGINSYSTEM WHERE USERNAME = ?";
    PreparedStatement ps = connect.prepareStatement(Query);
    ps.setString(1, name);
    ResultSet rs = ps.executeQuery();
    
    if (rs.next()) {
        String UserPassword = rs.getString("password");
        if(password.equals(UserPassword)) {
            System.out.println("Login Successful");
            EmployeeAccess(connect, scan);
        }
    }
}
```

### 2. Department Filtering

```java
public static void displayByDepartment(Connection connect, Scanner scan) {
    System.out.print("Enter department name: ");
    String dept = scan.next();
    
    String query = "SELECT * FROM EMPLOYEERECORD WHERE department = ?";
    PreparedStatement ps = connect.prepareStatement(query);
    ps.setString(1, dept);
    
    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
        // Display filtered results
    }
}
```

### 3. Salary Sorting

```java
public static void sortBySalary(Connection connect, Scanner scan) {
    String query = "SELECT * FROM EMPLOYEERECORD ORDER BY salary DESC";
    PreparedStatement ps = connect.prepareStatement(query);
    ResultSet rs = ps.executeQuery();
    
    while (rs.next()) {
        System.out.println(
            "Id: " + rs.getInt("id") +
            " | Name: " + rs.getString("EMPname") +
            " | Salary: " + rs.getInt("salary") +
            " | Department: " + rs.getString("department")
        );
    }
}
```

### 4. Module Integration

```java
// LoginSystem.java - After successful login
private static void EmployeeAccess(Connection connect, Scanner scan) {
    // Access employee management methods
    EmployeeDetails.addEmployee(connect, scan);
    EmployeeDetails.viewEmployee(connect);
    // etc.
}
```

---

## 🔮 Future Enhancements

### Planned Features
- [ ] **Password Encryption**: Hash passwords using BCrypt or SHA-256
- [ ] **Role-Based Access**: Admin, Manager, Employee roles
- [ ] **Session Management**: Track login time and user activity
- [ ] **Employee Search**: Search by name or ID
- [ ] **Salary Range Filter**: Find employees in salary brackets
- [ ] **Department Management**: Add/edit/delete departments
- [ ] **Attendance Tracking**: Record employee attendance
- [ ] **Performance Reviews**: Track ratings and feedback
- [ ] **Email Notifications**: Send alerts for important events
- [ ] **Report Generation**: Export employee reports to PDF/CSV

### Technical Improvements
- [ ] Implement DAO pattern for data access
- [ ] Add connection pooling (HikariCP)
- [ ] Use logging framework (Log4j, SLF4J)
- [ ] Create configuration file for database settings
- [ ] Add input validation with regex
- [ ] Implement password strength checker
- [ ] Add session timeout functionality
- [ ] Create unit tests (JUnit 5)
- [ ] Migrate to Spring Boot with Spring Security
- [ ] Build REST API for mobile/web integration
- [ ] Add database migration tools (Flyway)
- [ ] Implement audit logging for all operations

### Security Enhancements
- [ ] Password hashing (never store plain text)
- [ ] Brute force protection (login attempt limiting)
- [ ] SQL injection testing and hardening
- [ ] Input sanitization for all user inputs
- [ ] Session token management
- [ ] Two-factor authentication (2FA)
- [ ] Password reset functionality
- [ ] Account lockout after failed attempts

---

## 🎓 Learning Outcomes

This project demonstrates:
- **JDBC Fundamentals**: Connection, PreparedStatement, ResultSet
- **User Authentication**: Registration, login, session management
- **SQL Operations**: INSERT, SELECT, UPDATE, DELETE, WHERE, ORDER BY
- **Database Design**: Multi-table schemas, primary keys, relationships
- **Security Concepts**: Password verification, SQL injection prevention
- **Modular Architecture**: Package organization, code reusability
- **Exception Handling**: Comprehensive error catching
- **Clean Code**: Separation of concerns, method extraction

---

## 🔧 Technical Details

### Authentication Flow
```
1. User selects "New Registration"
   ↓
2. Username & password stored in LOGINSYSTEM table
   ↓
3. User selects "Login"
   ↓
4. System verifies credentials against database
   ↓
5. On success → Employee Management Menu
   ↓
6. User performs employee operations
   ↓
7. Exit → Logout
```

### Database Relationships
- **LOGINSYSTEM**: Stores user credentials (username as primary key)
- **EMPLOYEERECORD**: Stores employee data (id as primary key)
- **Future**: Can add foreign key linking employees to users

### PreparedStatement Security
```java
// ✅ SECURE - Parameterized query
String query = "SELECT * FROM LOGINSYSTEM WHERE USERNAME = ?";
ps.setString(1, username);

// ❌ INSECURE - String concatenation
String query = "SELECT * FROM LOGINSYSTEM WHERE USERNAME = '" + username + "'";
// Vulnerable to SQL injection!
```

---

## 🌐 Extensibility

The application is designed for easy extension:

1. **Add New Tables**: Create related tables (departments, positions, projects)
2. **New Operations**: Add methods to `EmployeeDetails` class
3. **Enhanced Authentication**: Add role-based access control
4. **Additional Filters**: Search by multiple criteria
5. **GUI Version**: Replace console with JavaFX or Swing interface
6. **Web Application**: Build with Spring Boot and Thymeleaf
7. **Mobile API**: Create RESTful endpoints for mobile apps

---

## 🛡️ Security Best Practices

### Current Implementation
✅ **PreparedStatement**: Prevents SQL injection  
✅ **Password Verification**: Checks credentials before access  
✅ **Exception Handling**: Logs errors securely  
⚠️ **Plain Text Passwords**: Store as plain text (should be hashed)

### Recommended for Production
```java
// Hash passwords before storing
import org.mindrot.jbcrypt.BCrypt;

// During registration
String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
// Store hashedPassword in database

// During login
if (BCrypt.checkpw(inputPassword, storedHashedPassword)) {
    // Login successful
}
```

### Security Checklist
- [x] Use PreparedStatement for all queries
- [ ] Hash passwords (BCrypt, PBKDF2, Argon2)
- [ ] Implement password strength requirements
- [ ] Add input validation and sanitization
- [ ] Use HTTPS/SSL for connections
- [ ] Implement rate limiting for login attempts
- [ ] Add logging for security events
- [ ] Use environment variables for credentials
- [ ] Implement session timeout
- [ ] Add CAPTCHA for login protection

---

## 🐛 Troubleshooting

### Common Issues

#### 1. Login Failed - User Not Found
**Cause**: Username doesn't exist in database

**Solution**:
- Register new user first (Option 1)
- Check LOGINSYSTEM table: `SELECT * FROM LOGINSYSTEM;`

#### 2. Password Didn't Match
**Cause**: Incorrect password entered

**Solution**:
- Verify password is correct
- Passwords are case-sensitive
- Check for extra spaces

#### 3. Primary Key Violation on Registration
**Cause**: Username already exists

**Solution**:
- Choose a different username
- Usernames must be unique

#### 4. Connection Refused
**Cause**: PostgreSQL not running

**Solution**:
```bash
sudo systemctl start postgresql
sudo systemctl status postgresql
```

#### 5. Table Does Not Exist
**Cause**: Tables not created

**Solution**:
```sql
-- Run schema.sql file or create tables manually
\i database/schema.sql
```

---

## 🤝 Contributing

While this is a portfolio project, suggestions are welcome:
- Security improvements (especially password hashing!)
- Code optimization ideas
- New feature suggestions
- Bug reports
- Best practice recommendations

---

## 📄 License

This project is available for educational and portfolio purposes.

---

## 👨‍💻 Developer

**Giri Dharan**  
Java Developer | Database Programmer | Security Enthusiast

**Education:**  
B.E. in Electronics and Communication Engineering  
KCG College of Technology, Chennai

**Skills Demonstrated:**
- Core Java programming
- JDBC database connectivity
- User authentication systems
- SQL and PostgreSQL
- Security awareness
- Modular code architecture
- Exception handling

---

## 🔗 Related Projects

**Java Projects:**
- [Student Management](../StudentManagement) - JDBC CRUD operations
- [Expense Tracker](../Expense) - OOP with file serialization

**Full-Stack Projects:**
- [EEG ML System](../EEG_ML) - Django + Machine Learning
- [Weather App](../Wheatherapi) - JavaScript API integration

---

## 📧 Contact

- **Email**: dharan24giri@gmail.com
- **LinkedIn**: [Giri Dharan](https://www.linkedin.com/in/giri-dharan-18179b23b)
- **GitHub**: [@gir1x](https://github.com/gir1x)
- **Phone**: +91 6379025125

---

## 🙏 Acknowledgments

- PostgreSQL community for database documentation
- JDBC specification for standardized access
- Security best practices from OWASP
- Java community for authentication patterns

---

## 📚 Technologies Deep Dive

### Why Two Modules?
- **Separation of Concerns**: Login logic separate from business logic
- **Code Reusability**: Employee methods used by both modules
- **Scalability**: Easy to add more modules (HR, Payroll, etc.)
- **Maintenance**: Changes to one module don't affect others

### Why PreparedStatement?
- Prevents SQL injection attacks
- Better performance through query caching
- Type safety for parameters
- Cleaner, more readable code

### Why PostgreSQL?
- Open-source and enterprise-grade
- ACID compliance for data integrity
- Rich feature set with excellent performance
- Strong community support

---

**Built with ☕ using Core Java and PostgreSQL**

*Secure employee management with authentication.* 👔🔐