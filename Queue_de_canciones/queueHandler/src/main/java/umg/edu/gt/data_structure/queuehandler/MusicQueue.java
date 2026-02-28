package umg.edu.gt.data_structure.queuehandler;

import umg.edu.gt.data_structure.queue.manual.QueueLinked;
import umg.edu.gt.data_structure.queuehandler.model.Song;

public class MusicQueue {
    private QueueLinked<Song> highPriorityQueue;
    private QueueLinked<Song> normalPriorityQueue;
    
    public MusicQueue() {
        highPriorityQueue = new QueueLinked<>();
        normalPriorityQueue = new QueueLinked<>();
    }
    
    public void enqueue(Song song) {
        if (song.getPriority() == 1) {
            highPriorityQueue.enqueue(song);
        } else {
            normalPriorityQueue.enqueue(song);
        }
    }
    
    public Song dequeue() {
        if (!highPriorityQueue.isEmpty()) {
            return highPriorityQueue.dequeue();
        } else if (!normalPriorityQueue.isEmpty()) {
            return normalPriorityQueue.dequeue();
        }
        return null;
    }
    
    public boolean isEmpty() {
        return highPriorityQueue.isEmpty() && normalPriorityQueue.isEmpty();
    }
    
    public int size() {
        return highPriorityQueue.size() + normalPriorityQueue.size();
    }
}