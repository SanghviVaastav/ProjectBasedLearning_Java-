public class QueueArrayImplementation {
    // Define a static inner class for Queue
    static class Queue {
        static int[] q; // Array to store queue elements
        static int size; // Maximum size of the queue
        int rear = -1; // Track the position of the last element, initialized to -1 (queue is empty)

        // Constructor to initialize the queue with a specified size
        Queue(int n) {
            q = new int[n]; // Create array of size 'n'
            this.size = n; // Set the size of the queue
        }
        
        // Check if the queue is empty
        public boolean isEmpty() {
            return rear == -1; // If rear is -1, queue is empty
        }
        
        // Add an element to the queue
        public void add(int x) {
            if (rear == size - 1) { // Check if the queue is full
               System.out.println("Queue is full!!");
               return; // Exit if queue is full
            }
            rear++; // Move rear to the next position
            q[rear] = x; // Insert the new element at the rear
        }

        // Remove an element from the front of the queue
        public int remove() {
            if (isEmpty()) { // Check if the queue is empty
                System.out.println("Queue is empty");
                return -1; // Return -1 to indicate queue is empty
            }
            int front = q[0]; // Store the front element to return later
            // Shift all elements one position to the left
            for (int i = 0; i < rear; i++) {
                q[i] = q[i + 1];
            }
            rear--; // Decrement rear as the front element is removed
            return front; // Return the removed front element
        }

        // Peek at the front element without removing it
        public int peek() {
           if (isEmpty()) { // Check if the queue is empty
                System.out.println("Queue is empty");
                return -1; // Return -1 to indicate queue is empty
            }
           return q[0]; // Return the front element
        }
    }
    
    // Main method to demonstrate queue operations
    public static void main(String[] args) {
        Queue qu = new Queue(5); // Create a queue with a capacity of 5

        // Add elements to the queue
        qu.add(1);
        qu.add(2);
        qu.add(3);
        qu.add(4);
        qu.add(5);

        // Remove and print each element from the queue until it’s empty
        while (!qu.isEmpty()) {
            System.out.println(qu.peek()); // Display the front element
            qu.remove(); // Remove the front element
        }
    }
}
