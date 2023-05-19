package com.pattern.go.utils;

import java.util.Random;

public class ArrayGenerator {

  private ArrayGenerator() {
  }

  public static Integer[] generateOrderedArray(int size) {

    Integer[] array = new Integer[size];

    for (int i = 0; i < size; i++) {
      array[i] = i;
    }

    return array;
  }

  // 生成一个长度为 size 的随机数组，每个数字的范围是 [0, bound)
  public static Integer[] generateRandomArray(int size, int bound) {

    Integer[] array = new Integer[size];

    Random random = new Random();
    for (int i = 0; i < size; i++) {
      array[i] = random.nextInt(bound);
    }

    return array;
  }
}
