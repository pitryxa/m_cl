package pitryxa.math;

import java.awt.Point;

public class Distance2D {
    private final Point p1;
    private final Point p2;

    public Distance2D(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public double value() {
        int dX = p1.x - p2.x;
        int dY = p1.y - p2.y;
        return Math.sqrt(dX * dX + dY * dY);
    }
}
