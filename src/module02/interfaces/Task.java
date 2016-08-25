package module02.interfaces;

public interface Task<T> {

    void execute();

    T getResult();
}
