# Quick Setup Guide

## 🚀 5-Minute Setup

### Step 1: Clone Repository
```bash
git clone https://github.com/gir1x/student-management-jdbc.git
cd student-management-jdbc
```

### Step 2: Setup Database
```bash
# Login to PostgreSQL
psql -U postgres

# Run in psql:
CREATE DATABASE studentdatabase;
\c studentdatabase
\i database/schema.sql
\q
```

### Step 3: Configure Application
Edit `src/com/g1rix/javalearning/Main.java`:
```java
private static final String DB_USER = "your_username";
private static final String DB_PASSWORD = "your_password";
```

### Step 4: Add JDBC Driver
- Download: https://jdbc.postgresql.org/download/
- Add to classpath in your IDE

### Step 5: Compile & Run
```bash
# Compile
javac src/com/g1rix/javalearning/*.java

# Run
java -cp src com.g1rix.javalearning.Main
```

---

## 📋 Pre-requisites Checklist

- [ ] JDK 8 or higher installed
- [ ] PostgreSQL 12+ installed and running
- [ ] PostgreSQL JDBC driver downloaded
- [ ] IDE configured (optional but recommended)

---

## 🆘 Quick Troubleshooting

**Can't connect to database?**
```bash
# Check if PostgreSQL is running
sudo systemctl status postgresql

# Start PostgreSQL
sudo systemctl start postgresql
```

**JDBC driver not found?**
- Ensure `.jar` file is in classpath
- For Maven users: Add dependency to `pom.xml`

**Authentication failed?**
- Verify username/password in `Main.java`
- Check PostgreSQL user exists: `psql -U postgres -c "\du"`

---

## 📱 Test Your Setup

Run these commands in your application:
1. Choose option `1` - Insert a test record
2. Choose option `2` - View all records
3. Choose option `6` - Exit

If all three work, you're good to go! ✅

---

**Need help?** Open an issue on GitHub or contact: dharan24giri@gmail.com