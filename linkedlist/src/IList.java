interface IList<T extends Object> {

    public void add(T x);
    public T get(int x);
    public void remove(int x);
    public void add(int index,T x);
    public boolean contains(T x);
    public int indexOf(T x);
    public void addFirst(T x);
    public void addLast(T x);
    public T getFirst();
    public T getLast();
    public T pop();
    public void push(T x);
    public T poll(T x);
    public void removeFirst();
    public void removeLast();

}
