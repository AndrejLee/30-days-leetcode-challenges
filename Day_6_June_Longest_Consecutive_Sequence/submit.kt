import kotlin.math.max

/**
 * Link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/603/week-1-june-1st-june-7th/3769/
 * Longest Consecutive Sequence
 */

class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        var result = 0
        val set = HashSet<Int>(nums.asList())
        val seen = HashSet<Int>()
        val map = HashMap<Int, Int>()

        for (num in set) {
            if (seen.contains(num)) continue

            var pointer = num
            while (set.contains(pointer)) {
                val jump = map[pointer]
                if (jump != null) {
                    pointer += jump
                    break
                }
                seen.add(pointer)
                pointer++
            }

            map[num] = pointer - num

            result = max(result, pointer - num)
        }

        return result
    }
}