/**
 * Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/616/week-4-august-22nd-august-28th/3920/
 * Verify Preorder Serialization
 */

class Solution {
    var index = 0

    fun isValidSerialization(preorder: String): Boolean {
        val preorders = preorder.split(",")
        return doTraverse(preorders) && index == preorders.size
    }

    fun doTraverse(preorders: List<String>): Boolean {
        if (index >= preorders.size) return false
        val currentChar = preorders[index++]

        if (currentChar == "#") {
            return true
        }

        val resLeft = doTraverse(preorders)
        val resRight = doTraverse(preorders)

        return resLeft && resRight
    }
}