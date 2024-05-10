package pitryxa.action.click;

import pitryxa.InitialMouseArea;
import pitryxa.action.Cursor;
import pitryxa.action.Delay;
import pitryxa.action.motion.Motion;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.logging.Logger;

public class Click {
    private final Logger logger = Logger.getLogger(Motion.class.getName());
    private final Cursor cursor;
    private final InitialMouseArea initialMouseArea;
    private final Delay delayRelease;
    private final Delay delayClick;
    private final Count count;
    private final Robot robot;

    public Click(Cursor cursor, InitialMouseArea initialMouseArea, Delay delayRelease, Delay delayClick) throws AWTException {
        this(cursor, initialMouseArea, delayRelease, delayClick, new Count(0), new Robot());
    }

    public Click(Cursor cursor, InitialMouseArea initialMouseArea, Delay delayRelease, Delay delayClick, Robot robot) {
        this(cursor, initialMouseArea, delayRelease, delayClick, new Count(0), robot);
    }

    public Click(Cursor cursor, InitialMouseArea initialMouseArea, Delay delayRelease, Delay delayClick, Count count, Robot robot) {
        this.cursor = cursor;
        this.initialMouseArea = initialMouseArea;
        this.delayRelease = delayRelease;
        this.delayClick = delayClick;
        this.count = count;
        this.robot = robot;
    }

    public void execute() {
        Point current = cursor.current();
        if (initialMouseArea.pointOut(current)) {
            return;
        }
        delayClick.execute();
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        delayRelease.execute();
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        logger.info("Click " + count.inc());
    }
}
