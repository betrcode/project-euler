package se.bettercode.projecteuler;

import java.util.Optional;
import java.util.OptionalLong;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by max on 2016-06-26.
 * <p>
 * Largest prime factor
 * Problem 3
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * <p>
 * What is the largest prime factor of the number 600851475143 ?
 */
public class Problem3LargestPrimeFactor {


  static class TrialDivision {

    public static Stream<Long> getPrimeFactors(Long test) {
      return getFactorsStream(test)
          .filter(candidate -> isPrimeNumber(candidate));
    }

    public static Optional<Long> getLargestPrimeFactor(Long test) {
      return getFactorsStream(test)
          .filter(candidate -> isPrimeNumber(candidate))
          .findFirst();
    }

    public static Set<Long> getFactors(Long test) {
      return getFactorsStream(test)
          .collect(Collectors.toSet());
    }

    /**
     * Stream is ordered by the largest factors first. This knowledge can be used for optimizations.
     */
    public static Stream<Long> getFactorsStream(Long test) {
      final Long startInclusive = 2L;
      //TODO: Can the range be limited more?
      final Long rangeLimit = test / 2;
      return LongStream.rangeClosed(startInclusive, rangeLimit)
          .parallel()
          //reverse the Stream!
          .map(number -> rangeLimit - number + startInclusive)
          .filter(divisor -> isEvenlyDivisibleBy(test, divisor))
          .boxed();
    }

  }

  static boolean isPrimeNumber(Long test) {
    OptionalLong any = LongStream.rangeClosed(2, test - 1)
        .filter(divisor -> isEvenlyDivisibleBy(test, divisor))
        .findFirst();

    return !any.isPresent();
  }

  static boolean isEvenlyDivisibleBy(Long test, Long divisor) {
    return test % divisor == 0;
  }

}
