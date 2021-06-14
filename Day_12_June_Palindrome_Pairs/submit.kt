/**
 * Link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/604/week-2-june-8th-june-14th/3777/
 * Palindrome Pairs
 */

class Solution {
    fun palindromePairs(words: Array<String>): List<List<Int>> {
        val map = HashMap<String, Int>()
        val ans = mutableListOf<List<Int>>()
        for ((index, word) in words.withIndex()) {
            map[word] = index
        }

        for (word in words) {
            // Case 1: current word is empty check all self-palindrome words
            if (word.isEmpty()) {
                for (reCheckWord in words) {
                    if (reCheckWord.isEmpty()) continue
                    if (isPalindrome(reCheckWord, 0, reCheckWord.length - 1)) {
                        ans.add(listOf(map[word]!!, map[reCheckWord]!!))
                        ans.add(listOf(map[reCheckWord]!!, map[word]!!))
                    }
                }
                continue
            }

            // Case 2: reversed word of current word makes a palindrome
            val reversedWord = word.reversed()
            if (word != reversedWord && map.containsKey(reversedWord)) {
                ans.add(listOf(map[word]!!, map[reversedWord]!!))
            }

            // Case 3: reversed partial of current word makes a palindrome
            for (index in 1 until word.length) {
                if (isPalindrome(word, 0, index - 1)) {
                    val partialReversedWord = word.substring(index).reversed()
                    if (map.containsKey(partialReversedWord)) ans.add(listOf(map[partialReversedWord]!!, map[word]!!))
                }
                if (isPalindrome(word, index, word.length - 1)) {
                    val partialReversedWord = word.substring(0, index).reversed()
                    if (map.containsKey(partialReversedWord)) ans.add(listOf(map[word]!!, map[partialReversedWord]!!))
                }
            }
        }

        return ans
    }

    fun isPalindrome(word: String, left: Int, right: Int): Boolean {
        var start = left
        var end = right
        while (start < end) {
            if (word[start++] != word[end--]) return false
        }
        return true
    }
}