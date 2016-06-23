package se.bettercode.projecteuler;

import java.util.stream.IntStream;

/**
 * Created by max on 2016-06-23.
 *
 * Multiples of 3 and 5
 * Problem 1
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
 * The sum of these multiples is 23.
 *
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class Problem1Multiples {

  public static int sumOfMultiplesOf3or5below10() {
    return sumOfMultiplesOf3or5BelowLimit(10);
  }

  public static int sumOfMultiplesOf3or5below1000() {
    return sumOfMultiplesOf3or5BelowLimit(1000);
  }

  private static int sumOfMultiplesOf3or5BelowLimit(int limit) {
    return IntStream.range(1, limit)
        .filter(number -> isMultipleOfEither(number, 3, 5))
        .sum();
  }

  private static boolean isMultipleOfEither(int checked, int a, int b) {
    return checked % a == 0 || checked % b == 0;
  }

}
