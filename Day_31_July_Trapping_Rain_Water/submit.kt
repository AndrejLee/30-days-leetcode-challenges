/**
 * Link: https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/612/week-5-july-29th-july-31st/3833/
 * Trapping Rain Water
 * Ref: https://leetcode.com/discuss/explore/july-leetcoding-challenge-2021/1373887/Trapping-Rainwater-oror-Detailed-Explanation-oror-Java
 */

class Solution {
    fun trap(height: IntArray): Int {
        var total = 0
        if (height.size < 3) return 0
        var leftMax = height[0]
        var rightMax = height[height.size - 1]
        var leftPointer = 1
        var rightPointer = height.size - 1
        while (leftPointer <= rightPointer) {
            if (leftMax <= rightMax) {
                if (leftMax < height[leftPointer]) {
                    leftMax = height[leftPointer]
                } else {
                    total += leftMax - height[leftPointer]
                }
                leftPointer++
            } else {
                if (rightMax < height[rightPointer]) {
                    rightMax = height[rightPointer]
                } else {
                    total += rightMax - height[rightPointer]
                }
                rightPointer--
            }
        }
        return total
    }
}