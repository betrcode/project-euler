package se.bettercode.projecteuler;

import java.util.List;
import java.util.OptionalLong;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by max on 2016-06-26.
 *
 * Largest prime factor
 * Problem 3
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143 ?
 */
public class Problem3LargestPrimeFactor {


  static class TrialDivision {

    public static Stream<Long> getPrimeFactors(Long test) {
      return getFactorsStream(test)
          .filter(candidate -> isPrimeNumber(candidate));
    }

    public static List<Long> getFactors(Long test) {
      return getFactorsStream(test)
          .collect(Collectors.toList());
    }

    public static Stream<Long> getFactorsStream(Long test) {
      //TODO: Can the range be limited more?
      final Long rangeLimit = test;
      return LongStream.rangeClosed(2, rangeLimit)
          .filter(divisor -> isEvenlyDivisibleBy(test, divisor))
          .boxed();
    }

  }

  static boolean isPrimeNumber(Long test) {
    OptionalLong any = LongStream.rangeClosed(2, test-1)
        .filter(divisor -> isEvenlyDivisibleBy(test, divisor))
        .findAny();

    return !any.isPresent();
  }

  static boolean isEvenlyDivisibleBy(Long test, Long divisor) {
    return test % divisor == 0;
  }

}
