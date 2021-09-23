/**
 * Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/639/week-4-september-22nd-september-28th/3985/
 * Break a Palindrome
 */

class Solution {
    fun breakPalindrome(palindrome: String): String {
        if (palindrome.length <= 1)
            return ""

        var nonACount = 0
        var firstNonAIndex = 0

        for ((index, char) in palindrome.withIndex()) {
            if (char != 'a') {
                nonACount++
                if (nonACount >= 2)
                    break
                firstNonAIndex = index
            }
        }

        val ans = palindrome.toCharArray()

        if (nonACount <= 1) {
            ans[ans.size - 1] = 'b'
        } else {
            ans[firstNonAIndex] = 'a'
        }
        return ans.joinToString("")
    }
}