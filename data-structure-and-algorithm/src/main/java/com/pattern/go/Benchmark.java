package com.pattern.go;

import java.util.Random;

import com.pattern.go.algorithm.sub01linearsearch.LinearSearch;
import com.pattern.go.datastructure.sub01student.ComparableStudent;
import com.pattern.go.datastructure.sub02array.Array;
import com.pattern.go.datastructure.sub03stack.ArrayStack;
import com.pattern.go.datastructure.sub03stack.Stack;
import com.pattern.go.datastructure.sub04queue.ArrayQueue;
import com.pattern.go.datastructure.sub04queue.LoopQueue;
import com.pattern.go.datastructure.sub04queue.Queue;
import com.pattern.go.utils.ArrayGenerator;
import com.pattern.go.utils.SortingHelper;

public class Benchmark {

  private Benchmark() {
  }

  public static void main(String[] args) {

    String mode = "QUEUE";

    switch (mode) {
    /**
     * Data Structure Test
     */
    case "ARRAY":
      testArray();
      break;
    case "STACK":
      testStack();
      break;
    case "QUEUE":
      testQueue(new ArrayQueue<Integer>(), 100 * 1000);
      testQueue(new LoopQueue<Integer>(), 100 * 1000);
      break;

    /**
     * Algorithm Test
     */
    case "LINEAR_SEARCH":
      testLinearSearch();
      break;
    case "SELECTION_SORT":
      testSelectionSort();
      break;
    default:
      break;
    }
  }

  public static void testArray() {

    Array<Integer> array = new Array<Integer>();

    for (int i = 0; i < 10; i++) {
      array.addLast(i);
    }
    System.out.println(array);

    array.add(1, 100);
    System.out.println(array);

    array.addFirst(-1);
    System.out.println(array);

    array.remove(2);
    System.out.println(array);

    array.removeElement(4);
    System.out.println(array);

    array.removeFirst();
    System.out.println(array);

    Array<ComparableStudent> studentArray = new Array<ComparableStudent>();

    studentArray.addLast(new ComparableStudent(1, "Alice", 100));
    studentArray.addLast(new ComparableStudent(2, "Bob", 66));
    studentArray.addLast(new ComparableStudent(3, "Charlie", 88));
    System.out.println(studentArray);
  }

  public static void testStack() {

    Stack<Integer> stack = new ArrayStack<Integer>();

    for (int i = 0; i < 5; i++) {
      stack.push(i);
      System.out.println(stack);
    }

    stack.pop();
    System.out.println(stack);
  }

  public static void testQueue(Queue<Integer> queue, int operationCount) {

    long startTime = System.nanoTime();

    Random random = new Random();
    for (int i = 0; i < operationCount; i++) {
      queue.enqueue(random.nextInt(Integer.MAX_VALUE));
    }
    for (int i = 0; i < operationCount; i++) {
      queue.dequeue();
    }

    long endTime = System.nanoTime();

    double time = (endTime - startTime) / (1000 * 1000 * 1000 * 1.0);
    System.out.println("time: " + time + " s");
  }

  public static void testLinearSearch() {

    int[] sizes = { 1000 * 1000, 10 * 1000 * 1000 };
    int iteration = 100;

    for (int size : sizes) {
      Integer[] array = ArrayGenerator.generateOrderedArray(size);

      long startTime = System.nanoTime();
      for (int i = 0; i < iteration; i++) {
        LinearSearch.search(array, size);
      }
      long endTime = System.nanoTime();

      double time = (endTime - startTime) / (1000 * 1000 * 1000 * 1.0);
      System.out.println("size = " + size + ", " + iteration + " runs : " + time + "s");
    }
  }

  public static void testSelectionSort() {

    int[] sizes = { 10000, 100000 };
    int bound = 10000;

    for (int size : sizes) {
      Integer[] array = ArrayGenerator.generateRandomArray(size, bound);
      SortingHelper.sortTest("SELECTION_SORT", array);
    }
  }
}
