import kotlin.math.min

/**
 * Link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/603/week-1-june-1st-june-7th/3770/
 * Min Cost Climbing Stairs
 */

class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val stairs = mutableListOf<Int>()
        stairs.addAll(cost.toTypedArray())
        stairs.add(0)
        for (i in 2 until stairs.size) {
            stairs[i] += min(stairs[i - 1], stairs[i - 2])
        }
        return stairs.last()
    }
}