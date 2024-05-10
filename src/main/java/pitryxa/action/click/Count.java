package pitryxa.action.click;

public class Count {
    private long count;

    public Count(long count) {
        this.count = count;
    }

    public long inc() {
        return ++count;
    }
}
