# Assignments Package

## Overview

The `assignments` package contains a series of tasks that demonstrate various functionalities, including arithmetic operations, statistical calculations, date and time manipulations, and more. Each task implements the `Task` interface and is designed to be executed based on user input.

## Task Modules

### Assignment1
- **Description**: Prints "Hello World".

### Assignment2
- **Description**: Performs addition on two float operands using `ArithmeticOperation`.

### Assignment3
- **Description**: Greets the user with "Hello!! [name]". Accepts a name as input.

### Assignment4
- **Description**: Replaces "name" in a message with the user's provided name.

### Assignment5
- **Description**: Performs arithmetic operations (addition, subtraction, multiplication, division) on integer operands.

### Assignment6
- **Description**: Performs arithmetic operations (addition, subtraction, multiplication, division) on float operands.

### Assignment7
- **Description**: Provides a calculator that performs basic arithmetic operations (+, -, *, /) on float operands.

### Assignment8
- **Description**: Calculates the sum of a list of numbers.

### Assignment9
- **Description**: Performs statistical operations (count, mean, maximum, minimum) on a list of numbers.

### Assignment10
- **Description**: Adds the "sort" operation to `Assignment9`, returning the sorted list of numbers.

### Assignment11
- **Description**: Counts the number of even and odd values in a list of numbers.

### Assignment12
- **Description**: Generates and prints a multiplication table for a given number up to a specified limit.

### Assignment13
- **Description**: Prints a matrix based on user input.

### Assignment14
- **Description**: Prints the current date and time in various formats.

### Assignment15
- **Description**: Prints the current date and time in IST time zone.

### Assignment16
- **Description**: Prints the current date and time in a specific time zone (Asia/Kolkata).

### Assignment17
- **Description**: Calculates and prints the difference between two dates in days, months, and years.

### Assignment18
- **Description**: Accepts a date and determines if it falls within a leap year. Date can be in any supported format.

### Assignment19
- **Description**: Compares two dates and calculates the difference between them.

### Assignment20
- **Description**: Counts the number of weekends (Saturdays and Sundays) in the current month.

## Main Class

### Main.java

The `Main` class is the entry point for running the tasks. It initializes the necessary support classes and handles user input to determine which task to execute.

#### Features:
- **Task Initialization**: Creates instances of the various `Assignment` classes based on user input.
- **Support Classes**: Instantiates support classes (`ArithmeticOperation`, `ConsoleInputHandler`, etc.) before the switch case to avoid redundancy.
- **Task Execution**: Uses a `switch` statement to select and execute the appropriate task based on user choice.

#### Key Points:
- **Task Handling**: Each task is associated with a case in the switch statement. If the user provides an invalid or no input, the program defaults to executing `Assignment3` or `Assignment4` based on the number of arguments.
- **Argument Handling**: If arguments are provided during runtime, the program will execute `Assignment3` or `Assignment4` based on the number of arguments.
- **Input Handling**: Uses `ConsoleInputHandler` to gather user inputs and handle them accordingly.