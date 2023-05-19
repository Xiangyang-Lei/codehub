package com.pattern.go.datastructure.sub02array;

public class Array<E> {

  private E[] data;
  private int size;

  /**
   * 构造函数，传入数组的容量capacity构造Array
   * 
   * @param capacity
   */
  @SuppressWarnings("unchecked")
  public Array(int capacity) {

    data = (E[]) new Object[capacity];
    size = 0;
  }

  /**
   * 无参数的构造函数，默认数组的容量capacity=10
   */
  public Array() {

    this(10);
  }

  /**
   * 获取数组的容量
   * 
   * @return
   */
  public int getCapacity() {

    return data.length;
  }

  /**
   * 获取数组中的元素个数
   * 
   * @return
   */
  public int getSize() {

    return size;
  }

  /**
   * 返回数组是否为空
   * 
   * @return
   */
  public boolean isEmpty() {

    return size == 0;
  }

  /**
   * 在所有元素前添加一个新元素
   * 
   * @param element
   */
  public void addFirst(E element) {

    add(0, element);
  }

  /**
   * 向所有元素后添加一个新元素
   * 
   * @param element
   */
  public void addLast(E element) {

    add(size, element);
  }

  /**
   * 在index索引的位置插入一个新元素element
   * 
   * @param index
   * @param element
   */
  public void add(int index, E element) {

    if (index < 0 || index > size) {
      throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
    }

    if (size == data.length) {
      resize(2 * data.length);
    }

    for (int i = size - 1; i >= index; i--) {
      data[i + 1] = data[i];
    }

    data[index] = element;

    size++;
  }

  /**
   * 获取数组中第一个元素
   * 
   * @return
   */
  public E getFirst() {
    return get(0);
  }

  /**
   * 获取数组中最后一个元素
   * 
   * @return
   */
  public E getLast() {
    return get(size - 1);
  }

  /**
   * 获取index索引位置的元素
   * 
   * @param index
   * @return
   */
  public E get(int index) {

    if (index < 0 || index >= size) {
      throw new IllegalArgumentException("Get failed. Index is illegal.");
    }

    return data[index];
  }

  /**
   * 修改index索引位置的元素为element
   * 
   * @param index
   * @param element
   */
  public void set(int index, E element) {

    if (index < 0 || index >= size) {
      throw new IllegalArgumentException("Set failed. Index is illegal.");
    }

    data[index] = element;
  }

  /**
   * 查找数组中是否有元素element
   * 
   * @param element
   * @return
   */
  public boolean contains(E element) {

    for (int i = 0; i < size; i++) {
      if (data[i] == element) {
        return true;
      }
    }

    return false;
  }

  /**
   * 查找数组中元素element所在的索引，如果不存在元素element，则返回-1
   * 
   * @param element
   * @return
   */
  public int find(E element) {

    for (int i = 0; i < size; i++) {
      if (data[i] == element) {
        return i;
      }
    }

    return -1;
  }

  /**
   * 从数组中删除第一个元素, 返回删除的元素
   * 
   * @return
   */
  public E removeFirst() {

    return remove(0);
  }

  /**
   * 从数组中删除最后一个元素, 返回删除的元素
   * 
   * @return
   */
  public E removeLast() {

    return remove(size - 1);
  }

  /**
   * 从数组中删除index位置的元素，返回删除的元素
   * 
   * @param index
   * @return
   */
  public E remove(int index) {

    if (index < 0 || index >= size) {
      throw new IllegalArgumentException("Remove failed. Index is illegal.");
    }

    E result = data[index];
    for (int i = index; i < size - 1; i++) {
      data[i] = data[i + 1];
    }

    size--;
    data[size] = null; // loitering objects != memory leak

    if (size == data.length / 4 && data.length / 2 != 0) {
      resize(data.length / 2);
    }

    return result;
  }

  /**
   * 从数组中删除元素element
   * 
   * @param element
   */
  public void removeElement(E element) {

    int index = find(element);

    if (index != -1) {
      remove(index);
    }
  }

  /**
   * 将数组空间的容量变成newCapacity大小
   * 
   * @param newCapacity
   */
  private void resize(int newCapacity) {

    @SuppressWarnings("unchecked")
    E[] newData = (E[]) new Object[newCapacity];

    for (int i = 0; i < size; i++) {
      newData[i] = data[i];
    }

    data = newData;
  }

  @Override
  public String toString() {

    StringBuilder result = new StringBuilder();

    result.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
    result.append('[');
    for (int i = 0; i < size; i++) {
      result.append(data[i]);
      if (i != size - 1) {
        result.append(", ");
      }
    }
    result.append(']');

    return result.toString();
  }
}
