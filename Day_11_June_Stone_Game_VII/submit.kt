import kotlin.math.max

/**
 *   Link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/604/week-2-june-8th-june-14th/3775/
 *   Stone Game VII
 *   Solution ideas: https://leetcode.com/problems/stone-game-vii/discuss/970281/C%2B%2BJavaPython-2-approaches-Clean-and-Concise
 */

class Solution {
    fun stoneGameVII(stones: IntArray): Int {
        var sum = 0
        for (stone in stones) {
            sum += stone
        }
        val dp = Array(stones.size) { Array(stones.size) { 0 } }

        return play(0, stones.size - 1, stones, sum, dp)
    }

    fun play(left: Int, right: Int, stones: IntArray, sum: Int, dp: Array<Array<Int>>): Int {
        if (right == left)
            return 0

        if (left + 1 == right)
            return max(stones[left], stones[right])

        if (dp[left][right] != 0)
            return dp[left][right]

        dp[left][right] = max(sum - stones[left] - play(left + 1, right, stones, sum - stones[left], dp),
            sum - stones[right] - play(left, right - 1, stones, sum - stones[right], dp))

        return dp[left][right]
    }
}