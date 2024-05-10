package pitryxa.action;

import pitryxa.random.IntRandom;

public class Delay {
    private final int delayMin;
    private final int delayMax;

    public Delay(int delayMin, int delayMax) {
        this.delayMin = delayMin;
        this.delayMax = delayMax;
    }

    public void execute() {
        int delay = new IntRandom(delayMin, delayMax).generate();
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
