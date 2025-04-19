# Unit 7: ArrayList

## Table of Contents

1. [Unit Overview](#unit-overview)
2. [Essential Concepts](#essential-concepts)
3. [ArrayList Basics](#arraylist-basics)
4. [Creating and Initializing ArrayLists](#creating-and-initializing-arraylists)
5. [ArrayList Methods](#arraylist-methods)
6. [Traversing ArrayLists](#traversing-arraylists)
7. [Common ArrayList Algorithms](#common-arraylist-algorithms)
8. [Wrapper Classes](#wrapper-classes)
9. [ArrayList vs. Array](#arraylist-vs-array)
10. [Common Coding Patterns](#common-coding-patterns)
11. [Test-Taking Strategies](#test-taking-strategies)
12. [Sample Multiple Choice Questions](#sample-multiple-choice-questions)
13. [Sample Free Response Question](#sample-free-response-question)

## Unit Overview

Unit 7 focuses on the ArrayList class, a flexible and powerful alternative to arrays in Java. ArrayLists are resizable collections that can grow and shrink dynamically as elements are added or removed. This data structure is part of Java's Collections Framework and provides numerous convenient methods for managing collections of objects. In AP CSA, ArrayList concepts represent approximately 2.5-5% of the exam, making it an important topic to understand.

**Key Topics in This Unit:**
- Creating and initializing ArrayLists
- Adding, removing, and modifying elements
- Accessing elements using methods
- Traversing ArrayLists
- Wrapper classes for primitive data types
- Understanding the differences between arrays and ArrayLists

## Essential Concepts

### Computational Thinking Practices Addressed:
- Program design (organizing data with ArrayLists)
- Code implementation (using ArrayLists to solve problems)
- Code analysis (understanding ArrayList operations)

### Course Skills Developed:
- VAR-2.D: Represent collections of related object reference data using ArrayList objects

## ArrayList Basics

### What is an ArrayList?
- A resizable collection class that can grow or shrink as needed
- Part of the `java.util` package
- Stores only objects, not primitive types
- Uses generics to specify the type of objects it holds
- Provides methods for adding, removing, and manipulating elements

### Key Features:
- Dynamic size (no fixed length like arrays)
- Access to elements by index (like arrays)
- Many built-in methods for common operations
- Type safety through generics
- Automatic resizing when elements are added or removed

### Example of ArrayList vs. Array:
```java
// Array - fixed size
String[] namesArray = new String[10];
namesArray[0] = "Alice";
// Can't easily add more than 10 names

// ArrayList - dynamic size
import java.util.ArrayList;
ArrayList<String> namesList = new ArrayList<String>();
namesList.add("Alice");
namesList.add("Bob");
// Can keep adding names without worrying about size
```

## Creating and Initializing ArrayLists

### Import Statement:
```java
import java.util.ArrayList;
```

### Declaration and Initialization:
```java
// Declaration with generics
ArrayList<Type> listName = new ArrayList<Type>();

// In Java 7 and newer, you can use diamond operator
ArrayList<Type> listName = new ArrayList<>();
```

### Examples:
```java
// ArrayList of Strings
ArrayList<String> names = new ArrayList<String>();

// ArrayList of Integers
ArrayList<Integer> scores = new ArrayList<Integer>();

// ArrayList of Student objects
ArrayList<Student> roster = new ArrayList<Student>();
```

### Initializing with Initial Capacity:
```java
// Creates an ArrayList with initial capacity of 20
ArrayList<String> names = new ArrayList<String>(20);
```

### Initializing from Another Collection:
```java
ArrayList<String> list1 = new ArrayList<String>();
list1.add("Apple");
list1.add("Banana");

// Create a new ArrayList containing all elements from list1
ArrayList<String> list2 = new ArrayList<String>(list1);
```

## ArrayList Methods

### Adding Elements:
- `add(Object element)`: Appends element to the end
- `add(int index, Object element)`: Inserts element at specified index

```java
ArrayList<String> fruits = new ArrayList<String>();
fruits.add("Apple");               // ["Apple"]
fruits.add("Banana");              // ["Apple", "Banana"]
fruits.add(0, "Orange");           // ["Orange", "Apple", "Banana"]
```

### Accessing Elements:
- `get(int index)`: Returns element at specified index
- `size()`: Returns number of elements
- `isEmpty()`: Returns true if ArrayList has no elements

```java
String firstFruit = fruits.get(0);          // "Orange"
int count = fruits.size();                  // 3
boolean empty = fruits.isEmpty();           // false
```

### Removing Elements:
- `remove(int index)`: Removes element at specified index
- `remove(Object element)`: Removes first occurrence of element
- `clear()`: Removes all elements

```java
fruits.remove(0);                  // ["Apple", "Banana"]
fruits.remove("Banana");           // ["Apple"]
fruits.clear();                    // []
```

### Modifying Elements:
- `set(int index, Object element)`: Replaces element at index

```java
ArrayList<String> colors = new ArrayList<String>();
colors.add("Red");
colors.add("Blue");
colors.set(1, "Green");            // ["Red", "Green"]
```

### Searching:
- `contains(Object element)`: Returns true if element exists
- `indexOf(Object element)`: Returns index of first occurrence, or -1 if not found

```java
boolean hasRed = colors.contains("Red");            // true
int index = colors.indexOf("Green");                // 1
int notFound = colors.indexOf("Blue");              // -1
```

## Traversing ArrayLists

### Using for Loop with Index:
```java
ArrayList<String> names = new ArrayList<String>();
names.add("Alice");
names.add("Bob");
names.add("Charlie");

for (int i = 0; i < names.size(); i++) {
    System.out.println(names.get(i));
}
```

### Using Enhanced for Loop:
```java
ArrayList<String> names = new ArrayList<String>();
names.add("Alice");
names.add("Bob");
names.add("Charlie");

for (String name : names) {
    System.out.println(name);
}
```

### Traversing in Reverse Order:
```java
ArrayList<String> names = new ArrayList<String>();
names.add("Alice");
names.add("Bob");
names.add("Charlie");

for (int i = names.size() - 1; i >= 0; i--) {
    System.out.println(names.get(i));
}
```

## Common ArrayList Algorithms

### Finding Sum/Average:
```java
ArrayList<Integer> numbers = new ArrayList<Integer>();
numbers.add(10);
numbers.add(20);
numbers.add(30);

int sum = 0;
for (Integer num : numbers) {
    sum += num;
}

double average = (double) sum / numbers.size();
```

### Finding Maximum/Minimum:
```java
ArrayList<Integer> numbers = new ArrayList<Integer>();
numbers.add(15);
numbers.add(7);
numbers.add(22);
numbers.add(9);

int max = numbers.get(0);
for (int i = 1; i < numbers.size(); i++) {
    if (numbers.get(i) > max) {
        max = numbers.get(i);
    }
}

int min = numbers.get(0);
for (int i = 1; i < numbers.size(); i++) {
    if (numbers.get(i) < min) {
        min = numbers.get(i);
    }
}
```

### Filtering Elements:
```java
ArrayList<Integer> numbers = new ArrayList<Integer>();
numbers.add(15);
numbers.add(7);
numbers.add(22);
numbers.add(9);

// Create a new ArrayList with only even numbers
ArrayList<Integer> evens = new ArrayList<Integer>();
for (Integer num : numbers) {
    if (num % 2 == 0) {
        evens.add(num);
    }
}
```

### Linear Search:
```java
public static int search(ArrayList<String> list, String target) {
    for (int i = 0; i < list.size(); i++) {
        if (list.get(i).equals(target)) {
            return i;  // Return index if found
        }
    }
    return -1;  // Return -1 if not found
}
```

### Removing Elements While Traversing:
```java
// Removing all even numbers - BAD WAY (causes problems)
ArrayList<Integer> numbers = new ArrayList<Integer>();
numbers.add(1);
numbers.add(2);
numbers.add(3);
numbers.add(4);

// Wrong way - will cause issues because the list changes during traversal
for (int i = 0; i < numbers.size(); i++) {
    if (numbers.get(i) % 2 == 0) {
        numbers.remove(i);  // Changes the indices!
    }
}

// Correct way - traverse backward
ArrayList<Integer> numbers2 = new ArrayList<Integer>();
numbers2.add(1);
numbers2.add(2);
numbers2.add(3);
numbers2.add(4);

for (int i = numbers2.size() - 1; i >= 0; i--) {
    if (numbers2.get(i) % 2 == 0) {
        numbers2.remove(i);  // Safe because we're traversing backward
    }
}
```

## Wrapper Classes

### Introduction to Wrapper Classes:
- ArrayLists can only store objects, not primitive types
- Wrapper classes provide object representations of primitive types
- Java provides autoboxing and unboxing for convenience

### Common Wrapper Classes:
- `Integer` for `int`
- `Double` for `double`
- `Boolean` for `boolean`

### Using Wrapper Classes with ArrayLists:
```java
// Using the Integer wrapper class
ArrayList<Integer> scores = new ArrayList<Integer>();

// Autoboxing: primitive int to Integer object
scores.add(95);  // Automatically converts int to Integer
scores.add(87);
scores.add(91);

// Unboxing: Integer object to primitive int
int firstScore = scores.get(0);  // Automatically converts Integer to int
```

### Creating Wrapper Objects Explicitly:
```java
// Explicit creation of wrapper objects
Integer num1 = new Integer(42);  // Deprecated in newer Java versions
Integer num2 = Integer.valueOf(42);  // Preferred method

// Converting between String and wrapper
Integer num3 = Integer.parseInt("123");
String str = num3.toString();
```

## ArrayList vs. Array

### Key Differences:

| Feature | Array | ArrayList |
|---------|-------|-----------|
| Size | Fixed size | Dynamic size |
| Type | Can store primitives or objects | Can only store objects |
| Syntax | Uses brackets for access: `arr[0]` | Uses methods: `list.get(0)` |
| Methods | Limited to length property | Many built-in methods |
| Memory | More efficient for primitives | Less efficient due to object overhead |
| Multi-dimensional | Directly supported | Must use ArrayList of ArrayLists |

### When to Use Arrays:
- Fixed size is known and won't change
- Performance is critical
- Working with primitive types (for efficiency)
- Multi-dimensional data structures

### When to Use ArrayLists:
- Size may change during program execution
- Need convenient methods (add, remove, contains, etc.)
- Working with collections of objects
- Flexibility is more important than performance

### Converting Between Arrays and ArrayLists:
```java
// Array to ArrayList
String[] namesArray = {"Alice", "Bob", "Charlie"};
ArrayList<String> namesList = new ArrayList<String>();
for (String name : namesArray) {
    namesList.add(name);
}

// ArrayList to Array
ArrayList<String> colorsList = new ArrayList<String>();
colorsList.add("Red");
colorsList.add("Green");
colorsList.add("Blue");

String[] colorsArray = new String[colorsList.size()];
for (int i = 0; i < colorsList.size(); i++) {
    colorsArray[i] = colorsList.get(i);
}
```

## Common Coding Patterns

### Pattern 1: Adding Elements That Meet a Condition

```java
public static ArrayList<Integer> getPositives(int[] numbers) {
    ArrayList<Integer> positives = new ArrayList<Integer>();
    
    for (int num : numbers) {
        if (num > 0) {
            positives.add(num);
        }
    }
    
    return positives;
}
```

### Pattern 2: Removing Elements That Meet a Condition

```java
public static void removeNegatives(ArrayList<Integer> list) {
    for (int i = list.size() - 1; i >= 0; i--) {
        if (list.get(i) < 0) {
            list.remove(i);
        }
    }
}
```

### Pattern 3: Processing Each Element in an ArrayList

```java
public static void doubleAllValues(ArrayList<Integer> list) {
    for (int i = 0; i < list.size(); i++) {
        list.set(i, list.get(i) * 2);
    }
}
```

### Pattern 4: Merging Two ArrayLists

```java
public static ArrayList<String> mergeLists(ArrayList<String> list1, 
                                          ArrayList<String> list2) {
    ArrayList<String> merged = new ArrayList<String>();
    
    // Add all elements from first list
    for (String item : list1) {
        merged.add(item);
    }
    
    // Add all elements from second list
    for (String item : list2) {
        merged.add(item);
    }
    
    return merged;
}
```

## Test-Taking Strategies

### For Multiple Choice Questions:

1. **Watch for ArrayList Method Names**: Be familiar with common methods like `add`, `remove`, `get`, `set`, `size`.
2. **Be Careful with Indices**: Remember that ArrayList indices start at 0 and end at `size() - 1`.
3. **Understand Wrapper Classes**: Know how autoboxing and unboxing work with ArrayLists.
4. **Trace List Modifications**: When elements are added or removed, indices of subsequent elements change.
5. **Remember Return Values**: Some methods return values (like `remove(int)` returns the removed element).
6. **Pay Attention to Types**: ArrayLists use generics to enforce type safety.
7. **Watch for Off-by-One Errors**: Especially in loops that traverse ArrayLists.

### For Free Response Questions:

1. **Use the Correct Methods**: Make sure to use the proper ArrayList methods for the task.
2. **Handle Edge Cases**: Consider what happens with empty lists or invalid indices.
3. **Be Careful When Removing Elements**: Remove from the end to the beginning when traversing and removing.
4. **Include Necessary Import Statements**: Don't forget `import java.util.ArrayList;`.
5. **Use Enhanced for-loops When Appropriate**: But remember their limitations (can't modify the list).
6. **Respect Type Parameters**: Make sure to use the correct type in the ArrayList declaration.
7. **Avoid Index Out of Bounds Exceptions**: Always check that indices are valid before accessing elements.

## Sample Multiple Choice Questions

### Question 1

Consider the following code segment:

```java
ArrayList<Integer> numbers = new ArrayList<Integer>();
numbers.add(10);
numbers.add(20);
numbers.add(30);
numbers.add(40);
numbers.add(1, 15);
numbers.remove(3);
```

What are the contents of the ArrayList `numbers` after this code executes?

- A) [10, 15, 20, 30, 40]  
- B) [10, 15, 20, 40]  
- C) [10, 15, 30, 40]  
- D) [10, 20, 30, 40]  
- E) [15, 20, 30, 40]  

### Question 2

Consider the following code segment:

```java
ArrayList<String> words = new ArrayList<String>();
words.add("apple");
words.add("banana");
words.add("cherry");

for (int i = 0; i < words.size(); i++) {
    String word = words.get(i);
    words.set(i, word.toUpperCase());
}
```

What is the effect of this code segment on the ArrayList `words`?

- A) It adds uppercase versions of each word to the end of the list  
- B) It creates a new ArrayList with uppercase versions of each word  
- C) It replaces each word with its uppercase version  
- D) It removes all the words from the list  
- E) It causes an error because the ArrayList is being modified during traversal  

### Question 3

Consider the following code segment:

```java
ArrayList<Integer> list = new ArrayList<Integer>();
list.add(3);
list.add(7);
list.add(2);
list.add(9);
list.add(5);

int sum = 0;
for (Integer num : list) {
    if (num % 2 == 0) {
        sum += num;
    }
}
```

What is the value of `sum` after this code executes?

- A) 0  
- B) 2  
- C) 9  
- D) 17  
- E) 26  

### Question 4

Consider the following code segment:

```java
ArrayList<String> names = new ArrayList<String>();
names.add("Alice");
names.add("Bob");
names.add("Charlie");
names.add("David");

String removed = names.remove(2);
boolean result = names.remove("Alice");
```

What are the values of `removed` and `result` after this code executes?

- A) removed = "Charlie", result = true  
- B) removed = "Bob", result = true  
- C) removed = "Charlie", result = false  
- D) removed = "David", result = true  
- E) removed = null, result = false  

### Question 5

Consider the following method:

```java
public static void mystery(ArrayList<Integer> list) {
    for (int i = 0; i < list.size() - 1; i++) {
        if (list.get(i) > list.get(i + 1)) {
            int temp = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, temp);
            i = -1;
        }
    }
}
```

What does this method do to the ArrayList passed as a parameter?

- A) Sorts the list in ascending order  
- B) Sorts the list in descending order  
- C) Removes all duplicate elements  
- D) Removes all elements greater than their successor  
- E) Reverses the order of the elements  

## Sample Free Response Question

### Question: Library Book Catalog

You are asked to design a class called `BookCatalog` for a library system. The catalog maintains a collection of books, each represented by a title (a String). The class should provide functionality to add books, remove books, check out books, return books, and search for books by title prefix.

Your implementation should include:

1. Instance variables to store the list of books and the list of checked-out books
2. A constructor that creates an empty catalog
3. A method to add a book to the catalog
4. A method to remove a book from the catalog
5. A method to check out a book (moving it from the catalog to the checked-out list)
6. A method to return a book (moving it from the checked-out list back to the catalog)
7. A method that returns a new ArrayList containing all books that start with a given prefix

**Key Points to Include in Your Answer:**
1. Properly using ArrayLists to store and manage books
2. Implementing required methods with correct functionality
3. Using appropriate ArrayList methods (add, remove, indexOf, etc.)
4. Moving books between available and checked-out lists
5. Implementing prefix search without using Character class
6. Handling edge cases (book not found, etc.)
7. Following good object-oriented design principles