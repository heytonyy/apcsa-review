# Unit 3: Boolean Expressions and If Statements

## Table of Contents
1. [Unit Overview](#unit-overview)
2. [Essential Concepts](#essential-concepts)
3. [Boolean Expressions](#boolean-expressions)
4. [Relational Operators](#relational-operators)
5. [If Statements](#if-statements)
6. [If-Else and Else-If Statements](#if-else-and-else-if-statements)
7. [Nested Conditionals](#nested-conditionals)
8. [Compound Boolean Expressions](#compound-boolean-expressions)
9. [Equivalent Boolean Expressions](#equivalent-boolean-expressions)
10. [Object Comparison](#object-comparison)
11. [Common Coding Patterns](#common-coding-patterns)
12. [Test-Taking Strategies](#test-taking-strategies)
13. [Sample Multiple Choice Questions](#sample-multiple-choice-questions)
14. [Sample Free Response Question](#sample-free-response-question)

## Unit Overview

Unit 3 focuses on Boolean Expressions and If Statements in Java, a fundamental aspect of controlling program flow and decision-making. This unit represents approximately 15-17.5% of the AP CSA exam weight and typically requires about 11-13 class periods to cover. The unit explores how to create boolean expressions, implement conditional statements, and use logical operators to create complex decision-making structures.

**Key Topics in This Unit:**
- Boolean expressions and relational operators
- If, if-else, and else-if statements
- Compound boolean expressions using logical operators
- Comparing objects
- Equivalent boolean expressions and De Morgan's Laws

## Essential Concepts

### Computational Thinking Practices Addressed:
- Control flow analysis (analyzing how decisions affect program execution)
- Code implementation (writing and using conditional statements effectively)
- Algorithm implementation (implementing decision-making algorithms)

### Course Skills Developed:
- CON-1: Evaluating boolean expressions
- CON-2: Writing conditional statements
- CON-3: Comparing objects using .equals() and == operators
- CON-4: Understanding De Morgan's Laws
- CON-5: Creating complex decision structures

## Boolean Expressions

### What is a Boolean Expression?
Boolean expressions are statements that evaluate to one of two possible values: true or false. They form the basis for decision-making in programming by allowing the code to take different paths based on specific conditions.

### Boolean Type
- The `boolean` primitive type has only two possible values: `true` or `false`
- Boolean variables are commonly used to track states and conditions
- Boolean expressions are used in conditional statements to control program flow

### Examples:
```java
// Boolean variables
boolean isRaining = true;
boolean hasUmbrella = false;

// Boolean expressions
boolean willGetWet = isRaining && !hasUmbrella; // true

// Direct boolean expressions
boolean isAdult = age >= 18; // evaluates to true or false based on age value
```

## Relational Operators

### Basic Relational Operators
- `==` : Equal to
- `!=` : Not equal to
- `<` : Less than
- `<=` : Less than or equal to
- `>` : Greater than
- `>=` : Greater than or equal to

### Using Relational Operators with Primitives
```java
int x = 5;
int y = 10;
boolean result;

result = x == y; // false
result = x != y; // true
result = x < y;  // true
result = x <= y; // true
result = x > y;  // false
result = x >= y; // false
```

### Common Mistakes
- Using `=` (assignment) instead of `==` (equality comparison)
- Forgetting that comparisons are strict (5 is not equal to 5.0 when using `==` without casting)
- Improper handling of floating-point equality due to precision issues

## If Statements

### Basic If Statement Syntax
```java
if (booleanExpression) {
    // Code executed if booleanExpression is true
}
```

### Control Flow with If Statements
- If the boolean expression evaluates to `true`, the code block inside the curly braces executes
- If the boolean expression evaluates to `false`, the code block is skipped
- After the if statement, program execution continues with the next statement

### Example:
```java
int temperature = 35;

if (temperature > 30) {
    System.out.println("It's hot outside!");
}
// Program continues here regardless of the condition
```

### Single Statement Bodies
If the body of an if statement contains only one statement, curly braces are optional, but using them is recommended for clarity and to prevent errors:

```java
// Without braces (not recommended)
if (score > 90)
    System.out.println("Excellent!");

// With braces (recommended)
if (score > 90) {
    System.out.println("Excellent!");
}
```

## If-Else and Else-If Statements

### If-Else Syntax
```java
if (booleanExpression) {
    // Code executed if booleanExpression is true
} else {
    // Code executed if booleanExpression is false
}
```

### Else-If Syntax
```java
if (condition1) {
    // Code executed if condition1 is true
} else if (condition2) {
    // Code executed if condition1 is false and condition2 is true
} else if (condition3) {
    // Code executed if condition1 and condition2 are false and condition3 is true
} else {
    // Code executed if all conditions are false
}
```

### Multi-way Decision Making
- Only one branch in an if-else chain will execute
- Conditions are evaluated in order (top to bottom)
- Once a condition evaluates to true, its code block executes and all other conditions are skipped
- The else block is optional and serves as a "catch-all" for when no conditions are true

### Example: Grade Assignment
```java
int score = 85;
char grade;

if (score >= 90) {
    grade = 'A';
} else if (score >= 80) {
    grade = 'B';
} else if (score >= 70) {
    grade = 'C';
} else if (score >= 60) {
    grade = 'D';
} else {
    grade = 'F';
}
// grade is 'B' after this code executes
```

## Nested Conditionals

### Nested If Statements
```java
if (outerCondition) {
    // Code executed if outerCondition is true
    
    if (innerCondition) {
        // Code executed if both outerCondition and innerCondition are true
    }
}
```

### Use Cases
- When decisions depend on multiple sequential conditions
- When one condition needs to be checked only if another condition is true
- For implementing complex decision trees

### Example: Admission Criteria
```java
int gpa = 3.8;
int satScore = 1300;

if (gpa >= 3.5) {
    if (satScore >= 1200) {
        System.out.println("Congratulations! You qualify for a scholarship.");
    } else {
        System.out.println("You qualify for admission but not for a scholarship.");
    }
} else {
    if (satScore >= 1400) {
        System.out.println("You qualify for admission based on test scores.");
    } else {
        System.out.println("Sorry, you don't qualify for direct admission.");
    }
}
```

### Improving Readability
- Proper indentation is crucial for readability
- Consider using compound boolean expressions to reduce nesting when appropriate
- Comments can help clarify complex nesting structures

## Compound Boolean Expressions

### Logical Operators
- `&&` : Logical AND (both expressions must be true)
- `||` : Logical OR (at least one expression must be true)
- `!` : Logical NOT (negates the boolean value)

### Truth Tables

**AND (&&) Operator:**
| A | B | A && B |
|---|---|--------|
| true | true | true |
| true | false | false |
| false | true | false |
| false | false | false |

**OR (||) Operator:**
| A | B | A \|\| B |
|---|---|--------|
| true | true | true |
| true | false | true |
| false | true | true |
| false | false | false |

**NOT (!) Operator:**
| A | !A |
|---|---|
| true | false |
| false | true |

### Short-Circuit Evaluation
- For `&&`: If the first operand is `false`, the second operand is not evaluated (since the result will be `false` regardless)
- For `||`: If the first operand is `true`, the second operand is not evaluated (since the result will be `true` regardless)
- This can be useful for efficiency and to avoid potential errors

### Example:
```java
// Short-circuit evaluation prevents NullPointerException
if (str != null && str.length() > 0) {
    System.out.println("String is not empty");
}

// Without short-circuit evaluation, this would throw an exception if str is null
```

### Order of Operations
1. `!` (NOT) - highest precedence
2. `&&` (AND)
3. `||` (OR) - lowest precedence

To force a different order of evaluation, use parentheses:
```java
boolean result = (a || b) && c; // (a || b) is evaluated first, then && c
```

## Equivalent Boolean Expressions

### De Morgan's Laws
De Morgan's Laws provide a way to distribute the NOT operator over AND and OR expressions:

1. `!(A && B)` is equivalent to `!A || !B`
2. `!(A || B)` is equivalent to `!A && !B`

### Practical Application
```java
// These are equivalent
if (!(age >= 18 && hasID)) {
    System.out.println("Cannot enter");
}

if (age < 18 || !hasID) {
    System.out.println("Cannot enter");
}
```

### Other Common Equivalences
- `!(A == B)` is equivalent to `A != B`
- `!(A < B)` is equivalent to `A >= B`
- `!(A > B)` is equivalent to `A <= B`

### Truth Tables for Verification
A truth table can be used to verify if two boolean expressions are equivalent by checking that they produce the same output for all possible input combinations.

## Object Comparison

### `==` vs. `.equals()`
- `==` compares object references (checks if two variables refer to the same object in memory)
- `.equals()` compares object content (behavior depends on how the method is implemented for that class)

### String Comparison
```java
String s1 = "Hello";
String s2 = "Hello";
String s3 = new String("Hello");

// Reference comparison
boolean b1 = (s1 == s2);   // true (string literals are interned)
boolean b2 = (s1 == s3);   // false (different objects)

// Content comparison
boolean b3 = s1.equals(s2); // true (same content)
boolean b4 = s1.equals(s3); // true (same content)
```

### Handling Null References
- Always check for null before calling methods on an object
- The expression `null == null` evaluates to `true`
- Calling any method (including `.equals()`) on a null reference results in a `NullPointerException`

```java
String str = null;

// Safe null checking
if (str != null && str.equals("value")) {
    // Safe to proceed
}

// Alternative for string comparison when null is possible
if ("value".equals(str)) {
    // This won't throw exception if str is null
}
```

## Common Coding Patterns

### Pattern 1: Range Checking

```java
// Checking if a value is within a range (inclusive)
if (value >= min && value <= max) {
    System.out.println("Value is in range");
}

// Checking if a value is outside a range
if (value < min || value > max) {
    System.out.println("Value is out of range");
}
```

### Pattern 2: Input Validation

```java
import java.util.Scanner;

Scanner input = new Scanner(System.in);
System.out.print("Enter your age: ");
int age = input.nextInt();

if (age < 0 || age > 120) {
    System.out.println("Invalid age entered.");
} else {
    System.out.println("Your age is: " + age);
}
```

### Pattern 3: Tiered Decision Making

```java
// Shipping cost calculation based on order value
double orderValue = 75.0;
double shippingCost;

if (orderValue >= 100.0) {
    shippingCost = 0.0; // Free shipping
} else if (orderValue >= 50.0) {
    shippingCost = 5.99;
} else {
    shippingCost = 9.99;
}

System.out.println("Shipping cost: $" + shippingCost);
```

### Pattern 4: Null-Safe Object Comparison

```java
// Safe string comparison when null values are possible
String str1 = getSomeString(); // might return null
String str2 = "expected";

// Method 1: Explicit null checking
if (str1 != null && str1.equals(str2)) {
    // strings match and str1 is not null
}

// Method 2: Putting the known non-null value first
if (str2.equals(str1)) {
    // strings match (works even if str1 is null)
}
```

## Test-Taking Strategies

### For Multiple Choice Questions:
1. **Evaluate Each Branch**: For if-else chains, trace through each condition to determine which branch will execute
2. **Order Matters**: Remember that conditions in if-else chains are evaluated in order
3. **Watch for Short-Circuit Evaluation**: Be aware of how `&&` and `||` evaluate expressions
4. **Trace Step-by-Step**: For complex conditions, break down each part and evaluate separately
5. **Common Errors**: Look for classic errors like using `=` instead of `==` or improper object comparison
6. **Return Statements**: Remember that if a return statement executes within a conditional block, the method will exit immediately
7. **Logical Equivalence**: Understand how to apply De Morgan's Laws to simplify or transform boolean expressions

### For Free Response Questions:
1. **Check All Conditions**: Ensure your conditionals cover all possible scenarios
2. **Edge Cases**: Consider boundary conditions and extreme values
3. **Logical Errors**: Double-check your boolean expressions, especially complex ones
4. **Curly Braces**: Always use curly braces for clarity and to prevent errors
5. **Efficiency**: Use short-circuit evaluation to optimize code and prevent errors
6. **Object Comparison**: Properly handle string and object comparisons using `.equals()` when appropriate
7. **Null Handling**: Include null checks before accessing object methods or properties

## Sample Multiple Choice Questions

### Question 1
Consider the following code segment:
```java
int x = 5;
int y = 10;
if (x > 0) {
    if (y > 0) {
        System.out.println("Both positive");
    }
} else {
    System.out.println("x not positive");
}
if (x > 0 && y > 0) {
    System.out.println("Both positive again");
}
```

What is printed when this code segment is executed?

- A) Both positive<br>
- B) x not positive<br>
- C) Both positive<br>
   Both positive again<br>
- D) x not positive<br>
   Both positive again<br>
- E) Both positive again<br>

### Question 2
What is the value of result after the following code segment executes?
```java
boolean a = true;
boolean b = false;
boolean result = !(a && b) || (a || !b);
```

- A) true<br>
- B) false<br>
- C) It depends on the implementation<br>
- D) The code contains a syntax error<br>
- E) The code contains a logical error<br>

### Question 3
Consider the following code segment:
```java
String str1 = "Hello";
String str2 = new String("Hello");
String str3 = "Hello";

if (str1 == str3) {
    System.out.print("A");
}
if (str1 == str2) {
    System.out.print("B");
}
if (str1.equals(str2)) {
    System.out.print("C");
}
```

What is printed as a result of executing this code segment?

- A) A<br>
- B) B<br>
- C) C<br>
- D) AC<br>
- E) ABC<br>

### Question 4
What is the output of the following code segment?
```java
int num = 7;
if (num % 2 == 0)
    System.out.println("Even");
else if (num % 3 == 0)
    System.out.println("Divisible by 3");
else
    System.out.println("Neither");
```

- A) Even<br>
- B) Divisible by 3<br>
- C) Neither<br>
- D) Even<br>
   Divisible by 3<br>
- E) No output is produced<br>

### Question 5
Consider the following code segment:
```java
boolean a = true;
boolean b = false;
boolean c = true;
boolean result = a || b && c;
```

What is the value of result?

A) true<br>
B) false<br>
C) It depends on the implementation<br>
D) The expression has a syntax error<br>
E) The expression will cause a runtime error<br>

## Sample Free Response Question

### Question: MovieRating System

You are creating a system to recommend movies based on ratings. Implement the `MovieRating` class that provides various methods for determining if a movie is recommended.

The class should include:
1. Instance variables for movie title, viewer rating (0.0 to 5.0), and critic rating (0.0 to 5.0)
2. A method to determine if a movie is "Highly Recommended" (both viewer and critic ratings >= 4.0)
3. A method to determine if a movie is "Mixed Reviews" (difference between viewer and critic ratings > 2.0)
4. A method to determine if a movie is "Recommended" based on additional criteria

**Key Concepts Demonstrated:**
1. Boolean expressions with relational operators
2. Compound boolean expressions with logical operators
3. Conditional statements (if-else chains)
4. Short-circuit evaluation
5. Method implementation with boolean return types
6. Complex decision-making logic
