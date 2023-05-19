package com.pattern.go.datastructure.sub04queue;

import com.pattern.go.datastructure.sub02array.Array;

public class ArrayQueue<E> implements Queue<E> {

  private Array<E> array;

  public ArrayQueue(int capacity) {

    array = new Array<E>(capacity);
  }

  public ArrayQueue() {

    array = new Array<E>();
  }

  public int getCapacity() {

    return array.getCapacity();
  }

  @Override
  public int getSize() {

    return array.getSize();
  }

  @Override
  public boolean isEmpty() {

    return array.isEmpty();
  }

  @Override
  public void enqueue(E element) {

    array.addLast(element);
  }

  @Override
  public E dequeue() {

    return array.removeFirst();
  }

  @Override
  public E getFront() {

    return array.getFirst();
  }

  @Override
  public String toString() {

    StringBuilder result = new StringBuilder();

    result.append("Queue: ");
    result.append("front [");
    for (int i = 0; i < array.getSize(); i++) {
      result.append(array.get(i));
      if (i != array.getSize() - 1) {
        result.append(", ");
      }
    }
    result.append("] tail");

    return result.toString();
  }
}
