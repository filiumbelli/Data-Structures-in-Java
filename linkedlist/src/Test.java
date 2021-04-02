public class Test {
    public static void main(String[] args) {
        ListImpl<Integer> l = new ListImpl<Integer>();
        l.add(15);
        l.add(25);
        l.add(33);
        l.add(44);
        l.add(55);
        l.add(66);
        l.remove(0);
        l.remove(4);
        l.push(10);
        l.pop();
        l.removeFirst();
        l.removeLast();
        l.remove(1);
        l.remove(0);
        l.add(25);
        l.add(33);
        l.add(2,55);
        l.addFirst(55);
        System.out.println(l.size());
        System.out.println(l);

    }
}
