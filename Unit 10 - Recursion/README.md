# Unit 10: Recursion

## Table of Contents

1. [Unit Overview](#unit-overview)
2. [Essential Concepts](#essential-concepts)
3. [Recursion Fundamentals](#recursion-fundamentals)
4. [Recursive vs. Iterative Solutions](#recursive-vs-iterative-solutions)
5. [Writing Recursive Methods](#writing-recursive-methods)
6. [Tracing Recursive Methods](#tracing-recursive-methods)
7. [Common Recursive Algorithms](#common-recursive-algorithms)
8. [Recursion with Strings and Arrays](#recursion-with-strings-and-arrays)
9. [Test-Taking Strategies](#test-taking-strategies)
10. [Sample Multiple Choice Questions](#sample-multiple-choice-questions)
11. [Sample Free Response Question](#sample-free-response-question)

## Unit Overview

Unit 10 focuses on recursion, which is a powerful programming technique where a method calls itself to solve a problem. This is the final unit in the AP CSA curriculum and represents approximately 5-7.5% of the AP CSA exam weight. Recursion is a key concept in computer science that allows for elegant solutions to complex problems.

**Key Topics in This Unit:**

- Understanding recursive methods
- Analyzing and developing recursive algorithms
- Comparing recursive vs. iterative approaches
- Tracing recursive method execution
- Implementing common recursive algorithms

## Essential Concepts

### Computational Thinking Practices Addressed:

- Program Analysis (analyzing how recursive methods work)
- Code Implementation (writing recursive methods)
- Algorithm Implementation (implementing recursive algorithms)

### Course Skills Developed:

- CON-2.L: Determine the result of recursive method calls
- CON-2.M: Identify base case and recursive step in recursive methods
- CON-2.N: Write recursive methods
- CON-2.O: Compare iterative and recursive solution alternatives

## Recursion Fundamentals

### What is Recursion?

- Recursion is a programming technique where a method calls itself to solve a problem
- The method breaks down the problem into smaller, similar subproblems
- Each recursive call works on a simpler version of the original problem
- Eventually, the problem becomes simple enough to solve directly (the base case)

### Key Components of Recursion:

1. **Base Case(s)**: The simplest version of the problem that can be solved directly without further recursion
2. **Recursive Case(s)**: The part where the method calls itself with a simpler version of the problem
3. **Progress Toward Base Case**: Each recursive call must make progress toward the base case

### How Recursion Works:

- When a method calls itself, a new activation record (stack frame) is created on the call stack
- Each stack frame contains its own set of parameters and local variables
- As the recursion progresses, the stack builds up with multiple frames
- Once the base case is reached, the stack unwinds as each method call returns its result
- The final result is passed back through the chain of returns

### Example: Basic Recursion

```java
// Factorial of n (n!)
public static int factorial(int n) {
    // Base case
    if (n == 0 || n == 1) {
        return 1;
    }
    // Recursive case
    else {
        return n * factorial(n - 1);
    }
}
```

### Call Stack Visualization for factorial(4):

```
Call                   Return
factorial(4)           24 ← 4 * 6
  └── factorial(3)     6  ← 3 * 2
       └── factorial(2) 2  ← 2 * 1
            └── factorial(1) 1  ← Base case
```

## Recursive vs. Iterative Solutions

### Comparing Approaches:

| Aspect | Recursive | Iterative |
|--------|-----------|-----------|
| Code Clarity | Often clearer for certain problems | May be more complex for certain problems |
| Memory Usage | Uses call stack (space overhead) | Typically uses less memory |
| Performance | May be slower due to function call overhead | Often faster |
| Implementation | Uses method calls to itself | Uses loops (for, while) |
| Problem Suitability | Natural for problems with recursive structures | Good for simple repetitive tasks |

### Example: Factorial Comparison

#### Recursive Implementation:

```java
public static int factorialRecursive(int n) {
    if (n == 0 || n == 1) {
        return 1;
    } else {
        return n * factorialRecursive(n - 1);
    }
}
```

#### Iterative Implementation:

```java
public static int factorialIterative(int n) {
    int result = 1;
    for (int i = 2; i <= n; i++) {
        result *= i;
    }
    return result;
}
```

### When to Use Recursion:

- When the problem has a recursive structure (like tree traversal)
- When the problem can be broken down into smaller, similar subproblems
- When code clarity is more important than performance
- When the depth of recursion is reasonably limited

### When to Use Iteration:

- When efficiency is critical
- When the problem is simple and can be solved with straightforward loops
- When the recursion depth might be large (to avoid stack overflow)
- When managing state is more straightforward with variables than with recursive calls

## Writing Recursive Methods

### Steps to Developing a Recursive Method:

1. **Identify the Base Case(s)**:
   - Determine the simplest version of the problem
   - Define what the method should return for this simplest case

2. **Define the Recursive Case**:
   - Break down the problem into a smaller subproblem
   - Ensure each recursive call moves toward the base case
   - Combine the result of the recursive call with additional processing if needed

3. **Verify the Solution**:
   - Trace the execution for simple inputs
   - Check that each recursive call simplifies the problem
   - Confirm the method eventually reaches the base case

### Common Pitfalls to Avoid:

- **Missing Base Case**: Leads to infinite recursion and stack overflow
- **Incorrect Base Case**: Produces wrong results
- **No Progress Toward Base Case**: Causes infinite recursion
- **Inefficient Recursive Structure**: Can lead to redundant calculations

### Example: Writing a Recursive Method

```java
// Sum of integers from 1 to n
public static int sum(int n) {
    // Step 1: Identify the base case
    if (n == 1) {
        return 1;  // Sum of 1 is just 1
    }
    // Step 2: Define the recursive case
    else {
        return n + sum(n - 1);  // n plus the sum of (n-1)
    }
}
```

## Tracing Recursive Methods

### How to Trace Recursive Methods:

1. **Draw the Call Tree**:
   - Start with the initial call
   - Draw branches for each recursive call
   - Continue until all branches reach a base case

2. **Track Parameters and Return Values**:
   - Note the parameter values for each call
   - Record the return value from each call
   - Show how return values combine up the call tree

3. **Follow the Execution Order**:
   - Trace calls in order of execution (depth-first)
   - Follow the unwinding of the call stack as methods return

### Example: Tracing the Fibonacci Sequence

```java
public static int fibonacci(int n) {
    if (n == 0) {
        return 0;
    } else if (n == 1) {
        return 1;
    } else {
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
```

Tracing fibonacci(4):

```
fibonacci(4)
├── fibonacci(3)
│   ├── fibonacci(2)
│   │   ├── fibonacci(1) → 1
│   │   └── fibonacci(0) → 0
│   │   Result: 1 + 0 = 1
│   └── fibonacci(1) → 1
│   Result: 1 + 1 = 2
└── fibonacci(2)
    ├── fibonacci(1) → 1
    └── fibonacci(0) → 0
    Result: 1 + 0 = 1
Result: 2 + 1 = 3
```

### Common Tracing Mistakes:

- Losing track of which method call is currently being processed
- Forgetting to combine results correctly during unwinding
- Mishandling the order of operations in compound expressions
- Skipping steps in the recursive process

## Common Recursive Algorithms

### 1. Factorial:

```java
public static int factorial(int n) {
    if (n == 0 || n == 1) {
        return 1;
    } else {
        return n * factorial(n - 1);
    }
}
```

### 2. Fibonacci Sequence:

```java
public static int fibonacci(int n) {
    if (n == 0) {
        return 0;
    } else if (n == 1) {
        return 1;
    } else {
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
```

### 3. Sum of Array Elements:

```java
public static int sumArray(int[] arr, int index) {
    if (index >= arr.length) {
        return 0;  // Base case: empty array or past the end
    } else {
        return arr[index] + sumArray(arr, index + 1);  // Current element + sum of rest
    }
}

// Usage: sumArray(myArray, 0) to start from the beginning
```

### 4. Greatest Common Divisor (GCD):

```java
public static int gcd(int a, int b) {
    if (b == 0) {
        return a;  // Base case
    } else {
        return gcd(b, a % b);  // Euclid's algorithm
    }
}
```

### 5. Power Function:

```java
public static int power(int base, int exponent) {
    if (exponent == 0) {
        return 1;  // Base case: any number to the power of 0 is 1
    } else {
        return base * power(base, exponent - 1);
    }
}
```

### 6. Binary Search:

```java
public static int binarySearch(int[] arr, int target, int left, int right) {
    if (left > right) {
        return -1;  // Base case: not found
    }
    
    int mid = (left + right) / 2;
    
    if (arr[mid] == target) {
        return mid;  // Base case: found the target
    } else if (arr[mid] > target) {
        return binarySearch(arr, target, left, mid - 1);  // Search left half
    } else {
        return binarySearch(arr, target, mid + 1, right);  // Search right half
    }
}

// Usage: binarySearch(sortedArray, target, 0, sortedArray.length - 1)
```

### 7. Count Occurrences in Array:

```java
public static int countOccurrences(int[] arr, int target, int index) {
    if (index >= arr.length) {
        return 0;  // Base case: reached the end
    }
    
    int count = 0;
    if (arr[index] == target) {
        count = 1;  // Found one occurrence
    }
    
    return count + countOccurrences(arr, target, index + 1);
}

// Usage: countOccurrences(myArray, target, 0)
```

## Recursion with Strings and Arrays

### String Manipulation:

#### 1. String Reversal:

```java
public static String reverse(String str) {
    if (str.length() <= 1) {
        return str;  // Base case: empty string or single character
    } else {
        String firstPart = str.substring(0, 1);
        String restReversed = reverse(str.substring(1));
        return restReversed + firstPart;  // Append first part to the end
    }
}
```

#### 2. Palindrome Check:

```java
public static boolean isPalindrome(String str) {
    // Base cases
    if (str.length() <= 1) {
        return true;
    }
    
    // Check first and last characters
    if (!str.substring(0, 1).equals(str.substring(str.length() - 1))) {
        return false;
    }
    
    // Recursive case: check the substring without first and last chars
    return isPalindrome(str.substring(1, str.length() - 1));
}
```

### Array Processing:

#### 1. Find Maximum in Array:

```java
public static int findMax(int[] arr, int index) {
    // Base case: only one element left
    if (index == arr.length - 1) {
        return arr[index];
    }
    
    // Recursive case: find maximum of current element and rest of array
    int maxOfRest = findMax(arr, index + 1);
    return Math.max(arr[index], maxOfRest);
}

// Usage: findMax(myArray, 0)
```

#### 2. Check if Array is Sorted:

```java
public static boolean isSorted(int[] arr, int index) {
    // Base case: reached the end or only one element
    if (index >= arr.length - 1) {
        return true;
    }
    
    // Check if current and next elements are in order
    if (arr[index] > arr[index + 1]) {
        return false;
    }
    
    // Recursive case: check rest of the array
    return isSorted(arr, index + 1);
}

// Usage: isSorted(myArray, 0)
```

### Example: Recursive String Count

```java
public class StringProcessor {
    public static void main(String[] args) {
        String text = "Hello, World!";
        String target = "l";
        
        int count = countString(text, target, 0);
        System.out.println("The string '" + target + "' appears " + count + " times.");
    }
    
    public static int countString(String str, String target, int index) {
        // Base case: end of string
        if (index >= str.length() - target.length() + 1) {
            return 0;
        }
        
        // Count current occurrence if it matches
        int currentCount = 0;
        if (str.substring(index, index + target.length()).equals(target)) {
            currentCount = 1;
        }
        
        // Add count from rest of string
        return currentCount + countString(str, target, index + 1);
    }
}
```

## Test-Taking Strategies

### For Multiple Choice Questions:

1. **Identify Base Cases**: Look for the terminating condition in the recursive method.

2. **Trace Through Execution**: For questions about the result of a recursive call, trace through the execution step by step.

3. **Count Recursive Calls**: Some questions may ask how many recursive calls are made for a specific input.

4. **Consider Edge Cases**: Check how the method handles edge cases like zero, negative numbers, or empty collections.

5. **Watch for Infinite Recursion**: Identify if a recursive method might never reach its base case.

6. **Understand Call Stack**: Visualize how the call stack builds up and unwinds during recursion.

7. **Compare Time Complexity**: Be able to analyze the time complexity of recursive algorithms (especially common ones).

### For Free Response Questions:

1. **Start with Base Cases**: Always begin by identifying and handling base cases properly.

2. **Ensure Progress**: Make sure each recursive call moves closer to the base case.

3. **Simplify the Problem**: Break down the problem into a simpler subproblem that can be solved recursively.

4. **Handle Parameters**: Be careful with parameter manipulation in recursive calls.

5. **Combine Results**: Pay attention to how you combine the results of recursive calls.

6. **Test with Simple Examples**: Mentally trace your solution with simple examples to verify correctness.

7. **Consider Efficiency**: Be aware of potentially redundant calculations in your recursive solution.

## Sample Multiple Choice Questions

### Question 1

Consider the following recursive method:

```java
public static int mystery(int n) {
    if (n == 1) {
        return 1;
    } else {
        return n + mystery(n - 1);
    }
}
```

What is the value of `mystery(5)`?

- A) 5  
- B) 10  
- C) 15  
- D) 20  
- E) 25

### Question 2

Consider the following recursive method:

```java
public static int recur(int n) {
    if (n <= 10) {
        return n * 2;
    } else {
        return recur(n - 7);
    }
}
```

What is the value of `recur(24)`?

- A) 6  
- B) 10  
- C) 12  
- D) 14  
- E) 20

### Question 3

Consider the following recursive method:

```java
public static int bunnyEars(int bunnies) {
    if (bunnies == 0) {
        return 0;
    } else {
        return 2 + bunnyEars(bunnies - 1);
    }
}
```

How many recursive calls are made when evaluating `bunnyEars(5)`?

- A) 1  
- B) 4  
- C) 5  
- D) 6  
- E) 10

### Question 4

Consider the following recursive method:

```java
public static int countX(String str) {
    if (str.length() == 0) {
        return 0;
    }
    
    int count = 0;
    if (str.substring(0, 1).equals("x")) {
        count = 1;
    }
    
    return count + countX(str.substring(1));
}
```

What is the result of calling `countX("xaxbxc")`?

- A) 1  
- B) 2  
- C) 3  
- D) 4  
- E) 5

### Question 5

Consider the following recursive method:

```java
public static int recursive(int m, int n) {
    if (m == 0) {
        return n + 1;
    } else if (n == 0) {
        return recursive(m - 1, 1);
    } else {
        return recursive(m - 1, recursive(m, n - 1));
    }
}
```

What is the value of `recursive(2, 1)`?

- A) 3  
- B) 4  
- C) 5  
- D) 6  
- E) 7

## Sample Free Response Question

### Question: Recursive String Pattern Checker

You are given a method that checks if a string follows a specific pattern. A string follows the pattern if:

1. It consists entirely of repeated blocks of the same substring.
2. Each block must be at least one character long.

For example:
- "abcabc" follows the pattern (two blocks of "abc")
- "xxxxxx" follows the pattern (six blocks of "x")
- "abcdabcd" follows the pattern (two blocks of "abcd")
- "abc" follows the pattern (one block of "abc")
- "abcde" does not follow the pattern (cannot be divided into blocks)
- "abcdeabc" does not follow the pattern (incomplete block at the end)

Write a recursive method `checkPattern` that takes a string and returns `true` if it follows the pattern, and `false` otherwise. Your method should identify the shortest possible block that can be repeated to form the string.

**Complete the implementation of the class below:**

```java
public class PatternChecker {
    
    public static boolean checkPattern(String str) {
        // Call the helper method with starting prefix length 1
        return checkPatternHelper(str, 1);
    }
    
    private static boolean checkPatternHelper(String str, int prefixLength) {
        // Your code here
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println(checkPattern("abcabc")); // true
        System.out.println(checkPattern("xxxxxx")); // true
        System.out.println(checkPattern("abcdabcd")); // true
        System.out.println(checkPattern("abc")); // true
        System.out.println(checkPattern("abcde")); // false
        System.out.println(checkPattern("abcdeabc")); // false
    }
}
```

**Key Points for Evaluation:**

1. **Correct Base Cases**: The solution includes proper base cases for empty strings and when prefix length exceeds string length.

2. **Recursive Structure**: The method correctly uses recursion to try different prefix lengths.

3. **Complete Logic**: The solution checks if the string is evenly divisible by the prefix length and if all blocks match the prefix.

4. **Efficiency**: The solution avoids redundant checks by only testing prefix lengths that could potentially divide the string evenly.

5. **Correct Return Values**: The method returns true only when a valid pattern is found, and false otherwise.

6. **Proper Testing**: The main method includes comprehensive test cases to verify the solution works.