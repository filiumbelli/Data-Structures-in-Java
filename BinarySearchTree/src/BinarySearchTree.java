


import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable> {
    private int nodeCount = 0;
    private Node root = null;

    private class Node {
        T data;
        Node left, right;

        public Node(Node left, Node right, T elem) {
            this.data = elem;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isEmpty() {
        return size() > 0;
    }

    public int size() {
        return nodeCount;
    }

    public boolean add(T elem) {
        if (contains(elem)) {
            return false;
        } else {
            root = add(root, elem);
            nodeCount++;
            return true;
        }

    }

    private Node add(Node node, T elem) {
        if (node == null) {
            node = new Node(null, null, elem);
        } else {
            if (elem.compareTo(node.data) < 0) {
                node.left = add(node.left, elem);
            } else {
                node.right = add(node.right, elem);
            }
        }
        return node;
    }

    public boolean remove(T elem) {
        if (contains(elem)) {
            root = remove(root, elem);
            nodeCount--;
            return true;
        }
        return false;
    }

    private Node remove(Node node, T elem) {
        if (node == null) return null;
        int cmp = elem.compareTo(node.data);

        if (cmp < 0) {
            node.left = remove(node.left, elem);
        } else if (cmp > 0) {
            node.right = remove(node.right, elem);
        } else {
            if (node.left == null) {
                Node rightChild = node.right;
                node.data = null;
                node = null;
                return rightChild;
            } else if (node.right == null) {
                Node leftChild = node.left;
                node.data = null;
                node = null;
                return leftChild;
            } else {
                Node tmp = digLeft(node.right);
                node.data = tmp.data;

                node.right = remove(node.right, tmp.data);
            }
        }
        return node;

    }

    private Node digLeft(Node node) {
        Node cur = node;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur;

    }

    private Node digRight(Node node) {
        Node cur = node;
        while (cur.right != null) {
            cur = cur.right;
        }
        return cur;

    }

    public boolean contains(T elem) {
        return contains(root, elem);
    }

    private boolean contains(Node node, T elem) {
        if (node == null) return false;
        int cmp = elem.compareTo(node.data);
        if (cmp < 0) return contains(node.left, elem);
        else if (cmp > 0) return contains(node.left, elem);
        else return true;
    }
}
