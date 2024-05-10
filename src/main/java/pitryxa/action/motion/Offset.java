package pitryxa.action.motion;

import pitryxa.InitialMouseArea;
import pitryxa.random.IntRandom;

import java.awt.Point;

public class Offset {
    private final InitialMouseArea initialMouseArea;
    private final int maxOffsetX;
    private final int maxOffsetY;

    public Offset(InitialMouseArea initialMouseArea, int maxOffsetX, int maxOffsetY) {
        this.initialMouseArea = initialMouseArea;
        this.maxOffsetX = maxOffsetX;
        this.maxOffsetY = maxOffsetY;
    }

    public Point destination(Point current) {
        while (true) {
            int offsetX = new IntRandom(-maxOffsetX, maxOffsetX).generate();
            int offsetY = new IntRandom(-maxOffsetY, maxOffsetY).generate();
            Point destination = new Point(current.x + offsetX, current.y + offsetY);
            if (initialMouseArea.pointIn(destination)
                    || initialMouseArea.compareByProximity(destination, current) <= 0) {
                return destination;
            }
        }
    }
}
