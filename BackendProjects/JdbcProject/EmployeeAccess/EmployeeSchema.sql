-- ================================================
-- Employee Management System - Database Schema
-- PostgreSQL Database Setup
-- ================================================

-- Database Creation
-- Note: Run this separately if database doesn't exist
-- CREATE DATABASE studentdatabase;

-- Connect to database (if using psql)
-- \c studentdatabase

-- ================================================
-- Table Creation
-- ================================================

-- Drop tables if exist (for clean setup)
DROP TABLE IF EXISTS EMPLOYEERECORD;
DROP TABLE IF EXISTS LOGINSYSTEM;

-- ================================================
-- 1. Login System Table
-- ================================================

CREATE TABLE LOGINSYSTEM (
    USERNAME VARCHAR(20) PRIMARY KEY,
    PASSWORD VARCHAR(30) NOT NULL
);

-- ================================================
-- 2. Employee Record Table
-- ================================================

CREATE TABLE EMPLOYEERECORD (
    id INT PRIMARY KEY,
    empname VARCHAR(20) NOT NULL,
    salary INT CHECK (salary > 0),
    department VARCHAR(20)
);

-- ================================================
-- Sample Data - Login System
-- ================================================

-- Sample user accounts for testing
INSERT INTO LOGINSYSTEM (USERNAME, PASSWORD) VALUES
    ('admin', 'admin123'),
    ('manager', 'manager123'),
    ('user', 'user123');

-- Note: In production, passwords should be hashed!
-- These are plain text for demonstration only.

-- ================================================
-- Sample Data - Employee Records
-- ================================================

-- Sample employee data (20 employees across 6 departments)
INSERT INTO employeerecord (id, empname, salary, department) VALUES
(1, 'Arun Kumar', 35000, 'HR'),
(2, 'Priya Sharma', 42000, 'Finance'),
(3, 'Rahul Verma', 50000, 'IT'),
(4, 'Sneha Reddy', 38000, 'Marketing'),
(5, 'Vikram Singh', 60000, 'IT'),
(6, 'Anjali Mehta', 45000, 'Finance'),
(7, 'Karthik Raj', 37000, 'HR'),
(8, 'Divya Nair', 52000, 'IT'),
(9, 'Rohit Gupta', 41000, 'Sales'),
(10, 'Meena Iyer', 39000, 'Marketing'),
(11, 'Suresh Babu', 47000, 'Operations'),
(12, 'Neha Kapoor', 43000, 'HR'),
(13, 'Ajay Patel', 55000, 'IT'),
(14, 'Pooja Das', 36000, 'Sales'),
(15, 'Manoj Kumar', 48000, 'Finance'),
(16, 'Lakshmi Devi', 51000, 'Operations'),
(17, 'Deepak Yadav', 44000, 'Marketing'),
(18, 'Kavya N', 39500, 'HR'),
(19, 'Nitin Jain', 62000, 'IT'),
(20, 'Shalini Roy', 40500, 'Sales');

-- ================================================
-- Verify Setup
-- ================================================

-- Display table structures
\d LOGINSYSTEM
\d EMPLOYEERECORD

-- View all login accounts
SELECT * FROM LOGINSYSTEM;

-- View all employees
SELECT * FROM EMPLOYEERECORD;

-- Count employees by department
SELECT department, COUNT(*) as employee_count 
FROM EMPLOYEERECORD 
GROUP BY department 
ORDER BY employee_count DESC;

-- Calculate average salary by department
SELECT department, AVG(salary) as avg_salary 
FROM EMPLOYEERECORD 
GROUP BY department 
ORDER BY avg_salary DESC;

-- ================================================
-- Useful Queries for Testing
-- ================================================

-- Find employees in IT department
-- SELECT * FROM EMPLOYEERECORD WHERE department = 'IT';

-- Find employees with salary > 50000
-- SELECT * FROM EMPLOYEERECORD WHERE salary > 50000;

-- Sort employees by salary (highest to lowest)
-- SELECT * FROM EMPLOYEERECORD ORDER BY salary DESC;

-- Update employee salary
-- UPDATE EMPLOYEERECORD SET salary = 65000 WHERE id = 5;

-- Delete specific employee
-- DELETE FROM EMPLOYEERECORD WHERE id = 20;

-- Count total employees
-- SELECT COUNT(*) as total_employees FROM EMPLOYEERECORD;

-- Find highest paid employee
-- SELECT * FROM EMPLOYEERECORD ORDER BY salary DESC LIMIT 1;

-- Find average salary
-- SELECT AVG(salary) as average_salary FROM EMPLOYEERECORD;

-- List all departments
-- SELECT DISTINCT department FROM EMPLOYEERECORD ORDER BY department;

-- ================================================
-- Advanced Queries (Optional)
-- ================================================

-- Employees with above-average salary
-- SELECT * FROM EMPLOYEERECORD 
-- WHERE salary > (SELECT AVG(salary) FROM EMPLOYEERECORD);

-- Department-wise salary statistics
-- SELECT 
--     department,
--     COUNT(*) as emp_count,
--     MIN(salary) as min_salary,
--     MAX(salary) as max_salary,
--     AVG(salary) as avg_salary,
--     SUM(salary) as total_payroll
-- FROM EMPLOYEERECORD
-- GROUP BY department
-- ORDER BY total_payroll DESC;

-- Top 5 highest paid employees
-- SELECT * FROM EMPLOYEERECORD ORDER BY salary DESC LIMIT 5;

-- Employees by salary range
-- SELECT 
--     CASE 
--         WHEN salary < 40000 THEN 'Entry Level'
--         WHEN salary BETWEEN 40000 AND 50000 THEN 'Mid Level'
--         ELSE 'Senior Level'
--     END as salary_bracket,
--     COUNT(*) as employee_count
-- FROM EMPLOYEERECORD
-- GROUP BY salary_bracket;

-- ================================================
-- Additional Indexes (Optional for Performance)
-- ================================================

-- Create index on department for faster filtering
-- CREATE INDEX idx_department ON EMPLOYEERECORD(department);

-- Create index on salary for faster sorting
-- CREATE INDEX idx_salary ON EMPLOYEERECORD(salary);

-- Create index on empname for faster searching
-- CREATE INDEX idx_empname ON EMPLOYEERECORD(empname);

-- ================================================
-- Constraints and Validation
-- ================================================

-- Add NOT NULL constraint to empname (if not already set)
-- ALTER TABLE EMPLOYEERECORD ALTER COLUMN empname SET NOT NULL;

-- Add check constraint for salary
-- ALTER TABLE EMPLOYEERECORD ADD CONSTRAINT salary_positive CHECK (salary > 0);

-- Add check constraint for valid departments (optional)
-- ALTER TABLE EMPLOYEERECORD ADD CONSTRAINT valid_department 
-- CHECK (department IN ('HR', 'IT', 'Finance', 'Sales', 'Marketing', 'Operations'));

-- ================================================
-- Cleanup Queries (Use with Caution!)
-- ================================================

-- Delete all employee records (keeps table structure)
-- TRUNCATE TABLE EMPLOYEERECORD;

-- Delete all login records
-- TRUNCATE TABLE LOGINSYSTEM;

-- Drop tables completely
-- DROP TABLE IF EXISTS EMPLOYEERECORD;
-- DROP TABLE IF EXISTS LOGINSYSTEM;

-- ================================================
-- Backup and Restore Commands
-- ================================================

-- Backup database
-- pg_dump -U giri studentdatabase > backup.sql

-- Restore database
-- psql -U giri studentdatabase < backup.sql

-- Export employee table to CSV
-- COPY EMPLOYEERECORD TO '/tmp/employees.csv' CSV HEADER;

-- Import from CSV
-- COPY EMPLOYEERECORD FROM '/tmp/employees.csv' CSV HEADER;

-- ================================================
-- End of Schema
-- ================================================

-- Success message
SELECT 'Database schema created successfully!' as status;
SELECT 'Total Login Accounts: ' || COUNT(*) FROM LOGINSYSTEM;
SELECT 'Total Employees: ' || COUNT(*) FROM EMPLOYEERECORD;