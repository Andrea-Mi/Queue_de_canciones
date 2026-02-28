package umg.edu.gt.data_structure.queuehandler;

import umg.edu.gt.data_structure.queuehandler.model.Song;

public class Main {
    
    private static int totalSongsPlayed = 0;
    private static int totalSecondsPlayed = 0;

    public static void main(String[] args) {
        System.out.println("=== SPOTIFY SIMULATION ===");
        
        MusicQueue playlist = new MusicQueue();
        
        playlist.enqueue(new Song("Bohemian Rhapsody", "Queen", 25, 1));
        playlist.enqueue(new Song("Stairway to Heaven", "Led Zeppelin", 20, 1));
        playlist.enqueue(new Song("Hotel California", "Eagles", 18, 2));
        playlist.enqueue(new Song("Imagine", "John Lennon", 15, 2));
        playlist.enqueue(new Song("Hey Jude", "The Beatles", 22, 2));
        
        System.out.println("[LOG] Starting playlist...");
        System.out.println();
        
        int num = 1;
        while (!playlist.isEmpty()) {
            playSong(playlist.dequeue(), num++);
        }
        
        System.out.println("[LOG] Playlist finished.");
        System.out.println("[LOG] Total songs played: " + totalSongsPlayed);
        System.out.println("[LOG] Total playtime: " + totalSecondsPlayed + " seconds");
    }
    
    private static void playSong(Song song, int number) {
        System.out.println("[LOG] Now playing: " + song);
        System.out.println("[LOG] Priority: " + (song.getPriority() == 1 ? "HIGH" : "NORMAL"));
        System.out.println();
        
        int duration = song.getDuration();
        
        for (int s = 1; s <= duration; s++) {
            String bar = createProgressBar(s, duration);
            System.out.println("[LOG] " + song.getTitle() + " | " + bar + " " + s + "s/" + duration + "s");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
        System.out.println();
        System.out.println("[LOG] Finished: " + song.getTitle());
        System.out.println();
        
        totalSongsPlayed++;
        totalSecondsPlayed += duration;
    }
    
    private static String createProgressBar(int current, int total) {
        int len = 20;
        int filled = (current * len) / total;
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < len; i++) {
            if (i < filled) {
                sb.append("#");
            } else {
                sb.append("-");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}