package history_of_women;

@FunctionalInterface
public interface SQLConsumer<T> {
    void accept(T t) throws Exception;
}
