package cub.scalaexercises.fp_in_scala

import cub.scalaexercises.UnitTest
import cub.scalaexercises.fp_in_scala.Exercise_2_1.fib

class Exercise_2_1Test extends UnitTest {
  "Fibonacci numbers" should "provide correct results" in {
    fib(5) should be(5)
  }
}
