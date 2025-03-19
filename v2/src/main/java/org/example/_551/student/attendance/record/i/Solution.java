package org.example._551.student.attendance.record.i;

class Solution {
    public boolean checkRecord(String s) {
        byte absences = 0;
        byte late = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'A')
                if (++absences >= 2)
                    return false;

            if (ch == 'L') {
                if (++late >= 3)
                    return false;
            }

            else
                late = 0;
        }
        return true;
    }
}
