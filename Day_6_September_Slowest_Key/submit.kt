/**
 * Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/636/week-1-september-1st-september-7th/3965/
 * Slowest Key
 */

class Solution {
    fun slowestKey(releaseTimes: IntArray, keysPressed: String): Char {
        var ans: Char = ' '
        var max = 0
        for (index in releaseTimes.indices) {
            val duration = if (index == 0) releaseTimes[index] else releaseTimes[index] - releaseTimes[index - 1]
            if (duration > max || (duration == max && keysPressed[index] > ans)) {
                max = duration
                ans = keysPressed[index]
            }
        }
        return ans
    }
}