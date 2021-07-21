/**
 * Link: https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/610/week-3-july-15th-july-21st/3821/
 * Push Dominoes
 */

class Solution {
    fun pushDominoes(dominoes: String): String {
        val left = dominoes.toCharArray()
        val right = dominoes.toCharArray()
        var result = dominoes.toCharArray()
        var change = false
        for (index in right.indices) {
            if (right[index] == 'R') change = true
            if (right[index] == 'L') change = false
            if (right[index] == '.' && change) right[index] = 'R'
        }
        change = false
        for (index in left.indices.reversed()) {
            if (left[index] == 'L') change = true
            if (left[index] == 'R') change = false
            if (left[index] == '.' && change) left[index] = 'L'
        }
        var count = -1
        for (index in dominoes.indices) {
            when {
                dominoes[index] == 'L' -> {
                    result[index] = 'L'
                    if (count >= 0) {
                        var start = index - count
                        var end = index - 1
                        while (start < end) {
                            result[start] = 'R'
                            result[end] = 'L'
                            start++
                            end--
                        }
                    }
                    count = -1
                }
                dominoes[index] == 'R' -> {
                    result[index] = 'R'
                    count = 0
                }
                else -> {
                    if (left[index] == right[index]) result[index] = left[index]
                    else {
                        when {
                            left[index] == '.' -> result[index] = right[index]
                            right[index] == '.' -> result[index] = left[index]
                            else -> {
                                result[index] = '.'
                                count++
                            }
                        }
                    }
                }
            }
        }
        return result.joinToString("")
    }
}