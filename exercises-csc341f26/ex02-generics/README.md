### Generics

We have a lot of ways to reuse code -- functions, class inheritance, interfaces. Using Generics in Java allows you as a programmer to reuse code from a very high level. You are reusing the logic and applying it to any type of object.

In the provided code, you will see a class Trio that has 3 member variables. These are all of type int. If you wanted a class to hold 3 things but they were of type float or Student, you would have to rewrite the class, but primarily you would just change the type.

In this exercise create a new class Trio that uses generics to store 3 items in order of any type. Test your code by first declaring an instance of Trio that stores integers. Then test your code by declaring an instance of Trio that stores the Simple type.

> Note: You will have to make changes to the Student class to be able to compare elements within the Trio class. Add any needed getters and setters.

BONUS CONCEPT: Notice the "copy constructor". In OOP languages, there is the ability to create a special constructor that creates a copy of the passed object. This allows you to easily copy the values of an instance without being tied to that object.



