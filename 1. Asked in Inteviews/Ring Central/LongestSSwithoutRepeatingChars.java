/** Given a string s, find the length of the longest 
substring
 without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring. */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int l = 0, r = 0;
        int n = s.length();
        int maxi = 0;
        while (r < n) {
            char currentChar = s.charAt(r);
        
            if (hm.containsKey(currentChar)) {
                l = Math.max(hm.get(currentChar) + 1, l);
            }
            
            hm.put(currentChar, r);
            
            maxi = Math.max(maxi, r - l + 1);
            
            r++;
        }

        return maxi;

    }
}