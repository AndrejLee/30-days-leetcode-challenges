/**
 * Link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/603/week-1-june-1st-june-7th/3766/
 * Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts
 */

import kotlin.math.max

class Solution {
    fun maxArea(h: Int, w: Int, horizontalCuts: IntArray, verticalCuts: IntArray): Int {
        Arrays.sort(horizontalCuts)
        Arrays.sort(verticalCuts)
        var maxHorizontalDistance = horizontalCuts.first()
        for (index in 1 until horizontalCuts.size) {
            maxHorizontalDistance = max(maxHorizontalDistance, horizontalCuts[index] - horizontalCuts[index - 1])
        }
        maxHorizontalDistance = max(maxHorizontalDistance, h - horizontalCuts.last())

        var maxVerticalDistance = verticalCuts.first()
        for (index in 1 until verticalCuts.size) {
            maxVerticalDistance = max(maxVerticalDistance, verticalCuts[index] - verticalCuts[index - 1])
        }
        maxVerticalDistance = max(maxVerticalDistance, w - verticalCuts.last())

        return (maxHorizontalDistance.toULong() * maxVerticalDistance.toULong()).rem(1000000007UL).toInt()
    }
}