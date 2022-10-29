package com.youkeda;
import java.util.Arrays;

public class Sort {

  // 冒泡排序
  public static void bubbleSort(int[] array) {
    // 每次循环，都能冒泡出剩余元素中最大的元素，因此需要循环 array.length 次
    for (int i = 0; i < array.length; i++) {
      // 每次遍历，只需要遍历 0 到 array.length - i - 1中元素，因此之后的元素都已经是最大的了
      for (int j = 0; j < array.length - i - 1; j++) {
        // 交换元素
        if (array[j] < array[j + 1]) {
          int temp = array[j + 1];
          array[j + 1] = array[j];
          array[j] = temp;
        }
      }
    }
  }


  public static void main(String[] args) {
    int[] array = {9, 2, 4, 7, 5, 3};
    // Arrays.toString 可以方便打印数组内容
    System.out.println(Arrays.toString(array));
    bubbleSort(array);
    System.out.println(Arrays.toString(array));
  }
}
