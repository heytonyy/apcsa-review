# Unit 4: Iteration

## Table of Contents
1. [Unit Overview](#unit-overview)
2. [Essential Concepts](#essential-concepts)
3. [While Loops](#while-loops)
4. [For Loops](#for-loops)
5. [Loop Comparison: While vs. For](#loop-comparison-while-vs-for)
6. [Developing Algorithms Using Strings](#developing-algorithms-using-strings)
7. [Nested Iteration](#nested-iteration)
8. [Informal Code Analysis](#informal-code-analysis)
9. [Common Coding Patterns](#common-coding-patterns)
10. [Test-Taking Strategies](#test-taking-strategies)
11. [Sample Multiple Choice Questions](#sample-multiple-choice-questions)
12. [Sample Free Response Question](#sample-free-response-question)

## Unit Overview

Unit 4 focuses on iteration in Java, which is the repeated execution of code. This unit represents approximately 17.5-22.5% of the AP CSA exam weight and typically requires about 14-16 class periods to cover. The unit explores how to use loops to efficiently repeat code execution, develop algorithms using strings, and analyze how code behaves through tracing.

This unit introduces several standard algorithms that use iteration. Knowledge of standard algorithms makes solving similar problems easier, as algorithms can be modified or combined to suit new situations. Iteration is a fundamental building block in programming and is essential for working with data structures like arrays and ArrayLists that you'll explore in later units.

**Key Topics in This Unit:**
- While loops and for loops
- Developing algorithms using strings
- Nested iteration
- Informal code analysis (tracing and efficiency)

## Essential Concepts

### Computational Thinking Practices Addressed:
- Program design (implementing iterative solutions)
- Code implementation (writing efficient loop structures)
- Code analysis (tracing code execution)
- Algorithm development (creating reusable algorithms)

### Course Skills Developed:
- CON-1: Using iteration to repeatedly execute statements
- CON-2: Analyzing program code to determine outputs
- CON-3: Developing algorithms for string processing
- CON-4: Implementing nested loops for complex operations
- CON-5: Analyzing loop efficiency and runtime

## While Loops

### Basic While Loop Syntax
```java
while (booleanExpression) {
    // Code to be repeated as long as booleanExpression is true
}
```

### How While Loops Work
1. The boolean expression is evaluated
2. If true, the loop body executes; if false, the loop terminates and program continues after the loop
3. After the loop body executes, control returns to step 1

### Common While Loop Structure
```java
// Initialize counter variable
int i = 0;

// Condition check
while (i < 10) {
    // Loop body
    System.out.println(i);
    
    // Update counter variable (prevent infinite loop)
    i++;
}
```

### Key Considerations
- The boolean expression must eventually become false to avoid infinite loops
- The update statement (e.g., counter increment) is crucial to ensure loop termination
- A while loop might execute zero times if the initial condition is false
- While loops are ideal when the number of iterations is not known in advance

### Example: Sum of Numbers
```java
int sum = 0;
int num = 1;

while (num <= 100) {
    sum += num;
    num++;
}

System.out.println("Sum of 1 to 100: " + sum);
```

## For Loops

### Basic For Loop Syntax
```java
for (initialization; condition; update) {
    // Code to be repeated
}
```

### Components of a For Loop
1. **Initialization**: Executed once before the loop begins
2. **Condition**: Evaluated before each iteration; if false, the loop terminates
3. **Update**: Executed after each iteration of the loop body

### Common For Loop Structure
```java
for (int i = 0; i < 10; i++) {
    System.out.println(i);
}
```

### Key Considerations
- All components (initialization, condition, update) are optional but usually present
- The variable declared in the initialization is only in scope within the loop
- For loops are ideal when the number of iterations is known in advance
- Multiple variables can be initialized and updated in a for loop

### Example: Computing Factorial
```java
int factorial = 1;

for (int i = 1; i <= 5; i++) {
    factorial *= i;
}

System.out.println("5! = " + factorial);
```

### Enhanced For Loop (For-Each Loop)
```java
// Only applicable for arrays and collections
// Not on the AP CSA exam until later units
for (ElementType element : arrayOrCollection) {
    // Process element
}
```

## Loop Comparison: While vs. For

### When to Use While Loops
- When the number of iterations is not known in advance
- When the loop might need to execute zero times
- When the loop condition doesn't depend on a simple counter
- When working with user input or external data

### When to Use For Loops
- When the number of iterations is known in advance
- When iterating through a specific range of values
- When using a simple counter variable
- When the update expression is straightforward

### Conversion Between Loop Types
Any for loop can be rewritten as a while loop and vice versa:

```java
// For loop
for (int i = 0; i < 5; i++) {
    System.out.println(i);
}

// Equivalent while loop
int i = 0;
while (i < 5) {
    System.out.println(i);
    i++;
}
```

### Efficiency Comparison
- For loops often have cleaner syntax for simple counting loops
- While loops may be more readable for complex termination conditions
- No significant performance difference between the two

## Developing Algorithms Using Strings

### String Traversal
Examining each character in a string one by one:

```java
String str = "Hello";

// Using for loop to traverse a string
for (int i = 0; i < str.length(); i++) {
    String character = str.substring(i, i + 1);
    System.out.println("Character at index " + i + ": " + character);
}
```

### Counting Characters
```java
String str = "Mississippi";
int count = 0;

for (int i = 0; i < str.length(); i++) {
    if (str.substring(i, i + 1).equals("s")) {
        count++;
    }
}

System.out.println("Number of 's' characters: " + count);
```

### Finding Substrings
```java
String str = "programming";
boolean found = false;

for (int i = 0; i <= str.length() - 3; i++) {
    if (str.substring(i, i + 3).equals("ram")) {
        found = true;
        System.out.println("Found 'ram' at index " + i);
        break;
    }
}

if (!found) {
    System.out.println("Substring not found");
}
```

### Reversing a String
```java
String original = "Hello";
String reversed = "";

for (int i = original.length() - 1; i >= 0; i--) {
    reversed += original.substring(i, i + 1);
}

System.out.println("Reversed string: " + reversed);
```

### Palindrome Check
```java
String str = "racecar";
boolean isPalindrome = true;

for (int i = 0; i < str.length() / 2; i++) {
    String charFromFront = str.substring(i, i + 1);
    String charFromBack = str.substring(str.length() - 1 - i, str.length() - i);
    
    if (!charFromFront.equals(charFromBack)) {
        isPalindrome = false;
        break;
    }
}

System.out.println(str + " is palindrome: " + isPalindrome);
```

## Nested Iteration

### Basic Nested Loop Structure
```java
for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 4; j++) {
        System.out.print("(" + i + "," + j + ") ");
    }
    System.out.println(); // New line after each row
}
```

### Execution Flow in Nested Loops
- The outer loop executes once
- For each iteration of the outer loop, the inner loop executes completely
- Total iterations = (outer loop iterations) × (inner loop iterations)

### Examples of Nested Loop Patterns

#### Rectangle Pattern
```java
for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 5; j++) {
        System.out.print("* ");
    }
    System.out.println();
}
```
Output:
```
* * * * * 
* * * * * 
* * * * * 
```

#### Triangle Pattern
```java
for (int i = 1; i <= 5; i++) {
    for (int j = 1; j <= i; j++) {
        System.out.print("* ");
    }
    System.out.println();
}
```
Output:
```
* 
* * 
* * * 
* * * * 
* * * * * 
```

### Nested While Loops
```java
int i = 0;
while (i < 3) {
    int j = 0;
    while (j < 3) {
        System.out.print(i * j + " ");
        j++;
    }
    System.out.println();
    i++;
}
```

### Use Cases for Nested Loops
- Working with 2D structures (grids, matrices)
- Comparing all pairs of elements in a data structure
- Generating combinations or permutations
- Creating complex patterns

## Informal Code Analysis

### Tracing Loops
Tracking the execution of loops by following the values of variables at each iteration:

```java
int sum = 0;
for (int i = 1; i <= 5; i++) {
    sum += i;
}
```

**Trace Table:**
| Iteration | i | sum | Condition (i <= 5) |
|-----------|---|-----|-------------------|
| Start     | - | 0   | -                 |
| 1         | 1 | 1   | true              |
| 2         | 2 | 3   | true              |
| 3         | 3 | 6   | true              |
| 4         | 4 | 10  | true              |
| 5         | 5 | 15  | true              |
| 6         | 6 | 15  | false (exit loop) |

### Loop Execution Count
The number of iterations in a typical counting loop can be calculated as:

`IterationCount = (largestValue - smallestValue + 1)`

For example, in `for (int i = 3; i < 10; i++)`:
- Smallest value = 3
- Largest value = 9 (not 10, because of `<` instead of `<=`)
- Iteration count = (9 - 3 + 1) = 7

### Nested Loop Analysis
For nested loops, the total number of iterations is the product of the iterations of each loop:

```java
for (int i = 0; i < 5; i++) {
    for (int j = 0; j < 3; j++) {
        // Code here executes 5 × 3 = 15 times
    }
}
```

### Common Inefficiencies
1. **Unnecessary Iterations**: Continuing to loop after finding a result
2. **Redundant Calculations**: Repeatedly computing the same value
3. **Poor Loop Bounds**: Using inefficient start/end conditions
4. **String Concatenation in Loops**: Using `+=` with strings in loops

### Optimizing Loops
```java
// Inefficient: Calculating length in each iteration
for (int i = 0; i < str.length(); i++) {
    // Process string
}

// More efficient: Calculate length once
int len = str.length();
for (int i = 0; i < len; i++) {
    // Process string
}
```

## Common Coding Patterns

### Pattern 1: Finding an Element

```java
// Find first occurrence of a character in a string
public static int findChar(String str, String target) {
    for (int i = 0; i < str.length(); i++) {
        if (str.substring(i, i + 1).equals(target)) {
            return i; // Return index when found
        }
    }
    return -1; // Return -1 if not found
}
```

### Pattern 2: Counting Occurrences

```java
// Count occurrences of a character in a string
public static int countChar(String str, String target) {
    int count = 0;
    for (int i = 0; i < str.length(); i++) {
        if (str.substring(i, i + 1).equals(target)) {
            count++;
        }
    }
    return count;
}
```

### Pattern 3: Accumulating Results

```java
// Sum all even numbers from 1 to n
public static int sumEvenNumbers(int n) {
    int sum = 0;
    for (int i = 2; i <= n; i += 2) {
        sum += i;
    }
    return sum;
}
```

### Pattern 4: String Manipulation

```java
// Remove all spaces from a string
public static String removeSpaces(String str) {
    String result = "";
    for (int i = 0; i < str.length(); i++) {
        String character = str.substring(i, i + 1);
        if (!character.equals(" ")) {
            result += character;
        }
    }
    return result;
}
```

### Pattern 5: Finding Minimum or Maximum

```java
// Find the largest digit in a non-negative integer
public static int largestDigit(int num) {
    int largest = 0;
    
    while (num > 0) {
        int digit = num % 10;
        largest = Math.max(largest, digit);
        num /= 10;
    }
    
    return largest;
}
```

## Test-Taking Strategies

### For Multiple Choice Questions:
1. **Create Trace Tables**: Track variable values at each iteration
2. **Count Iterations**: Use the formula `(largestValue - smallestValue + 1)`
3. **Watch Loop Boundaries**: Pay attention to `<` vs. `<=` in loop conditions
4. **Check Initial Conditions**: Verify if loops will execute at least once
5. **Look for Infinite Loops**: Ensure loop variables are properly updated
6. **Consider Special Cases**: Empty strings, arrays with zero elements, etc.
7. **Nested Loop Analysis**: Count inner loop iterations for each outer loop iteration

### For Free Response Questions:
1. **Plan Your Approach**: Decide which loop structure is most appropriate
2. **Initialize Variables**: Set up counters and accumulators properly
3. **Set Proper Bounds**: Double-check your loop conditions
4. **Update Loop Variables**: Ensure your loop will terminate
5. **Handle Edge Cases**: Consider empty inputs, boundary values, etc.
6. **Use Early Returns**: Return when a result is found to improve efficiency
7. **Test Your Code**: Trace through your solution with sample inputs

## Sample Multiple Choice Questions

### Question 1
Consider the following code segment:
```java
int x = 0;
int y = 10;
while (x < y) {
    x += 2;
    y -= 1;
}
```

What are the values of x and y after the code segment executes?

- A) x = 8, y = 6  
- B) x = 10, y = 5  
- C) x = 12, y = 4  
- D) x = 6, y = 7  
- E) x = 10, y = 0  

### Question 2
Which of the following code segments will print exactly 5 asterisks on a single line?

- A) 
```java
for (int i = 0; i < 5; i++) {
    System.out.print("*");
}
```

- B) 
```java
for (int i = 1; i <= 5; i++) {
    System.out.print("*");
}
```

- C) 
```java
for (int i = 5; i > 0; i--) {
    System.out.print("*");
}
```

- D) 
```java
int i = 0;
while (i < 5) {
    System.out.print("*");
    i++;
}
```

- E) All of the above

### Question 3
Consider the following code segment:
```java
String str = "computer";
int count = 0;

for (int i = 0; i < str.length(); i++) {
    if (str.substring(i, i+1).equals("e") || 
        str.substring(i, i+1).equals("o")) {
        count++;
    }
}
```

What is the value of count after the code segment executes?

- A) 0  
- B) 1  
- C) 2  
- D) 3  
- E) 4  

### Question 4
What is the output of the following nested loops?
```java
for (int i = 1; i <= 3; i++) {
    for (int j = 1; j <= i; j++) {
        System.out.print(j + " ");
    }
    System.out.println();
}
```

- A) 
```
1
1 2
1 2 3
```

- B) 
```
1
2 2
3 3 3
```

- C) 
```
1 1 1
2 2
3
```

- D) 
```
1 2 3
1 2
1
```

- E) 
```
1
1 2
```

### Question 5
Consider the following code segment:
```java
String str = "ABCDEFGHI";
String result = "";

for (int i = 0; i < str.length(); i += 3) {
    result += str.substring(i, i+1);
}
```

What is the value of result after the code segment executes?

- A) "ABCDEFGHI"  
- B) "ADGHI"  
- C) "ADG"  
- D) "BCEFHI"  
- E) "CEI"  

## Sample Free Response Question

### Question: WordAnalyzer

You are creating a program to analyze text for various patterns. Implement the `WordAnalyzer` class with the following methods:

1. A method that counts the number of vowels in a string
2. A method that determines if a string contains consecutive duplicate characters
3. A method that finds the longest sequence of consecutive equal characters in a string
4. A method that returns the most frequent character in a string

**Key Concepts Demonstrated:**
1. String traversal and character analysis using substring
2. Counters and flags
3. Comparing adjacent elements
4. Finding maximum values
5. Tracking state within loops
6. Array-based frequency counting (in one implementation)
7. Nested loops for character frequency analysis
8. Loop bounds and conditions