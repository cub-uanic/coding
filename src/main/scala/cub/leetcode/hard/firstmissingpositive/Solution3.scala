package cub.leetcode.hard.firstmissingpositive

class Solution3 extends Solution {
  def firstMissingPositive(nums: Array[Int]): Int = {
    def orderer(nums: Array[Int], index: Int = 0): Array[Int] = {
      if (index == nums.length) {
        nums
      } else {
        val num = nums(index)

        if (num > 0 && num <= nums.length && num != index + 1 && num != nums(num - 1)) {
          val swap = nums(num - 1)
          nums(num - 1) = nums(index)
          nums(index) = swap
          orderer(nums, index)
        } else {
          orderer(nums, index + 1)
        }
      }
    }

    val sortedNums = orderer(nums)
    val candidates = sortedNums
      .zipWithIndex
      .filter { case (num, idx) => num != idx + 1 }
      .toList

    (if (candidates.nonEmpty) {candidates.map(_._2).head} else {nums.length}) + 1
  }
}
