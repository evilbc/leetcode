package org.example;

import java.util.*;

public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty())
            return 0;

        int index = haystack.indexOf(needle.charAt(0));
        while (index != -1) {
            if (index + needle.length() > haystack.length())
                break;
            if (needle.equals(haystack.substring(index, index + needle.length())))
                return index;
            index = haystack.indexOf(needle.charAt(0), index + 1);
        }
        return -1;
    }
}
