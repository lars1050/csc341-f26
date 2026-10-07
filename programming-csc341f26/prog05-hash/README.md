### Programming Assignment 05 : Hash Table (Dictionary)
#### Due <del>Thursday, October 8</del> Sunday, October 11 end-of-day
#### Submit via Gitlab

<hr>

In this programming assignment, you will create a Hash Table (a.k.a. Dictionary or HashMap) to store Auggie objects. The most important aspect of a hash table is the hashing function that maps a key value to an index in an array. This can make search operations very fast (perhaps even O(1)). The efficiency of the search (and add operation) depend on how a _collision_ is handled. A collision occurs when 2 keys map to the same index, therefor you are trying to put 2 objects in 1 slot of the array.

In *Open Addressing*, if a collision occurs, a systematic search of the array begins to find an open slot. It is necessary that the array is large enough to hold all the elements of the data collection.

In *Chaining*, the data structure is an array of linked lists. When a collision occurs, the new object is added to the linked list stored at that array slot, thus more than 1 element can be stored in a single slot of the array. You will be implementing chaining.

In the corresponding written portion of this assignment, you will analyze the performance of a couple of different hash functions with respect to their efficiency of the add (put) and find (get) operations of the data collection. Hash functions can be passed to the constructor in the form of a lambda function.

You might encounter a lot of syntax in this assignment that you are not familiar with. This includes iterators, arrays of linked lists, suppression of compilation warnings, and lambda functions. Feel free to do a web search or have a conversation with claude.ai or chatGPT about any of these concepts. You can also attend office hours to learn more. However, please do not use those resources to write the code.

** PLEASE cite your resources on the Submission Form. I expect that you will need to use resources on this assignment, therefore I expect to see them on your submission form. **

Learning Outcomes:

- Know how to implement a Hash Table / Dictionary / HashMap.
- Know how to write a lambda function in Java.
- Understand how hash functions can be used to improve efficiency.

<hr>

### Implementation

Pull the repo from gitlab and copy the prog05-hash folder into your gitlab programming folder. You are starting from scratch on this assignment.

One thing of note is the use of the hash function. In Java, functions can be passed as `Function<>` objects and then executed using `apply`. (Other programming languages handle lambda functions more elegantly.) Spend time looking through the code to understand how the hash functions are being defined, passed, and executed.

Complete the methods listed below. Look at the comments in the code for guidance.

- `public Boolean contains(String key)`
- `public void put(String key, Auggie auggie)`
- `public Auggie[] toArray()`

The constructors, Javadocs, and get() method are already complete.

Write the basicTest method in TestHash.java to verify the correctness of your code. The simplest thing to do is to create a small ArrayList of Auggies by calling AuggieFactory.makeAuggies. Instantiate a HashTable using the default constructor. _put_ all the ArrayList elements into the HashMap. Then you can test _get_, _contains_, _toArray_, and _toString_. Be sure to look for things in the HashTable that are not there. And test the replacement of a value (which is part of the put method).

Finally, define a hash function called hashB in TestHash. In this hash function, sum all numeric values of the characters in the key then mod it with the TABLE_SIZE. Look at hashA for some guidance. To test this, pass this hash function as part of a lambda function to the constructor in your basicTest method. Look at the comments for guidance.

<hr>

### Submit Code

- [ ] contains, put, and toArray in HashTable are complete
- [ ] basicTest written and executed to verify code correctness
- [ ] new hash function is defined and used in TestHash
- [ ] Code was pushed to Gitlab.
- [ ] Confirmed code on Gitlab is the intended version for submission.
- [ ] Complete and submit the Submission Form in class.

It is your responsibility to ensure that the code on Gitlab at the time it is due is the version that you want to submit. Be sure to look at it on the web -- better yet, clone the repo again and run the tests (then delete this temporary repo from your computer).

