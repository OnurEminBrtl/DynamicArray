# Dynamic Array in Java

## Overview

This project consists of two Java classes:

1. **GenerateRandomIntegersToFile.java**  
   Generates 100 random integers between 1 and 100 and writes them into a file named `data.txt`.

2. **DynamicArrayAssignment.java**  
   Implements a basic dynamic array using an integer array. It reads the integers from `data.txt`, adds them to the custom dynamic array, and allows deletion of a specified integer from the array.

## Features

- Custom implementation of a dynamic array with automatic resizing.
- File I/O: Reads from and writes to `data.txt`.
- Demonstrates basic array operations: addition, deletion, and resizing.
- Console-based interaction for deletion input.

## How to Run

1. Compile both Java files:
   ```bash
   javac GenerateRandomIntegersToFile.java
   javac DynamicArrayAssignment.java
   ```

2. First, run the file generator:
   ```bash
   java GenerateRandomIntegersToFile
   ```

3. Then, run the dynamic array program:
   ```bash
   java DynamicArrayAssignment
   ```

4. When prompted, enter a number to delete from the array.

## Example Output

```
Generated file: data.txt
Read 100 integers from file.
Dynamic array contents:
[23, 87, 45, 12, ..., 66]

Enter a number to delete: 45
Deleted 45 from the array.

Updated array:
[23, 87, 12, ..., 66]
```

## Notes

- The custom dynamic array resizes itself when full, similar to `ArrayList` in Java.
- This is educational project intended to demonstrate understanding of:
  - Array resizing
  - File handling
  - User interaction
