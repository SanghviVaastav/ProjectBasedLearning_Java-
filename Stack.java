public class Stack {
    private int[] stackArray; // array to implement a stack
    private int top; // pointer to keep track of the top element
    private int capacity; // to keep track of the size of the stack

    public Stack(int size) { // constructor to initialize the size of the stack and the top pointer
        stackArray = new int[size];
        top = -1;
        capacity = size;
    }

    public boolean isFull() { // method to check if the stack is full
        return top == capacity - 1;
    }

    public boolean isEmpty() { // method to check if the stack is empty
        return top == -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push " + value);
            return; // return to avoid adding an element to a full stack
        }
        stackArray[++top] = value;
        System.out.println("Pushed element " + value + " into Stack");
    }

    public int pop() { // method to remove the top element from the stack
        if (isEmpty()) {
            System.out.println("Stack is Empty. Cannot pop."); // Stack underflow
            return -1; // return an invalid value or error code
        }
        System.out.println("Popped element: " + stackArray[top]);
        return stackArray[top--];
    }

    public int peek() { // method to view the top element without removing it
        if (isEmpty()) {
            System.out.println("Stack is Empty. No top element.");
            return -1; // return an invalid value or error code
        }
        System.out.println("Top element is: " + stackArray[top]);
        return stackArray[top];
    }

    public static void main(String[] args) {
        Stack stk = new Stack(5);
        stk.push(10);
        stk.push(20);
        stk.push(30);
        stk.push(40);
        stk.push(50);
        stk.push(60); // Stack overflow

        stk.pop();
        stk.pop();
        stk.pop();
        stk.pop();
        stk.pop();
        stk.pop();

        stk.peek(); // returns the topmost element of the stack
    }
}
