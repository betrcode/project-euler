import org.junit.Test;
import se.bettercode.projecteuler.Problem1Multiples;

import static org.junit.Assert.assertEquals;

/**
 * Created by max on 2016-06-23.
 */
public class Problem1MultiplesTest {

  @Test
  public void below10() {
    assertEquals(23, Problem1Multiples.sumOfMultiplesOf3or5below10());
  }

  @Test
  public void below1000() {
    assertEquals(233168, Problem1Multiples.sumOfMultiplesOf3or5below1000());
  }

}
