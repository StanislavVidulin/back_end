import java.util.concurrent.atomic.AtomicInteger;

public class Warehouse {
    private String title;
    private AtomicInteger value = new AtomicInteger();
    private Object lock = new Object();

    public Warehouse(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "title='" + title + '\'' +
                ", value=" + value +
                '}';
    }

    // public synchronized void addValue(int value)
    public void addValue(int value) {
//        synchronized (this)
//        synchronized (lock)
        this.value.getAndAdd(value);
//            this.value += value;
    }
}
