package com.pattern.go.utils;

import com.pattern.go.algorithm.sub02selectionsort.SelectionSort;

public class SortingHelper {

  private SortingHelper() {
  }

  public static <T extends Comparable<T>> Boolean isSorted(T[] array) {

    for (int i = 0; i < array.length - 1; i++) {
      if (array[i + 1].compareTo(array[i]) < 0) {
        return false;
      }
    }

    return true;
  }

  public static <T extends Comparable<T>> void sortTest(String sortName, T[] array) {

    long startTime = System.nanoTime();

    switch (sortName) {
    case "SELECTION_SORT":
      SelectionSort.sort(array);
      break;
    default:
      break;
    }

    long endTime = System.nanoTime();
    double time = (endTime - startTime) / (1000 * 1000 * 1000 * 1.0);

    if (!isSorted(array)) {
      throw new RuntimeException(sortName + " failed");
    }
    System.out.println(String.format("%s , size = %d : %f s", sortName, array.length, time));
  }
}
