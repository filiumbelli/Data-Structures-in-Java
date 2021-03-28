public interface IArray<T> {

    boolean add(T t);
    void remove(T t);
    boolean contains(T t);
    ArrayImpl<T> clone();
    T get(int index);
    boolean isEmpty();
    int size();
    int indexOf(T t);
    void clear();
}
