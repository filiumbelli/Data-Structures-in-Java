public class ListImpl<T extends Object> implements IList {

    private int len = 0;
    private Node tail;
    private Node head;
    Node node = new Node();

    public int size(){
        return len;
    }
    class Node<T extends Node> {
        private T next;
        private T prev;
        private Object value;

        public Node() {
        }

        public Object getValue() {
            return value;
        }

        public Node setValue(Object value) {
            this.value = value;
            return this;
        }

        public T getNext() {
            return next;
        }

        public Node setNext(T next) {
            this.next = next;
            return this;
        }

        public T getPrev() {
            return prev;
        }

        public Node setPrev(T prev) {
            this.prev = prev;
            return this;
        }
    }


    public ListImpl() {
    }

    @Override
    public void add(Object x) {
        if (node == null || node.getValue() == null  ) {
            node = new Node();
            node.setValue(x);
            node.setNext(null);
            node.setPrev(null);
            head = node;
            tail = node;
            len++;
        }
        //1 3 null
        else {
//            Node temp = node;
//            while(temp.getNext() !=null){
//                temp.getNext().setPrev(temp);
//                temp.getNext().setValue(temp.getNext().getValue());
//                temp = temp.getNext();
//            }
//            Node node = new Node();
//            node.setPrev(temp);
//            node.setNext(null);
//            node.setValue(x);
//            temp.setNext(node);
//
            Node node = new Node()
                    .setPrev(tail)
                    .setNext(null)
                    .setValue(x);
            tail.setNext(node);
            tail = node;
            len++;
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node tempNode = node;
        if(node == null){
            return null;
        }
        while (tempNode.getNext() != null) {
            sb.append(tempNode.getValue());
            sb.append(",");
            tempNode = tempNode.getNext();
        }
        sb.append(tempNode.getValue());
        sb.append("]");
        return sb.toString();
    }


    @Override
    public Object get(int x) {
        if (x >= len) {
            throw new IndexOutOfBoundsException();
        } else {
            int i = 0;
            Node temp = node;
            while (i != x) {
                temp = temp.getNext();
            }
            return temp.getValue();
        }
    }

    @Override
    public Object poll(Object x) {
        int val = indexOf(x);
        if (val != -1) {
            return get(val);
        }
        return null;
    }

    @Override
    public void removeFirst() {
        Node temp = node;
        temp = temp.getNext();
        temp.setPrev(null);
        this.node = temp;
        len--;


    }

    @Override
    public void removeLast() {
        tail = tail.getPrev();
        if (tail != null) {
            tail.setNext(null);
            len--;
        } else {
            head = null;
            tail = null;
            this.node = null;
            len = 0;
        }

    }

    @Override
    public void remove(int x) {
        Node temp = node;
        if (x >= len) {
            throw new IndexOutOfBoundsException();
        } else {
            if (x == len - 1) {
                removeLast();
            } else if (x == 0) {
                removeFirst();
            } else {
                for (int i = 0; i <= x; i++) {

                    if (i == x) {

                        temp.getPrev().setNext(temp.getNext());
                        temp = null;
                        //1 3 ->5 6 7
                        break;
                    }
                    temp = temp.getNext();

                }
                len--;


            }

        }

    }

    @Override
    public void add(int index, Object x) {

    }

    @Override
    public boolean contains(Object x) {
        return indexOf(x) > -1;
    }

    @Override
    public int indexOf(Object x) {
        Node temp = node;
        int count = 0;
        while (temp.getNext().getValue() != null) {
            if (temp.getValue() == x) {
                return count;
            }
            temp = temp.getNext();
            count++;
        }
        return -1;
    }

    @Override
    public void addFirst(Object x) {
        Node node = new Node().setValue(x).setNext(head).setPrev(null);
        head.setPrev(node);
        head = node;
    }

    @Override
    public void addLast(Object x) {
        add(x);
    }

    @Override
    public Object getFirst() {
        return head;
    }

    @Override
    public Object getLast() {
        return tail;
    }

    @Override
    public Object pop() {
        Object t = tail.getValue();
        removeLast();
        return t;
    }

    @Override
    public void push(Object x) {
        len++;
        Node node = new Node().setValue(x)
                .setPrev(tail)
                .setNext(null);
        tail.setNext(node);
        tail = node;


        //10 5 62 6 5 null tail-> node(1,5,null) 6 5 1 null
    }
}

