package umg.edu.gt.data_structure.queue;

import umg.edu.gt.data_structure.queue.manual.QueueLinked;

public class Main {
    public static void main(String[] args) {
        System.out.println("[LOG] Queue library loaded successfully");
        
        // Prueba básica de la cola
        QueueLinked<String> queue = new QueueLinked<>();
        
        System.out.println("[LOG] Testing enqueue...");
        queue.enqueue("Cancion 1");
        queue.enqueue("Cancion 2");
        queue.enqueue("Cancion 3");
        
        System.out.println("[LOG] Queue size: " + queue.size());
        System.out.println("[LOG] Peek: " + queue.peek());
        
        System.out.println("[LOG] Testing dequeue...");
        while (!queue.isEmpty()) {
            System.out.println("[LOG] Dequeued: " + queue.dequeue());
        }
        
        System.out.println("[LOG] Queue is empty: " + queue.isEmpty());
        System.out.println("[LOG] All tests passed!");
    }
}
