https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3306/

/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int x, int y) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    // USING BINARY SEARCH SOLUTION
//     public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
//         int result = Integer.MAX_VALUE;
//         List<Integer> size = binaryMatrix.dimensions();
//         int n = size.get(0);
//         int m = size.get(1);
//         if (n != 0) {
//             for (int i = 0; i < n; i++) {
//                 result = Math.min(result, findLeftMost1(i, m, binaryMatrix));
//             }
//         }
        
//         return result == Integer.MAX_VALUE ? -1 : result;
//     }
    
//     private int findLeftMost1(int row, int rowSize, BinaryMatrix binaryMatrix) {
//         int res = Integer.MAX_VALUE;
//         int lo = 0;
//         int hi = rowSize - 1;
//         int mid;
        
//         while (hi >= lo) {
//             mid = (hi + lo) / 2;
            
//             if (binaryMatrix.get(row, mid) == 1) {
//                 res = Math.min(res, mid);
//                 hi = mid - 1;
//             } else {
//                 lo = mid + 1;
//             }
//         }
        
//         return res;
//     }
    
    // USING TOP RIGHT MOVING POINTER SOLUTION
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int result = -1;
        List<Integer> size = binaryMatrix.dimensions();
        int n = size.get(0);
        int m = size.get(1);
        int currentRow = 0;
        int currentCol = m - 1;
        
        while (currentRow < n) {
            while (currentCol >= 0 && binaryMatrix.get(currentRow, currentCol) == 1) {
                result = currentCol;
                currentCol--;
            }
            currentRow++;
        }
        
        return result;
    }
}
