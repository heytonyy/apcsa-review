I notice you've shared information about Unit 5: Writing Classes from the AP Computer Science A curriculum. I'll create a comprehensive review guide for this unit based on the provided materials and following the structure of the Unit 1 guide you shared previously.

Let me create a complete markdown file for Unit 5: Writing Classes.

# Unit 5: Writing Classes

## Comprehensive Review Guide

## Table of Contents

1. [Unit Overview](#unit-overview)
2. [Essential Concepts](#essential-concepts)
3. [Class Definition and Structure](#class-definition-and-structure)
4. [Instance Variables and Methods](#instance-variables-and-methods)
5. [Constructors](#constructors)
6. [Method Implementation](#method-implementation)
7. [Static Variables and Methods](#static-variables-and-methods)
8. [The toString Method](#the-tostring-method)
9. [Reference Parameters](#reference-parameters)
10. [Common Coding Patterns](#common-coding-patterns)
11. [Test-Taking Strategies](#test-taking-strategies)
12. [Sample Multiple Choice Questions](#sample-multiple-choice-questions)
13. [Sample Free Response Question](#sample-free-response-question)

## Unit Overview

Unit 5 focuses on writing classes in Java, which is a fundamental concept in object-oriented programming. This unit teaches you how to create your own custom classes with appropriate behaviors, attributes, and methods. In AP CSA, writing classes represents approximately 10-15% of the exam, making it a crucial concept to master.

**Key Topics in This Unit:**
- Defining classes and creating objects
- Instance variables and methods
- Constructors and initialization
- Method design and implementation
- Static variables and methods
- Reference parameters
- The `toString` method

## Essential Concepts

### Computational Thinking Practices Addressed:
- Program design (designing and creating classes)
- Code implementation (implementing class functionality)
- Code testing (ensuring methods work as intended)

### Course Skills Developed:
- MOD-2.D: Define behaviors of an object through non-void methods without parameters written in a class
- MOD-2.F: Define behaviors of an object through non-void methods with parameters written in a class
- MOD-2.H: Define the static variables that belong to the class
- CON-2.D: Define constructors to initialize objects

## Class Definition and Structure

### Basic Class Structure:

```java
public class ClassName {
    // Instance variables (attributes)
    private dataType variableName;
    
    // Constructors
    public ClassName() {
        // Default constructor code
    }
    
    // Methods
    public returnType methodName(parameters) {
        // Method code
    }
}
```

### Example: Simple Student Class

```java
public class Student {
    // Instance variables
    private String name;
    private int gradeLevel;
    private double gpa;
    
    // Constructor
    public Student(String name, int gradeLevel, double gpa) {
        this.name = name;
        this.gradeLevel = gradeLevel;
        this.gpa = gpa;
    }
    
    // Methods
    public String getName() {
        return name;
    }
    
    public int getGradeLevel() {
        return gradeLevel;
    }
    
    public double getGpa() {
        return gpa;
    }
    
    public void setGpa(double newGpa) {
        gpa = newGpa;
    }
    
    public String toString() {
        return name + " (Grade " + gradeLevel + "): " + gpa;
    }
}
```

## Instance Variables and Methods

### Instance Variables:
- Represent the properties/attributes of an object
- Typically declared as `private` (encapsulation)
- Initialization happens in constructors
- Accessed and modified through accessor and mutator methods

```java
// Example of instance variables
private String title;
private double price;
private int quantity;
```

### Accessor Methods (Getters):
- Return the value of an instance variable
- Typically named `getVariableName()`
- Do not modify the state of the object

```java
// Example of accessor methods
public String getTitle() {
    return title;
}

public double getPrice() {
    return price;
}

public int getQuantity() {
    return quantity;
}
```

### Mutator Methods (Setters):
- Change the value of an instance variable
- Typically named `setVariableName()`
- Can include validation logic

```java
// Example of mutator methods
public void setTitle(String newTitle) {
    title = newTitle;
}

public void setPrice(double newPrice) {
    if (newPrice >= 0) {
        price = newPrice;
    }
}

public void setQuantity(int newQuantity) {
    if (newQuantity >= 0) {
        quantity = newQuantity;
    }
}
```

### Other Methods:
- Implement behaviors specific to the class
- May use instance variables in calculations
- May return values or modify the object's state

```java
// Example of other methods
public double getTotalValue() {
    return price * quantity;
}

public void increaseQuantity(int amount) {
    quantity += amount;
}

public boolean isOutOfStock() {
    return quantity == 0;
}
```

## Constructors

### Purpose of Constructors:
- Initialize a new object's instance variables
- Ensure the object is in a valid initial state
- Called when an object is created using the `new` keyword

### Default Constructor:
- Takes no parameters
- Provided by Java if no constructors are defined
- Sets instance variables to default values (0, null, false)

```java
public class Book {
    private String title;
    private double price;
    
    // Default constructor
    public Book() {
        title = "Unknown";
        price = 0.0;
    }
}
```

### Parameterized Constructors:
- Accept arguments to initialize instance variables
- Can provide different ways to create objects
- May include validation logic

```java
public class Book {
    private String title;
    private double price;
    
    // Parameterized constructor
    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }
}
```

### Overloaded Constructors:
- Multiple constructors with different parameter lists
- Allows for flexible object creation
- May call other constructors using `this()`

```java
public class Book {
    private String title;
    private double price;
    private String author;
    
    // Constructor with all parameters
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    
    // Constructor with some parameters
    public Book(String title, String author) {
        this(title, author, 9.99); // Calls the first constructor
    }
    
    // Default constructor
    public Book() {
        this("Unknown", "Unknown", 0.0); // Calls the first constructor
    }
}
```

### The `this` Keyword:
- Refers to the current object
- Used to distinguish between instance variables and parameters with the same name
- Can be used to call another constructor

```java
public class Rectangle {
    private double length;
    private double width;
    
    public Rectangle(double length, double width) {
        this.length = length; // "this.length" refers to the instance variable
        this.width = width;   // "width" alone would refer to the parameter
    }
}
```

## Method Implementation

### Method Structure:
- Access modifier (`public`, `private`, etc.)
- Return type (or `void` if no return value)
- Method name (usually begins with a verb)
- Parameter list (if any)
- Method body

```java
public double calculateArea(double radius) {
    return Math.PI * radius * radius;
}
```

### Non-void Methods:
- Return a value using the `return` statement
- Return type must match the declared type
- Define behaviors of an object through computational process

```java
// Example of non-void methods
public double getDiscountPrice() {
    return price * 0.9; // 10% discount
}

public String getFormattedPrice() {
    return "$" + price;
}
```

### Void Methods:
- Do not return a value
- Used to change the state of an object
- End with `return;` (optional)

```java
// Example of void methods
public void applyDiscount(double percentage) {
    price = price * (1 - percentage/100);
}

public void reset() {
    title = "Unknown";
    price = 0.0;
    quantity = 0;
}
```

### Method Overloading:
- Multiple methods with the same name but different parameter lists
- Determined by the number, type, and order of parameters
- Return type alone cannot distinguish overloaded methods

```java
// Method overloading examples
public void setDimensions(double length, double width) {
    this.length = length;
    this.width = width;
}

public void setDimensions(double side) {
    this.length = side;
    this.width = side;
}
```

## Static Variables and Methods

### Static Variables:
- Belong to the class, not to any instance
- Shared among all instances of the class
- Declared with the `static` keyword
- Can be `public` or `private`
- Used with the class name and dot operator

```java
public class Counter {
    private int value;
    private static int totalCount = 0; // Static variable
    
    public Counter() {
        value = 0;
        totalCount++; // Increment when a new Counter is created
    }
    
    public static int getTotalCount() {
        return totalCount;
    }
}
```

### Static Methods:
- Belong to the class, not to any instance
- Cannot access instance variables or non-static methods directly
- Used with the class name and dot operator
- Often used for utility functions

```java
public class MathUtils {
    public static double square(double x) {
        return x * x;
    }
    
    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }
}

// Usage:
double result = MathUtils.square(5.0);
int maximum = MathUtils.max(10, 20);
```

### When to Use Static:
- For class-wide constants: `public static final double PI = 3.14159;`
- For counters that track class-wide information
- For utility methods that don't require object state
- For methods that create objects of the class (factory methods)

```java
public class Circle {
    private double radius;
    public static final double PI = 3.14159; // Static constant
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    public double getArea() {
        return PI * radius * radius;
    }
    
    // Static factory method
    public static Circle createUnitCircle() {
        return new Circle(1.0);
    }
}
```

## The toString Method

### Purpose of toString:
- Provides a string representation of an object
- Called automatically when an object is used with `System.out.print()` or `println()`
- Overrides the default `toString()` method from the `Object` class

### Implementation:
- Must be `public`
- Must return a `String`
- No parameters
- Should include important instance variables

```java
public class Student {
    private String name;
    private int id;
    private double gpa;
    
    // Constructor and other methods...
    
    public String toString() {
        return "Student: " + name + " (ID: " + id + ", GPA: " + gpa + ")";
    }
}
```

### Usage Example:

```java
Student student = new Student("Alice", 12345, 3.85);
System.out.println(student); // Implicitly calls student.toString()

// Output: Student: Alice (ID: 12345, GPA: 3.85)
```

## Reference Parameters

### Reference vs. Value:
- Primitive types are passed by value (copy of the value)
- Objects are passed by reference (reference to the memory location)

### Passing Objects as Parameters:
- When an object is passed to a method, a copy of the reference is passed
- Both references point to the same object in memory
- Changes to the object are visible outside the method

```java
public class Counter {
    private int value;
    
    // Constructor and other methods...
    
    // Method that modifies another object
    public void transferTo(Counter other) {
        other.value += this.value;
        this.value = 0;
    }
}
```

### Aliasing:
- Multiple references to the same object
- Changes through one reference affect all references
- Important to understand for mutable objects

```java
// Example of aliasing
Student s1 = new Student("Bob", 12346, 3.5);
Student s2 = s1; // s2 and s1 point to the same object

s2.setGpa(3.7); // Changes GPA for both s1 and s2
System.out.println(s1.getGpa()); // Outputs 3.7
```

### Parameter Passing Examples:

```java
public class ParameterExample {
    public static void main(String[] args) {
        // Primitive parameter
        int x = 5;
        modifyValue(x);
        System.out.println(x); // Still 5, unchanged
        
        // Object parameter
        Counter c = new Counter();
        c.setValue(5);
        modifyObject(c);
        System.out.println(c.getValue()); // Now 10, changed
    }
    
    public static void modifyValue(int num) {
        num = num * 2; // Only changes the local copy
    }
    
    public static void modifyObject(Counter counter) {
        counter.setValue(counter.getValue() * 2); // Changes the original object
    }
}
```

## Common Coding Patterns

### Pattern 1: Creating and Using Objects

```java
// Creating an object
Car myCar = new Car("Toyota", "Camry", 2022);

// Using object methods
myCar.drive(100);
double fuelRemaining = myCar.getFuelLevel();
System.out.println(myCar); // Uses toString
```

### Pattern 2: Encapsulation with Private Variables and Public Methods

```java
public class BankAccount {
    private String accountNumber;
    private double balance;
    
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
    
    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
}
```

### Pattern 3: Static Counter Pattern

```java
public class Student {
    private static int nextId = 1000;
    private int id;
    private String name;
    
    public Student(String name) {
        this.name = name;
        this.id = nextId;
        nextId++;
    }
    
    public int getId() {
        return id;
    }
}

// Usage:
Student s1 = new Student("Alice"); // id = 1000
Student s2 = new Student("Bob");   // id = 1001
Student s3 = new Student("Carol"); // id = 1002
```

### Pattern 4: Object Composition

```java
public class Address {
    private String street;
    private String city;
    private String state;
    private String zipCode;
    
    // Constructor and methods...
}

public class Person {
    private String name;
    private Address homeAddress; // Composition
    
    public Person(String name, Address address) {
        this.name = name;
        this.homeAddress = address;
    }
    
    // Methods to access and modify the address
    public Address getHomeAddress() {
        return homeAddress;
    }
    
    public void setHomeAddress(Address newAddress) {
        homeAddress = newAddress;
    }
}
```

## Test-Taking Strategies

### For Multiple Choice Questions:

1. **Identify Object Creation and Method Calls**: Understand when new objects are created and how methods affect object state.
2. **Track Instance Variable Values**: Keep track of how instance variables change through method calls.
3. **Understand Static vs. Instance Context**: Know that static methods can't directly access instance variables.
4. **Watch for Object References**: Pay attention to when objects share references (aliasing).
5. **Pay Attention to this Keyword**: Understand how `this` distinguishes instance variables from parameters.
6. **Method Signatures**: Pay attention to return types and parameter lists.
7. **Constructor Overloading**: Understand which constructor is called in different scenarios.

### For Free Response Questions:

1. **Implement All Required Functionality**: Ensure your class implements all methods specified in the problem.
2. **Use Proper Encapsulation**: Make instance variables private and provide appropriate accessor/mutator methods.
3. **Handle Edge Cases**: Consider what happens with invalid input or special conditions.
4. **Use Meaningful Variable Names**: Choose names that reflect the purpose of variables and methods.
5. **Write Clean, Well-Commented Code**: Make your code readable and include comments to explain complex logic.
6. **Test Mental Models**: Visualize how objects would behave when methods are called.
7. **Double-Check Method Headers**: Ensure your method signatures match the requirements.

## Sample Multiple Choice Questions

### Question 1

Consider the following class:

```java
public class Counter {
    private int count;
    
    public Counter() {
        count = 0;
    }
    
    public void increment() {
        count++;
    }
    
    public int getCount() {
        return count;
    }
    
    public static void resetCounter(Counter c) {
        c.count = 0;
    }
}
```

What is the output of the following code segment?

```java
Counter c1 = new Counter();
Counter c2 = new Counter();
c1.increment();
c1.increment();
c2.increment();
Counter.resetCounter(c1);
System.out.println(c1.getCount() + " " + c2.getCount());
```

- A) 0 0  
- B) 0 1  
- C) 2 1  
- D) 2 0  
- E) 0 null  

### Question 2

Consider the following class:

```java
public class Rectangle {
    private double length;
    private double width;
    
    public Rectangle(double len, double w) {
        length = len;
        width = w;
    }
    
    public double getArea() {
        return length * width;
    }
    
    public void resize(double factor) {
        length *= factor;
        width *= factor;
    }
}
```

What is the value of `area` after the following code segment executes?

```java
Rectangle rect = new Rectangle(4, 5);
rect.resize(2);
double area = rect.getArea();
```

- A) 20  
- B) 40  
- C) 80  
- D) 100  
- E) 160  

### Question 3

Consider the following class:

```java
public class Student {
    private static int nextId = 100;
    private String name;
    private int id;
    
    public Student(String name) {
        this.name = name;
        id = nextId;
        nextId++;
    }
    
    public int getId() {
        return id;
    }
}
```

What are the values of `id1`, `id2`, and `id3` after the following code segment executes?

```java
Student s1 = new Student("Alice");
int id1 = s1.getId();
Student s2 = new Student("Bob");
int id2 = s2.getId();
Student s3 = new Student("Carol");
int id3 = s3.getId();
```

- A) 100, 100, 100  
- B) 100, 101, 102  
- C) 101, 102, 103  
- D) 0, 1, 2  
- E) null, null, null  

### Question 4

Consider the following class:

```java
public class Box {
    private double length;
    private double width;
    private double height;
    
    public Box(double side) {
        length = side;
        width = side;
        height = side;
    }
    
    public Box(double l, double w, double h) {
        length = l;
        width = w;
        height = h;
    }
    
    public double getVolume() {
        return length * width * height;
    }
    
    public String toString() {
        return length + " x " + width + " x " + height;
    }
}
```

What is the output of the following code segment?

```java
Box box1 = new Box(3);
Box box2 = new Box(2, 4, 5);
System.out.println(box1 + " has volume " + box1.getVolume());
```

- A) Box@A75BD24 has volume 27.0  
- B) 3.0 x 3.0 x 3.0 has volume 27.0  
- C) 3 x 3 x 3 has volume 27  
- D) 2 x 4 x 5 has volume 40  
- E) 3 has volume 27.0  

### Question 5

Consider the following class:

```java
public class Point {
    private int x;
    private int y;
    
    public Point(int initialX, int initialY) {
        x = initialX;
        y = initialY;
    }
    
    public int getX() { return x; }
    public int getY() { return y; }
    
    public void translate(int dx, int dy) {
        x += dx;
        y += dy;
    }
    
    public static double distance(Point p1, Point p2) {
        int dx = p2.x - p1.x;
        int dy = p2.y - p1.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}
```

Which of the following statements is TRUE about the `distance` method?

- A) It is an instance method that returns the distance from any point to this point.  
- B) It is a static method that cannot access the private instance variables of Points.  
- C) It is a static method that can access the private instance variables of Points.  
- D) It should be called using `point1.distance(point2)`.  
- E) It cannot be static because it uses instance variables.  


## Sample Free Response Question

### Question: Design a Library Catalog System

Design a `Book` class that could be used in a library catalog system. Your class should include:

1. Private instance variables for title, author, ISBN, and availability status
2. A constructor that initializes all instance variables
3. Accessor methods for all instance variables
4. A method to check out the book (if available)
5. A method to return the book
6. A toString method that returns a string representation of the book

Additionally, design a `Library` class that:
1. Has a static variable tracking the total number of books across all libraries
2. Has instance variables for library name and a counter for books in this specific library
3. Has a method to add a book to the library (increments both counters)
4. Has static and instance methods to access the respective counters

**Key Points to Include in Your Answer:**
1. Proper encapsulation with private instance variables
2. Appropriate constructors that initialize all necessary variables
3. Accessor methods (getters) for all relevant instance variables
4. Methods that implement the required functionality (checkout, return)
5. A proper toString method that includes relevant information
6. Static variable and method implementation in the Library class
7. Proper implementation of instance counters vs. static counters