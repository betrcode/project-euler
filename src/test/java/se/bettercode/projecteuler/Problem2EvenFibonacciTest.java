package se.bettercode.projecteuler;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static se.bettercode.projecteuler.Problem2EvenFibonacci.sumOfEvenFibonacciBelowLimit;
import static se.bettercode.projecteuler.TimeLimit.ONE_MINUTE;
import static se.bettercode.projecteuler.TimeLimit.ONE_SECOND;

/**
 * Created by max on 2016-06-23.
 */
public class Problem2EvenFibonacciTest {

  @Test(timeout = ONE_SECOND)
  public void smallValues() {
    assertEquals(10, sumOfEvenFibonacciBelowLimit(10));
    assertEquals(44, sumOfEvenFibonacciBelowLimit(100));
  }

  @Test(timeout = ONE_MINUTE)
  public void theAnswer() {
    assertEquals(4613732, sumOfEvenFibonacciBelowLimit(4000000));
  }
}
