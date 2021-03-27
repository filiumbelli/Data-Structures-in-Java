public class ListImpl implements IList {
    class Node<T extends Node> {
        private Node next;
        private Node prev;
        private Node node;

        public Node() {
        }

        public Node(Object x) {
            this.node = new Node(x);
        }

        public Node(T next, T prev, T node) {
            this.next = next;
            this.prev = prev;
            this.node = node;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Object next) {
            this.next = new Node(next);
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Object getNode() {
            return node;
        }


        public void setNode(Object node) {
            this.node = new Node(node);
        }
    }

    private int len;
    private Node node;
    private int currentIndex = 0;
    private int size;

    public ListImpl() {
        len = 5;
        node = new Node();
    }

    @Override
    public String toString() {
        return "ListImpl{" +
                "len=" + len +
                ", node=" + node +
                ", currentIndex=" + currentIndex +
                ", size=" + size +
                '}';
    }

    public void add(Object x) {
        Node prevNode = null;
        if (node.getNode() == null) {
            node.setNode(x);
            node.setPrev(prevNode);
            node.setNext(null);
            size++;
        } else {
            for (int i = 0; i < size; i++) {
                if (node.getNext() == null) {
                    prevNode = node;
                    node.setNext(x);
                    node.getNext();
                    node.setPrev(prevNode);
                }
            }
            size++;
        }
    }

    @Override
    public Object get(int x) {
        int count = 0;
        while (node.getNext() != null) {
            if (count == x) {
                return node.getNode();
            }
            node = node.getNext();
            count++;
        }
        return null;
    }

    @Override
    public void remove(int x) {

    }


    @Override
    public void add(int index, Object x) {

    }

    @Override
    public boolean contains(Object x) {
        return false;
    }

    @Override
    public int indexOf(Object x) {
        return 0;
    }
}
