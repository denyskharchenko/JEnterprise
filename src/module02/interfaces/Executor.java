package module02.interfaces;

import module02.exceptions.LaunchException;

import java.util.List;

public interface Executor<T> {

    void addTask(Task<? extends T> task) throws LaunchException;

    void addTask(Task<? extends T> task, Validator<? super T> validator) throws LaunchException;

    void execute();

    List<? extends T> getValidResults() throws LaunchException;

    List<? extends T> getInvalidResults() throws LaunchException;
}
