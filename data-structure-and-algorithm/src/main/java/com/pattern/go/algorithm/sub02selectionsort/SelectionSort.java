package com.pattern.go.algorithm.sub02selectionsort;

import com.pattern.go.datastructure.sub01student.ComparableStudent;

public class SelectionSort {

  private SelectionSort() {
  }

  public static void main(String[] args) {

    Integer[] array1 = { 1, 4, 2, 3, 6, 5 };
    Integer[] array2 = { 1, 4, 2, 3, 6, 5 };
    ComparableStudent[] comparableStudents1 = { new ComparableStudent(1, "Alice", 98),
        new ComparableStudent(2, "Bobo", 100), new ComparableStudent(3, "Charles", 66) };
    ComparableStudent[] comparableStudents2 = { new ComparableStudent(1, "Alice", 98),
        new ComparableStudent(2, "Bobo", 100), new ComparableStudent(3, "Charles", 66) };

    sort(array1);
    recursionSort(array2, 0);
    sort(comparableStudents1);
    recursionSort(comparableStudents2, 0);

    for (int x : array1) {
      System.out.print(x + " ");
    }
    System.out.println();
    for (int x : array2) {
      System.out.print(x + " ");
    }
    System.out.println();
    for (ComparableStudent comparableStudent : comparableStudents1) {
      System.out.print(comparableStudent + " ");
    }
    System.out.println();
    for (ComparableStudent comparableStudent : comparableStudents2) {
      System.out.print(comparableStudent + " ");
    }
    System.out.println();
  }

  public static <E extends Comparable<E>> void sort(E[] array) {

    // array[0...i) 是有序的；array[i...n) 是无序的
    for (int i = 0; i < array.length; i++) {
      // 选择 array[i...n) 中的最小值的索引
      int minIndex = i;
      for (int j = i; j < array.length; ++j) {
        if (array[j].compareTo(array[minIndex]) < 0) {
          minIndex = j;
        }
      }

      swap(array, i, minIndex);
    }
  }

  // array[0...index) 是有序的；array[index...n) 是无序的
  public static <E extends Comparable<E>> void recursionSort(E[] array, int index) {

    if (index >= array.length) {
      return;
    }

    // 选择 array[index...n) 中的最小值的索引
    int minIndex = index;
    for (int i = index; i < array.length; i++) {
      if (array[i].compareTo(array[minIndex]) < 0) {
        minIndex = i;
      }
    }

    swap(array, index, minIndex);

    recursionSort(array, ++index);
  }

  private static <E> void swap(E[] array, int x, int y) {

    E temp = array[x];
    array[x] = array[y];
    array[y] = temp;
  }
}
