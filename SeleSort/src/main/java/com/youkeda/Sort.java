package com.youkeda;
import java.util.Arrays;

public class Sort {

  // 选择排序
  public static void selectSort(int[] array) {
    for (int i = 0; i < array.length; i++) {
      // 暂时把第一个元素当做最大元素，并且记录最大元素的索引
      int maxIndex = 0;
      int max = array[0];
      // 注意 j 从 索引1 开始，到 array.length - i 截止
      for (int j = 1; j < array.length - i; j++) {
        // 如果元素大于当前最大值，则替换 max，maxIndex
        if (array[j] > max) {
          max = array[j];
          maxIndex = j;
        }
      }

      // 交换最大值元素 和 数组末尾元素
      int temp = array[maxIndex];
      array[maxIndex] = array[array.length - i - 1];
      array[array.length - i - 1] = temp;
    }
    
  }


  public static void main(String[] args) {
    int[] array = {9, 2, 4, 7, 5, 3};
    // Arrays.toString 可以方便打印数组内容
    System.out.println(Arrays.toString(array));
    selectSort(array);
    System.out.println(Arrays.toString(array));
  }
}
