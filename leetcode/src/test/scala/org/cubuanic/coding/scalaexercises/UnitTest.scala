package org.cubuanic.coding.scalaexercises

import org.scalatest._
import org.scalatest.flatspec._
import org.scalatest.matchers._

abstract class UnitTest extends AnyFlatSpec
  with should.Matchers
  with OptionValues
  with Inside
  with Inspectors

//class UnitTest {
//
//}
