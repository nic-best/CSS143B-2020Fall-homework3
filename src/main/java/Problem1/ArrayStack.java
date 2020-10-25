package Problem1;

import java.util.Arrays;

public class ArrayStack<T> implements Stack<T> {
    // do not change member variables
    private T[] data;
    private int size;

    private ArrayStack() {
    }

    public ArrayStack(int capacity) {
        //generic array creation
        data = (T[]) new Object[capacity];
        size = 0;
    }

    @Override
    public boolean push(T val) {
        if(size==data.length){
            return false;
        }
        if(data.length==0){
            return false;
        }
        System.out.println("valPush = " + val);
        data[size] = val;
        size++;
        return true;
    }

    @Override
    public T pop() {
        if(size==0){
            return null;
        }
        if(data.length==0){
            return null;
        }
        T val = data[size-1];
        data[size-1] = null;
        size--;
        return val;
    }

    @Override
    public T peek() {
        if(data.length==0){
            return null;
        }
        if(size==0){
            return null;
        }
        T val = data[size-1];
        System.out.println("valPeek = " + val);
        System.out.println(Arrays.toString(data));
        return val;
    }

    @Override
    public int size() {
        return size;
    }
}
