package module02.interfaces;

public interface Validator<T> {

    boolean isValid(T value);
}
