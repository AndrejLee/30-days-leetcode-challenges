/**
 * Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/615/week-3-august-15th-august-21st/3891/
 * Minimum Window Substring
 * Ref: https://leetcode.com/discuss/explore/august-leetcoding-challenge-2021/1404507/Minimum-Window-Substring-oror-Using-Map-w-Explanation-oror-C%2B%2B-or-Python-or-Java
 */

class Solution {
    fun minWindow(s: String, t: String): String {
        val map = HashMap<Char, Int>()
        for (char in t) {
            var count = map[char]
            if (count == null) count = 0
            map[char] = count + 1
        }

        var count = 0
        var left = 0
        var len = Int.MAX_VALUE
        var ans = ""

        for (right in s.indices) {
            if (map.contains(s[right])) {
                map[s[right]] = map[s[right]]!! - 1
                if (map[s[right]]!! >= 0) {
                    count++
                }

                while (count == t.length) {
                    if (right - left + 1 < len) {
                        len = right - left + 1
                        ans = s.substring(left, right + 1)
                    }
                    if (map.contains(s[left])) {
                        map[s[left]] = map[s[left]]!! + 1
                        if (map[s[left]]!! > 0) {
                            count--
                        }
                    }
                    left++
                }
            }
        }

        return if (left > s.length) "" else ans
    }

}