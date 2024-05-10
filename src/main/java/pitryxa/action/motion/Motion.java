package pitryxa.action.motion;

import pitryxa.action.Cursor;

import java.awt.Point;
import java.util.logging.Logger;

public class Motion {
    private final Logger logger = Logger.getLogger(Motion.class.getName());
    private final Cursor cursor;
    private final Offset offset;

    public Motion(Cursor cursor, Offset offset) {
        this.cursor = cursor;
        this.offset = offset;
    }

    public void execute() throws InterruptedException {
        Point current = cursor.current();
        Point destination = offset.destination(current);
        cursor.move(destination);
        logger.info(String.format("Move to %d:%d from %d:%d", destination.x, destination.y, current.x, current.y));
    }
}
