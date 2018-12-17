public class Exercise1 {

    private static class LinkedList {

        public static class LinkedListNode {
            private int data;
            private LinkedListNode next = null;
    
            public LinkedListNode(int value) {
                this.data = value;
            }

            public int getData() {
                return this.data;
            }

            public LinkedListNode getNext() {
                return this.next;
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
    
        public int remove() {
            return 0;
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

    public static void main(String [] args) {
        LinkedList myList = new LinkedList();

        myList.insertAtBack(5);
        myList.insertAtBack(2);

        for (int i = 0; i < 10; i++) {
            myList.insertAtBack(i);
        }

        iterationSerial(myList);
        iterationRecursive(myList);
        twoPoinerTraversal(myList);


        return;
    }
}