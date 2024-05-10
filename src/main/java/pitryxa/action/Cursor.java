package pitryxa.action;

import com.github.joonasvali.naturalmouse.api.MouseMotionFactory;

import java.awt.Point;

public class Cursor {
    private final MouseMotionFactory motionFactory;

    public Cursor(MouseMotionFactory motionFactory) {
        this.motionFactory = motionFactory;
    }

    public Point current() {
        return motionFactory.getMouseInfo().getMousePosition().getLocation();
    }

    public void move(Point p) throws InterruptedException {
        motionFactory.move(p.x, p.y);
    }
}
