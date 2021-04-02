import java.util.EmptyStackException;
import java.util.LinkedList;

public class Stack<T>{


    private LinkedList<T> list  = new LinkedList<T>();


    public Stack(){}

    public Stack(T element){
        push(element);
    }

    public void push(T element){
        list.addFirst(element);
    }

    public void pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        list.removeLast();
    }

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return list.size()>0;
    }
}
