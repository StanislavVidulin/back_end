public class TaskBoardImpl1 implements TaskBoard {
    private String task;

    @Override
    public synchronized void setTask(String task) {
        this.task = task;
        this.notify();
    }

    // на время wait, тред отпустил блокировку synchronised
    @Override
    public synchronized String getTask() {
        while (task == null) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        String res = task;
        task = null;
        return res;
    }
}