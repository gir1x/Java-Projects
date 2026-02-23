##🎓 Java Student Management System - JDBC Application

A console-based student record management system built with Core Java and PostgreSQL, demonstrating JDBC connectivity, SQL operations, and database-driven application development. This application provides comprehensive CRUD functionality for managing student records with proper error handling and SQL injection prevention.

[![Java](https://img.shields.io/badge/Java-ED8B00?logo=openjdk&logoColor=white)](https://www.java.com/)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?logo=postgresql&logoColor=white)](https://www.postgresql.org/)
[![JDBC](https://img.shields.io/badge/JDBC-Database_Connectivity-blue)]()

---

## 📋 Project Overview

This Student Management System is a command-line application that helps manage student records in a PostgreSQL database. The project showcases proficiency in JDBC programming, SQL operations, database design, and building production-ready database applications with proper separation of concerns.

**Key Highlights:**
- Complete CRUD operations (Create, Read, Update, Delete)
- PostgreSQL database integration using JDBC
- PreparedStatement for SQL injection prevention
- Clean separation of database logic and presentation layer
- Robust exception handling and resource management
- Menu-driven command-line interface

---

## 🛠️ Technologies & Concepts

### Core Technologies
- **Java SE 8+** - Core Java programming language
- **JDBC (Java Database Connectivity)** - Database communication API
- **PostgreSQL 12+** - Relational database management system
- **Scanner Class** - User input handling

### Programming Paradigms & Patterns
- **Database Programming**
  - JDBC connectivity and configuration
  - PreparedStatement (parameterized queries)
  - ResultSet processing and iteration
  - Try-with-resources for connection management
- **Exception Handling** - Comprehensive error catching
- **Separation of Concerns** - Database operations separated from UI
- **SQL Operations** - DDL, DML, and querying

---

## ✨ Features & Functionality

### Core Features

#### 1. **Insert Student Record**
- Add new students with ID, name, age, and course
- Input validation through database constraints
- Confirmation message on successful insertion
- Duplicate ID prevention via primary key

#### 2. **View All Students**
- Display complete list of student records
- Formatted table-like output showing all fields
- Empty table handling with appropriate messages
- Clean data presentation

#### 3. **Search by ID**
- Quick lookup of specific student by unique ID
- Display individual student details
- Not found handling for invalid IDs
- Efficient indexed search

#### 4. **Update Student Information**
- Modify any field (name, age, course) dynamically
- Column selection by user input
- Update confirmation with row count
- Flexible field updating

#### 5. **Delete Student Record**
- Remove student from database by ID
- Permanent deletion with confirmation
- Row count feedback
- Cascade handling (if applicable)

#### 6. **Exit Application**
- Graceful shutdown with closing message
- Automatic resource cleanup
- Thread-based exit animation
- Data persistence guaranteed

### Technical Highlights

- **PreparedStatement Usage**: Prevents SQL injection attacks through parameterized queries
- **Try-with-Resources**: Automatic connection and resource management preventing leaks
- **Exception Handling**: Comprehensive error catching with stack trace logging
- **Modular Architecture**: Database operations separated in `StudentRecord` class
- **Connection Management**: Proper opening and closing of database connections
- **Input Validation**: Safe integer and string input handling

---

## 🎯 Database Design

### Table Schema

```sql
CREATE TABLE StudentRecord (
    id INT PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    age INT CHECK (age > 0),
    course VARCHAR(20)
);
```

### Database Configuration

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
- PostgreSQL 12+ installed and running
- PostgreSQL JDBC driver (postgresql-42.7.0.jar)
- Command line terminal or IDE
```

### Database Setup

#### Step 1: Install PostgreSQL
```bash
# Ubuntu/Debian
sudo apt update
sudo apt install postgresql postgresql-contrib

# macOS (Homebrew)
brew install postgresql@14

# Windows
# Download installer from postgresql.org
```

#### Step 2: Create Database
```bash
# Login to PostgreSQL
psql -U postgres

# Create database
CREATE DATABASE studentdatabase;

# Connect to database
\c studentdatabase

# Create table
CREATE TABLE StudentRecord (
    id INT PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    age INT CHECK (age > 0),
    course VARCHAR(20)
);

# Exit
\q
```

### Application Setup

#### Method 1: Command Line

1. **Download JDBC Driver**
   - Visit: https://jdbc.postgresql.org/download/
   - Download `postgresql-42.7.0.jar`

2. **Update Database Credentials**
   ```java
   // In Main.java
   private static final String DB_URL = "jdbc:postgresql://localhost:5432/studentdatabase";
   private static final String DB_USER = "your_username";
   private static final String DB_PASSWORD = "your_password";
   ```

3. **Compile with JDBC Driver**
   ```bash
   javac -cp .:postgresql-42.7.0.jar com/g1rix/javalearning/*.java
   ```

4. **Run the Application**
   ```bash
   java -cp .:postgresql-42.7.0.jar com.g1rix.javalearning.Main
   ```

#### Method 2: Using IDE (IntelliJ IDEA)

1. **Import Project**
   - File → New → Project from Existing Sources
   - Select project directory

2. **Add JDBC Driver**
   - File → Project Structure → Libraries
   - Click "+" → Java
   - Select `postgresql-42.7.0.jar`

3. **Update Credentials**
   - Edit `Main.java` with your database details

4. **Run**
   - Right-click `Main.java` → Run

---

## 📖 User Guide

### Menu Options

```
1. Insert             - Add new student record
2. View All           - Display all students
3. Get by ID          - Search specific student
4. Update name|course - Modify student information
5. Delete Specific    - Remove student record
6. Exit               - Save and close application
```

### Usage Example

```
Choose: 1
Insert student records...
Enter id: 101
Enter name: Alice
Enter age: 20
Enter course: Computer Science
Inserted Record

Choose: 2

Id: 101    Name: Alice     Age: 20     Course: Computer Science

Choose: 4
Enter Id: 101
Enter Column to update: course
Enter course detail: Software Engineering
1 record updated

Choose: 3
Enter Id: 101

Id: 101    Name: Alice     Age: 20     Course: Software Engineering

Choose: 6
Exiting From Program...
```

---

## 📁 Project Structure

```
student-management-jdbc/
│
├── Main.java                             # Entry point
│   ├── Database connection setup
│   ├── Menu-driven interface
│   ├── Scanner for user input
│   └── Method delegation to StudentRecord
│
├── StudentRecord.java                    # Database operations
│   ├── insert()        - Add new student
│   ├── viewAll()       - Display all records
│   ├── searchById()    - Find by ID
│   ├── updateCourse()  - Update fields
│   ├── deleteRecord()  - Remove student
│   └── exitApplication() - Graceful exit
│
└── database/
    └── studentdatabase (PostgreSQL)
        └── StudentRecord table
```

---

## 💡 Key Java Concepts Demonstrated

### 1. JDBC Connectivity

**Database Connection:**
```java
try (
    Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    Scanner scan = new Scanner(System.in)
) {
    // Database operations
}
```

**Try-with-Resources Benefits:**
- Automatic resource cleanup
- No connection leaks
- Cleaner code structure
- Exception safety

### 2. PreparedStatement (SQL Injection Prevention)

**Secure Parameterized Query:**
```java
String Query = "INSERT INTO STUDENTRECORD VALUES(?,?,?,?)";
PreparedStatement ps = connect.prepareStatement(Query);
ps.setInt(1, id);
ps.setString(2, name);
ps.setInt(3, age);
ps.setString(4, course);

int row = ps.executeUpdate();
```

**Why PreparedStatement?**
- Prevents SQL injection attacks
- Better performance (query compilation)
- Type safety
- Code readability

### 3. ResultSet Processing

**Iterating Through Results:**
```java
String Query = "SELECT * FROM STUDENTRECORD";
PreparedStatement ps = connect.prepareStatement(Query);
ResultSet rs = ps.executeQuery();

while(rs.next()) {
    System.out.println(
        "\nId: " + rs.getInt("id") +
        "\tName: " + rs.getString("name") +
        "\tAge: " + rs.getInt("age") +
        "\tCourse: " + rs.getString("course")
    );
}
```

### 4. Dynamic SQL Updates

**User-Controlled Column Updates:**
```java
System.out.println("Enter Column to update");
String columnName = scan.nextLine();

System.out.println("Enter new value");
String newValue = scan.nextLine();

String Query = "UPDATE STUDENTRECORD SET " + columnName + " = ? WHERE ID = ?";
PreparedStatement ps = connect.prepareStatement(Query);
ps.setString(1, newValue);
ps.setInt(2, id);

int rows = ps.executeUpdate();
```

---

## 🔮 Future Enhancements

### Planned Features
- [ ] **Bulk Operations**: Import/export CSV files
- [ ] **Search Filters**: Find by name, course, age range
- [ ] **Sorting Options**: Order by name, age, ID, course
- [ ] **Pagination**: Handle large datasets efficiently
- [ ] **Attendance Module**: Track student attendance
- [ ] **Grade Management**: Add marks/grade tracking
- [ ] **Course Management**: Separate course table with foreign keys
- [ ] **Student Photos**: Store image paths or BLOBs
- [ ] **Report Generation**: PDF/Excel exports
- [ ] **Backup/Restore**: Database backup functionality

### Technical Improvements
- [ ] Implement DAO (Data Access Object) pattern
- [ ] Add connection pooling (HikariCP, Apache DBCP)
- [ ] Use logging framework (Log4j, SLF4J)
- [ ] Add unit tests (JUnit 5, Mockito)
- [ ] Create configuration file for database settings
- [ ] Implement transaction management
- [ ] Add input validation with regex
- [ ] Create stored procedures for complex operations
- [ ] Migrate to ORM framework (Hibernate, JPA)
- [ ] Build REST API with Spring Boot
- [ ] Create GUI version (JavaFX, Swing)
- [ ] Add database migration tools (Flyway, Liquibase)

### Advanced Features
- [ ] Multi-table joins (students, courses, departments)
- [ ] User authentication and authorization
- [ ] Role-based access control (admin, teacher, student)
- [ ] Audit logging for all operations
- [ ] Email notifications for important events
- [ ] Dashboard with analytics and charts
- [ ] Mobile app integration via REST API

---

## 🎓 Learning Outcomes

This project demonstrates:
- **JDBC Fundamentals**: Connection, Statement, PreparedStatement, ResultSet
- **Database Operations**: INSERT, SELECT, UPDATE, DELETE
- **SQL Knowledge**: DDL, DML, constraints, primary keys
- **Connection Management**: Try-with-resources, connection pooling concepts
- **Security**: SQL injection prevention
- **Error Handling**: SQLException catching and logging
- **Clean Code**: Separation of database logic from presentation
- **Resource Management**: Proper opening and closing of connections

---

## 🔧 Technical Details

### Connection String Breakdown
```java
jdbc:postgresql://localhost:5432/studentdatabase
│    │          │         │     │
│    │          │         │     └─ Database name
│    │          │         └─────── Port number
│    │          └─────────────────── Host
│    └────────────────────────────── Database type
└─────────────────────────────────── Protocol
```

### PreparedStatement vs Statement

| Feature | PreparedStatement | Statement |
|---------|------------------|-----------|
| SQL Injection | ✅ Protected | ❌ Vulnerable |
| Performance | ✅ Faster (compiled once) | ❌ Slower |
| Readability | ✅ Clean | ❌ String concatenation |
| Type Safety | ✅ Type checking | ❌ Manual conversion |

### Database Constraints

```sql
-- Primary Key: Ensures unique IDs
id INT PRIMARY KEY

-- NOT NULL: Name is mandatory
name VARCHAR(20) NOT NULL

-- CHECK: Age must be positive
age INT CHECK (age > 0)
```

---

## 🌐 Extensibility

The application is designed for easy extension:

1. **Add New Tables**: Create related tables (courses, departments)
2. **New Operations**: Add methods to `StudentRecord` class
3. **Different Database**: Change JDBC URL and driver
4. **Enhanced UI**: Replace Scanner with GUI framework
5. **Web Interface**: Create servlet-based web application

---

## 🛡️ Security Best Practices

### Current Implementation
✅ **PreparedStatement**: Prevents SQL injection  
✅ **Try-with-Resources**: Prevents connection leaks  
✅ **Exception Handling**: Logs errors without exposing details  

### Recommended for Production
```java
// Use environment variables
String dbUrl = System.getenv("DB_URL");
String dbUser = System.getenv("DB_USER");
String dbPassword = System.getenv("DB_PASSWORD");

// Or use properties file
Properties props = new Properties();
props.load(new FileInputStream("config.properties"));
```

### Security Checklist
- [ ] Don't hardcode credentials in source code
- [ ] Use encrypted connections (SSL/TLS)
- [ ] Implement user authentication
- [ ] Add input validation and sanitization
- [ ] Log security events
- [ ] Regular security updates for JDBC driver
- [ ] Database user with minimal privileges
- [ ] Encrypt sensitive data in database

---

## 🐛 Troubleshooting

### Common Issues

#### 1. ClassNotFoundException: org.postgresql.Driver
**Cause**: JDBC driver not in classpath

**Solution**:
```bash
# Download driver
wget https://jdbc.postgresql.org/download/postgresql-42.7.0.jar

# Add to classpath
javac -cp .:postgresql-42.7.0.jar Main.java
java -cp .:postgresql-42.7.0.jar com.g1rix.javalearning.Main
```

#### 2. Connection refused
**Cause**: PostgreSQL not running

**Solution**:
```bash
# Check status
sudo systemctl status postgresql

# Start PostgreSQL
sudo systemctl start postgresql

# Enable auto-start
sudo systemctl enable postgresql
```

#### 3. Authentication failed
**Cause**: Wrong username/password

**Solution**:
- Update credentials in `Main.java`
- Or create PostgreSQL user:
```sql
CREATE USER your_username WITH PASSWORD 'your_password';
GRANT ALL PRIVILEGES ON DATABASE studentdatabase TO your_username;
```

#### 4. Table does not exist
**Cause**: Table not created

**Solution**:
```sql
-- Connect to database
psql -U postgres -d studentdatabase

-- Create table
CREATE TABLE StudentRecord (
    id INT PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    age INT CHECK (age > 0),
    course VARCHAR(20)
);
```

---

## 🤝 Contributing

While this is a portfolio project, suggestions are welcome:
- Code optimization ideas
- Security improvements
- Feature suggestions
- Bug reports
- Best practice recommendations

---

## 📄 License

This project is available for educational and portfolio purposes.

---

## 👨‍💻 Developer

**Giri Dharan**  
Java Developer | Database Programmer

**Education:**  
B.E. in Electronics and Communication Engineering  
KCG College of Technology, Chennai

**Skills Demonstrated:**
- Core Java programming
- JDBC database connectivity
- SQL and PostgreSQL
- Database design and operations
- Exception handling
- Clean code architecture

---

## 🔗 Related Projects

**Java Projects:**
- [Expense Tracker](../Expense) - OOP-based expense management with file persistence

**Full-Stack Projects:**
- [EEG ML System](../EEG_ML) - Django + Machine Learning + PostgreSQL
- [Weather App](../Wheatherapi) - JavaScript API integration

---

## 📧 Contact

- **Email**: dharan24giri@gmail.com
- **LinkedIn**: [Giri Dharan](https://www.linkedin.com/in/giri-dharan-18179b23b)
- **GitHub**: [@gir1x](https://github.com/gir1x)
- **Phone**: +91 6379025125

---

## 🙏 Acknowledgments

- PostgreSQL community for excellent documentation
- JDBC specification for standardized database access
- Java community for best practices
- Stack Overflow for troubleshooting help

---

## 📚 Resources

**Official Documentation:**
- [JDBC Tutorial](https://docs.oracle.com/javase/tutorial/jdbc/)
- [PostgreSQL Documentation](https://www.postgresql.org/docs/)
- [PreparedStatement API](https://docs.oracle.com/javase/8/docs/api/java/sql/PreparedStatement.html)

**Learning Resources:**
- Oracle JDBC Guide
- PostgreSQL JDBC Driver Documentation
- Database Programming Best Practices
- SQL Injection Prevention Techniques

---

**Built with ☕ using Java, JDBC, and PostgreSQL**

*Managing student records with professional database operations.* 🎓