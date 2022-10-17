package cub.scalaexercises.fp_in_scala

object Exercise_2_2 {
  def isSorted[A](as: Array[A], ordering: (A, A) => Boolean): Boolean = {
    @annotation.tailrec
    def go(n: Int): Boolean =
      if (n >= as.length - 1) true
      else if (!ordering(as(n), as(n + 1))) false
      else go(n + 1)

    go(0)
  }
}
