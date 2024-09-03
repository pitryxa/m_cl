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
import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.util.Arrays;
import java.util.Comparator;

public class App {
    private static final Integer DEFAULT_WIDTH = 1920;
    private static final Integer DEFAULT_HEIGHT = 1080;

    public static void main(String[] args) {
        try {
            final MouseMotionFactory motionFactory = getMotionFactory();
            InitialMouseArea initialMouseArea = new InitialMouseArea(motionFactory, 300);
            Cursor cursor = new Cursor(motionFactory);
            new MouseImitation(
                    new Mouse(
                            new Motion(
                                    cursor,
                                    new Offset(initialMouseArea, 20, 20)),
                            new Scroll(
                                    new Delay(100, 400),
                                    new ScrollNumber(-10, 10)),
                            new Click(
                                    cursor,
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
        GraphicsDevice[] screenDevices = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();
        Integer width = Arrays.stream(screenDevices)
                .map(GraphicsDevice::getDisplayMode)
                .map(DisplayMode::getWidth)
                .reduce(Integer::sum)
                .orElse(DEFAULT_WIDTH);
        Integer height = Arrays.stream(screenDevices)
                .map(GraphicsDevice::getDisplayMode)
                .map(DisplayMode::getHeight)
                .min(Comparator.comparingInt(Integer::intValue))
                .orElse(DEFAULT_HEIGHT);
        ScreenAdjustedNature nature = new ScreenAdjustedNature(
                new Dimension(width, height),
                new Point(0, 0)
        );
        return FactoryTemplates.createAverageComputerUserMotionFactory(nature);
    }
}
