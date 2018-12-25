public class Exercise1 {

    private static class LinkedList {

        public static class LinkedListNode {
            private int data;
            private LinkedListNode next = null;
            private LinkedListNode prev = null;
    
            public LinkedListNode(int value) {
                this.data = value;
            }

            public int getData() {
                return this.data;
            }

            public LinkedListNode getNext() {
                return this.next;
            }

            public void setNext(LinkedListNode nextNode) {
                this.next = nextNode;
            } 
        }
    
        private LinkedListNode mHead = null, mTail = null;
        private int mSize = 0;
    
        public void insertAtBack(int value) {
            // This add will add in new linked list nodes at the tail.
            LinkedListNode newNode = new LinkedListNode(value);

            // test for invalid linkedlist state
            assert (!((this.mHead == null && this.mTail != null) || 
                (this.mHead != null && this.mTail == null)));

            // empty for the linkedlist
            if (this.mHead == null && this.mTail == null) {
                this.mHead = newNode;
                this.mTail = newNode;
            }
            // non-empty case
            else {
                // Connect the reference at the current tail.
                this.mTail.next = newNode;

                // Update tail to the new node.
                this.mTail = newNode;
            }
        }
    
        public int removeHead() {
            // empty
            // non-empty

            if (this.mHead == null) {
                // no work
                throw new java.lang.IllegalStateException("");
            }
            
            // do work there is a head.
            LinkedListNode nodeToRemove = this.mHead;
            LinkedListNode newHead = nodeToRemove.next;

            // set the current head to null
            nodeToRemove.next = null;

            // Update head to the new head for the linked list.
            this.mHead = newHead;

            // tail could still be pointing to head when the array size is 1 for head removal.
            if (this.mHead == null) {
                // update tail
                this.mTail = null;
            }

            return nodeToRemove.data;
        }

        public int removeTail() {
            // empty
            // non-empty

            if (this.mTail == null) {
                // no work
                throw new java.lang.IllegalStateException("");
            }
            
            // do work there is a head.
            LinkedListNode nodeToRemove = this.mTail;
            LinkedListNode newTail = this.mHead;

            // get new tail first
            while (newTail != nodeToRemove && newTail.next != nodeToRemove) {
                // traversal
                newTail = newTail.next;                
            }

            // newTail can be equal to nodeToRemove or the next of newTail is nodeToRemove
            if (newTail == nodeToRemove) {
                // linked lsit of size one
                newTail = null;
                this.mHead = null;
                this.mTail = null;
            }
            else if (newTail.next == nodeToRemove) {
                // newTail is set to the right value
                newTail.next = null;
            }
            else {
                throw new java.lang.IllegalStateException("");
            }

            // Update head to the new head for the linked list.
            this.mTail = newTail;

            return nodeToRemove.data;
        }
    
        public int size() {
            return 0;
        }

        public LinkedListNode getHead() {
            return this.mHead; 
        }

        public LinkedListNode getTail() {
            return this.mTail;
        }

        public void setTail(LinkedListNode newTail) {
            this.mTail = newTail;
        }

        public  void setHead(LinkedListNode newHead) {
            this.mHead = newHead;
        }
    }

    // iteration through linked list.
    public static void iterationSerial(LinkedList head) {
        // check for if head is invalid.
        if (head == null) {
            throw new java.lang.IllegalArgumentException("");
        }

        LinkedList.LinkedListNode currentNode = head.getHead();

        while (currentNode != null) {
            System.out.println("At Node " + currentNode.getData());
            // update the reference for current
            currentNode = currentNode.getNext();
        }

        System.out.println("");

        // We have reached the end of the linked list.
    }

    // recursive iteration
    public static void iterationRecursive(LinkedList head) {
        if (head == null) {
            throw new java.lang.IllegalArgumentException("");
        }

        recursive(head.getHead());
    }

    private static void recursive(LinkedList.LinkedListNode currentNode) {
        if (currentNode == null) {
            return;
        }

        System.out.println("At Node " + currentNode.getData() + " recursive.");
        recursive(currentNode.getNext());
        System.out.println("");

    }

    // two pointers one slow and one fast
    public static void twoPoinerTraversal(LinkedList head) {
        // error check

        LinkedList.LinkedListNode slow, fast;
        // slow will move by one
        // fast will move by two
        slow = head.getHead();
        fast = head.getHead();

        while (fast != null && fast.getNext() != null) {
            System.out.println("Fast Node " + fast.getData());
            System.out.println("Slow Node " + slow.getData());
            
            // do our work
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }

        System.out.println("");
        recursive(slow);
    }

    // swap contents of even index within the list to the odd and vice versa.
    public static void evenOddSwap(LinkedList myLinkedList) {
        // error check

        LinkedList.LinkedListNode oddNode = null, evenNode = myLinkedList.getHead();
        LinkedList.LinkedListNode prev = null;

        while (evenNode != null && evenNode.getNext() != null) {
            // declare what we have
            oddNode = evenNode.getNext();
            LinkedList.LinkedListNode oddNodeNext; //, evenNodeNext;

            oddNodeNext = oddNode.getNext();
            // evenNodeNext = evenNode.getNext();

            // check for head
            if (prev == null) {
                myLinkedList.setHead(oddNode);
            }

            // perform swap
            oddNode.setNext(evenNode);
            evenNode.setNext(oddNodeNext);
            
            // update the even & odd node
            prev = evenNode;
            evenNode = oddNodeNext;
            oddNode = null;
        }

        if (evenNode == null) {
            myLinkedList.setTail(prev);
        }
        else {
            myLinkedList.setTail(evenNode);
        }
    }

    public static void main(String [] args) {
        LinkedList myList = new LinkedList();

        myList.insertAtBack(5);
        myList.insertAtBack(2);

        //for (int i = 0; i < 10; i++) {
        //    myList.insertAtBack(i);
        //}

        iterationSerial(myList);
        evenOddSwap(myList);
        iterationRecursive(myList);
        // twoPoinerTraversal(myList);

        myList.removeTail();
        myList.removeTail();
        myList.insertAtBack(3);

        return;
    }
}