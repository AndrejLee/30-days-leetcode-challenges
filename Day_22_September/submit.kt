import kotlin.math.max

/**
 * Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/639/week-4-september-22nd-september-28th/3984/
 * Ref: https://leetcode.com/discuss/explore/september-leetcoding-challenge-2021/1478545/Maximum-Length-of-a-Concatenated-String-with-Unique-Characters-or-Java
 * Maximum Length Of A Concatenated String With Unique Characters
 */

class Solution {
    fun maxLength(arr: List<String>): Int {
        return doCheck(arr, 0, Array(26) {0})
    }

    fun doCheck(arr: List<String>, index: Int, hash: Array<Int>): Int {
        if (index == arr.size)
            return 0

        val exclude = doCheck(arr, index + 1, hash)

        val currentWord = arr[index]

        var isDup = false

        for (char in currentWord) {
            if (hash[char - 'a'] != 0) {
                isDup = true
            }
            hash[char - 'a']++
        }

        var include = 0
        if (!isDup) {
            include = doCheck(arr, index + 1, hash) + currentWord.length
        }

        for (char in currentWord) {
            hash[char - 'a']--
        }

        return max(include, exclude)
    }
}