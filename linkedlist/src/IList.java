interface IList<T extends Object> {

    public void add(T x);
    public T get(int x);
    public void remove(int x);
    public void add(int index,T x);
    public boolean contains(T x);
    public int indexOf(T x);

}
