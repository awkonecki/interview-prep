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

        LinkedList.LinkedListNode current = head.getHead();

        while (current != null) {
            System.out.println("At Node " + current.getData());
            // update the reference for current
            current = current.getNext();
        }

        // We have reached the end of the linked list.
    }

    public static void main(String [] args) {
        LinkedList myList = new LinkedList();

        myList.insertAtBack(5);
        myList.insertAtBack(2);

        for (int i = 0; i < 100; i++) {
            myList.insertAtBack(i);
        }

        iterationSerial(myList);

        return;
    }
}