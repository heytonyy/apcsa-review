# Unit 8: 2D Arrays

## Table of Contents

1. [Unit Overview](#unit-overview)
2. [Essential Concepts](#essential-concepts)
3. [2D Array Fundamentals](#2d-array-fundamentals)
4. [Creating and Initializing 2D Arrays](#creating-and-initializing-2d-arrays)
5. [Accessing and Modifying 2D Arrays](#accessing-and-modifying-2d-arrays)
6. [Traversing 2D Arrays](#traversing-2d-arrays)
7. [Common 2D Array Algorithms](#common-2d-array-algorithms)
8. [Test-Taking Strategies](#test-taking-strategies)
9. [Sample Multiple Choice Questions](#sample-multiple-choice-questions)
10. [Sample Free Response Question](#sample-free-response-question)

## Unit Overview

Unit 8 focuses on two-dimensional arrays in Java, which are essentially arrays of arrays. This unit builds on your understanding of one-dimensional arrays from Unit 6 and extends that knowledge to handle more complex data structures. Two-dimensional arrays are particularly useful for representing tables, grids, matrices, and other data that naturally fit into rows and columns. This unit represents approximately 7.5-10% of the AP CSA exam weight.

**Key Topics in This Unit:**

- 2D array creation and access
- Nested iteration through 2D arrays
- Algorithms involving 2D arrays
- Traversal patterns (row-major vs. column-major)
- Square and rectangular 2D arrays

## Essential Concepts

### Computational Thinking Practices Addressed:

- Program design and algorithm development
- Code logic with 2D data structures
- Code implementation with nested loops
- Program analysis of complex data structures

### Course Skills Developed:

- VAR-2.C: Identify the most appropriate data types and variables to represent data in a program that uses 2D arrays
- VAR-2.D: Initialize and modify elements in a 2D array
- CON-2.J: Traverse a 2D array using nested for loops
- CON-2.K: For algorithms in the context of a particular specification that require the use of 2D array traversals

## 2D Array Fundamentals

### Concept of 2D Arrays:

- A 2D array is an array whose elements are 1D arrays
- Conceptually represented as a grid or table with rows and columns
- Each element is accessed using two indices: one for row and one for column
- First index represents the row, second index represents the column
- Indices are zero-based (first element is at position [0][0])

### Memory Model for 2D Arrays:

- In Java, a 2D array is implemented as an array of references to 1D arrays
- Each row is a separate 1D array object
- The 2D array variable stores a reference to an array of row references

### Example: Visualizing a 2D Array

```
2D array int[][] grid = new int[3][4]:

grid[0][0] grid[0][1] grid[0][2] grid[0][3]  ← row 0
grid[1][0] grid[1][1] grid[1][2] grid[1][3]  ← row 1
grid[2][0] grid[2][1] grid[2][2] grid[2][3]  ← row 2
   ↑         ↑         ↑         ↑
 col 0     col 1     col 2     col 3
```

## Creating and Initializing 2D Arrays

### Declaration:

- Format: `dataType[][] arrayName;` or `dataType arrayName[][];`
- Example: `int[][] matrix;` or `double scores[][];`

### Instantiation:

- Format: `arrayName = new dataType[numRows][numCols];`
- Example: `matrix = new int[3][4];` (3 rows, 4 columns)

### Combined Declaration and Instantiation:

- Format: `dataType[][] arrayName = new dataType[numRows][numCols];`
- Example: `int[][] grid = new int[5][5];`

### Initialization with Values:

- Method 1: Initialize at declaration
  ```java
  int[][] matrix = {
      {1, 2, 3},
      {4, 5, 6},
      {7, 8, 9}
  };
  ```

- Method 2: Set values after declaration
  ```java
  int[][] grid = new int[2][3];
  grid[0][0] = 1; grid[0][1] = 2; grid[0][2] = 3;
  grid[1][0] = 4; grid[1][1] = 5; grid[1][2] = 6;
  ```

### Example: Creating and Initializing 2D Arrays

```java
// Declaration only
int[][] temperatures;

// Declaration and instantiation
temperatures = new int[7][24]; // 7 days, 24 hours per day

// Combined declaration, instantiation, and initialization
double[][] testScores = {
    {98.5, 87.0, 93.5}, // Student 1's scores
    {77.0, 82.5, 91.0}, // Student 2's scores
    {92.0, 89.5, 85.0}  // Student 3's scores
};

// Square 2D array (4x4)
int[][] gameBoard = new int[4][4];
```

## Accessing and Modifying 2D Arrays

### Accessing Elements:

- Format: `arrayName[rowIndex][colIndex]`
- Example: `int value = matrix[1][2];` (row 1, column 2)

### Modifying Elements:

- Format: `arrayName[rowIndex][colIndex] = value;`
- Example: `grid[0][3] = 42;`

### Getting Dimensions:

- Number of rows: `arrayName.length`
- Number of columns: `arrayName[0].length`
- For square arrays: `arrayName.length` gives both dimensions

### Example: Accessing and Modifying 2D Arrays

```java
// Accessing elements
int[][] numbers = {
    {1, 2, 3},
    {4, 5, 6}
};

int value = numbers[1][2]; // value = 6 (row 1, column 2)

// Modifying elements
numbers[0][1] = 10; // changes the element at row 0, column 1 to 10

// Getting dimensions
int numRows = numbers.length; // 2
int numCols = numbers[0].length; // 3

System.out.println("Value at [1][2]: " + value);
System.out.println("Updated array:");
for (int r = 0; r < numRows; r++) {
    for (int c = 0; c < numCols; c++) {
        System.out.print(numbers[r][c] + " ");
    }
    System.out.println();
}
```

Output:
```
Value at [1][2]: 6
Updated array:
1 10 3 
4 5 6 
```

## Traversing 2D Arrays

### Row-Major Traversal:

- Traverses the array row by row
- Outer loop iterates through rows, inner loop iterates through columns
- Standard way of traversing 2D arrays in most scenarios

```java
// Row-major traversal
for (int row = 0; row < grid.length; row++) {
    for (int col = 0; col < grid[0].length; col++) {
        // Process grid[row][col]
        System.out.print(grid[row][col] + " ");
    }
    System.out.println(); // New line after each row
}
```

### Column-Major Traversal:

- Traverses the array column by column
- Outer loop iterates through columns, inner loop iterates through rows
- Useful for specific algorithms or when column-based processing is needed

```java
// Column-major traversal
for (int col = 0; col < grid[0].length; col++) {
    for (int row = 0; row < grid.length; row++) {
        // Process grid[row][col]
        System.out.print(grid[row][col] + " ");
    }
    System.out.println(); // New line after each column
}
```

### Enhanced For Loop (For-Each):

- Can be used for traversing all elements
- Less flexible (can't access indices directly)
- Useful when you just need to process all elements

```java
// Enhanced for loop traversal
for (int[] row : grid) {
    for (int value : row) {
        // Process value
        System.out.print(value + " ");
    }
    System.out.println();
}
```

### Example: Different Traversal Methods

```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

System.out.println("Row-major traversal:");
for (int r = 0; r < matrix.length; r++) {
    for (int c = 0; c < matrix[0].length; c++) {
        System.out.print(matrix[r][c] + " ");
    }
    System.out.println();
}

System.out.println("\nColumn-major traversal:");
for (int c = 0; c < matrix[0].length; c++) {
    for (int r = 0; r < matrix.length; r++) {
        System.out.print(matrix[r][c] + " ");
    }
    System.out.println();
}

System.out.println("\nEnhanced for loop traversal:");
for (int[] row : matrix) {
    for (int value : row) {
        System.out.print(value + " ");
    }
    System.out.println();
}
```

Output:
```
Row-major traversal:
1 2 3 
4 5 6 
7 8 9 

Column-major traversal:
1 4 7 
2 5 8 
3 6 9 

Enhanced for loop traversal:
1 2 3 
4 5 6 
7 8 9 
```

## Common 2D Array Algorithms

### 1. Sum of All Elements:

```java
public static int sumAll(int[][] arr) {
    int sum = 0;
    for (int r = 0; r < arr.length; r++) {
        for (int c = 0; c < arr[0].length; c++) {
            sum += arr[r][c];
        }
    }
    return sum;
}
```

### 2. Find Maximum Element:

```java
public static int findMax(int[][] arr) {
    int max = arr[0][0]; // Assume non-empty array
    for (int r = 0; r < arr.length; r++) {
        for (int c = 0; c < arr[0].length; c++) {
            if (arr[r][c] > max) {
                max = arr[r][c];
            }
        }
    }
    return max;
}
```

### 3. Row and Column Sums:

```java
// Calculate sum of a specific row
public static int rowSum(int[][] arr, int row) {
    int sum = 0;
    for (int c = 0; c < arr[0].length; c++) {
        sum += arr[row][c];
    }
    return sum;
}

// Calculate sum of a specific column
public static int colSum(int[][] arr, int col) {
    int sum = 0;
    for (int r = 0; r < arr.length; r++) {
        sum += arr[r][col];
    }
    return sum;
}
```

### 4. Diagonal Sums (for square matrices):

```java
// Sum of main diagonal (top-left to bottom-right)
public static int mainDiagonalSum(int[][] arr) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
        sum += arr[i][i];
    }
    return sum;
}

// Sum of other diagonal (top-right to bottom-left)
public static int otherDiagonalSum(int[][] arr) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
        sum += arr[i][arr.length - 1 - i];
    }
    return sum;
}
```

### 5. Array Transformation (e.g., doubling all values):

```java
public static void doubleValues(int[][] arr) {
    for (int r = 0; r < arr.length; r++) {
        for (int c = 0; c < arr[0].length; c++) {
            arr[r][c] *= 2;
        }
    }
}
```

### 6. Finding Specific Values:

```java
public static boolean contains(int[][] arr, int target) {
    for (int r = 0; r < arr.length; r++) {
        for (int c = 0; c < arr[0].length; c++) {
            if (arr[r][c] == target) {
                return true;
            }
        }
    }
    return false;
}
```

### 7. Count Occurrences:

```java
public static int countOccurrences(int[][] arr, int target) {
    int count = 0;
    for (int r = 0; r < arr.length; r++) {
        for (int c = 0; c < arr[0].length; c++) {
            if (arr[r][c] == target) {
                count++;
            }
        }
    }
    return count;
}
```

### Example: Working with a 2D Array

```java
public class TwoDArrayExample {
    public static void main(String[] args) {
        int[][] data = {
            {3, 2, 5},
            {1, 4, 4},
            {5, 1, 6}
        };
        
        System.out.println("Original array:");
        printArray(data);
        
        System.out.println("Sum of all elements: " + sumAll(data));
        System.out.println("Maximum value: " + findMax(data));
        System.out.println("Sum of row 1: " + rowSum(data, 1));
        System.out.println("Sum of column 2: " + colSum(data, 2));
        System.out.println("Sum of main diagonal: " + mainDiagonalSum(data));
        System.out.println("Number of 4's: " + countOccurrences(data, 4));
        
        doubleValues(data);
        System.out.println("\nAfter doubling all values:");
        printArray(data);
    }
    
    // Helper method to print the array
    public static void printArray(int[][] arr) {
        for (int[] row : arr) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    // All other methods as defined above
    // ...
}
```

## Test-Taking Strategies

### For Multiple Choice Questions:

1. **Pay Attention to Indices**: Watch for off-by-one errors and remember that indices start at 0.

2. **Trace Through Nested Loops**: Track values of loop variables and array indices carefully when analyzing code.

3. **Draw Pictures**: For algorithms on 2D arrays, sketch the array and trace through operations visually.

4. **Watch for Bounds Issues**: Check for potential ArrayIndexOutOfBoundsException in code examples.

5. **Check Loop Conditions**: Ensure that loops properly handle the array dimensions.

6. **Verify Row-Major vs. Column-Major**: Make sure you understand which traversal method is being used in the code.

7. **Calculate Expected Output**: For questions about specific algorithms, calculate the expected result step by step.

8. **Consider Special Cases**: Think about how algorithms handle edge cases like empty arrays or single-element arrays.

### For Free Response Questions:

1. **Use Standard Traversal Patterns**: Use well-established patterns for traversing 2D arrays.

2. **Handle Array Bounds Correctly**: Ensure your code respects array dimensions.

3. **Use Clear Variable Names**: Choose descriptive names for indices (e.g., row/col rather than i/j).

4. **Comment Your Code**: Add comments explaining your approach, especially for complex algorithms.

5. **Test with Small Examples**: Verify your solution works with simple test cases.

6. **Check for Edge Cases**: Consider what happens with empty arrays or single-element arrays.

7. **Indent Properly**: Use consistent indentation for nested loops to make your code readable.

8. **Avoid Redundant Code**: Look for opportunities to simplify or refactor your solution.

## Sample Multiple Choice Questions

### Question 1

Consider the following code segment:

```java
int[][] arr = new int[3][4];
for (int row = 0; row < arr.length; row++) {
    for (int col = 0; col < arr[0].length; col++) {
        arr[row][col] = row * col;
    }
}
```

What is the value of `arr[2][3]` after this code executes?

- A) 0  
- B) 3  
- C) 5  
- D) 6  
- E) 8

### Question 2

Consider the following 2D array:

```java
int[][] grid = {
    {3, 5, 7},
    {2, 4, 6},
    {9, 1, 8}
};
```

What is the output of the following code segment?

```java
int sum = 0;
for (int c = 0; c < grid[0].length; c++) {
    sum += grid[c][c];
}
System.out.println(sum);
```

- A) 9  
- B) 12  
- C) 15  
- D) 18  
- E) 45

### Question 3

Consider the following method:

```java
public static int mystery(int[][] m) {
    int result = 0;
    for (int r = 0; r < m.length; r++) {
        for (int c = 0; c < m[0].length; c++) {
            if (r > c) {
                result += m[r][c];
            }
        }
    }
    return result;
}
```

Given the 2D array:

```java
int[][] nums = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};
```

What is the value of `mystery(nums)`?

- A) 15  
- B) 19  
- C) 21  
- D) 30  
- E) 45

### Question 4

Consider the following code segment:

```java
int[][] matrix = new int[3][3];
for (int r = 0; r < matrix.length; r++) {
    for (int c = 0; c < matrix[0].length; c++) {
        if (r == c) {
            matrix[r][c] = 1;
        } else if (r < c) {
            matrix[r][c] = 2;
        } else {
            matrix[r][c] = 3;
        }
    }
}
```

What is the sum of all elements in the matrix after this code executes?

- A) 9  
- B) 15  
- C) 18  
- D) 21  
- E) 24

### Question 5

Consider the following method:

```java
public static int[][] transform(int[][] arr) {
    int rows = arr.length;
    int cols = arr[0].length;
    int[][] result = new int[cols][rows];
    
    for (int r = 0; r < rows; r++) {
        for (int c = 0; c < cols; c++) {
            result[c][r] = arr[r][c];
        }
    }
    return result;
}
```

What does this method do to a 2D array?

- A) Creates a copy of the original array  
- B) Reflects the array across the main diagonal  
- C) Rotates the array 90 degrees clockwise  
- D) Rotates the array 90 degrees counterclockwise  
- E) Inverts the values in the array

## Sample Free Response Question

### Question: Image Processing

You are given a 2D array representing a grayscale image, where each element is an integer from 0 (black) to 255 (white). Write a class called `ImageProcessor` with the following methods:

1. **invert**: Takes a 2D array of integers and returns a new 2D array where each value is inverted (255 - original value).

2. **blur**: Takes a 2D array of integers and returns a new 2D array where each pixel is the average of itself and its immediate neighbors (up, down, left, right, and diagonals). For pixels at the edges, only consider the neighbors that exist.

3. **findBrightestRegion**: Takes a 2D array of integers and returns the sum of the 3×3 region with the highest total brightness. If the array is smaller than 3×3, return the sum of all elements.

Implement these methods according to the specifications.

**Key Points to Include in Your Answer:**

1. **Correct Method Implementations**:
   - invert: Properly compute 255 - original value for each element
   - blur: Calculate average including all valid neighbors
   - findBrightestRegion: Correctly identify the 3×3 region with maximum sum

2. **Parameter and Return Types**:
   - All methods should have correct signatures
   - Methods should return new arrays rather than modifying the original

3. **Edge Case Handling**:
   - blur should correctly handle pixels at the edges
   - findBrightestRegion should handle images smaller than 3×3

4. **Algorithmic Efficiency**:
   - Methods should use efficient algorithms, particularly for findBrightestRegion
   - No unnecessary iterations or calculations

5. **Code Structure**:
   - Well-organized and readable code
   - Appropriate comments explaining the approach
   - Meaningful variable names

6. **Testing**:
   - Include a main method with test cases
   - Provide helper methods for printing/verifying results