https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/529/week-2/3299/

class Solution {
    public String stringShift(String s, int[][] shift) {
        int[] command = new int[2];
        command[0] = command[1] = 0;
        getCommand(command, shift);
        return rotateString(s, command);
    }
    
    private void getCommand(int[] command, int[][] shift) {
        for (int i = 0; i < shift.length; ++i) {
            if (shift[i].length == 2) {
                command[1] += (shift[i][0] * 2 - 1) * shift[i][1]; 
            }
        }
        
        command[0] = command[1] > 0 ? 1 : 0;
        command[1] = Math.abs(command[1]);
    }
    
    private String rotateString(String s, int[] command) {
        StringBuilder result = new StringBuilder();
        
        int shift = command[1] % s.length();
        
        if (command[0] == 0) {
            result.append(s.substring(shift, s.length()));
            result.append(s.substring(0, shift));
        } else {
            result.append(s.substring(s.length() - shift, s.length()));
            result.append(s.substring(0, s.length() - shift));
        }
        
        return result.toString();
    }
}
