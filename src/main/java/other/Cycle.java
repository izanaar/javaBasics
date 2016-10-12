package other;

public class Cycle {
    public static void main(String[] args) {
        int n = 10;
        for(int i = 1; i < n; i++) {
            n = i * (i + 1);
        }

    }
}
