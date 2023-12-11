package main.java;

import java.lang.reflect.Array;
import java.util.*;

public class Queue_Implement<T> implements Queue_AbstractDataType<T> {
    private int capacity;
    private List<T> item;

    public Queue_Implement(int capacity, List<T> item) {
        this.capacity = capacity;
        this.item = new ArrayList<>();
    }

    public Queue_Implement(int capacity) {
        this.capacity = capacity;
        item = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    @Override
    public void enqueue(T t) {
        this.item.add(t);
    }
    @Override
    public T dequeue() {
        T t = item.get(0);
        item.remove(t);
        return t;
    }

    @Override
    public T peek() {
        T t = item.get(0);
        return t;
    }

    @Override
    public boolean isFull() {
        if(item.size() == capacity) return true;
        return false;
    }

    @Override
    public boolean isEmpty() {
        if(item.isEmpty()) return true;
        return false;
    }

    @Override
    public List<T> Orderlist() {
        return item;
    }
}
