import arrays.src.main.java.com.array.Array;

public class Stack<T> {

    private Array<T> stack_array_ = new Array<T>();
    // Array.insert
    // Array.at
    // Array.remove(index) where index will be equal to the current height of the stack.

    Stack() {}

    // 1. push
    public void push(T data) {
        if (data == null) {
            throw new java.lang.IllegalArgumentException("");
        }
        stack_array_.insert(data);
    }

    public int size() {
        return stack_array_.size();
    }

    // 2. peek
    public T peek() {
        // default will always be at top
        return peekAtTop();
    }

    public T peekAtTop() {
        int size = stack_array_.size();
        if (size == 0) {
            // stack is empty
            throw new java.lang.IllegalStateException("");
        }

        return stack_array_.at(size - 1);    
    }

    // 3. pop
    public T pop() {
        int size = stack_array_.size();
        if (size <= 0) {
            throw new java.lang.IllegalStateException("");
        }

        return stack_array_.remove(size - 1);
    }

    public static void main(String [] args) {
        Stack<Integer> my_stack = new Stack<>();

        // assert (my_stack.size() == 0);
        //System.out.println(my_stack.size());
        // my_stack.push(10);
        // assert (my_stack.size() == 1);
        // System.out.println(my_stack.size());

        for (int i = 0; i < 100; i++) {
            my_stack.push(i);
            System.out.print(my_stack.size() + " " + my_stack.peek());
            my_stack.pop();
            System.out.println(" " + my_stack.size());
        }   
        
        my_stack.push(10);
        my_stack.push(20);
        my_stack.push(25);
        System.out.println(my_stack.size());
        while (my_stack.size() > 0) {
            System.out.print(my_stack.pop() + " ");
            System.out.println(my_stack.size());
        }
    }
}