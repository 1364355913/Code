package com.youkeda;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

/**
 * @author zhoufan
 * @date 2020/5/25
 */
public class YKDTest {

  public static void error(String msg) {
    System.err.println("<YkdError>" + msg + "</YkdError>");
  }

  // 普通的插入
  @Test
  public void runA() {
    Class<?> aClass = null;
    try {
      aClass = Class.forName("com.youkeda.QuickSort");
    } catch (ClassNotFoundException e) {
      error("没有创建`QuickSort`类");
      return;
    }

    Object instance = null;
    try {
      instance = aClass.newInstance();
    } catch (Exception e) {
      e.printStackTrace();
      return;
    }

    try {
      Method quickSortMethod = aClass.getMethod("quickSort", int[].class);

      int[] array1 = {9, 2, 4, 7, 5, 3};
      int[] answer1 = {2, 3, 4, 5, 7, 9};
      quickSortMethod.invoke(null, array1);
      if (!Arrays.toString(array1).equals(Arrays.toString(answer1))) {
        error("`" + Arrays.toString(array1) + "`: 测试结果不正确");
        return;
      }

      int[] array2 = {1, 6, 4, 2, 5, 3};
      int[] answer2 = {1, 2, 3, 4, 5, 6};
      quickSortMethod.invoke(null, array2);
      if (!Arrays.toString(array2).equals(Arrays.toString(answer2))) {
        error("`" + Arrays.toString(array2) + "`: 测试结果不正确");
        return;
      }

      int[] array3 = {54, 3, 4, 0, 7, 20, 30, 45, 23, 11, 5, 10};
      int[] answer3 = {0, 3, 4, 5, 7, 10, 11, 20, 23, 30, 45, 54};
      quickSortMethod.invoke(null, array3);
      if (!Arrays.toString(array3).equals(Arrays.toString(answer3))) {
        error("`" + Arrays.toString(array3) + "`: 测试结果不正确");
        return;
      }

    } catch (NoSuchMethodException e) {
      error("`QuickSort`类没有创建对应的方法");
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
