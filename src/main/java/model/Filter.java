package model;

@FunctionalInterface
public interface Filter<T> {
    T search(String input);
}
