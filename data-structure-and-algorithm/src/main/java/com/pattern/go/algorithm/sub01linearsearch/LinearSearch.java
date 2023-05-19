package com.pattern.go.algorithm.sub01linearsearch;

public class LinearSearch {

  private LinearSearch() {
  }

  public static void main(String[] args) {

    Integer[] array = { 24, 18, 12, 9, 16, 66, 32, 4 };
    Integer target1 = 12;
    Integer target2 = 100;

    Integer result1 = search(array, target1);
    Integer result2 = search(array, target2);
    Integer result3 = recursionSearch(array, target1, 0);
    Integer result4 = recursionSearch(array, target2, 0);

    System.out.println("result1: " + result1);
    System.out.println("result2: " + result2);
    System.out.println("result3: " + result3);
    System.out.println("result4: " + result4);
  }

  public static <E> Integer search(E[] array, E target) {

    for (int i = 0; i < array.length; i++) {
      if (array[i].equals(target)) {
        return i;
      }
    }

    return -1;
  }

  public static <E> Integer recursionSearch(E[] array, E target, int index) {

    if (index >= array.length) {
      return -1;
    }

    if (array[index].equals(target)) {
      return index;
    }

    return recursionSearch(array, target, ++index);
  }
}
