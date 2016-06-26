package se.bettercode.projecteuler;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static se.bettercode.projecteuler.Problem3LargestPrimeFactor.isPrimeNumber;

/**
 * Created by max on 2016-06-26.
 */
public class Problem3LargestPrimeFactorTest {

  private final static Long QUESTION_NUMBER = 600851475143L;

  @Test
  public void canFindFactors() {
    Set<Long> expected = new HashSet<>(Arrays.asList(2L, 3L, 6L, 7L, 14L, 21L));
    Set<Long> result = Problem3LargestPrimeFactor.TrialDivision.getFactors(42L);
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
    Set<Long> expected = new HashSet<>(Arrays.asList(2L, 3L, 7L));
    Set<Long> result = Problem3LargestPrimeFactor.TrialDivision.getPrimeFactors(42L).collect(Collectors.toSet());
    assertEquals(expected, result);
  }

  @Test(timeout = 1000)
  public void findLargestPrimeFactor() {
    Long expected = 7L;
    Optional<Long> result = Problem3LargestPrimeFactor.TrialDivision.getLargestPrimeFactor(42L);
    assertEquals(expected, result.get());
  }

  @Test(timeout = 1000)
  public void findLargestPrimeFactor2() {
    Long expected = 73L;
    Optional<Long> result = Problem3LargestPrimeFactor.TrialDivision.getLargestPrimeFactor(219L);
    assertEquals(expected, result.get());
  }

  //TODO: Too slow
  @Test(timeout = 15000)
  public void findLargestPrimeFactorOfLargeNumber() {
    Long expected = 123123L; //TODO: Not correct
    Optional<Long> result = Problem3LargestPrimeFactor.TrialDivision.getLargestPrimeFactor(QUESTION_NUMBER);
    assertEquals(expected, result.get());
  }
}
