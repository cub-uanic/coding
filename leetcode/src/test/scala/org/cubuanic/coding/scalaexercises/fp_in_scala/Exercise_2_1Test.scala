package org.cubuanic.coding.scalaexercises.fp_in_scala;

import org.cubuanic.coding.scalaexercises.UnitTest
import org.cubuanic.coding.scalaexercises.fp_in_scala.Exercise_2_1.fib

class Exercise_2_1Test extends UnitTest {
  "Fibonacci numbers" should "provide correct results" in {
    fib(5) should be(5)
  }
}
