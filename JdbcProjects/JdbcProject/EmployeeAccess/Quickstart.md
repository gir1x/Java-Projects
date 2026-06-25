# 🚀 Quick Setup Guide - Employee Management System

## 5-Minute Setup

### Step 1: Database Setup
```bash
# Login to PostgreSQL
psql -U postgres

# Create database and run schema
CREATE DATABASE studentdatabase;
\c studentdatabase
\i database/employee_schema.sql
\q
```

### Step 2: Configure Application
Update credentials in both files:
- `com/g1rix/javalearning/loginSystem/Main.java`
- `com/g1rix/javalearning/EmployeeDetails/mainOfEmployee.java`

```java
private static final String DB_USER = "your_username";
private static final String DB_PASSWORD = "your_password";
```

### Step 3: Add JDBC Driver
- Download: https://jdbc.postgresql.org/download/postgresql-42.7.0.jar
- Add to classpath in your IDE

### Step 4: Compile & Run
```bash
# Compile
javac -cp .:postgresql-42.7.0.jar com/g1rix/javalearning/**/*.java

# Run with authentication
java -cp .:postgresql-42.7.0.jar com.g1rix.javalearning.loginSystem.Main

# OR run direct employee access
java -cp .:postgresql-42.7.0.jar com.g1rix.javalearning.EmployeeDetails.mainOfEmployee
```

---

## 📋 Default Test Credentials

After running schema.sql, use these accounts:

| Username | Password | Purpose |
|----------|----------|---------|
| admin | admin123 | Administrator |
| manager | manager123 | Manager |
| user | user123 | Regular user |

⚠️ **Note**: Change these passwords in production!

---

## 🎯 Quick Test Flow

1. **Run Main.java** (with login)
2. Choose option `1` - New Registration
3. Create your account
4. Choose option `2` - Login
5. Enter credentials
6. Access employee management menu
7. Try adding an employee (option `1`)
8. View all employees (option `2`)

---

## 🆘 Troubleshooting

**PostgreSQL not running?**
```bash
sudo systemctl start postgresql
sudo systemctl status postgresql
```

**JDBC driver not found?**
- Ensure `.jar` file is in classpath
- Check IDE library configuration

**Tables don't exist?**
```sql
-- Verify tables
\dt

-- If missing, run schema again
\i database/employee_schema.sql
```

**Login fails?**
- Use default credentials from schema.sql
- Or register new account first

---

## 📊 Sample Data Overview

The schema includes:
- ✅ 3 test login accounts
- ✅ 20 sample employees
- ✅ 6 departments (HR, IT, Finance, Sales, Marketing, Operations)
- ✅ Salary range: ₹35,000 - ₹62,000

---

## 🔄 Two Ways to Run

### Option A: With Authentication (Recommended)
```bash
java com.g1rix.javalearning.loginSystem.Main
```
- Requires login
- Secure access
- User management

### Option B: Direct Employee Access
```bash
java com.g1rix.javalearning.EmployeeDetails.mainOfEmployee
```
- No login required
- Direct to employee menu
- Good for testing

---

**Need help?** Contact: dharan24giri@gmail.com