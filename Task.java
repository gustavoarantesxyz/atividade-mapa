public class Task {
    private static int count = 0;
    private int id;
    private String description;
    private boolean isCompleted;

    public Task(String description) {
        this.id = ++count;
        this.description = description;
        this.isCompleted = false;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    @Override
    public String toString() {
        return id + ". " + "[" +(isCompleted ? "X" : " ")+ "] " + description;
    }
}