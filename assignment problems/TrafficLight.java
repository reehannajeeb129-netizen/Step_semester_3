public class TrafficLight {
    private static final String[] COLORS = {"RED", "GREEN", "YELLOW"};
    private final String id;
    private int index = 0;

    public TrafficLight(String id) {
        this.id = id;
    }

    public String next() {
        index = (index + 1) % COLORS.length;
        return COLORS[index];
    }

    public String getColor() {
        return COLORS[index];
    }

    public String getId() {
        return id;
    }
}
