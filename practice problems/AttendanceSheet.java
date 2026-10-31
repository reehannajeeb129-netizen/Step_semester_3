public class AttendanceSheet {
    private final String[] present;
    private int count = 0;

    public AttendanceSheet(int maxClassSize) {
        present = new String[maxClassSize];
    }

    public void markPresent(String name) {
        if (isPresent(name) || count >= present.length) return;
        present[count++] = name;
    }

    public int getPresentCount() {
        return count;
    }

    public boolean isPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (present[i].equals(name)) return true;
        }
        return false;
    }
}
