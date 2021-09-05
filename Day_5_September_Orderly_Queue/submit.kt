/**
 * Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/636/week-1-september-1st-september-7th/3964/
 * Ref: https://leetcode.com/discuss/explore/september-leetcoding-challenge-2021/1445967/Orderly-Queue-oror-Explanation-with-Examlpe
 * Orderly Queue
 */

class Solution {
    fun orderlyQueue(s: String, k: Int): String {
        return if (k > 1) {
            s.toCharArray().sorted().joinToString("")
        } else {
            var ans = s

            val ss = s + s
            for (index in s.indices) {
                val temp = ss.substring(index, index + s.length)
                if (temp < ans)
                    ans = temp
            }

            ans
        }
    }
}