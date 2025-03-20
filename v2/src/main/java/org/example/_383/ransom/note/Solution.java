package org.example._383.ransom.note;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        StringBuilder sb = new StringBuilder(magazine);

        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            int index = sb.indexOf(String.valueOf(c));
            if (index < 0)
                return false;
            sb.deleteCharAt(index);
        }
        return true;
    }
}