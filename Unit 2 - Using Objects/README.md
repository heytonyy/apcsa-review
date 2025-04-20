# Unit 2: Using Objects

## Table of Contents
1. [Unit Overview](#unit-overview)
2. [Essential Concepts](#essential-concepts)
3. [Objects: Instances of Classes](#objects-instances-of-classes)
4. [Creating and Storing Objects](#creating-and-storing-objects)
5. [Calling Methods](#calling-methods)
6. [String Objects and Methods](#string-objects-and-methods)
7. [Wrapper Classes](#wrapper-classes)
8. [Math Class](#math-class)
9. [Common Coding Patterns](#common-coding-patterns)
10. [Test-Taking Strategies](#test-taking-strategies)
11. [Sample Multiple Choice Questions](#sample-multiple-choice-questions)
12. [Sample Free Response Question](#sample-free-response-question)

## Unit Overview

Unit 2 focuses on using objects in Java, which is fundamental to object-oriented programming. This unit represents approximately 5-7.5% of the AP CSA exam weight and typically requires about 13-15 class periods to cover. The unit explores how to create and use objects, call methods, work with Strings, understand wrapper classes, and utilize the Math class.

**Key Topics in This Unit:**
- Objects as instances of classes
- Creating and initializing objects using constructors
- Calling void and non-void methods
- String objects and their methods
- Wrapper classes (Integer and Double)
- Using the Math class

## Essential Concepts

### Computational Thinking Practices Addressed:
- Program design (planning and implementing classes and objects)
- Code implementation (writing code that uses objects effectively)
- Code testing (ensuring objects behave as expected)

### Course Skills Developed:
- MOD-1: Calling methods without parameters
- MOD-1.E: Calling non-static void methods
- MOD-1.F: Understanding the dot operator for calling non-static methods
- MOD-1.G: Understanding void methods and expressions
- MOD-1.H: Understanding the NullPointerException
- VAR-1.E: Creating and using String objects
- VAR-1.F: Using wrapper classes
- CON-1.D: Using Math class methods

## Objects: Instances of Classes

### What are Objects?
- Objects are instances of classes
- They contain data (state) and behaviors (methods)
- They represent real-world entities in code
- Each object is an independent entity with its own state

### Classes vs. Objects
- A class is a blueprint or template
- An object is an instance created from that blueprint
- Multiple objects can be created from the same class
- Each object has its own memory space

### Example: Object Creation

```java
// Creating objects of String class
String name = new String("Alice");
String school = new String("High School");

// Creating objects of Scanner class
Scanner input = new Scanner(System.in);

// Creating objects of Random class
Random generator = new Random();
```

## Creating and Storing Objects

### Constructors
- Special methods used to initialize objects
- Have the same name as the class
- Called using the `new` keyword
- Can be overloaded (multiple constructors with different parameters)

### Instantiation Process
1. Memory is allocated for the object
2. Constructor is called to initialize the object
3. Reference to the object is returned

### Object References
- Variables don't store objects; they store references to objects
- Multiple variables can reference the same object
- An object without any references may be garbage collected

### Example: Multiple Constructors

```java
// Using String class constructors
String s1 = new String(); // Empty string
String s2 = new String("Hello"); // String with initial value

// Using Random class constructors
Random r1 = new Random(); // Uses current time as seed
Random r2 = new Random(42); // Uses specific seed value

// Null reference
String str = null; // str does not reference any object
```

## Calling Methods

### Non-Static vs. Static Methods
- Non-static methods are called on objects using the dot operator
- Static methods are called on classes, not objects

### Void Methods
- Methods that do not return values
- Cannot be used in expressions
- Called for their side effects (e.g., printing to screen, modifying object state)

### Methods with Parameters
- Parameters are values passed to methods
- Arguments are the actual values provided when calling the method

### Methods with Return Values
- Return a value that can be used in expressions
- Return type is specified in the method signature

### The Dot Operator
- Used to access members (methods and fields) of an object
- Syntax: `objectReference.methodName(arguments)`

### NullPointerException
- Occurs when trying to call a method on a null reference
- Common runtime error in Java
- Important to check for null before calling methods

### Examples: Calling Methods

```java
// Calling void methods
System.out.println("Hello"); // void method with parameter

// Calling methods with return values
String str = "Hello, World!";
int length = str.length(); // Returns an int value

// Calling a method with multiple parameters
String result = str.substring(0, 5); // Returns "Hello"

// Calling a method on null (will cause NullPointerException)
String nullStr = null;
// nullStr.length(); // This will throw NullPointerException
```

## String Objects and Methods

### String Creation
- String literals: `String s = "Hello";`
- Using constructor: `String s = new String("Hello");`
- String concatenation: `String s = "Hello" + " World";`

### String Immutability
- Strings in Java are immutable (cannot be changed)
- Operations on strings create new string objects
- String methods never modify the original string

### Important String Methods

1. **String Constructor**
   ```java
   String str = new String("Hello"); // Creates a new String object
   ```

2. **length()**
   ```java
   int len = str.length(); // Returns the number of characters
   ```

3. **substring(int from, int to)**
   ```java
   String sub = str.substring(1, 4); // Returns characters from index 1 to 3
   ```

4. **substring(int from)**
   ```java
   String sub = str.substring(1); // Returns characters from index 1 to the end
   ```

5. **indexOf(String str)**
   ```java
   int index = "Hello".indexOf("e"); // Returns 1 (index of 'e')
   ```

6. **equals(String other)**
   ```java
   boolean isEqual = str.equals("Hello"); // Compares string content, not reference
   ```

7. **compareTo(String other)**
   ```java
   int result = "apple".compareTo("banana"); // Negative value (a comes before b)
   ```

8. **Single Character Extraction**
   ```java
   // Get a single character at a specific index
   String str = "substring(index, index + 1)";
   ```

## Wrapper Classes

### Purpose of Wrapper Classes
- Provide object equivalents for primitive data types
- Allow primitives to be used in contexts requiring objects
- Provide utility methods for working with primitive values

### Integer and Double Classes
- `Integer` - wrapper for `int`
- `Double` - wrapper for `double`

### Creating Wrapper Objects
```java
// Using constructors (deprecated in recent Java versions)
Integer num1 = new Integer(42);
Double num2 = new Double(3.14);

// Using static factory methods (preferred)
Integer num3 = Integer.valueOf(42);
Double num4 = Double.valueOf(3.14);
```

### Autoboxing and Unboxing
- Autoboxing: Automatic conversion from primitive to wrapper
- Unboxing: Automatic conversion from wrapper to primitive

```java
// Autoboxing
Integer num = 42; // automatically boxes int to Integer

// Unboxing
int value = num; // automatically unboxes Integer to int

// Autoboxing in method parameters
void processValue(Integer i) { /* ... */ }
processValue(42); // 42 is autoboxed to Integer
```

### Common Methods
- `intValue()`, `doubleValue()` - Convert to primitive type
- `parseInt(String s)`, `parseDouble(String s)` - Convert strings to primitives
- `toString()` - Convert to string representation
- `valueOf(String s)` - Convert string to wrapper object

```java
// Parsing methods
int num1 = Integer.parseInt("42");
double num2 = Double.parseDouble("3.14");

// Value conversions
Integer wrappedInt = Integer.valueOf(42);
int primitiveInt = wrappedInt.intValue();

// Constants
int maxValue = Integer.MAX_VALUE;
int minValue = Integer.MIN_VALUE;
```

## Math Class

### Overview
- Provides mathematical operations and constants
- All methods are static - called on the class, not objects
- No constructor - cannot create Math objects

### Common Math Methods

1. **abs(int/double x)**
   ```java
   int absolute = Math.abs(-5); // Returns 5
   ```

2. **pow(double base, double exponent)**
   ```java
   double squared = Math.pow(2.0, 3.0); // Returns 8.0 (2³)
   ```

3. **sqrt(double x)**
   ```java
   double root = Math.sqrt(16.0); // Returns 4.0
   ```

4. **random()**
   ```java
   double rand = Math.random(); // Returns value between 0.0 (inclusive) and 1.0 (exclusive)
   ```

### Generating Random Numbers
```java
// Random value between 0.0 (inclusive) and 1.0 (exclusive)
double random = Math.random();

// Random integer between 0 (inclusive) and n (exclusive)
int randomInt = (int)(Math.random() * n);

// Random integer between min (inclusive) and max (exclusive)
int randomInRange = min + (int)(Math.random() * (max - min));
```

## Common Coding Patterns

### Pattern 1: Creating and Using Objects

```java
// Create a Scanner object to read input
Scanner input = new Scanner(System.in);

// Get user input
System.out.print("Enter your name: ");
String name = input.nextLine();

// Process the input
System.out.println("Hello, " + name + "!");

// Close the resource
input.close();
```

### Pattern 2: String Manipulation

```java
// Extract part of a string
String sentence = "Java programming is fun";
String extracted = sentence.substring(5, 16); // "programming"

// Find a substring
int index = sentence.indexOf("fun"); // 17

// Build a string with specific format
String firstName = "John";
String lastName = "Doe";
String fullName = lastName + ", " + firstName; // "Doe, John"
```

### Pattern 3: Generating Random Numbers

```java
// Random value between 1 and 6 (simulating a die roll)
int dieRoll = (int)(Math.random() * 6) + 1;

// Random value from an array
String[] choices = {"rock", "paper", "scissors"};
int randomIndex = (int)(Math.random() * choices.length);
String computerChoice = choices[randomIndex];
```

### Pattern 4: Working with Wrapper Classes

```java
// Convert string to number
String input = "42";
int value = Integer.parseInt(input);

// Check if value is within range
if (value >= Integer.MIN_VALUE && value <= Integer.MAX_VALUE) {
    System.out.println("Value is within integer range");
}

// Converting between primitive and wrapper
Integer wrapped = Integer.valueOf(value); // primitive to wrapper
int primitive = wrapped.intValue(); // wrapper to primitive
```

## Test-Taking Strategies

### For Multiple Choice Questions:
1. **Understand Reference vs. Value**: Remember that objects are passed by reference, not value
2. **Track the Object State**: Pay attention to how method calls change object state
3. **Watch for NullPointerException**: Check if objects might be null before methods are called
4. **String Immutability**: Remember that string methods create new strings; they don't modify existing ones
5. **Method Return Types**: Be aware of what a method returns (void vs. non-void)
6. **Autoboxing/Unboxing**: Consider autoboxing/unboxing when primitives and wrappers interact
7. **Method Parameter Types**: Ensure parameter types match what the method expects

### For Free Response Questions:
1. **Use Appropriate Methods**: Select the right methods for the task
2. **Check for Null**: Handle potential null references
3. **String Comparison**: Use equals() for string content comparison, not ==
4. **Method Return Values**: Make sure to return appropriate values from non-void methods
5. **Avoid Magic Numbers**: Use constants or well-named variables
6. **Check Array Boundaries**: Ensure string indices and array accesses are in bounds
7. **Initialize Values**: Properly initialize all variables and objects

## Sample Multiple Choice Questions

### Question 1
What is the output of the following code segment?
```java
String str = "computer science";
String result = str.substring(3, 9);
System.out.println(result);
```

- A) computer  
- B) puter  
- C) puter s  
- D) puter sc  
- E) uter s  

### Question 2
Consider the following code segment:
```java
String s1 = new String("Hello");
String s2 = new String("Hello");
String s3 = "Hello";
String s4 = "Hello";
```

Which of the following expressions evaluates to true?

- A) s1 == s2  
- B) s1 == s3  
- C) s3 == s4  
- D) s1.equals(s2) && s1 == s2  
- E) !(s3.equals(s4))  

### Question 3
What is the value of result after the following code executes?
```java
double value = Math.abs(-3.5);
double result = Math.pow(value, 2);
```

A) -12.25  
B) 12.25  
C) 6.125  
D) -6.125  
E) 36.75  

### Question 4
What is stored in the variable output after the following code segment is executed?
```java
String str = "AP Computer Science A";
int n = str.indexOf(" ");
String output = str.substring(0, n);
```

- A) AP  
- B) AP Computer  
- C) AP Computer Science  
- D) Computer  
- E) Computer Science A  

### Question 5
What is the result of executing the following code segment?
```java
String s = null;
System.out.print(s + " is null");
```

- A) null is null  
- B) is null  
- C) A NullPointerException is thrown  
- D) Nothing is printed  **Answer: A) null is null**
- E) " is null"  

## Sample Free Response Question

### Question: WordProcessor

You are building a simple word processing application that needs to perform various operations on text. Implement the `WordProcessor` class with the following functionality:

1. A constructor that initializes the text to an empty string
2. A method to set the text content
3. A method to count the occurrences of a specific word in the text
4. A method to replace all occurrences of one word with another
5. A method to get statistics about the text (word count, character count)

**Key Concepts Demonstrated:**
1. Object creation and initialization
2. String methods (split, replace, indexOf, equalsIgnoreCase)
3. Parameter handling (null checks, empty string checks)
4. Wrapper classes and conversions
5. Complex string processing algorithms
6. Return types and method signatures
