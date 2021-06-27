import kotlin.math.max
/**
 * Link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/606/week-4-june-22nd-june-28th/3793/
 * Candy
 * Ref: https://leetcode.com/discuss/explore/june-leetcoding-challenge-2021/1300022/Candy-Distribution-oror-C%2B%2B-oror-99-faster-oror-explained
 */

class Solution {
    fun candy(ratings: IntArray): Int {
        val count = Array(ratings.size) { 1 }
        // traverse from left to right, higher rate will increase 1 candy from neighbor (left element)
        for (index in 1 until count.size) {
            if (ratings[index] > ratings[index - 1])
                count[index] = count[index - 1] + 1
        }

        // traverse from right to left, higher rate will get max of current candy and candy of neighbor + 1 (right element)
        for (index in count.size - 2 downTo 0) {
            if (ratings[index] > ratings[index + 1]) {
                count[index] = max(count[index], count[index + 1] + 1)
            }
        }

        return count.sum()
    }
}