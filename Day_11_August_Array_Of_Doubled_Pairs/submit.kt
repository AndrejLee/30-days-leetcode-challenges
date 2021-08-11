/**
 * Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/614/week-2-august-8th-august-14th/3877/
 * Array of Doubled Pairs
 */

class Solution {
    fun canReorderDoubled(arr: IntArray): Boolean {
        arr.sort()
        val map = HashMap<Double, Int>()
        for (value in arr) {
            var count = map[value * 1.0]
            if (count == null)
                count = 0
            map[value * 1.0] = count + 1
        }
        for (x in arr) {
            val xAsDouble = x * 1.0
            if (!map.contains(xAsDouble)) continue
            val x2 = if (xAsDouble >= 0) 2 * xAsDouble else xAsDouble / 2.0
            if (!map.contains(x2)) return false
            map[x2] = map[x2]!! - 1
            if (map[x2]!! == 0) map.remove(x2)
            if (!map.contains(xAsDouble)) return false
            map[xAsDouble] = map[xAsDouble]!! - 1
            if (map[xAsDouble]!! == 0) map.remove(xAsDouble)
        }

        return true
    }
}