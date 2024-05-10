package pitryxa;

import com.github.joonasvali.naturalmouse.api.MouseMotionFactory;
import com.github.joonasvali.naturalmouse.support.ScreenAdjustedNature;
import com.github.joonasvali.naturalmouse.util.FactoryTemplates;
import pitryxa.action.Cursor;
import pitryxa.action.Delay;
import pitryxa.action.click.Click;
import pitryxa.action.motion.Motion;
import pitryxa.action.motion.Offset;
import pitryxa.action.scroll.Scroll;
import pitryxa.action.scroll.ScrollNumber;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Point;

public class App {
    public static void main(String[] args) {
        try {
            final MouseMotionFactory motionFactory = getMotionFactory();
            InitialMouseArea initialMouseArea = new InitialMouseArea(motionFactory, 300);
            new MouseImitation(
                    new Mouse(
                            new Motion(
                                    new Cursor(motionFactory),
                                    new Offset(initialMouseArea, 20, 20)),
                            new Scroll(
                                    new Delay(100, 400),
                                    new ScrollNumber(-10, 10)),
                            new Click(
                                    new Cursor(motionFactory),
                                    initialMouseArea,
                                    new Delay(100, 300),
                                    new Delay(1_000, 10_000))),
                    10_000
            ).start();
        } catch (AWTException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static MouseMotionFactory getMotionFactory() {
        Dimension screenOnTheRight = new Dimension(1920, 1080);
        Dimension mainScreen = new Dimension(1920, 1080);
        ScreenAdjustedNature nature = new ScreenAdjustedNature(
                new Dimension(screenOnTheRight.width + mainScreen.width, 1080),
                new Point(0, 0)
        );
        return FactoryTemplates.createAverageComputerUserMotionFactory(nature);
    }
}
