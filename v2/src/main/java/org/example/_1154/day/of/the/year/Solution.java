package org.example._1154.day.of.the.year;

class Solution {
    private final int[] numberOfDays = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public int dayOfYear(String date) {
        String[] dates = date.split("-");
        int year = Integer.parseInt(dates[0]);
        if (isLeapYear(year))
            numberOfDays[2] = 29;

        int month = Integer.parseInt(dates[1]);
        int day = Integer.parseInt(dates[2]);

        int dayOfYear = 0;
        for (int i = 1; i < month; i++) {
            dayOfYear += numberOfDays[i];
        }

        return dayOfYear + day;
    }

    private boolean isLeapYear(int year) {
        if (year % 400 == 0)
            return true;
        if (year % 100 == 0)
            return false;
        return year % 4 == 0;
    }
}
