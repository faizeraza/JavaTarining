package assignments.task;

// Basic rule every task must be executed
public interface Task<T> {
    public T execute();
}
