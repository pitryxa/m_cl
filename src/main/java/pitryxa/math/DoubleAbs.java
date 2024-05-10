package pitryxa.math;

public class DoubleAbs {
    private final double d;

    public DoubleAbs(double d) {
        this.d = d;
    }

    public double value() {
        return d < 0 ? -d : d;
    }
}
