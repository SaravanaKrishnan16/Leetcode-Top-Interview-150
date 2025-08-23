Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false

Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false

Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true
 
Constraints:

1 <= ransomNote.length, magazine.length <= 105
ransomNote and magazine consist of lowercase English letters.

--------------------------------------------------------------------------------------------------------------------------------------------------------
  
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : ransomNote.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) <= 0) {
                return false;
            }
            map.put(c, map.get(c) - 1);
        }
        return true;
    }
}

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] letters = new int[26];
        for(char c : magazine.toCharArray())
            letters[c - 'a']++;
        for(char ch : ransomNote.toCharArray()){
            letters[ch - 'a']--;
            if(letters[ch - 'a'] == -1)
                return false;
        }
        return true;
    }
}
