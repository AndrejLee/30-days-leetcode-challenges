import kotlin.math.min

/**
 * Link: https://leetcode.com/problems/dungeon-game/
 * Ref: https://www.youtube.com/watch?v=htyKDF_0wz8&t=852s
 * Dungeon Game
 */

class Solution {
    fun calculateMinimumHP(dungeon: Array<IntArray>): Int {
        val hasCache = Array(dungeon.size) {
            Array(dungeon[0].size) {
                false
            }
        }
        val cache = Array(dungeon.size) {
            Array(dungeon[0].size) {
                0
            }
        }
        return getMin(hasCache, cache, dungeon, 0, 0)
    }

    fun getMin(hasCache: Array<Array<Boolean>>, cache: Array<Array<Int>>, dungeon: Array<IntArray>, x: Int, y: Int): Int {
        if (x == dungeon.size - 1 && y == dungeon[0].size - 1) {
            if (dungeon[x][y] >= 0)
                return 1
            else
                return 1 - dungeon[x][y]
        }

        if (hasCache[x][y])
            return cache[x][y]

        var best = Int.MAX_VALUE

        // going right
        if (y + 1 < dungeon[0].size) {
            val minRight = getMin(hasCache, cache, dungeon, x, y + 1)
            if (dungeon[x][y] >= minRight) {
                best = min(best, 1)
            } else {
                best = min(best, minRight - dungeon[x][y])
            }
        }


        // going down
        if (x + 1 < dungeon.size) {
            val minDown = getMin(hasCache, cache, dungeon, x + 1, y)
            if (dungeon[x][y] >= minDown) {
                best = min(best, 1)
            } else {
                best = min(best, minDown - dungeon[x][y])
            }
        }

        hasCache[x][y] = true
        cache[x][y] = best

        return best
    }
}