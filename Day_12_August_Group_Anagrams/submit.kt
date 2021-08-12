/**
 * Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/614/week-2-august-8th-august-14th/3887/
 * Group Anagrams
 */

class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = HashMap<String, ArrayList<String>>()

        for (str in strs) {
            val sortedString = str.toCharArray().sorted().joinToString("")
            var cache = map[sortedString]
            if (cache == null)
                cache = ArrayList()
            cache.add(str)
            map[sortedString] = cache
        }

        val ans = ArrayList<List<String>>()

        for (entry in map.entries) {
            ans.add(entry.value)
        }

        return ans
    }
}