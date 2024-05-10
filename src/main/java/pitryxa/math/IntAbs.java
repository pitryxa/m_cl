package pitryxa.math;

public class IntAbs {
    private final int n;

    public IntAbs(int n) {
        this.n = n;
    }

    public int value() {
        return n < 0 ? -n : n;
    }
}
