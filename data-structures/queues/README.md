# Topic - Queues
## Table of Contents
[TOC]

## Description
Queues are a data structure that follows a first in last out paradiagm.  They are often used to limit access to a resource with an interface.  The use of a first in last out design allows the obtaining of the element that was first added to the queue in constant time, while elements that are being added to be added to the back of the queue in the best case of constant time.

Arbitrary insertions, traversals, searching within a queue typically require linear time but depending on the underlying management of the queue data structure, some improvements can be made typically with the increase in memory usage.

```
    Head                                               Tail
       
| Element 0 | Element 1 |  ...  | Element N - 2 | Element N - 1|  
```

### Queue Class
The overall queue will need to be backed by another data structure that will be responsible for maintaining the order of the linked list as elements are added to the queue.

The two general cases for this is an array or linked list backed container definition.  Thus the queue class will contain the necessary references for either definition. 

### Queue API 
#### Enqueue
Want to be able to add new entries into the queue.  Candidates for support for insertion will be at the head and tail of the queue, with the default being the tail.
```java
boolean enqueue(T data)
boolean enqueueFront(T data)
boolean enqueueBack(T data)
```

#### Peek
Inspection of an element at the head or tail without making modification to the queue itself (no removal).
```java
T peek()
T peekAtHead()
T peekAtBack()
T peekAtIndex(int index)
```

#### Dequeue
Removal of an element from the queue.  Following the FIFO rules the head of the queue will be removed from the queue when called.
```java
T dequeue()
```

#### Exercises

1. Implement the API for a queue backed by a static array container data structure implementation.
1. Implement the API for a queue backed by a dynamic array container data structure implementation.
1. Implement the API for a queue backed by a linked list container data structure implementation.
1. Implement the API for a queue that allows for having a priority in addition to non-priority elements.

### Problem Set