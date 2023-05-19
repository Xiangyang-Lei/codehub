package com.pattern.go.datastructure.sub03stack;

import com.pattern.go.datastructure.sub02array.Array;

public class ArrayStack<E> implements Stack<E> {

  private Array<E> array;

  public ArrayStack(int capacity) {

    array = new Array<E>(capacity);
  }

  public ArrayStack() {

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
  public void push(E element) {

    array.addLast(element);
  }

  @Override
  public E pop() {

    return array.removeLast();
  }

  @Override
  public E peek() {

    return array.getLast();
  }

  @Override
  public String toString() {

    StringBuilder result = new StringBuilder();

    result.append("Stack: ");
    result.append('[');
    for (int i = 0; i < array.getSize(); i++) {
      result.append(array.get(i));
      if (i != array.getSize() - 1) {
        result.append(", ");
      }
    }
    result.append("] top");

    return result.toString();
  }
}
