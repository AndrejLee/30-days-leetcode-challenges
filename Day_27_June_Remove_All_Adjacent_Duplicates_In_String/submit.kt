/**
 * Link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/606/week-4-june-22nd-june-28th/3794/
 * Remove All Adjacent Duplicates In String
 */

class Solution {
    fun removeDuplicates(s: String): String {
        val stack = Stack<Char>()

        for (char in s) {
            if (stack.isNotEmpty() && stack.peek() == char) {
                stack.pop()
            } else {
                stack.push(char)
            }
        }

        var result = ""
        while (stack.isNotEmpty()) {
            result += stack.pop()
        }

        return result.reversed()
    }
}