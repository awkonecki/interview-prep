# Topic - Trees
## Table of Contents
[TOC]

## Description
One of the issues associated with linked lists and arrays is wanting to know, modify data associated with it in time that is faster than O(NlgN) time.  Putting constraints on the data (e.g. there exists a proper order w.r.t the data) can provide benefits to this to possibly achieve O(lgH) for worse case with typical (depending on data) O(lgN).

### Tree Node
View the tree node as the object that would be responsible for actually containing the data that will be saved along with the connection to the left and right nodes.

```java
public class TreeNode <T> {
        private T data_;
        private TreeNode<T> left, right;
}
```

### Binary Tree
The most common type of tree that is dicussed and presented is a binary tree.  A binary tree is one that is composed of a pair of children nodes (left/right) and a parent.

```
            |  Parent Node |
                /       \
               /         \
              /           \
    |  Left Node |   |  Right Node  |
```

### Binary Tree Class
```java
class BinaryTree <T> {
    private TreeNode<T> root; 
}
```

### Binary Tree API 
#### Insert
Insert new elements into the binary tree.
```java
void insert(T data)
```

#### Contains / Search / Find
Determine if a current data element already exists within the binary tree.
```java
boolean contains(T data)
```

#### Remove
Removal of an element from the tree.
```java
T remove(T data)
```

#### Exercises

### Problem Set