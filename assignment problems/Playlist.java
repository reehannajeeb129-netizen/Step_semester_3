import java.util.Arrays;

public class Playlist {
    private final String[] songs;
    private int count = 0;

    public Playlist(int maxSize) {
        songs = new String[maxSize];
    }

    public boolean addSong(String title) {
        if (count >= songs.length) return false;
        songs[count++] = title;
        return true;
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, count);
    }

    public int getSongCount() {
        return count;
    }
}
