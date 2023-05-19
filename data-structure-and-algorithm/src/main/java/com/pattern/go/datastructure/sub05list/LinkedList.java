package com.pattern.go.datastructure.sub05list;

public class LinkedList<E> {

  private class Node {

    public E element;
    public Node next;

    public Node(E element, Node next) {

      this.element = element;
      this.next = next;
    }

    @SuppressWarnings("unused")
    public Node(E element) {

      this(element, null);
    }

    @SuppressWarnings("unused")
    public Node() {

      this(null, null);
    }

    @Override
    public String toString() {

      return element.toString();
    }
  }

  private Node head;
  private int size;

  public LinkedList() {

    head = null;
    size = 0;
  }

  /**
   * 获取链表中的元素个数
   * 
   * @return
   */
  public int getSize() {

    return size;
  }

  /**
   * 返回链表是否为空
   * 
   * @return
   */
  public boolean isEmpty() {

    return size == 0;
  }

  /**
   * 在链表头添加新的元素element
   * 
   * @param element
   */
  public void addFirst(E element) {

    head = new Node(element, head.next);
    size++;
  }

  /**
   * 在链表的index(0-based)位置添加新的元素element
   * 
   * 在链表中不是一个常用的操作，练习用：）
   * 
   * @param index
   * @param element
   */
  public void add(int index, E element) {

    if (index < 0 || index > size) {
      throw new IllegalArgumentException("Add failed. Illegal index.");
    }

    if (index == 0) {
      addFirst(element);
    } else {
      Node prev = head;
      for (int i = 0; i < index - 1; i++) {
        prev = prev.next;
      }
      prev.next = new Node(element, prev.next);
      size++;
    }
  }

  /**
   * 在链表末尾添加新的元素element
   * 
   * @param element
   */
  public void addLast(E element) {

    add(size, element);
  }
}
