import java.util.Arrays;
class Playlist {
    private final String[] songs;
    private int songCount;
    public Playlist(int maxSize) {
        if (maxSize < 0) {
            throw new IllegalArgumentException("Size cannot be negative");
        }
        songs = new String[maxSize];
        songCount = 0;
    }
    public void addSong(String song) {
        if (songCount >= songs.length) {
            throw new IllegalStateException("Playlist is full");
        }
        songs[songCount] = song;
        songCount++;
    }
    public String[] getSongs() {
        return Arrays.copyOf(songs, songCount);
    }
    public int getSongCount() {
        return songCount;
    }
}
public class Main {
    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");
        String[] copy = p.getSongs();
        System.out.println(Arrays.toString(copy));
        copy[0] = "Hacked";
        System.out.println(Arrays.toString(p.getSongs()));
        System.out.println(p.getSongCount());
    }
}