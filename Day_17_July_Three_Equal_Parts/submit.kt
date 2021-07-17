/**
 * Link: https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/610/week-3-july-15th-july-21st/3817/
 * Three Equal Parts
 * Ref: https://leetcode.com/discuss/explore/july-leetcoding-challenge-2021/1343092/Three-Equal-Parts-oror-C%2B%2B-Easy-Solution-oror-With-Approach
 */

class Solution {
    fun threeEqualParts(arr: IntArray): IntArray {
        val onesArr = mutableListOf<Int>()
        for ((index, num) in arr.withIndex()) {
            if (num == 1) onesArr.add(index)
        }
        if (onesArr.size == 0) return intArrayOf(0, arr.size - 1)
        if (onesArr.size.rem(3) != 0) return intArrayOf(-1,-1)
        var a = onesArr[0]
        var b = onesArr[onesArr.size / 3]
        var c = onesArr[onesArr.size * 2 / 3]
        while (c < arr.size && arr[a] == arr[b] && arr[a] == arr[c]) {
            a++
            b++
            c++
        }

        return if (c == arr.size) intArrayOf(a - 1, b) else intArrayOf(-1, -1)
    }
}