/**
 * Link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/605/week-3-june-15th-june-21st/3780/
 * Matchsticks to Square
 */

class Solution {
    fun makesquare(matchsticks: IntArray): Boolean {
        var total = 0
        for (stick in matchsticks) {
            total += stick
        }
        if (total.rem( 4) != 0)
            return false

        val limitLength = total / 4
        for (stick in matchsticks)
            if (stick > limitLength)
                return false

        return putSide(matchsticks, 1, limitLength, matchsticks[0], 0, 0, 0)
                || putSide(matchsticks, 1, limitLength, 0, matchsticks[0], 0, 0)
                || putSide(matchsticks, 1, limitLength, 0, 0, matchsticks[0], 0)
                || putSide(matchsticks, 1, limitLength, 0, 0, 0, matchsticks[0])
    }

    fun putSide(matchsticks: IntArray, currentStick: Int, limitLength: Int, side1: Int, side2: Int, side3: Int, side4: Int): Boolean {
        if (currentStick == matchsticks.size) {
            return side1 == side2 && side2 == side3 && side3 == side4
        }

        val newSide1 = side1 + matchsticks[currentStick]
        var res1 = false
        if (newSide1 <= limitLength) {
            res1 = putSide(matchsticks, currentStick + 1, limitLength, newSide1, side2, side3, side4)
        }

        val newSide2 = side2 + matchsticks[currentStick]
        var res2 = false
        if (newSide2 <= limitLength) {
            res2 = putSide(matchsticks, currentStick + 1, limitLength, side1, newSide2, side3, side4)
        }

        val newSide3 = side3 + matchsticks[currentStick]
        var res3 = false
        if (newSide3 <= limitLength) {
            res3 = putSide(matchsticks, currentStick + 1, limitLength, side1, side2, newSide3, side4)
        }

        val newSide4 = side4 + matchsticks[currentStick]
        var res4 = false
        if (newSide4 <= limitLength) {
            res4 = putSide(matchsticks, currentStick + 1, limitLength, side1, side2, side3, newSide4)
        }

        return res1 || res2 || res3 || res4
    }
}