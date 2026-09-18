### Programming Assignment 03 : Ordering Lists and Binary Search
#### Due Thursday, Sep 24 end-of-day
#### Submit via Gitlab

<hr>

In this programming assignment, you will continue your implementation of a List using an array. The primary difference is that the List will be ordered at all times based on a basis of comparison for the Auggie class. Furthermore, to make search more efficient, you will be implementing Binary Search to locate an element in the list.

Learning Outcomes

- Know how to implement the Comparable interface for a class.
- Know how to define a Comparator for a class.
- Know how to implement an ordered List.
- Know how to implement Iterative Binary Search on an ordered List.
- Use Java built-in sorting methods.
- Write useful inline code comments.

### Implementation

Create a new folder prog03-ordering in your Gitlab programming folder. Copy your prog02 files into the folder, then modify as specified below.

> If you did not complete prog02 or it has errors, please meet with Dr. Larson right away to get prog02 complete and ready for this assignment.

### Implementation for Ordering

First, focus on the Auggie.java and the file Ordering.java in which you need to create 2 Comparators and sort an ArrayList in 3 ways.

- Modify Auggie.java so that it implements Comparable. The default comparison for an Auggie should be based on the ID (without a tie-breaker). You need to change the signature of the class definition so that it implements Comparable. You need to write the compareTo method.

- In Ordering.java, create a Comparator<Auggie> called byLast. It orders Auggies by last name, using the first name as a tie-breaker. A sample Comparator is below, which looks very similar to what you will be writing.

- In Ordering.java, create a Comparator<Auggie> called byCredits. It orders Auggies by the total credits earned, using the last name as a tie-breaker.

- In Ordering.java, follow the directions to sort the ArrayList using 1) the Auggie compareTo method, 2) byLast, and 3) byCredits.

Compile and run the Ordering.java file and look carefully at the results. Did everything get sorted as expected? If not, fix it.


### Implementation of AuggieList

Add this to the top of the file inside the class definition, grouped with other member variable definitions. In the case that an Auggie is created with the default constructor, this one will be used to order the list. Notice that it uses the compareTo method of Auggie, which is considered the default ordering.

```
/** Comparator for ordering array. Uses compareTo of Auggie by default */
private Comparator<Auggie> orderBy = new Comparator<Auggie>() {
    @Override
    public int compare(Auggie a1, Auggie a2) {
        return a1.compareTo(a2);
    }
};
```

Implement or modify the following methods in AuggieList.

>Advice: Add the comparator above, write the constructors, and create the stubs for search and sublist. Now you can incrementally code (a little) and test.

There should be only 1 constructor that creates the array auggies[]. All other constructors should call that constructor (i.e. AuggieList(int capacity)).

- `AuggieList(Comparator<Auggie> ordering, int capacity)`: Call the other constructor, passing along the capacity, then set orderBy to ordering.

- `AuggieList(Comparator<Auggie> ordering)`: Call your new constructor above with the default capacity.

- modify `void add(Auggie auggie)`: You can no longer add at the end of the list. You have to determine where to add the element to maintain order. Iterate from count towards 0, shifting as you go until you find the right spot to add. **USE A WHILE LOOP**. Remember to use the orderBy.compare, not the compareTo method.

- `int find(Auggie auggie)`: write binary search (an iterative version) to locate the Auggie auggie. Remember to use the orderBy.compare, not the compareTo method!

- `Auggie[] sublist(Auggie start, Auggie end)`: extract a sublist of elements that fall between start and end (**exclusive**), based on orderBy. Notice that the start and/or end do not have to be in the list. Consider an example with a list of numbers {2,5,8,12,17}. The sublist that falls between 7 and 15 are {8,12}. Once you have established the start and last index, if there are elements to be placed in the array, call your other sublist. Do not throw an Exception for this one if there is nothing in the sublist -- instead return an array of size 0.

>Note that add(value,index) should no longer be available to users as this can break the ordering of the List. Do not do anything to this method -- the tests do not call it and we will pretend it does not exist.

<hr>

### Submit Code

- [ ] Ordering is executing and the output looks correct.
- [ ] Unit tests in TestBinSearch.java are passing.
- [ ] find() was modified to use an iterative binary search
- [ ] Code is well documented with meaningful comments and informative variable names.
- [ ] javadocs in AuggieList is complete (and production quality). Javadocs is not necessary for Ordering.java.
- [ ] Code was pushed to Gitlab.
- [ ] Confirmed code on Gitlab is the intended version for submission.
- [ ] Complete and submit the Submission Form in class.

It is your responsibility to ensure that the code on Gitlab at the time it is due is the version that you want to submit. Be sure to look at it on the web -- better yet, clone the repo again and run the tests (then delete this temporary repo from your computer).

Do not forget that there is a corresponding written homework that is due next week.
