public class Exercise1 {

    private class LinkedList {

        public class LinkedListNode {
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
    
        public void add(int value) {}
    
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
    void iterationSerial(LinkedList head) {
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
        return;
    }
}