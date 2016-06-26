package se.bettercode.projecteuler;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static se.bettercode.projecteuler.Problem3LargestPrimeFactor.isPrimeNumber;

/**
 * Created by max on 2016-06-26.
 */
public class Problem3LargestPrimeFactorTest {

  @Test
  public void canFindFactors() {
    List<Long> expected = Arrays.asList(2L, 3L, 6L, 7L, 14L, 21L, 42L);
    List<Long> result = Problem3LargestPrimeFactor.TrialDivision.getFactors(42L);
    assertEquals(expected, result);
  }

  @Test
  public void isPrime() {
    assertEquals(true, isPrimeNumber(2L));
    assertEquals(true, isPrimeNumber(3L));
    assertEquals(false, isPrimeNumber(4L));
    assertEquals(true, isPrimeNumber(5L));
    assertEquals(false, isPrimeNumber(6L));
    assertEquals(true, isPrimeNumber(7L));
    assertEquals(false, isPrimeNumber(8L));
    assertEquals(false, isPrimeNumber(9L));
    assertEquals(false, isPrimeNumber(10L));
    assertEquals(true, isPrimeNumber(11L));
  }

  @Test(timeout = 1000)
  public void canFindPrimeFactors() {
    List<Long> expected = Arrays.asList(2L, 3L, 7L);
    List<Long> result = Problem3LargestPrimeFactor.TrialDivision.getPrimeFactors(42L).collect(Collectors.toList());
    assertEquals(expected, result);
  }

  @Test(timeout = 10000)
  public void findLargestPrimeFactor() {
    Long expected = 7L;
    Optional<Long> result = Problem3LargestPrimeFactor.TrialDivision.getPrimeFactors(42L)
        .max((x, y) -> Long.compare(x, y));
    assertEquals(expected, result.get());
  }

  @Test(timeout = 60000)
  public void findLargestPrimeFactorOfLargeNumber() {
    Long expected = 123123L; //TODO: Not correct
    Optional<Long> result = Problem3LargestPrimeFactor.TrialDivision.getPrimeFactors(600851475143L)
        .max((x, y) -> Long.compare(x, y));
    assertEquals(expected, result.get());
  }
}
