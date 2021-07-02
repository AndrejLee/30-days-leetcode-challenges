import kotlin.math.abs
/**
 * Link: https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/608/week-1-july-1st-july-7th/3800/
 * Find K Closest Elements
 */

class Solution {
    fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
        if (x < arr[0]) {
            return arr.toList().subList(0, k)
        }
        if (x > arr[arr.size - 1]) {
            return arr.toList().subList(arr.size - k, arr.size)
        }
        var R = lowerBound(arr, 0, arr.size, x)
        var L = R - 1
        var count = k
        while (count-- > 0) {
            if (R == arr.size || (L >= 0 && abs(arr[L] - x) <= abs(arr[R] - x)))
                L--
            else
                R++
        }
        return arr.toList().subList(L + 1, R)
    }

    fun lowerBound(a: IntArray, left: Int, right: Int, x: Int): Int {
        var pos = right
        var tempRight = right
        var tempLeft = left
        while (tempLeft < tempRight) {
            val mid = tempLeft + (tempRight - tempLeft) / 2
            if (a[mid] >= x) {
                pos = mid
                tempRight = mid
            } else {
                tempLeft = mid + 1
            }
        }
        return pos
    }
}