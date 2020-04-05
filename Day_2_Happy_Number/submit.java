https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3284/

class Solution {
    // Good solutions: 
    // Math base: https://leetcode.com/problems/happy-number/discuss/560228/My-solution-with-magic-math-property
    // Brute force cases: https://leetcode.com/problems/happy-number/discuss/560171/C%2B%2B-100-easy-solution
    
    // Normal solution with extra mem
//     public boolean isHappy(int n) {
//         if (n == 1)
//             return true;
        
//         int temp = 0;
//         Set<Integer> container = new HashSet<Integer>();
        
//         while (n != 1) {
            
//             while (n > 0) {
//                 int a = n % 10;
//                 temp += a * a;
//                 n /= 10;
//             }
            
//             n = temp;
//             temp = 0;
            
//             if (container.contains(n)) {
//                 return false;
//             } else {
//                 container.add(n);
//             }
//         }
        
//         return true;
//     }
    
    // Using Floyd's tortoise and hare
    // We can use this algorithm because loop while progressing occurs
    public boolean isHappy(int n) {
        int tortoise = n;
        int hare = n;
        
        // If happy number sum is found, loop will occurs at 1
        do {
            tortoise = squareSum(tortoise);
            hare = squareSum(squareSum(hare));
        } while (tortoise != hare);
        
        return tortoise == 1;
    }
    
    private int squareSum(int n) {
        int result = 0;
        while (n != 0) {
            result += (n % 10) * (n % 10);
            n /= 10;
        }
        return result;
    }
}
