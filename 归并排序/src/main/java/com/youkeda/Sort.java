package com.youkeda;

import java.util.Arrays;

public class Sort {

  // 归并排序
  public static int[] mergeSort(int[] array) {
    // 为了方便查看结果，我们将每个数组进行打印
    if (array.length == 1) {
      return array;
    }

    int middle = array.length / 2;
    // 处理 0 到 middle 左侧数组部分
    int[] left = mergeSort(subArray(array, 0, middle));
    // 处理 middle 到 array.length 右侧数组部分
    int[] right = mergeSort(subArray(array, middle, array.length));

    // TODO处理合并问题
    return array;
  }

  // 拷贝原数组的部分内容，从 left 到 right
  public static int[] subArray(int[] source, int left, int right) {
    // 创建一个新数组
    int[] result = new int[right - left];
    // 依次赋值进去
    for (int i = left; i < right; i++) {
      result[i - left] = source[i];
    }
    return result;
  }

  public static void main(String[] args) {
    int[] array = {9, 2, 4, 7, 5, 3};
    // Arrays.toString 可以方便打印数组内容
    System.out.println("raw: " + Arrays.toString(array));
    int[] result = mergeSort(array);
    System.out.println("result: " + Arrays.toString(result));
  }
}
