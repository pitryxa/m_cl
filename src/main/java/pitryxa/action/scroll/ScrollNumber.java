package pitryxa.action.scroll;

import pitryxa.random.IntRandom;

public class ScrollNumber {
    private final int minScroll;
    private final int maxScroll;

    public ScrollNumber(int minScroll, int maxScroll) {
        this.minScroll = minScroll;
        this.maxScroll = maxScroll;
    }

    public int generate() {
        int scrollNumber;
        while ((scrollNumber = new IntRandom(minScroll, maxScroll).generate()) == 0) {
        }
        return scrollNumber;
    }
}
