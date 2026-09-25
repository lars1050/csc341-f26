### Programming Assignment 04 : LIST Sorting and Recursive Binary Search
#### Due Thursday, October 1 end-of-day
#### Submit via Gitlab

This programming assignment is a fresh start and you no longer need your code from the previous assignments. This assignment still works with an AuggieList, but the Auggie class has changed. The methods are focused on ordering, sorting the list, and using a recursive version of binary search to take advantage of the ordered list. Parts of this assignment will be developed during class time. 

Learning Outcomes:

- Understand how to maintain an ordered list.
- Be able to implement binary search using recursion.
- Be able to implement a sorting algorithm.
- Write code that is style compliant
- Practiced in code testing to verify correctness.

<hr>

### Getting Started

Start the implementation by pulling the Github repo and copying the prog04-sort folder into your Gitlab repo.

General Requirements:

- Complete the methods outlined below.
- Code must be STYLE COMPLIANT according to the Google style guide.
- Code must be well documented.

Javadocs has been completed and is not part of the requirements of this assignment.

<hr>

### Style Compliance

Organizations establish rules about how to style your code. The style rules might discuss whitespace, variable naming conventions, curly brace placement, etc. In this lab (and all labs going forward), your code should be compliant with the Google Java style guide.

<a href ="https://google.github.io/styleguide/javaguide.html" target="_blank" > https://google.github.io/styleguide/javaguide.html </a>

In particular, you should:

- Use camelCase for variable and method names.
- Use capitalized CamelCase for classes.
- Use ALL CAPITALS for constants or enumerated types.
- Do not leave extra whitespace (or extra blank lines except to ease readability)
- Always use curly braces for if-else statements.
- Curly braces for the else portion should look like this: } else {
- Use @Override where appropriate
- Check error or special conditions FIRST in any method and return. Do not use - if-else statements to distinguish an error condition (e.g. invalid index) versus a valid index.
- Also make sure your code is CLEAN, nicely organized, and well commented.
- Remove all TODOs, unless it is something you still need to do.
- Group similar methods together. Keep methods structured in this general order:
	- member variable declarations and definitions
	- constructors
	- helper functions (e.g. toString)
	- primary methods
	- setters and getters
	
<hr>

### IMPLEMENTATION

Notice that there is a boolean `isOrdered` and a `Comparator currentOrder`. When adding to the list, values are appended (not added to maintain order). If the sort method is called, isOrdered will be set to true and the basis of ordering (i.e. the Comparator) will be saved in currentOrder.

There are two distinct ways to sort. This is an opportunity for you to practice implementing different sorting algorithms. Of course, you would typically not offer different algorithms for sorting to a user. Java and Python do not use either of these methods, but instead use a combination of a recursive sorting algorithm called Merge Sort and Insertion Sort.

Notice in the find method that if the list is ordered, Binary Search will be used to find a value. If it is not ordered, then Linear Search is used.

The last thing to notice is the use of the access modifier `private` for several methods. These are _helper_ functions that users should not be able to call.


#### Sorting Algorithms 

Complete the following: 

- `private int locationMinimum(Comparator<Auggie> order, int start, int end)`
- `private void sortSelection(Comparator<Auggie> orderBy)`
- `private void sortInsertion(Comparator<Auggie> orderBy)`

First, complete locationMinimum, which is a helper function that returns the index of the minimum value in the specified subarray from auggies[start] to auggies[end] (inclusive). 

Use this helper function to then complete Selection Sort, which repeatedly finds the next minimum value and places it in its proper location in the array. 

Finally, complete Insertion Sort, which repeatedly inserts the element into the sorted subarray to its "left."  


#### Recursive Binary Search Method

Binary Search follows a repeated pattern of looking at the middle of a subarray and determining if the element has been found, and if not, looking in a smaller subarray to the right or left of the middle element.

Complete the recursive method 

`private int findRecursive(Auggie value, int start, int end)`

Notice that the original call is in `find(Auggie value)`. This is typical of recursive algorithms -- there is one that makes the original call to a helper function that is recursive.


### Testing

The TestSort.java file has been provided for you to test your code. You confirm it is working by performing a visual inspection of the code. It is your responsibility to make sure that your code is working as intended.
