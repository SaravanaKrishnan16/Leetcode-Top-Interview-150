Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 
Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters if it is non-empty.

-----------------------------------------------------------------------------------------------------------

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ans="";
        Arrays.sort(strs);
        String f = strs[0];
        String l = strs[strs.length-1];
        for(int i=0;i<f.length();i++){
            if(f.charAt(i)==l.charAt(i)){
                ans=ans+f.charAt(i);
            }
            else{
                break;
            }
        }
        return ans;
    }
}
