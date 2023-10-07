
Rules for these tasks:

* No built-in data structures cam be used except for Arrays, all others are built from scratch.

# Assignment 1

Question 1: Rat in a Maze

    Solve the "rat in a maze" problem using a stack. 
    The maze is given as a binary matrix. '0' is a dead-end, '1' is a valid path. 
    The starting point is maze[0][0] and the end point is maze[N-1][N-1]. 
    The output should be saved in "output.txt". If no path is found, "PATH NOT FOUND" should be written.

Question 2: Maximum Depth of Nested Parentheses
    
    Write a program to determine the maximum depth of nested parenthesis in a string. 
    Display the maximum depth or an error message for imbalanced parentheses.

Question 3: Array-based Stack and Stueue (StackQueue)
    
    Part A: Create a program for a fixed-size array-based stack with operations such as
    empty(), full(), size(), top(), push(), and pop().
    
    Part B: Implement Stueue (StackQueue) using the above stack. This should perform both 
    stack and queue operations using instances of your Stack.

Question 4: Grocery Store Queue Management in Jämtland County

    Design a program for grocery stores in Jämtland County to manage two queues: 
    express (<=5 items) and regular (>5 items). 
    The program should handle customer data, place customers in the correct queue, 
    and display queue information.

Question 5: Circular Doubly Linked List with Triplets

    Implement a program for a circular doubly linked list with specified properties. 
    The list should be ordered, have unique values, and a method to count triplets 
    in the list that sum up to a given value.

Question 6: Egg Supply Management

    Design a system for the egg supply firm, Inomhus. 
    Eggs are stored in trays, stacks, boxes, trucks, and warehouses. 
    Each egg has an integer code. 
    Create a data structure to store and retrieve an egg's information based on its code.

# Assignment 2

Question 1: Analyzing Time Complexities

    Determine the Big O notation for the solutions of questions 3, 4, and 6 from the previous assignment.

Question 2: Binary Search Tree Insertion and Deletion

    A: Create an algorithm to insert data into a binary tree so it forms a BST. 
    B: Implement an algorithm to delete data from the BST.

Question 3: Binary Search Tree Operations and Traversals

    A: Implement a Binary Search Tree with methods such as Insert(), Remove(), find(), 
    checkBalance(), and Print(). 
    B: Implement and compare pre-order, post-order, in-order, and level-order traversals in both recursive
    and iterative methods. Plot results for differently sized number lists.

Question 4: AVL Tree vs. Binary Search Tree

    A: Design an AVL tree with single and double rotations. Ensure it maintains AVL property 
    during insertions and deletions. 
    B: Compare the AVL tree with the binary search tree from the previous question, noting 
    speed differences and conditions where one might be faster than the other.

# Assignment 3

Question 1: Max-Heap Validation in Binary Trees

    Determine if a given binary tree satisfies the max-heap properties:
        The tree is complete (all levels, except possibly the last, are fully populated).
        Every node's value is ≥ its child node.
    Create a program to verify whether a provided binary tree is a max-heap.

Question 2: ispell Utility Implementation with Hash Tables

    ispell is a Linux utility for interactive word checks. 
    Your goal is to replicate its functionalities using hash tables.

    Part I - ADT:

        Develop a class implementing an Open Hash Table of strings stored as arrays of linked lists.
            Methods:
                add(s)
                remove(s)
                contains(s)
                size()
                A hash function for string hashing.

    Part II – Main Program:

        Utilize your hash table class.
        Use /usr/share/dict/words or this file as the dictionary.
        Construct and check all possible near misses for input words.
        Display results in alphabetical order.
        Consider case insensitivity.

Question 3: Variants of Quicksort Algorithm

    Implement three variations of Quicksort: First, Median, and Random.
    Quicksort, First: Always pick the first element as the pivot.
    Quicksort, Median: Choose the median of the first, final, and middle elements as the pivot.
    Quicksort, Random: Randomly select the pivot.
    Accept two command-line arguments: filename and Quicksort variant.
    Depending on the chosen variant, execute the corresponding Quicksort algorithm.
    Output the total number of comparisons done by the Partition procedure.
