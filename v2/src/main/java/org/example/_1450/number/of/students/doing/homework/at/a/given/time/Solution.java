package org.example._1450.number.of.students.doing.homework.at.a.given.time;

class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        for (int i = 0; i < startTime.length; i++)
            if (startTime[i] <= queryTime && endTime[i] >= queryTime)
                count++;

        return count;
    }
}
