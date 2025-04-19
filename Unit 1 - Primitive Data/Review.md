# Unit 1: Primitive Types

## Table of Contents
1. [Unit Overview](#unit-overview)
2. [Essential Concepts](#essential-concepts)
3. [Primitive Data Types](#primitive-data-types)
4. [Variables and Assignment](#variables-and-assignment)
5. [Arithmetic Expressions](#arithmetic-expressions)
6. [Casting and Type Conversion](#casting-and-type-conversion)
7. [Input and Output](#input-and-output)
8. [Common Coding Patterns](#common-coding-patterns)
9. [Test-Taking Strategies](#test-taking-strategies)
10. [Sample Multiple Choice Questions](#sample-multiple-choice-questions)
11. [Sample Free Response Question](#sample-free-response-question)

## Overview

Unit 1 focuses on primitive types in Java, which forms the foundation of all Java programming. A primitive data type is a piece of data stored directly in the computer's memory. In Java, there are eight primitive data types, but for AP CSA, you only need to know three: int, double, and boolean. This unit represents approximately 2.5-5% of the AP CSA exam weight, making it essential to understand the fundamentals thoroughly.

**Key Topics in This Unit:**
- Primitive data types (int, double, boolean)
- Variables and data storage
- Arithmetic expressions and operators
- Type conversion and casting
- Input and output operations

## Essential Concepts

### Computational Thinking Practices Addressed:
- Program analysis (analyzing what code does)
- Code implementation (writing and using code effectively)
- Algorithm implementation (implementing algorithms in code)

### Course Skills Developed:
- VAR-1.B: Identify the most appropriate data type for a particular specification
- VAR-1.C: Declare variables of the correct types to represent primitive data
- CON-1.A: Evaluate arithmetic expressions in program code
- CON-1.B: Evaluate what is stored in a variable as a result of an expression with an assignment statement
- CON-1.C: Evaluate arithmetic expressions that use casting

## Primitive Data Types

### The Three Main Primitive Types for AP CSA:

1. **int (Integer)**
   - Stores whole numbers (positive, negative, or zero)
   - Range: -2,147,483,648 to 2,147,483,647 (Integer.MIN_VALUE to Integer.MAX_VALUE)
   - Size: 4 bytes (32 bits)
   - Example: `int score = 95;`

2. **double (Decimal Numbers)**
   - Stores floating-point numbers with decimal places
   - Range: approximately ±1.7e-308 to ±1.7e+308
   - Precision: up to 15 decimal digits
   - Size: 8 bytes (64 bits)
   - Example: `double gpa = 3.75;`

3. **boolean (Logical Values)**
   - Stores only two possible values: true or false
   - Used for logical operations and conditional statements
   - Size: 1 bit conceptually (though JVM implementation may vary)
   - Example: `boolean isActive = true;`

### Other Primitive Types (Not Tested on AP Exam):
- `byte`: 8-bit integer (-128 to 127)
- `short`: 16-bit integer (-32,768 to 32,767)
- `long`: 64-bit integer
- `float`: 32-bit floating-point
- `char`: Single Unicode character

### Example: Declaring and Using Primitive Types

```java
// Declare and initialize int variable
int studentCount = 32;

// Declare and initialize double variable
double averageScore = 87.5;

// Declare and initialize boolean variable
boolean passedExam = true;

// Declaration and initialization can be separate
int daysInWeek;
daysInWeek = 7;
```

## Variables and Assignment

### Variable Declaration:
- Format: `dataType variableName;`
- Example: `int age;`

### Variable Initialization:
- Format: `variableName = value;`
- Example: `age = 17;`

### Combined Declaration and Initialization:
- Format: `dataType variableName = value;`
- Example: `int age = 17;`

### Naming Conventions:
- Use camelCase for variable names
- First character must be a letter, underscore, or dollar sign
- Subsequent characters can include letters, numbers, underscores, or dollar signs
- Cannot use Java reserved keywords (like `new`, `class`, `public`, etc.)
- Should be descriptive of the variable's purpose

### Constants:
- Use `final` keyword
- Convention: use all uppercase with underscores
- Example: `final double PI = 3.14159;`

### Example: Variable Assignment and Manipulation

```java
// Declare and initialize a variable
int totalPoints = 100;

// Update the variable
totalPoints = 120;

// Use the variable in calculation
int bonusPoints = 10;
totalPoints = totalPoints + bonusPoints; // totalPoints is now 130

// Declaring a constant
final int MAX_SCORE = 150;
```

## Arithmetic Expressions

### Basic Arithmetic Operators:
- Addition: `+`
- Subtraction: `-`
- Multiplication: `*`
- Division: `/`
- Modulus (remainder): `%`

### Integer Division:
- When dividing two integers, the result is an integer (fractional part is truncated)
- Example: `7 / 2` evaluates to `3` (not 3.5)

### Modulus Operator:
- Returns the remainder of division
- Example: `7 % 2` evaluates to `1`
- Useful for determining even/odd numbers or cycling through values

### Operator Precedence:
1. Parentheses `()`
2. Unary operators (`++`, `--`, `+`, `-`)
3. Multiplication, Division, Modulus (`*`, `/`, `%`)
4. Addition, Subtraction (`+`, `-`)
5. Assignment operators (`=`, `+=`, etc.)

### Compound Assignment Operators:
- `+=` : Add and assign
- `-=` : Subtract and assign
- `*=` : Multiply and assign
- `/=` : Divide and assign
- `%=` : Modulus and assign

### Increment/Decrement Operators:
- `++` : Increment by 1
- `--` : Decrement by 1
- Can be prefix (++x) or postfix (x++)
- Prefix: increment/decrement first, then use value
- Postfix: use value first, then increment/decrement

### Example: Arithmetic Operations

```java
int a = 10;
int b = 3;

int sum = a + b;        // 13
int difference = a - b; // 7
int product = a * b;    // 30
int quotient = a / b;   // 3 (integer division)
int remainder = a % b;  // 1

// Compound assignment
int c = 5;
c += 3;  // c = c + 3, so c is now 8
c *= 2;  // c = c * 2, so c is now 16

// Increment/decrement
int d = 7;
System.out.println(d++); // Prints 7, then d becomes 8
System.out.println(++d); // d becomes 9, then prints 9
```

## Casting and Type Conversion

### Implicit Casting (Widening):
- Automatic conversion from smaller data type to larger data type
- No data loss occurs
- Example: `int` to `double`
- `int x = 5; double y = x;` (y becomes 5.0)

### Explicit Casting (Narrowing):
- Manual conversion from larger data type to smaller data type
- Potential data loss
- Format: `(targetType) expression`
- Example: `double` to `int`
- `double x = 5.7; int y = (int) x;` (y becomes 5, decimal part is truncated)

### Type Conversion in Expressions:
- If any operand is a `double`, the result is a `double`
- If all operands are `int`, the result is an `int`
- Example: `5 / 2` is `2` (integer division)
- Example: `5.0 / 2` is `2.5` (floating-point division)

### Example: Type Casting

```java
// Implicit casting (widening)
int intValue = 100;
double doubleValue = intValue;  // doubleValue is 100.0

// Explicit casting (narrowing)
double pi = 3.14159;
int roundedPi = (int) pi;  // roundedPi is 3 (decimal part is truncated)

// Mixed type expressions
int x = 5;
int y = 2;
double result1 = x / y;       // 2.0 (integer division happens first)
double result2 = x / (double) y;  // 2.5 (y is cast to double before division)
double result3 = (double) x / y;  // 2.5 (x is cast to double before division)
```

## Input and Output

### Output with System.out:
- `System.out.println(expression)`: Prints expression followed by newline
- `System.out.print(expression)`: Prints expression without newline
- `System.out.printf(format, args...)`: Formatted output (not required for AP exam)

### Input with Scanner:
- Import the Scanner class: `import java.util.Scanner;`
- Create Scanner object: `Scanner input = new Scanner(System.in);`
- Read input:
  - `input.nextInt()`: Read integer
  - `input.nextDouble()`: Read double
  - `input.nextBoolean()`: Read boolean
  - `input.next()`: Read a word (string)
  - `input.nextLine()`: Read entire line

### Example: Input and Output

```java
import java.util.Scanner;

public class InputOutputExample {
    public static void main(String[] args) {
        // Create Scanner object
        Scanner input = new Scanner(System.in);
        
        // Output prompt
        System.out.print("Enter your age: ");
        
        // Input
        int age = input.nextInt();
        
        // Output
        System.out.println("You are " + age + " years old.");
        
        // Calculate and display age in months
        int ageInMonths = age * 12;
        System.out.println("That's approximately " + ageInMonths + " months.");
        
        // Close Scanner
        input.close();
    }
}
```

## Common Coding Patterns

### Pattern 1: Calculating Averages

```java
// Calculate average of three test scores
int test1 = 85;
int test2 = 90;
int test3 = 78;

// Wrong way (integer division)
int average1 = (test1 + test2 + test3) / 3;  // 84

// Correct way
double average2 = (test1 + test2 + test3) / 3.0;  // 84.33...
```

### Pattern 2: Temperature Conversion

```java
// Convert Celsius to Fahrenheit
double celsius = 25.0;
double fahrenheit = (9.0 / 5) * celsius + 32;  // 77.0

// Convert Fahrenheit to Celsius
double fahrenheit2 = 77.0;
double celsius2 = (5.0 / 9) * (fahrenheit2 - 32);  // 25.0
```

### Pattern 3: Finding Remainder for Cyclic Patterns

```java
// Determine day of week after N days
int currentDay = 2;  // 0 = Sunday, 1 = Monday, ..., 6 = Saturday
int daysElapsed = 10;
int futureDayOfWeek = (currentDay + daysElapsed) % 7;  // 5 = Friday
```

### Pattern 4: Swapping Variables

```java
// Swap two variables
int a = 5;
int b = 10;

// Use temporary variable
int temp = a;
a = b;
b = temp;

// Now a = 10 and b = 5
```

## Test-Taking Strategies

### For Multiple Choice Questions:
1. **Read Carefully**: Pay close attention to what the question is asking.
2. **Look for Keywords**: Identify key terms like "evaluates to," "prints," "stores," etc.
3. **Trace through Code**: Mentally execute the code step-by-step.
4. **Eliminate Wrong Answers**: Cross out obviously incorrect options.
5. **Watch for Integer Division**: Remember that dividing two integers produces an integer result.
6. **Check for Off-by-One Errors**: Double-check array indices and loop bounds.
7. **Be Careful with Increments**: Pay attention to prefix (++x) vs. postfix (x++) operators.

### For Free Response Questions:
1. **Plan Before Coding**: Understand the problem before writing code.
2. **Use Proper Syntax**: Points are deducted for syntax errors.
3. **Test with Simple Cases**: Verify your solution with simple examples.
4. **Consider Edge Cases**: Think about boundary conditions.
5. **Document Your Code**: Add comments to explain your thinking.
6. **Reuse Code When Possible**: Avoid redundancy.
7. **Check Your Work**: Review your solution if time permits.

## Sample Multiple Choice Questions

### Question 1
What is the value of `result` after execution of the following code segment?
```java
int a = 15;
int b = 4;
double result = a / b;
```

- A) 3.0
- B) 3.75
- C) 3
- D) 3.5
- E) 3.8

### Question 2
What is the output of the following code segment?
```java
int x = 7;
int y = 3;
System.out.println(x % y + " " + x / y);
```

- A) 1 2
- B) 1 2.33...
- C) 1.0 2
- D) 1.0 2.33...
- E) 1.0 2.0

### Question 3
Consider the following code segment:
```java
int p = 5;
int q = ++p * 2;
int r = p-- + q;
```

What are the values of p, q, and r after execution?

- A) p = 5, q = 12, r = 17
- B) p = 5, q = 10, r = 16
- C) p = 5, q = 12, r = 18
- D) p = 6, q = 12, r = 18
- E) p = 5, q = 12, r = 16

### Question 4
What is the result of `(int)(15.7 / 2.2)`?

- A) 7
- B) 7.0
- C) 7.1
- D) 7.13...
- E) 8

### Question 5
What value is stored in the variable `result` after execution of the following code segment?
```java
int a = 20;
int b = 7;
double result = (double) a / b;
```

- A) 2
- B) 2.0
- C) 2.85
- D) 2.857142...
- E) 3

## Sample Free Response Question

### Question: Calorie Calculator

Create a program to calculate and display the number of calories burned during exercise based on the following factors:
- Weight (in pounds)
- Activity type (represented by an integer code)
- Duration (in minutes)

The formula for calories burned is:
Calories = (Weight × Activity Factor × Duration) / 100

Activity factors:
- Code 1 (walking): 4.5
- Code 2 (jogging): 7.5
- Code 3 (swimming): 8.0
- Code 4 (cycling): 6.0

Your program should:
1. Declare variables of appropriate types
2. Use a Scanner to input weight, activity code, and duration
3. Calculate calories burned using the formula
4. Output the result in a user-friendly format
5. Handle integer division correctly in the calculation

**Key Points to Include in Your Answer:**
1. Appropriate variable declarations (int for weight, activityCode, duration; double for activityFactor and caloriesBurned)
2. Proper input using Scanner
3. Correct calculation of activity factor based on code
4. Proper formula implementation
5. Use of double division (division by 100.0, not 100)
6. Clear output formatting
7. Closing Scanner resource
