package io.vividcode.java11to17.ffm;

import java.util.Arrays;

public class CallFunctionsMain {

  public static void main(String[] args) throws Throwable {
    System.out.println(new CallSqrt().sqrt(2));
    System.out.println(new CallStrlen().strlen("hello"));
    int[] input = new int[] {3, 2, 1, 8, 100};
    int[] result = new CallQsort().qsort(input);
    System.out.println(Arrays.toString(result));
  }
}
