package pitryxa.random;

import java.util.Random;

public class IntRandom {
    private final int startInclusive;
    private final int endExclusive;

    public IntRandom(int startInclusive, int endExclusive) {
        this.startInclusive = startInclusive;
        this.endExclusive = endExclusive;
    }

    public int generate() {
        return new Random().nextInt(endExclusive - startInclusive) + startInclusive;
    }
}
