package pitryxa;

import com.github.joonasvali.naturalmouse.api.MouseMotionFactory;
import pitryxa.math.Distance2D;
import pitryxa.math.IntAbs;

import java.awt.Point;

public class InitialMouseArea {
    private final Point initial;
    private final int maxOffset;

    public InitialMouseArea(MouseMotionFactory motionFactory, int maxOffset) {
        this(motionFactory.getMouseInfo().getMousePosition().getLocation(), maxOffset);
    }

    public InitialMouseArea(Point initial, int maxOffset) {
        this.initial = initial;
        this.maxOffset = maxOffset;
    }

    public int compareByProximity(Point p1, Point p2) {
        double distance1 = new Distance2D(p1, initial).value();
        double distance2 = new Distance2D(p2, initial).value();
        return Double.compare(distance1, distance2);
    }

    public boolean pointIn(Point point) {
        int offsetX = new IntAbs(point.x - initial.x).value();
        int offsetY = new IntAbs(point.y - initial.y).value();
        return offsetX <= maxOffset
                && offsetY <= maxOffset;
    }

    public boolean pointOut(Point point) {
        return !pointIn(point);
    }
}
