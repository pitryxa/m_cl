package pitryxa.action.scroll;

import pitryxa.action.Delay;
import pitryxa.random.BooleanRandom;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class Scroll {

    private final Logger logger = Logger.getLogger(Scroll.class.getName());
    private final Delay delay;
    private final ScrollNumber scrollNumber;
    private final Robot robot;

    public Scroll(Delay delay, ScrollNumber scrollNumber) throws AWTException {
        this(delay, scrollNumber, new Robot());
    }

    public Scroll(Delay delay, ScrollNumber scrollNumber, Robot robot) {
        this.delay = delay;
        this.scrollNumber = scrollNumber;
        this.robot = robot;
    }

    public void execute() {
        int direction = new BooleanRandom().generate() ? 1 : -1;
        int number = scrollNumber.generate();
        IntStream.range(0, number).forEach(i -> {
            robot.mouseWheel(direction);
            delay.execute();
        });
        logger.info("Scroll " + number);
    }
}
