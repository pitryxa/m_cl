package pitryxa;

public class MouseImitation {
    private final Mouse mouse;
    private final int iterationCount;

    public MouseImitation(Mouse mouse, int iterationCount) {
        this.iterationCount = iterationCount;
        this.mouse = mouse;
    }

    public void start() throws InterruptedException {
        for (int i = 0; i < iterationCount; i++) {
            mouse.scroll();
            mouse.move();
            mouse.click();
        }
    }
}
