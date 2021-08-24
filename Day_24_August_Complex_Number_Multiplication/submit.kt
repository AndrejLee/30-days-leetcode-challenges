/**
 * Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/616/week-4-august-22nd-august-28th/3917/
 * Complex Number Multiplication
 */

class Solution {
    fun complexNumberMultiply(num1: String, num2: String): String {
        val nums1 = num1.replace("+",",").replace("i",",").split(",")
        val nums2 = num2.replace("+",",").replace("i",",").split(",")
        val real = nums1[0].toInt() * nums2[0].toInt() - nums1[1].toInt() * nums2[1].toInt()
        val imaginary = nums1[1].toInt() * nums2[0].toInt() + nums1[0].toInt() * nums2[1].toInt()
        return real.toString() + "+" + imaginary.toString() + "i"
    }
}