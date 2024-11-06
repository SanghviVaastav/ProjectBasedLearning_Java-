public class CircularQueueImplementation {
    // Define a static inner class for the Circular Queue
    static class CircularQueue {
        static int[] cq; // Array to store circular queue elements
        static int size; // Maximum size of the circular queue
        int front = -1, rear = -1; // Track the front and rear of the queue

        // Constructor to initialize the circular queue with a specified size
        CircularQueue(int n) {
            cq = new int[n]; // Create array of size 'n'
            this.size = n; // Set the size of the queue
        }

        // Check if the queue is full
        public boolean isFull() {
            return (rear + 1) % size == front; // Queue is full when front is just ahead of rear in a circular manner
        }

        // Check if the queue is empty
        public boolean isEmpty() {
            return front == -1 && rear == -1; // Queue is empty when both front and rear are -1
        }

        // Add an element to the circular queue (enqueue)
        public void add(int x) {
            if (isFull()) { // Check if the queue is full
                System.out.println("CQ is full");
                return; // Exit if queue is full
            }
            rear = (rear + 1) % size; // Move rear to the next position in a circular manner
            cq[rear] = x; // Insert the new element at the rear
            if (front == -1) { // If queue was empty, set front to 0 after first insertion
                front = 0;
            }
        }

        // Remove an element from the circular queue (dequeue)
        public int remove() {
            if (isEmpty()) { // Check if the queue is empty
                System.out.println("CQ is empty");
                return -1; // Return -1 to indicate queue is empty
            }
            int result = cq[front]; // Store the front element to return later
            front = (front + 1) % size; // Move front to the next position in a circular manner
            if (front == (rear + 1) % size) { // If only one element was left, reset to empty state
                front = rear = -1;
            }
            return result; // Return the removed element
        }

        // Peek at the front element without removing it
        public int peek() {
            if (isEmpty()) { // Check if the queue is empty
                System.out.println("CQ is empty");
                return -1; // Return -1 to indicate queue is empty
            }
            return cq[front]; // Return the front element
        }

        // Print the elements in the circular queue from front to rear
        public void print() {
            if (isEmpty()) { // Check if the queue is empty
                System.out.println("CQ is empty");
                return;
            }
            System.out.print("Circular Queue: ");
            int i = front;
            while (true) {
                System.out.print(cq[i] + " ");
                if (i == rear) { // Stop when we reach the rear
                    break;
                }
                i = (i + 1) % size; // Move to the next position in a circular manner
            }
            System.out.println(); // Move to the next line after printing the queue
        }
    }

    // Main method to demonstrate circular queue operations
    public static void main(String[] args) {
        CircularQueue cq1 = new CircularQueue(5); // Create a circular queue with a capacity of 5

        // Add elements to the queue
        cq1.add(1);
        cq1.add(2);
        cq1.add(3);
        cq1.add(4);
        cq1.add(5);

        // Remove a few elements and add more to demonstrate circular behavior
        cq1.remove();
        cq1.remove();
        cq1.add(6);
        cq1.add(7);

        // Print the current contents of the circular queue
        cq1.print();
    }
}
