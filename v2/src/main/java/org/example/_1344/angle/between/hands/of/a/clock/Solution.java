package org.example._1344.angle.between.hands.of.a.clock;

class Solution {
    public double angleClock(int hour, int minutes) {
        double hourPosition = hour * 5 + (double) minutes / 12;
        double angle = Math.abs(hourPosition - minutes) * 6;
        if (angle > 180)
            angle = 360 - angle;
        return angle;
    }
}