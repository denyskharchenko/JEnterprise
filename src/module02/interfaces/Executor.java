package module02.interfaces;

import module02.exceptions.ExecuteLaunchException;

import java.util.List;

public interface Executor<T> {

    void addTask(Task<? extends T> task) throws ExecuteLaunchException;

    void addTask(Task<? extends T> task, Validator<? super T> validator) throws ExecuteLaunchException;

    void execute();

    List<? extends T> getValidResults() throws ExecuteLaunchException;

    List<? extends T> getInvalidResults() throws ExecuteLaunchException;
}
