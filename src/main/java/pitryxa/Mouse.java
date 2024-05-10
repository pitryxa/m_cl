package pitryxa;

import pitryxa.action.click.Click;
import pitryxa.action.motion.Motion;
import pitryxa.action.scroll.Scroll;
import pitryxa.random.BooleanRandom;

import java.awt.AWTException;

public class Mouse {

    private final Motion motion;
    private final Scroll scroll;
    private final Click click;

    public Mouse(Motion motion, Scroll scroll, Click click) throws AWTException {
        this.motion = motion;
        this.scroll = scroll;
        this.click = click;
    }

    public void click() {
        if (new BooleanRandom().generate()) {
            click.execute();
        }
    }

    public void move() throws InterruptedException {
        if (new BooleanRandom().generate()) {
            motion.execute();
        }
    }

    public void scroll() {
        if (new BooleanRandom().generate()) {
            scroll.execute();
        }
    }
}
