package org.cubuanic.coding.scalaexercises.fp_in_scala;

import org.cubuanic.coding.scalaexercises.UnitTest
import org.cubuanic.coding.scalaexercises.fp_in_scala.Exercise_2_2.isSorted

class Exercise_2_2Test extends UnitTest {
  "isSorted" should "give proper results" in {
    isSorted(Array(1, 3, 5, 7), (x: Int, y: Int) => x < y) shouldBe true

    isSorted(Array(7, 5, 1, 3), (x: Int, y: Int) => x > y) shouldBe false

    isSorted(Array("Scala", "Exercises"), (x: String, y: String) => x.length < y.length) shouldBe true
  }
}
