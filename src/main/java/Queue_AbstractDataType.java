package main.java;

import java.util.List;

public interface Queue_AbstractDataType<T> {
    void enqueue(T t);
    T dequeue();
    T peek();
    boolean isFull();
    boolean isEmpty();
    List<T> Orderlist();

}
