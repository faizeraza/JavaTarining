# ConsoleInputHandler Module

## Purpose
The `ConsoleInputHandler` class is designed to manage user inputs from the console in various data formats like strings, integers, floats, and more. It offers a user-friendly interface by incorporating color-coded prompts and error messages, ensuring robust input handling.

## Key Concepts Covered
- **Input Handling**: Handles various types of user input through the console.
- **Error Handling**: Validates input and provides feedback for invalid entries.
- **Recursion**: Applied in methods like `getIntInput` for re-prompting users until valid input is received.
- **Modularity**: Integrates with the `DateOperations` class for date format handling, promoting separation of concerns.
- **User Experience**: Uses ANSI escape codes to enhance the user interface with color-coded messages.

## Code Overview
The `ConsoleInputHandler` class uses a `Scanner` object to read inputs from the console. It provides a variety of methods to capture different data types from the user, such as `String`, `int`, `double`, `float`, and even a list of `float` values. It also includes a method for retrieving and validating time zones and another for detecting date formats.

## Key Methods/Classes
- **`getInput()`**: Captures a line of text input from the console.
- **`getStringInput(String message)`**: Prompts the user for a string input with a custom message.
- **`getIntInput(String message)`**: Prompts the user for an integer input and validates it, re-prompting if necessary.
- **`getDoubleInput(String message)`**: Captures a double input with validation.
- **`getFloatInput(String message)`**: Captures a float input with validation.
- **`getListInput(String message)`**: Gathers multiple float inputs until the user decides to proceed.
- **`getZone()`**: Provides a list of available time zones and validates the user's selection.
- **`getDate(String message, DateOperations dateOps)`**: Takes a date input and uses `DateOperations` to detect its format.
- **`free()`**: Closes the `Scanner` resource to avoid memory leaks.

## Usage
To use this module, simply instantiate the `ConsoleInputHandler` class and call the appropriate method to capture user input.

**Example:**
```java
ConsoleInputHandler inputHandler = new ConsoleInputHandler();
String name = inputHandler.getStringInput("Enter your name:");
int age = inputHandler.getIntInput("Enter your age:");
inputHandler.free();
