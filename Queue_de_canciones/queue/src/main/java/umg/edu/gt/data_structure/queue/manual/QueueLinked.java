package umg.edu.gt.data_structure.queue.manual;

public class QueueLinked<T> {
    
    private Node<T> head;
    private Node<T> tail;
    private int size;
    
    public QueueLinked() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    // O(1) - Insertar al final
    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item);
        
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }
    
    // O(1) - Remover del frente
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot dequeue from empty queue");
        }
        
        T data = head.getData();
        head = head.getNext();
        
        if (head == null) {
            tail = null;
        }
        
        size--;
        return data;
    }
    
    // O(1) - Ver elemento sin remover
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot peek from empty queue");
        }
        return head.getData();
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public int size() {
        return size;
    }
    
    // Método helper para debugging (opcional)
    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.getData());
            if (current.getNext() != null) sb.append(", ");
            current = current.getNext();
        }
        sb.append("]");
        return sb.toString();
    }
}
