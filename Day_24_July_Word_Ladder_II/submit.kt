/**
 * Link: https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/611/week-4-july-22nd-july-28th/3825/
 * Word Ladder II
 * Ref: https://leetcode.com/discuss/explore/july-leetcoding-challenge-2021/1358803/Word-Ladder-II-oror-With-Approach-oror-Using-BFS
 */

class Solution {
    fun findLadders(beginWord: String, endWord: String, wordList: List<String>): List<List<String>> {
        val queue = LinkedList<Pair<String, List<String>>>()
        queue.push(Pair(beginWord, mutableListOf(beginWord)))
        val ans = mutableListOf<List<String>>()
        val map = HashMap<String, Int>()
        map[beginWord] = 0
        for (word in wordList) {
            map[word] = Int.MAX_VALUE
        }
        while (queue.isNotEmpty()) {
            val pair = queue.poll()
            val kwd = pair.first
            val list = pair.second

            if (kwd == endWord) {
                if (ans.isNotEmpty() && list.size < ans[0].size) ans.clear()
                ans.addAll(listOf(list))
                continue
            }

            for (index in kwd.indices) {
                val charArray = kwd.toCharArray()
                for (char in 'a'..'z') {
                    charArray[index] = char
                    val t = String(charArray)
                    if (t == kwd) continue
                    if (!map.contains(t)) continue
                    if (list.size > map[t]!!) continue
                    map[t] = list.size
                    val newList = mutableListOf<String>()
                    newList.addAll(list)
                    newList.add(t)
                    queue.push(Pair(t, newList))
                }
            }
        }
        return ans
    }
}