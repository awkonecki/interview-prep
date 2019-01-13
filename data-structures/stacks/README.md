# Topic - Stacks
## Table of Contents
[TOC]

## Description
A Stack is a container that follows a last in first out paradiagm.  It is a common container that is present in the way that programs work as evident in the function call stack.  It can be viewed that the most recently added element to the stack is the one with the current scope of work and if a new scope of work is to be worked upon (via a new function call), the called function will be placed above the current scope on top of the stack.  Once the scope of the top is complete, it is removed from the top of the stack and the previous scope is now within focus.

### Full Stack
```
Top         Current Scope
            -------------
            Current Scope - 1
            -------------
            Current Scope - 2
            -------------
            Current Scope - 3
            .....
            -------------
Bot         Current Scope - N - 1 
Height = N  -------------
```

### Empty Stack
```
Top == Bot
Height = 0
```

### Single Element Stack
```
Top / Bot   Scope 0     
Height = 1  ---------------
```

### Two Element Stack
```
Top         Scope 1
            ----------------
Bot         Scope 0
Height = 2  ----------------
```

The emplacement of new element or scope of the stack is typcially referred to as a `push` while the removal of top element from the stack is a `pop`.

### Stack Class
A stack is supported by another container / data structure contains the logic for maintaining the order orientation of the stack, the correct addition of elements and removal of elements.

The two general containers as you might guess are arrays and linked lists.

### Stack API 
#### Push
Want to be able to add new entries onto the stack.  Candidates for support for `push` will be at the top of the stack.
```java
boolean push(T data)
```

#### Peek
Inspection of an element at the top of the stack with no modification of the stack itself (no removal).
```java
T peek()
T peekAtHead()
```

#### Pop
Removal of an element from the stack.  Following the LIFO rules the top of the stack will be removed from the stack when called.
```java
T pop()
```

#### Exercises

1. Implement the API for a stack backed by a dynamic array container data structure implementation.
1. Implement the API for a stack backed by a linked list container data structure implementation.

### Problem Set

1. Given an array of integers that represents a volume at the given index; determine the maximum volume between two indices.
```
Input:
[1, 2, 3, 4, 1]

Represents
4                       x
3                  x    x    
2             x    x    x    
1        x    x    x    x    x 
0 -----------------------------
Index    0    1    2    3    4 
```

```
Output:
6
```

2. Given an array of integers  that represents heights of land; determine the maximum volume of water that can be landlocked.
```
Input:
[1, 2, 3, 4, 1, 2]

Represents
4                       x
3                  x    x    
2             x    x    x         x
1        x    x    x    x    x    x
0 ---------------------------------
Index    0    1    2    3    4    5
```

```
Output:
1

Reasoning:
Volume of 1 water can be held between the land heights at index 3 and 5.
```