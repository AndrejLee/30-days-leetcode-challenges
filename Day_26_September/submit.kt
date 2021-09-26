import kotlin.math.min

/**
 * Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/639/week-4-september-22nd-september-28th/3988/
 * Ref: https://leetcode.com/discuss/explore/september-leetcoding-challenge-2021/1486892/Transform-to-Chessboard-oror-C%2B%2BJavaPython
 * Transform to chessboard
 */

class Solution {
    fun movesToChessboard(board: Array<IntArray>): Int {
        val n = board.size
        var rowSum = 0
        var colSum = 0
        var rowSwap = 0
        var colSwap = 0
        for (i in board.indices) {
            for (j in board.indices) {
                if (board[0][0] xor board[0][j] xor board[i][0] xor board[i][j] == 1)
                    return -1
            }
        }
        for (i in board.indices) {
            rowSum += board[0][i]
            colSum += board[i][0]
            if (board[i][0] == i.rem(2)) rowSwap++
            if (board[0][i] == i.rem(2)) colSwap++
        }
        if (rowSum != n / 2 && rowSum != (n + 1) / 2) return -1
        if (colSum != n / 2 && colSum != (n + 1) / 2) return -1
        if (n.rem(2) == 1) {
            if (colSwap.rem(2) == 1) colSwap = n - colSwap
            if (rowSwap.rem(2) == 1) rowSwap = n - rowSwap
        } else {
            colSwap = min(n - colSwap, colSwap)
            rowSwap = min(n - rowSwap, rowSwap)
        }
        return (colSwap + rowSwap) / 2
    }
}