package com.youkeda.test;

import java.lang.reflect.Method;

public class DaemonRunner {

  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws Exception {
    if (args == null || args.length < 1) {
      System.out.println("missing class name.");
      System.exit(0);
      return;
    }

    String mainClass = args[0];
    int maxTime = 3000;
    if (args.length > 1) {
      try {
        maxTime = Integer.valueOf(args[1]);
      } catch (NumberFormatException e) {
        System.out.println("超时时间输入错误：" + args[1]);
      }
    }

    Thread thread = new Thread() {
      @Override
      public void run() {
        try {
          Class clz = Class.forName(mainClass);

          Method method = clz.getMethod("main", String[].class);
          method.invoke(null, (Object) new String[]{});

        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    };
    thread.start();

    try {
      Thread.sleep(maxTime);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.exit(0);
  }

}
