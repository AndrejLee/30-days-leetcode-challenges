https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3301/

class Solution {
    // Try to use back tracking
//     private class Node {
//         public int index;
//         public char character;
        
//         public Node(int index, char character) {
//             this.index = index;
//             this.character = character;
//         }
//     }
    
//    public boolean checkValidString(String s) {
//         char[] array = s.toCharArray();
//         int n = s.length();
//         Stack<Pair<Node, Integer>> stack = new Stack<Pair<Node, Integer>>();
        
//         int count = 0;
//         int index = 0;
        
//         while (true) {
//             if (index == n) {
//                 if (count == 0)
//                     return true;
                
//                 if (!stack.empty()) {
//                     Pair<Node, Integer> item = stack.pop();
//                     char c = item.getKey().character;
//                     if (c == ')') {
//                         count = item.getValue() - 1;
//                     } else {
//                         count = item.getValue();
//                     }
//                     index = item.getKey().index + 1;
//                     continue;
//                 } else {
//                     System.out.println(new String(array));
//                     break;
//                 }
//             }
            
//             if (array[index] == '*') {
//                 stack.push(new Pair<>(new Node(index, ' '), count));
//                 stack.push(new Pair<>(new Node(index, ')'), count));
//                 ++index;
//                 ++count;
//             } else {
//                 if (array[index] == '(') {
//                     ++count;
//                     ++index;
//                 } else {
//                     if (count > 0) {
//                         --count;
//                         ++index;
//                     } else {
//                         if (!stack.empty()) {
//                             Pair<Node, Integer> item = stack.pop();
//                             char c = item.getKey().character;
//                             if (c == ')') {
//                                 count = item.getValue() - 1;
//                             } else {
//                                 count = item.getValue();
//                             }
//                             index = item.getKey().index + 1;
//                         } else {
//                             return false;
//                         }
//                     }
//                 }
//             }
//         }
        
//         return count == 0;
//     }
    

// GREEDY ALGORITHM
    
// Intuition

// When checking whether the string is valid, we only cared about the "balance": the number of extra, open left brackets as we parsed through the string. For example, when checking whether '(()())' is valid, we had a balance of 1, 2, 1, 2, 1, 0 as we parse through the string: '(' has 1 left bracket, '((' has 2, '(()' has 1, and so on. This means that after parsing the first i symbols, (which may include asterisks,) we only need to keep track of what the balance could be.

// For example, if we have string '(***)', then as we parse each symbol, the set of possible values for the balance is [1] for '('; [0, 1, 2] for '(*'; [0, 1, 2, 3] for '(**'; [0, 1, 2, 3, 4] for '(***', and [0, 1, 2, 3] for '(***)'.

// Furthermore, we can prove these states always form a contiguous interval. Thus, we only need to know the left and right bounds of this interval. That is, we would keep those intermediate states described above as [lo, hi] = [1, 1], [0, 2], [0, 3], [0, 4], [0, 3].

// Algorithm

// Let lo, hi respectively be the smallest and largest possible number of open left brackets after processing the current character in the string.

// If we encounter a left bracket (c == '('), then lo++, otherwise we could write a right bracket, so lo--. If we encounter what can be a left bracket (c != ')'), then hi++, otherwise we must write a right bracket, so hi--. If hi < 0, then the current prefix can't be made valid no matter what our choices are. Also, we can never have less than 0 open left brackets. At the end, we should check that we can have exactly 0 open left brackets.
    
    
    public boolean checkValidString(String s) {
        int lo = 0;
        int hi = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            lo += c == '(' ? 1 : -1;
            hi += c != ')' ? 1 : -1;
            if (hi < 0)
                break;
            lo = Math.max(lo, 0);
        }
        
        return lo == 0;
    }
}
