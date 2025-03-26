package org.example._649.dota2.senate;

class Solution {
    public String predictPartyVictory(String senate) {
        StringBuilder sb = new StringBuilder();
        int[] bans = { 0, 0 }; // [0] - bans to Rs, [1] - bans to Ds
        boolean[] senatorsExist = { false, false }; // [0] Rs exist, [1] - Ds exist
        while (true) {
            for (int i = 0; i < senate.length(); i++) {
                char c = senate.charAt(i);
                processSenator(bans, senatorsExist, sb, c == 'R');
            }
            if (!senatorsExist[0])
                return "Dire";
            if (!senatorsExist[1])
                return "Radiant";
            senatorsExist[0] = false;
            senatorsExist[1] = false;
            senate = sb.toString();
            sb.setLength(0);
        }
    }

    private static void processSenator(int[] bans, boolean[] senatorsExist, StringBuilder sb, boolean isRadiant) {
        int partyIndex = isRadiant ? 0 : 1;
        int oppositionIndex = isRadiant ? 1 : 0;
        if (bans[partyIndex] > 0) {
            bans[partyIndex]--;
        } else {
            bans[oppositionIndex]++;
            senatorsExist[partyIndex] = true;
            sb.append(isRadiant ? 'R' : 'D');
        }
    }
}
