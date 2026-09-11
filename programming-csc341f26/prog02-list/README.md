### Programming Assignment 02 : Building a LIST Abstract Data Type
#### Due Thursday, September 17 end-of-day
#### Submit via Gitlab

In this programming assignment, you will create a LIST Abstract Data Type (ADT) with the same functionality that is provided by the Java ArrayList<>. This will give you insight into how structures for data collections are implemented and how the choice of implementation impacts the efficiency with respect to both time and space.

One distinction between ArrayList<> and what you are developing is the use of _Generics_, which is indicated by the "<>" symbols. This allows you as the user to store any type of object. In our implementation (for now), we will only be storing Auggie objects.

In addition to learning about the List ADT, you will use a "homegrown" version of unit testing with which you can verify your implementation.


Learning Outcomes:

- Understand and implement the primary operations that add and find elements in a _List_ implemented with an array.
- Understand and implement the primary operations that remove elements from a _List_ implemented with an array.
- Understand the practice of _Test-Driven Development_.
- Use Exceptions to manage erroneous input or operations.
- Practiced in code documentation using Javadocs.
- Practiced in code testing to verify correctness.

<hr>

## You Are Required to Use BBEdit or Notepad++ (or some non-AI code editor) so that your IDE does not write all your code for you.

You will be regularly tested on your coding skills on paper. It is important that you understand the code sufficiently to explain it, to analyze its efficiency, and to reproduce it (or a modified version of the code) on a quiz or exam .

You may use AI as a tutor when learning the material presented in class or in the textbook. You may use AI to understand syntax and error messages. You may not use AI to complete any portion of an assignment that you are submitting for grade, unless explicitly stated as permitted (there will be some of those assignments later in the semester).

<hr>

### Javadocs Documentation

AS you are coding, add javadocs comments where appropriate. Documentation for javadocs can be found here:
    - [https://www.oracle.com/technetwork/java/javase/documentation/index-137868.html]
    - [https://www.tutorialspoint.com/java/java_documentation.htm]

    _Where Appropriate_ means that ...
    - all classes have a javadoc comment above its definition
    - all methods within a class are documented and include @param, @return, etc. as appropriate (the one exception is setters and getters, which are usually self-explanatory thus do not need documentation)
    - most class members/attributes/fields (pick your favorite vocabulary term) are documented. Most, if not all of these, have been done for you.

When complete, generate javadocs and inspect your work. To generate javadocs from the command line, create a `docs` folder inside the prog02-list folder. Compile javadoc comments from within that folder. This will generate a collection of web pages. At the command prompt, it looks like this:

  ```
  mkdir docs
  cd docs
  javadoc ../*.java
  ```
  
You can view the results by opening the index.html file in your browser.

<hr>

### Testing Your Work

Testing is an essentail part of coding. In this assignment, you will use the provided unit tests to ensure your code is working properly.

To run the tests, compile your code and run the TestList.java file. **If you see any output on the screen that starts with "ERROR," then your code is wrong** (or my tests are wrong, but I did check them, so I think they are good, but you can always ask to be sure!).

```
javac *.java
java TestList
```

>There is a "sanity check" that is first run for the tests. If these do not pass, then there is something wrong with either your add or get method. Until this is fixed, do not pay attention to the results of any of the other tests.

>When I test your code, I will copy a fresh TestList.java into your directory.

<hr>

### Implementation of a List

In this assignment, you will be creating an ADT List of Auggie objects by completing the implementation of the class _AuggieList_. An Auggie is a student with a first name, last name, student id, and total credits earned. Take a moment to look at the class definition for Auggie.

The Abstract Data Type (ADT) **_List_** refers to a collection of elements, which is maintained with primary operators that add, remove, find/get, and sort elements. It is important to have a shared understanding of the list qualities and how the operators modify the list. For this programming assignment:

- The list is not checked for duplicate items.
- The list is not sorted.
- If positional information is not provided, the `add()` method will add after the last element in the list, as long as the list is not full.
- If positional information is provided, the `add()` method will add at the INDEX indicated, shifting elements to make room, as long as the index is valid.

The instantiation of an AuggieList will create an array for storing Auggies. It has a fixed capacity, therefor it can get full and no longer be able to add elements to the List. In other words, unlike ArrayList in Java, this is (currently) not a dynamic array.

The List has a capacity (i.e. the length of the array that is storing Auggies) and it has a length (i.e. the number of Auggies in the array). **When traversing the array, you should only iterate to length, not to capacity.** If you are throwing NullPointer exceptions, check your for loop.

In the requirements, you will also notice that some situations will throw one of the defined exceptions. Take a moment to look at ArrayIndexException and IllegalOperationException. Typically, you would use Java's built-in exceptions, but this gives you practice with user-defined exceptions, and these can be tested with the provided unit tests.

Look for "TODO" in the code, which highlights what you need to implement.

#### ESSENTIALS and HELPERS

Implement the following ...

- `AuggieList(int capacity)` constructor with a set capacity for data.
- `boolean isFull()` determines whether or not there is capacity for more objects.
- `boolean isEmpty()` determines whether or not there are any objects in the List.
- `boolean isValid(int index)` determines if the given index corresponds to an element stored in the List.

#### ADD Methods

- Implement the method `void add(Auggie auggie)`.
    - If the structure is full, throw an IllegalOperationException and return.
    - If the structure is not full, add to the end of the list. (The _end_ of the list refers to the last element in the list.)
    - Maintain the length.

- Implement the method `void add(Auggie auggie, int index)`.
    - If the structure is full, throw an IllegalOperationException and return.
    - If the index is invalid (i.e. there is not a current element at the specified index), throw an ArrayIndexException and return.
    - If the structure is not full and the index is valid, add the element at the index indicated. Shift all elements as appropriate BEFORE adding the element to make space for it. **Hint: Start at the end of the List and shift right until the index is reached.**
    - Maintain the length.


#### SEARCH Methods

- Implement the method `Auggie get(int index)`.
    - If the index is not valid, throw ArrayIndexException and return.
    - If the index is valid, return the element at that index. It should not be removed, just returned. And no need to iterate!

- Implement the method `int find(Auggie auggie)`.
    - If _auggie_ is in the list, return its index. Note that you should use _equals_ to determine if auggie is in the List.
    - If _auggie_ is not in the list, return -1 (no error message required).

#### REMOVE Methods

- `Auggie remove(int index)`
	- if the index is not valid, throw ArrayIndexException.
	- remove the element from the array by shifting items to fill the gap
	- return the removed item
	
- `void remove(Auggie auggie)`
	- if _auggie_ is not in the list, throw an IllegalOperationException
	- remove the found _auggie_
	- NOTE: use your other methods to implement this one!
	
- `void removeAll()`
	- "Remove" all elements from the array by creating a new array with the same capacity.

#### CONVERT Methods

- Implement the method `Auggie[] toArray()`.
	- If the list is empty, throw an IllegalOperationException.
	- If the list is not empty, create an array equal to length (not capacity) and copy the contents of the List into the new array. 
	
- Implement the method `int toArray(Auggie[])`.
	- If the list is empty, return 0;
	- If the list is longer than the capacity of Auggie[], throw an IllegalOperationException.
	- If Auggie[] has the capacity to hold the list, copy the elements into Auggie[] and return the number of elements copied.
	
<hr>

### Submit Code

- [ ] Test code and check that no error messages are being displayed.
- [ ] Complete javadocs and compile to confirm all is good.
- [ ] Push code to your Gitlab account.
	- Be sure to have a "programming" folder that holds all programming assignments.
	- Do not change the names of files or folders, because that will break the grading scripts.
- [ ] Confirm the code on Gitlab is the version you want to submit.
- [ ] Complete and submit the Submission Form in class.

It is your responsibility to ensure that the code on Gitlab at the time it is due is the version that you want to submit. Be sure to look at it on the web  -- better yet, clone the repo again and run the tests (then delete this temporary repo from your computer). 

Do not forget that there is a corresponding written homework that is due next week.

<hr>

### Assessment

You can earn a maximum of 5 points on this assignment. Here is the breakdown:

- 1/2 point for turning it in AND it compiles
- 1/2 point for Javadocs complete
- 2 points for passing all the tests of constructor, status, get, add(student), and find.
- 2 points for passing all the tests of add(student, index), removes, toArrays. 

There is no partial credit for a method that is partially complete. A given method is correct only when it passes all the tests for that method. You may earn partial credit for those methods that pass the tests. For example, if you pass all the tests for all the methods except for the toArray method, then you will earn partial credit.


