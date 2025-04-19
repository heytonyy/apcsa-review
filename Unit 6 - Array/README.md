# Unit 6: Arrays

## Table of Contents

1. [Unit Overview](#unit-overview)
2. [Essential Concepts](#essential-concepts)
3. [Array Basics](#array-basics)
4. [Array Creation and Initialization](#array-creation-and-initialization)
5. [Accessing and Modifying Array Elements](#accessing-and-modifying-array-elements)
6. [Array Traversal](#array-traversal)
7. [Common Array Algorithms](#common-array-algorithms)
8. [Arrays with Methods](#arrays-with-methods)
9. [Arrays with Objects](#arrays-with-objects)
10. [Common Coding Patterns](#common-coding-patterns)
11. [Test-Taking Strategies](#test-taking-strategies)
12. [Sample Multiple Choice Questions](#sample-multiple-choice-questions)
13. [Sample Free Response Question](#sample-free-response-question)

## Unit Overview

Unit 6 focuses on arrays in Java, which are fundamental data structures that allow you to store multiple values of the same type in a single variable. Arrays are essential for organizing and manipulating collections of data efficiently. In AP CSA, array concepts represent approximately 7.5-10% of the exam, making them an important topic to master.

**Key Topics in This Unit:**
- Creating and initializing arrays
- Accessing and modifying array elements
- Traversing arrays
- Developing common array algorithms
- Using arrays with methods and objects
- Understanding array bounds and exceptions

## Essential Concepts

### Computational Thinking Practices Addressed:
- Program design (organizing data with arrays)
- Code implementation (using arrays to solve problems)
- Code analysis (understanding array algorithms)

### Course Skills Developed:
- VAR-2.A: Represent collections of related primitive or object reference data using one-dimensional (1D) array objects
- VAR-2.B: Traverse the elements in a 1D array

## Array Basics

### What is an Array?
- A fixed-size collection of elements of the same type
- Stores primitive values or object references
- Uses zero-based indexing (first element is at index 0)
- Has a length that cannot be changed after creation
- Is itself an object (with a `length` property)

### Array Features:
- Efficient random access to elements (using an index)
- Memory allocation is contiguous
- Length is fixed at creation time
- All elements are initialized to default values:
  - Numeric types: 0
  - boolean: false
  - Object references: null

### Array vs. Regular Variables:
```java
// Regular variables - each needs a separate declaration
int score1 = 85;
int score2 = 90;
int score3 = 78;

// Array - contains multiple values in a single variable
int[] scores = new int[3];
scores[0] = 85;
scores[1] = 90;
scores[2] = 78;
```

## Array Creation and Initialization

### Declaration:
- Format: `elementType[] arrayName;`
- Alternative format: `elementType arrayName[];` (less common)

```java
// Array declaration examples
int[] numbers;            // Array of integers
double[] measurements;    // Array of doubles
String[] names;           // Array of Strings
boolean[] flags;          // Array of booleans
Student[] students;       // Array of Student objects
```

### Allocation:
- Format: `arrayName = new elementType[length];`
- Creates an array with the specified number of elements
- Elements are initialized to default values

```java
// Array allocation examples
numbers = new int[10];           // Creates array of 10 integers
measurements = new double[5];    // Creates array of 5 doubles
names = new String[20];          // Creates array of 20 Strings
```

### Combined Declaration and Allocation:
- Format: `elementType[] arrayName = new elementType[length];`

```java
// Combined declaration and allocation
int[] counts = new int[100];
double[] prices = new double[50];
```

### Array Initialization with Values:
- Format: `elementType[] arrayName = {value1, value2, ...};`
- Creates and initializes array in one step

```java
// Array initialization with values
int[] primes = {2, 3, 5, 7, 11, 13};
String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
```

### Alternative Initialization Syntax:
- Format: `elementType[] arrayName = new elementType[] {value1, value2, ...};`

```java
// Alternative initialization syntax
int[] fibonacci = new int[] {1, 1, 2, 3, 5, 8, 13};
```

## Accessing and Modifying Array Elements

### Accessing Elements:
- Format: `arrayName[index]`
- Index must be an integer expression (0 to length-1)

```java
// Accessing array elements
int firstNumber = numbers[0];         // Gets first element
int lastNumber = numbers[numbers.length - 1];  // Gets last element
String day = days[2];                 // Gets the third element ("Wednesday")
```

### Modifying Elements:
- Format: `arrayName[index] = value;`
- Index must be valid (within array bounds)

```java
// Modifying array elements
scores[0] = 95;           // Changes first element to 95
names[3] = "Alex";        // Assigns "Alex" to the fourth element
```

### Getting Array Length:
- Format: `arrayName.length`
- Note: This is a property, not a method (no parentheses)

```java
// Getting array length
int size = numbers.length;   // Gets the number of elements in the array
```

### Valid Index Range:
- From 0 to length-1 (inclusive)
- Accessing an index outside this range causes an `ArrayIndexOutOfBoundsException`

```java
// Valid index range
int[] data = new int[5];   // Indices are 0, 1, 2, 3, 4
data[0] = 10;              // Valid
data[4] = 50;              // Valid
// data[5] = 60;           // Invalid - causes ArrayIndexOutOfBoundsException
// data[-1] = 20;          // Invalid - causes ArrayIndexOutOfBoundsException
```

## Array Traversal

### Traversing with for Loop:
- Most common method for array traversal
- Uses index variable to access elements

```java
// Traversing with for loop
int[] values = {10, 20, 30, 40, 50};
for (int i = 0; i < values.length; i++) {
    System.out.println("Element at index " + i + ": " + values[i]);
}
```

### Traversing with Enhanced for Loop (for-each):
- Simpler syntax for full traversal
- No explicit index variable
- Cannot modify array elements
- Cannot process elements in reverse order

```java
// Traversing with enhanced for loop
int[] values = {10, 20, 30, 40, 50};
for (int value : values) {
    System.out.println("Value: " + value);
}
```

### Partial Traversal:
- Processing only a subset of array elements

```java
// Processing only the first half of an array
int[] data = {10, 20, 30, 40, 50, 60};
for (int i = 0; i < data.length / 2; i++) {
    System.out.println(data[i]);
}
```

### Traversing in Reverse Order:
- Processing elements from last to first

```java
// Processing elements in reverse order
int[] data = {10, 20, 30, 40, 50};
for (int i = data.length - 1; i >= 0; i--) {
    System.out.println(data[i]);
}
```

## Common Array Algorithms

### Sum of All Elements:
```java
public static int sum(int[] arr) {
    int total = 0;
    for (int value : arr) {
        total += value;
    }
    return total;
}
```

### Finding Maximum/Minimum:
```java
public static int findMax(int[] arr) {
    if (arr.length == 0) {
        throw new IllegalArgumentException("Array is empty");
    }
    
    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {
        if (arr[i] > max) {
            max = arr[i];
        }
    }
    return max;
}

public static int findMin(int[] arr) {
    if (arr.length == 0) {
        throw new IllegalArgumentException("Array is empty");
    }
    
    int min = arr[0];
    for (int i = 1; i < arr.length; i++) {
        if (arr[i] < min) {
            min = arr[i];
        }
    }
    return min;
}
```

### Linear Search:
```java
public static int linearSearch(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) {
            return i; // Return index if found
        }
    }
    return -1; // Return -1 if not found
}
```

### Counting Elements That Meet a Condition:
```java
public static int countEvens(int[] arr) {
    int count = 0;
    for (int value : arr) {
        if (value % 2 == 0) {
            count++;
        }
    }
    return count;
}
```

### Computing Average:
```java
public static double average(int[] arr) {
    if (arr.length == 0) {
        throw new IllegalArgumentException("Array is empty");
    }
    
    int sum = 0;
    for (int value : arr) {
        sum += value;
    }
    return (double) sum / arr.length;
}
```

### Shifting Elements:
```java
// Shift all elements one position to the right
public static void shiftRight(int[] arr) {
    if (arr.length <= 1) {
        return; // Nothing to shift
    }
    
    int last = arr[arr.length - 1];
    for (int i = arr.length - 1; i > 0; i--) {
        arr[i] = arr[i - 1];
    }
    arr[0] = last;
}
```

### Reversing an Array:
```java
public static void reverse(int[] arr) {
    int left = 0;
    int right = arr.length - 1;
    
    while (left < right) {
        // Swap elements at left and right indices
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        
        // Move towards the center
        left++;
        right--;
    }
}
```

## Arrays with Methods

### Arrays as Parameters:
- Arrays are passed by reference
- Changes to array elements within a method affect the original array

```java
public static void modifyArray(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
        arr[i] *= 2; // Doubles each element
    }
}

// Usage
int[] values = {1, 2, 3, 4, 5};
modifyArray(values);
// Now values contains {2, 4, 6, 8, 10}
```

### Returning Arrays:
- Methods can return array references

```java
public static int[] createEvenArray(int n) {
    int[] result = new int[n];
    for (int i = 0; i < n; i++) {
        result[i] = i * 2;
    }
    return result;
}

// Usage
int[] evenNumbers = createEvenArray(5);
// evenNumbers contains {0, 2, 4, 6, 8}
```

### Copying Arrays:
- Using loops to create a copy

```java
// Manual copy
public static int[] copyArray(int[] source) {
    int[] copy = new int[source.length];
    for (int i = 0; i < source.length; i++) {
        copy[i] = source[i];
    }
    return copy;
}
```

## Arrays with Objects

### Creating Arrays of Objects:
- References to objects are stored, not the objects themselves
- Elements initialized to `null`
- Must create individual objects separately

```java
// Array of Student objects
Student[] roster = new Student[30];

// Creating and adding objects
roster[0] = new Student("Alice", 3.95);
roster[1] = new Student("Bob", 3.75);
roster[2] = new Student("Charlie", 4.0);
```

### Accessing Object Methods:
```java
// Using object methods through array elements
Student[] roster = new Student[3];
roster[0] = new Student("Alice", 3.95);
roster[1] = new Student("Bob", 3.75);
roster[2] = new Student("Charlie", 4.0);

// Access methods on objects
String name = roster[0].getName();
double gpa = roster[1].getGpa();
roster[2].setGpa(3.9);
```

### Array of Objects Example:
```java
public class Classroom {
    private Student[] students;
    private int count; // Number of students actually in the array
    
    public Classroom(int capacity) {
        students = new Student[capacity];
        count = 0;
    }
    
    public void addStudent(Student student) {
        if (count < students.length) {
            students[count] = student;
            count++;
        }
    }
    
    public double getClassAverage() {
        if (count == 0) {
            return 0.0;
        }
        
        double sum = 0.0;
        for (int i = 0; i < count; i++) {
            sum += students[i].getGpa();
        }
        return sum / count;
    }
}
```

## Common Coding Patterns

### Pattern 1: Finding an Element in an Array

```java
// Find an element in an array of primitives
public static int findElement(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) {
            return i; // Return index if found
        }
    }
    return -1; // Return -1 if not found
}

// Find an element in an array of objects
public static int findStudent(Student[] students, String name) {
    for (int i = 0; i < students.length; i++) {
        if (students[i] != null && students[i].getName().equals(name)) {
            return i;
        }
    }
    return -1;
}
```

### Pattern 2: Inserting an Element at a Specific Position

```java
public static int[] insertElement(int[] original, int value, int position) {
    if (position < 0 || position > original.length) {
        throw new IllegalArgumentException("Invalid position");
    }
    
    int[] result = new int[original.length + 1];
    
    // Copy elements before the position
    for (int i = 0; i < position; i++) {
        result[i] = original[i];
    }
    
    // Insert the new element
    result[position] = value;
    
    // Copy elements after the position
    for (int i = position; i < original.length; i++) {
        result[i + 1] = original[i];
    }
    
    return result;
}
```

### Pattern 3: Removing an Element from an Array

```java
public static int[] removeElement(int[] original, int position) {
    if (position < 0 || position >= original.length) {
        throw new IllegalArgumentException("Invalid position");
    }
    
    int[] result = new int[original.length - 1];
    
    // Copy elements before the position
    for (int i = 0; i < position; i++) {
        result[i] = original[i];
    }
    
    // Copy elements after the position
    for (int i = position + 1; i < original.length; i++) {
        result[i - 1] = original[i];
    }
    
    return result;
}
```

### Pattern 4: Filtering Elements Based on a Condition

```java
// Count elements that meet a condition
public static int countMatches(int[] arr, int threshold) {
    int count = 0;
    for (int value : arr) {
        if (value > threshold) {
            count++;
        }
    }
    return count;
}

// Create a new array with filtered elements
public static int[] filterGreaterThan(int[] arr, int threshold) {
    // First, count how many elements meet the condition
    int count = countMatches(arr, threshold);
    
    // Create new array of exact size needed
    int[] result = new int[count];
    
    // Fill the new array with values that meet the condition
    int resultIndex = 0;
    for (int value : arr) {
        if (value > threshold) {
            result[resultIndex] = value;
            resultIndex++;
        }
    }
    
    return result;
}
```

## Test-Taking Strategies

### For Multiple Choice Questions:

1. **Watch for Off-by-One Errors**: Be especially careful with array indices; remember they start at 0 and go to length-1.
2. **Trace Array Modifications**: When code modifies an array, trace through each change carefully.
3. **Distinguish Between Index and Value**: Don't confuse the index (position) with the value stored at that position.
4. **Handle Enhanced For Loop Limitations**: Remember that enhanced for loops can't modify array elements.
5. **Check for null References**: With arrays of objects, always consider whether elements might be null.
6. **Consider Array Bounds**: Be alert for potential `ArrayIndexOutOfBoundsException` errors.
7. **Pay Attention to Return Types**: If a method returns an array, understand what's in that array.

### For Free Response Questions:

1. **Initialize Arrays Properly**: Make sure arrays are properly created and initialized.
2. **Validate Indices**: Check that indices are within bounds before accessing array elements.
3. **Use Descriptive Variable Names**: Use names like `index` and `count` that clarify your code's purpose.
4. **Test Boundary Conditions**: Consider what happens at the first and last elements of an array.
5. **Avoid Hardcoding Array Sizes**: Use array length properties instead of hardcoded values.
6. **Document Algorithms**: Add comments explaining complex array manipulations.
7. **Verify Array Access Patterns**: Double-check loops to ensure correct traversal of arrays.

## Sample Multiple Choice Questions

### Question 1

Consider the following code segment:

```java
int[] arr = {3, 8, 5, 7, 2, 4};
int total = 0;
for (int i = 0; i < arr.length; i += 2) {
    total += arr[i];
}
```

What is the value of `total` after this code executes?

- A) 29  
- B) 26  
- C) 14  
- D) 10  
- E) 18  

### Question 2

Consider the following code segment:

```java
int[] values = new int[5];
for (int i = 0; i < values.length; i++) {
    values[i] = i * i;
}
int result = values[2] + values[4] - values[1];
```

What is the value of `result` after this code executes?

- A) 15  
- B) 16  
- C) 17  
- D) 19  
- E) 20  

### Question 3

Consider the following method:

```java
public static void mystery(int[] arr) {
    for (int i = 0; i < arr.length / 2; i++) {
        int temp = arr[i];
        arr[i] = arr[arr.length - 1 - i];
        arr[arr.length - 1 - i] = temp;
    }
}
```

What does this method do to the array passed as a parameter?

- A) Sorts the array in ascending order  
- B) Sorts the array in descending order  
- C) Reverses the order of elements in the array  
- D) Shifts all elements one position to the right  
- E) Replaces each element with its square  

### Question 4

Consider the following code segment:

```java
public static void modifyArray(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
        arr[i] = arr[i] * 2;
    }
}

public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4, 5};
    modifyArray(nums);
    System.out.println(nums[2]);
}
```

What is the output of this code segment?

- A) 2  
- B) 3  
- C) 4  
- D) 6  
- E) 10  

### Question 5

Consider the following code segment:

```java
int[] arr = {5, 10, 15, 20, 25};
for (int x : arr) {
    x = x + 5;
}
System.out.println(arr[2]);
```

What is the output of this code segment?

- A) 5  
- B) 10  
- C) 15  
- D) 20  
- E) 25  

## Sample Free Response Question

### Question: Array Statistics

You are given an array of integer values representing daily rainfall measurements over a period of time. Design a class called `RainfallAnalyzer` that processes this data and provides various statistics.

Your class should include:

1. A constructor that takes an array of integers (rainfall amounts in millimeters)
2. A method to find the average daily rainfall
3. A method to find the number of dry days (days with zero rainfall)
4. A method to find the wettest day (the maximum rainfall amount)
5. A method that returns a new array containing only the wet days (days with non-zero rainfall)
6. A method that returns a boolean indicating whether there was any period of at least 3 consecutive dry days

**Key Points to Include in Your Answer:**
1. Properly creating and manipulating the array data
2. Correctly implementing algorithms for finding statistics
3. Handling edge cases (empty arrays, etc.)
4. Creating a new array with the correct size for wet days
5. Implementing the consecutive dry days algorithm correctly
6. Following good object-oriented design principles
7. Using appropriate variable names and clear code structure