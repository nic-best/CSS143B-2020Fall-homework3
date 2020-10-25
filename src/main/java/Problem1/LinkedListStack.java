package Problem1;

import java.util.LinkedList;

public class LinkedListStack<T> implements Stack<T> {
    // use Java LinkedList to store the data
    // do not change member variables
    private LinkedList<T> data;

    public LinkedListStack() {
        data = new LinkedList<T>();
    }

    //accessing from first because of o(1) speed for operations

    @Override
    public boolean push(T val) {
        data.addFirst(val);
        return true;
    }

    @Override
    public T pop() {
        if(data.size()==0){
            return null;
        }

        T val = data.removeFirst();   // place holder
        return val;   // place holder
    }

    @Override
    public T peek() {
        // homework
        T val = data.peekFirst();   // place holder
        return val;   // place holder
    }

    @Override
    public int size() {
        return data.size();
    }
}
