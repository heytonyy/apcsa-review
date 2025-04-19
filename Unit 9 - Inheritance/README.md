# Unit 9: Inheritance

## Table of Contents

1. [Unit Overview](#unit-overview)
2. [Essential Concepts](#essential-concepts)
3. [Inheritance Fundamentals](#inheritance-fundamentals)
4. [Creating Subclasses](#creating-subclasses)
5. [Method Overriding](#method-overriding)
6. [Super Keyword](#super-keyword)
7. [Polymorphism](#polymorphism)
8. [Type Compatibility](#type-compatibility)
9. [The Object Class](#the-object-class)
10. [Test-Taking Strategies](#test-taking-strategies)
11. [Sample Multiple Choice Questions](#sample-multiple-choice-questions)
12. [Sample Free Response Question](#sample-free-response-question)

## Unit Overview

Unit 9 focuses on inheritance in Java, which is one of the four fundamental principles of object-oriented programming. Inheritance allows a class to acquire (inherit) the fields and methods of another class, promoting code reuse and establishing a hierarchical relationship between classes. This unit represents approximately 7.5-10% of the AP CSA exam weight.

**Key Topics in This Unit:**

- Creating superclasses and subclasses
- Method overriding
- Using the `super` keyword
- Understanding polymorphism

## Essential Concepts

### Computational Thinking Practices Addressed:

- Program design and implementation
- Code organization and reuse
- Abstraction in program development
- Program analysis with inheritance hierarchies

### Course Skills Developed:

- MOD-3.A: Define inheritance relationships to create object hierarchies
- MOD-3.B: Implement inheritance relationships using the `extends` keyword
- MOD-3.C: Define reference variables of a subclass type to objects of a superclass
- MOD-3.D: Use the `super` keyword to call superclass constructors and methods

## Inheritance Fundamentals

### What is Inheritance?

- Inheritance is a mechanism where a new class (subclass) acquires properties and behaviors from an existing class (superclass)
- The subclass inherits all the non-private members (fields and methods) of the superclass
- Inheritance promotes code reuse, organization, and hierarchical design
- It establishes an "is-a" relationship between classes (e.g., a Dog "is-a" Animal)

### Key Terminology:

- **Superclass/Parent Class**: The class being inherited from
- **Subclass/Child Class**: The class that inherits from the superclass
- **Inheritance Hierarchy**: The tree-like structure formed by inheritance relationships
- **Single Inheritance**: Java only supports direct inheritance from one superclass

### Example: Inheritance Hierarchy

```
         Animal
         /    \
       Bird    Mammal
      /   \      /   \
Sparrow  Eagle  Dog   Cat
```

### Benefits of Inheritance:

- **Code Reuse**: Reduces redundancy by inheriting common properties and behaviors
- **Extensibility**: Makes it easy to extend functionality without modifying existing code
- **Hierarchy**: Creates a logical structure that reflects real-world relationships
- **Polymorphism**: Enables treating objects of different classes uniformly through common superclass types

## Creating Subclasses

### Extending a Class:

- Use the `extends` keyword to create a subclass
- Syntax: `public class Subclass extends Superclass { ... }`
- A subclass inherits all non-private fields and methods from its superclass

### Example: Basic Inheritance

```java
// Superclass
public class Animal {
    private String name;
    private double weight;
    
    public Animal(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }
    
    public void eat() {
        System.out.println(name + " is eating.");
    }
    
    public void sleep() {
        System.out.println(name + " is sleeping.");
    }
    
    public String getName() {
        return name;
    }
    
    public double getWeight() {
        return weight;
    }
}

// Subclass
public class Dog extends Animal {
    private String breed;
    
    public Dog(String name, double weight, String breed) {
        super(name, weight); // Call superclass constructor
        this.breed = breed;
    }
    
    public void bark() {
        System.out.println(getName() + " is barking.");
    }
    
    public String getBreed() {
        return breed;
    }
}
```

### What Gets Inherited:

- **Public members**: Accessible in the subclass and everywhere else
- **Default (package-private) members**: Accessible in the subclass if it's in the same package

### What Doesn't Get Inherited:

- Constructors (though they can be called using `super()`)
- Private members (though they may be indirectly accessible)

## Method Overriding

### What is Method Overriding?

- Method overriding occurs when a subclass provides a specific implementation for a method already defined in its superclass
- The method in the subclass must have the same name, return type, and parameter list as the method in the superclass
- Method overriding is a key mechanism for achieving runtime polymorphism

### Rules for Method Overriding:

1. Method name, return type, and parameter list must be the same
2. Access modifier cannot be more restrictive than in the superclass
3. Cannot override methods declared as `final` or `static`
4. Cannot override constructor methods
5. Cannot throw broader checked exceptions than the superclass method

### Example: Method Overriding

```java
public class Animal {
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
    
    public void eat() {
        System.out.println("Animal eats food");
    }
}

public class Dog extends Animal {
    public void makeSound() {
        System.out.println("Dog barks");
    }
    
    public void eat() {
        System.out.println("Dog eats meat");
    }
}

public class Cat extends Animal {
    public void makeSound() {
        System.out.println("Cat meows");
    }
}
```

## Super Keyword

### Purpose of the `super` Keyword:

- Used to refer to the superclass members (fields, methods, constructors)
- Helps solve the problem of name hiding when a subclass has fields or methods with the same name as the superclass
- Used to call the superclass constructor from a subclass constructor

### Calling Superclass Constructor:

- Format: `super(arguments);`
- Must be the first statement in the subclass constructor
- If not explicitly called, the compiler will insert a call to the superclass's no-argument constructor

### Accessing Superclass Members:

- Call a superclass method: `super.methodName(arguments);`
- Access a superclass field: `super.fieldName`
- Particularly useful when overriding methods but still wanting to use the superclass implementation

### Example: Using `super`

```java
public class Shape {
    private String color;
    
    public Shape() {
        this.color = "white";
    }
    
    public Shape(String color) {
        this.color = color;
    }
    
    public double calculateArea() {
        return 0.0;
    }
    
    public String getColor() {
        return color;
    }
}

public class Circle extends Shape {
    private double radius;
    
    public Circle(double radius) {
        super(); // Call Shape's no-arg constructor
        this.radius = radius;
    }
    
    public Circle(String color, double radius) {
        super(color); // Call Shape(String color) constructor
        this.radius = radius;
    }
    
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    
    public void displayDetails() {
        System.out.println("This is a " + super.getColor() + " circle with radius " + radius);
        System.out.println("Area: " + calculateArea());
        System.out.println("Parent's calculateArea method returns: " + super.calculateArea());
    }
}
```

## Polymorphism

### What is Polymorphism?

- Polymorphism means "many forms" and allows objects of different classes to be treated as objects of a common superclass
- It enables a single interface to represent different underlying forms (data types)
- In Java, polymorphism is achieved through method overriding and inheritance

### Types of Polymorphism:

1. **Compile-time Polymorphism (Method Overloading)**: Multiple methods with the same name but different parameters
2. **Runtime Polymorphism (Method Overriding)**: Subclass method overrides superclass method, and method call is determined at runtime

### Key Concept: Dynamic Method Binding

- When a method is called on an object, Java looks for the method in the actual object's class first, not the reference type
- If not found, it looks in the superclass, and so on up the inheritance hierarchy
- This happens at runtime, allowing for flexible and extensible code

### Example: Runtime Polymorphism

```java
public class InheritanceDemo {
    public static void main(String[] args) {
        // Creating objects of different classes
        Animal genericAnimal = new Animal();
        Animal dog = new Dog(); // Dog object referenced by Animal type
        Animal cat = new Cat(); // Cat object referenced by Animal type
        
        // Method calls are resolved at runtime based on the actual object type
        genericAnimal.makeSound(); // Output: Animal makes a sound
        dog.makeSound();          // Output: Dog barks
        cat.makeSound();          // Output: Cat meows
        
        // Array of Animal references pointing to different objects
        Animal[] animals = new Animal[3];
        animals[0] = new Animal();
        animals[1] = new Dog();
        animals[2] = new Cat();
        
        // Polymorphic behavior in iteration
        for (Animal animal : animals) {
            animal.makeSound(); // Calls the appropriate method based on actual type
        }
    }
}
```

## Type Compatibility

### Assignment Compatibility:

- A reference variable of a superclass type can refer to an object of a subclass type
- This is called "upcasting" and is done implicitly
- Example: `Animal animal = new Dog();`

### Casting Objects:

- **Upcasting**: Converting a subclass reference to a superclass reference (implicit)
- **Downcasting**: Converting a superclass reference to a subclass reference (explicit)
- Downcasting requires explicit cast operator and can cause ClassCastException if invalid

### Example: Type Casting

```java
public class CastingDemo {
    public static void main(String[] args) {
        // Upcasting (implicit)
        Animal animal1 = new Dog("Buddy", 15.5, "Labrador");
        animal1.eat(); // Can call methods defined in Animal
        
        // Compile error: Cannot call subclass methods through superclass reference
        // animal1.bark();
        
        // Downcasting (explicit)
        Dog dog1 = (Dog) animal1;
        dog1.bark(); // Now can call Dog-specific methods
        
        // This will cause ClassCastException at runtime
        Animal animal2 = new Animal("Generic", 10.0);
        // Dog dog2 = (Dog) animal2; // Runtime error: Animal cannot be cast to Dog
        
        // Proper way to check before casting
        if (animal1 instanceof Dog) {
            Dog dog3 = (Dog) animal1;
            dog3.bark();
        }
    }
}
```

### The `instanceof` Operator:

- Used to test if an object is an instance of a specific class or interface
- Returns `true` if the object is an instance of the specified type (or a subclass)
- Format: `object instanceof Type`
- Useful for checking object type before casting

### Method Access in Polymorphism:

- A reference variable can only access methods declared in its reference type
- Even if the actual object has additional methods, they cannot be called through a superclass reference without casting

## The Object Class

### Java's Class Hierarchy:

- Every class in Java implicitly extends the `Object` class if no explicit superclass is specified
- `Object` is the root class of all classes in Java
- When you create a class without `extends`, it automatically extends `Object`

### Key Methods in Object Class:

1. **toString()**: Returns a string representation of the object
   - Default implementation: className@hashCode
   - Often overridden to provide meaningful string representation

2. **equals(Object obj)**: Compares objects for equality
   - Default implementation compares memory references (identity equality)
   - Often overridden to compare logical equality based on state

3. **getClass()**: Returns the runtime class of the object
   - Cannot be overridden

### Example: Overriding Object Methods

```java
public class Student {
    private String name;
    private int id;
    
    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }
    
    // Override toString() method
    public String toString() {
        return "Student[name=" + name + ", id=" + id + "]";
    }
    
    // Override equals() method
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Student student = (Student) obj;
        return id == student.id && name.equals(student.name);
    }
}
```

## Test-Taking Strategies

### For Multiple Choice Questions:

1. **Identify Inheritance Relationships**: Pay attention to class declarations and `extends` keywords.

2. **Trace Method Calls**: When a method is called on an object, determine which implementation will be executed based on the object's actual type.

3. **Check Access Modifiers**: Ensure that a subclass can access inherited members (public or package-private in the same package).

4. **Watch for Constructor Calls**: Remember that constructors are not inherited, and `super()` must be the first statement in a subclass constructor.

5. **Analyze Type Compatibility**: Be careful with upcasting and downcasting operations, especially when using arrays or collections of superclass types.

6. **Consider Method Overriding**: Make sure the subclass method has the same signature as the superclass method.

### For Free Response Questions:

1. **Understand the Inheritance Hierarchy**: Before writing code, understand the relationship between classes.

2. **Apply Proper Syntax**: Use correct syntax for inheritance (`extends`), method overriding, and constructor calls (`super()`).

3. **Think About Code Reuse**: Avoid duplicating code that could be inherited or reused from a superclass.

4. **Consider Method Overriding**: Determine which methods need to be overridden in subclasses to achieve required functionality.

5. **Check Type Compatibility**: Be mindful of reference types versus object types when programming with inheritance.

6. **Document Your Code**: Include comments explaining your design decisions, especially related to inheritance.

## Sample Multiple Choice Questions

### Question 1

Consider the following classes:

```java
public class A {
    public void method1() {
        System.out.print("A1 ");
    }
    
    public void method2() {
        System.out.print("A2 ");
    }
}

public class B extends A {
    public void method1() {
        System.out.print("B1 ");
    }
    
    public void method3() {
        System.out.print("B3 ");
    }
}
```

What is the output when the following code is executed?

```java
A obj = new B();
obj.method1();
obj.method2();
// obj.method3(); // This would cause a compilation error
```

- A) A1 A2   
- B) A1 A2 B3  
- C) B1 A2   
- D) B1 A2 B3  
- E) A1 B2  

### Question 2

Consider the following code:

```java
public class Vehicle {
    private String type;
    
    public Vehicle() {
        type = "Generic";
        System.out.println("Vehicle constructor");
    }
    
    public Vehicle(String type) {
        this.type = type;
        System.out.println("Vehicle parameterized constructor");
    }
}

public class Car extends Vehicle {
    private String model;
    
    public Car() {
        model = "Unknown";
        System.out.println("Car constructor");
    }
    
    public Car(String model) {
        this.model = model;
        System.out.println("Car parameterized constructor");
    }
    
    public Car(String type, String model) {
        super(type);
        this.model = model;
        System.out.println("Car type-model constructor");
    }
}
```

What is printed when `new Car("Sedan", "Toyota");` is executed?

- A) Vehicle constructor  
   Car type-model constructor

- B) Vehicle parameterized constructor  
   Car type-model constructor

- C) Car type-model constructor

- D) Vehicle constructor  
   Car parameterized constructor

- E) Vehicle parameterized constructor

### Question 3

Consider the following code:

```java
public class Animal {
    public void eat() {
        System.out.println("Animal eats");
    }
    
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

public class Dog extends Animal {
    public void makeSound() {
        System.out.println("Dog barks");
    }
}
```

Which of the following statements is true?

- A) The code will not compile because `Dog` does not override the `eat()` method.  
- B) A `Dog` object can call both `makeSound()` and `eat()`.  
- C) A `Dog` object can only call the methods defined in the `Dog` class.  
- D) The code will not compile because method overriding is not allowed.  
- E) An `Animal` reference variable cannot point to a `Dog` object.

### Question 4

Consider the following class hierarchy:

```java
public class Product {
    private String name;
    private double price;
    
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    public double getPrice() {
        return price;
    }
    
    public String getName() {
        return name;
    }
}

public class DiscountedProduct extends Product {
    private double discountPercentage;
    
    public DiscountedProduct(String name, double price, double discountPercentage) {
        super(name, price);
        this.discountPercentage = discountPercentage;
    }
    
    public double getPrice() {
        return super.getPrice() * (1 - discountPercentage / 100);
    }
    
    public double getDiscountAmount() {
        return super.getPrice() * (discountPercentage / 100);
    }
}
```

What is the value of `p.getPrice()` after the following code is executed?

```java
Product p = new DiscountedProduct("Laptop", 1000.0, 20.0);
```

- A) 1000.0  
- B) 800.0  
- C) 200.0  
- D) 0.0  
- E) There is a compilation error

### Question 5

Consider the following code:

```java
public class Shape {
    public double area() {
        return 0.0;
    }
    
    public void display() {
        System.out.println("Area: " + area());
    }
}

public class Circle extends Shape {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    public double area() {
        return Math.PI * radius * radius;
    }
}
```

What is the output when the following code is executed?

```java
Shape s = new Circle(2.0);
s.display();
```

- A) Area: 0.0  
- B) Area: 12.566370614359172  
- C) The code will not compile  
- D) Runtime error  
- E) Area: 4.0

## Sample Free Response Question

### Question: Educational Management System

You are developing a system to manage different types of educational entities. Design a class hierarchy that includes a base class, `EducationalEntity`, and two subclasses, `School` and `University`.

The base class should:
- Store common attributes like name, location, and student count
- Define a method to calculate funding based on student count

Each subclass should:
- Have additional attributes specific to its type
- Override the funding calculation method with specific logic
- Include at least one additional method relevant to its type

Write the complete code for all three classes, and a test class demonstrating polymorphism with these classes.
- 
**Key Points in the Solution:**

1. **Proper Inheritance Structure**:
   - `EducationalEntity` serves as the base class with common attributes and methods
   - `School` and `University` extend the base class with specialized functionality

2. **Method Overriding**:
   - Both subclasses override the `calculateAnnualFunding()` method with specific calculations
   - Both subclasses override the `displayInfo()` method to show additional information

3. **Superclass Reference**:
   - The solution demonstrates polymorphism by storing different object types in an array of the superclass type
   - The appropriate method implementation is called based on the actual object type

4. **Type Checking and Casting**:
   - The code demonstrates proper use of `instanceof` for type checking
   - It shows correct downcasting to access subclass-specific methods

5. **Constructors and Super Calls**:
   - Each subclass constructor correctly calls the superclass constructor using `super()`
   - Each class properly initializes its instance variables