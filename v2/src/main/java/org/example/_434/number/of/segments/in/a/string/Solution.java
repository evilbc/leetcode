package org.example._434.number.of.segments.in.a.string;

import java.util.*;

class Solution {
    public int countSegments(String s) {
        if (s.isBlank()) return 0;
        return s.trim().split("\\s+").length;
    }
}
