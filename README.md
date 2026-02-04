# 💰 Java Expense Tracker Application

A command-line expense management system built with core Java, demonstrating object-oriented programming principles, file I/O operations, exception handling, and data persistence. This application provides users with comprehensive expense tracking, budget monitoring, and data storage capabilities.

[![Java](https://img.shields.io/badge/Java-ED8B00?logo=openjdk&logoColor=white)](https://www.java.com/)
[![OOP](https://img.shields.io/badge/Paradigm-OOP-blue)](https://en.wikipedia.org/wiki/Object-oriented_programming)
[![Serialization](https://img.shields.io/badge/Persistence-File_Serialization-green)]()

---

## 📋 Project Overview

This Expense Tracker is a console-based Java application that helps users manage their personal finances by tracking expenses across different categories, monitoring budgets, and persisting data between sessions. The project showcases proficiency in Java fundamentals, object-oriented design patterns, and practical software engineering principles.

**Key Highlights:**
- Clean architecture with separation of concerns (MVC-like pattern)
- Robust exception handling for data validation
- File-based data persistence using Java Serialization
- Polymorphism and inheritance with abstract classes
- User-friendly command-line interface with input validation

---

## 🛠️ Technologies & Concepts

### Core Technologies
- **Java SE 8+** - Core Java programming language
- **Java I/O** - File operations and serialization
- **Java Collections** - ArrayList for dynamic data storage
- **Scanner Class** - User input handling

### Programming Paradigms & Patterns
- **Object-Oriented Programming (OOP)**
  - Encapsulation (private fields, public methods)
  - Inheritance (Expense subclasses)
  - Polymorphism (abstract methods)
  - Abstraction (abstract Expense class)
- **Exception Handling** - Custom exceptions for validation
- **MVC-like Architecture** - Model, Service, Utility separation
- **Serialization** - Object persistence to disk

---

## ✨ Features & Functionality

### Core Features

#### 1. **Expense Management**
- Add expenses in multiple categories (Food, Travel)
- View all recorded expenses with details
- Calculate total expenses across all categories
- Date tracking for each expense entry

#### 2. **Budget Monitoring**
- Set monthly budget limits
- Real-time budget alerts when exceeded
- Budget vs. actual spending comparison
- Immediate notification system (⚠ Budget exceeded!)

#### 3. **Data Persistence**
- Automatic data saving on exit
- Load previous session data on startup
- Serialization-based file storage
- User profile persistence

#### 4. **Input Validation**
- Robust input checking for numbers
- Positive amount validation
- Custom exception handling for invalid data
- User-friendly error messages

#### 5. **User Management**
- Personalized user profiles
- User-specific budget settings
- Name-based identification

### Technical Highlights

- **Abstract Class Design**: `Expense` class provides template for category-specific expenses
- **Polymorphic Behavior**: Each expense type implements `calculateExpense()` method
- **Service Layer**: `ExpenseService` handles business logic separate from UI
- **Utility Class**: `FileUtil` manages all file operations
- **Custom Exceptions**: `InvalidExpenseException` for domain-specific errors
- **Safe Input Handling**: Helper methods prevent crashes from invalid input
- **Object Serialization**: Efficient binary data storage and retrieval

---

## 🎯 Object-Oriented Design

### Class Structure

```
Gpt_project/
├── MainApp.java                           # Entry point, UI logic
├── model/
│   ├── Expense.java (Abstract)           # Base expense class
│   ├── FoodExpense.java                  # Food category implementation
│   ├── TravelExpense.java                # Travel category implementation
│   └── User.java                         # User profile model
├── service/
│   └── ExpenseService.java               # Business logic layer
├── util/
│   └── FileUtil.java                     # File I/O operations
└── exception/
    └── InvalidExpenseException.java      # Custom exception
```

### Design Patterns Applied

1. **Template Method Pattern**: Abstract `Expense` class with `calculateExpense()`
2. **Service Layer Pattern**: Separation of business logic from presentation
3. **Utility Pattern**: Static methods for common operations
4. **Exception Handling Pattern**: Custom exceptions for validation

---

## 🚀 How to Run the Project

### Prerequisites
```bash
- Java Development Kit (JDK) 8 or higher
- Command line terminal
- Text editor or IDE (optional: IntelliJ IDEA, Eclipse, VS Code)
```

### Compilation & Execution

#### Method 1: Command Line

1. **Navigate to project directory**
   ```bash
   cd Gpt_project
   ```

2. **Compile all Java files**
   ```bash
   javac MainApp.java model/*.java service/*.java util/*.java exception/*.java
   ```

3. **Run the application**
   ```bash
   java MainApp
   ```

#### Method 2: Using IDE

1. **Import as Java Project**
   - Open IDE (IntelliJ IDEA, Eclipse, VS Code)
   - Import/Open the `Gpt_project` folder

2. **Run MainApp.java**
   - Locate `MainApp.java`
   - Right-click → Run

---

## 📖 User Guide

### Menu Options

```
1. Add Food Expense       - Record food-related spending
2. Add Travel Expense     - Record travel-related spending
3. View Expenses          - Display all expense history
4. Set Budget             - Define monthly spending limit
5. View Total             - See total expenses
6. Exit                   - Save data and exit application
```

### Usage Example

```
Enter your name: Giri
Previous data loaded.

1. Add Food Expense
2. Add Travel Expense
3. View Expenses
4. Set Budget
5. View Total
6. Exit

Choice: 4
Enter monthly budget: 10000

Choice: 1
Enter amount: 250
Expense added.

Choice: 3
Today | Food | ₹250.0

Choice: 5
Total: ₹250.0

Choice: 6
Data saved. Bye!
```

---

## 📁 Project Structure

```
Gpt_project/
│
├── MainApp.java                          # Main entry point
│   ├── User interface
│   ├── Menu loop
│   ├── Input validation methods
│   └── Expense creation
│
├── model/                                # Data models
│   ├── Expense.java (Abstract)
│   │   ├── Fields: amount, category, date
│   │   ├── Abstract method: calculateExpense()
│   │   └── toString() for display
│   │
│   ├── FoodExpense.java
│   │   └── Implements calculateExpense()
│   │
│   ├── TravelExpense.java
│   │   └── Implements calculateExpense()
│   │
│   └── User.java
│       ├── name
│       └── monthlyBudget
│
├── service/                              # Business logic
│   └── ExpenseService.java
│       ├── addExpense()
│       ├── viewExpenses()
│       ├── getTotalExpense()
│       └── checkBudget()
│
├── util/                                 # Utility classes
│   └── FileUtil.java
│       ├── saveData() - Serialization
│       └── loadData() - Deserialization
│
├── exception/                            # Custom exceptions
│   └── InvalidExpenseException.java
│
└── expense_data.ser                      # Serialized data file
```

---

## 💡 Key Java Concepts Demonstrated

### 1. Object-Oriented Programming

**Encapsulation:**
```java
private ArrayList<Expense> expenses = new ArrayList<>();

public ArrayList<Expense> getExpenses() {
    return expenses;
}
```

**Inheritance & Polymorphism:**
```java
public abstract class Expense implements Serializable {
    public abstract double calculateExpense();
}

public class FoodExpense extends Expense {
    @Override
    public double calculateExpense() {
        return amount;
    }
}
```

**Abstraction:**
```java
// Template for all expense types
public abstract class Expense {
    protected double amount;
    protected String category;
    protected String date;
}
```

### 2. Exception Handling

```java
try {
    if (amount <= 0)
        throw new InvalidExpenseException("Amount must be positive");
    // Process expense
} catch (InvalidExpenseException e) {
    System.out.println(e.getMessage());
}
```

### 3. File I/O & Serialization

```java
// Saving objects to file
try (ObjectOutputStream oos = 
        new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
    oos.writeObject(expenses);
    oos.writeObject(user);
}

// Loading objects from file
try (ObjectInputStream ois = 
        new ObjectInputStream(new FileInputStream(FILE_NAME))) {
    ArrayList<Expense> expenses = (ArrayList<Expense>) ois.readObject();
    User user = (User) ois.readObject();
}
```

### 4. Collections Framework

```java
private ArrayList<Expense> expenses = new ArrayList<>();

public void addExpense(Expense expense) {
    expenses.add(expense);
}

for (Expense e : expenses) {
    total += e.calculateExpense();
}
```

---

## 🔮 Future Enhancements

### Planned Features
- [ ] **Additional Categories**: Add Entertainment, Utilities, Healthcare categories
- [ ] **Date Filtering**: View expenses by date range
- [ ] **Edit/Delete Expenses**: Modify or remove existing entries
- [ ] **Expense Reports**: Generate monthly/yearly summaries
- [ ] **Export to CSV**: Data export for analysis
- [ ] **Multi-user Support**: Separate profiles for multiple users
- [ ] **Graphical Reports**: ASCII charts for spending visualization
- [ ] **Recurring Expenses**: Automatic monthly expense addition
- [ ] **Budget Categories**: Category-specific budget limits
- [ ] **Search Functionality**: Find expenses by keyword or amount

### Technical Improvements
- [ ] Migrate to database (MySQL, PostgreSQL, SQLite)
- [ ] Add unit tests (JUnit 5)
- [ ] Implement DAO pattern for data access
- [ ] Add logging framework (Log4j, SLF4J)
- [ ] Create GUI version (JavaFX or Swing)
- [ ] Add input validation with regex
- [ ] Implement Builder pattern for Expense creation
- [ ] Use dependency injection (Spring Framework)
- [ ] Add Maven/Gradle for dependency management
- [ ] Implement proper date handling (LocalDate)
- [ ] Add configuration file (properties/YAML)
- [ ] Create RESTful API version with Spring Boot

### Advanced Features
- [ ] Budget recommendations based on spending patterns
- [ ] Currency conversion for international expenses
- [ ] Receipt image attachment (file path storage)
- [ ] Monthly spending analytics
- [ ] Budget alerts via email/SMS
- [ ] Integration with banking APIs
- [ ] Machine learning for expense prediction

---

## 🎓 Learning Outcomes

This project demonstrates:
- **Core Java Proficiency**: Classes, objects, methods, data types
- **OOP Principles**: Inheritance, polymorphism, encapsulation, abstraction
- **Exception Handling**: Try-catch blocks, custom exceptions
- **File I/O**: Serialization and deserialization
- **Collections**: ArrayList operations and iteration
- **Clean Code**: Modular design, separation of concerns
- **User Input Handling**: Scanner class, validation
- **Software Architecture**: Layered architecture pattern

---

## 🔧 Technical Details

### Data Persistence
- **Format**: Binary serialization (.ser file)
- **Objects Stored**: ArrayList<Expense>, User
- **Serialization**: Automatic object graph persistence
- **Advantages**: Simple, built-in Java feature
- **Limitations**: Not human-readable, version-dependent

### Input Validation
```java
private static int safeInt(Scanner sc) {
    while (!sc.hasNextInt()) {
        sc.next();
        System.out.print("Enter a number: ");
    }
    return sc.nextInt();
}
```

### Budget Alert System
```java
public void checkBudget(User user) {
    if (user.getMonthlyBudget() > 0 &&
        getTotalExpense() > user.getMonthlyBudget()) {
        System.out.println("⚠ Budget exceeded!");
    }
}
```

---

## 🌐 Extensibility

The application is designed for easy extension:

1. **Add New Expense Categories**: Create new class extending `Expense`
2. **New Services**: Add methods to `ExpenseService`
3. **Different Storage**: Replace `FileUtil` with database implementation
4. **New Features**: Add to menu in `MainApp`

---

## 🤝 Contributing

While this is a portfolio project, suggestions are welcome:
- Code optimization ideas
- New feature suggestions
- Bug reports
- Design pattern improvements
- Best practice recommendations

---

## 📄 License

This project is available for educational and portfolio purposes.

---

## 👨‍💻 Developer

**Giri Dharan**  
Java Developer | Full-Stack Engineer

**Education:**  
B.E. in Electronics and Communication Engineering  
KCG College of Technology, Chennai

**Skills Demonstrated:**
- Core Java programming
- Object-oriented design
- File I/O and serialization
- Exception handling
- Clean code architecture
- Software engineering principles

---

## 🔗 Related Projects

**Frontend Projects:**
- [Weather App](../Wheatherapi) - JavaScript API integration
- [Calculator](../calculator) - Frontend application
- [Portfolio Website](../portfolio) - Responsive web design

**Full-Stack Projects:**
- [EEG ML System](../EEG_ML) - Django + Machine Learning

---

## 📧 Contact

- **Email**: dharan24giri@gmail.com
- **LinkedIn**: [Giri Dharan](https://www.linkedin.com/in/giri-dharan-18179b23b)
- **GitHub**: [@gir1x](https://github.com/gir1x)
- **Phone**: +91 6379025125

---

## 🙏 Acknowledgments

- Java documentation and tutorials
- Object-oriented programming best practices
- Clean Code principles by Robert C. Martin
- Design patterns from Gang of Four

---

## 📚 Technologies Deep Dive

### Why Serialization?
- **Pros**: Built-in Java feature, easy to implement, automatic
- **Cons**: Not human-readable, Java-specific, versioning issues
- **Alternatives**: JSON, XML, Database (SQL/NoSQL)

### Why Abstract Class?
- Provides template for all expense types
- Enforces contract for subclasses
- Enables polymorphic behavior
- Shares common fields and methods

### Why Service Layer?
- Separates business logic from UI
- Makes testing easier
- Enables code reuse
- Follows Single Responsibility Principle

---

**Built with ☕ using Core Java**

*Managing expenses, one transaction at a time.* 💰
