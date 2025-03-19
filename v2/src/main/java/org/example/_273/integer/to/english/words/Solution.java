package org.example._273.integer.to.english.words;

class Solution {
    private final String[] belowTen = new String[] { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
            "Nine" };
    private final String[] belowTwenty = new String[] { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
            "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
    private final String[] belowHundred = new String[] { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty",
            "Seventy", "Eighty", "Ninety" };

    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";

        StringBuilder result = new StringBuilder();
        int count = 0;
        while (num > 0) {
            StringBuilder part = new StringBuilder();
            int setki = num % 1000;
            int dziesiatki = setki % 100;
            setki /= 100;

            int jednosci = dziesiatki % 10;
            dziesiatki /= 10;

            if (setki > 0)
                part.append(belowTen[setki])
                        .append(" Hundred ");
            if (dziesiatki > 1)
                part.append(belowHundred[dziesiatki])
                        .append(" ");
            if (dziesiatki == 1)
                part.append(belowTwenty[jednosci])
                        .append(" ");
            else if (jednosci > 0)
                part.append(belowTen[jednosci])
                        .append(" ");

            if (count == 1 && isNotZero(num))
                part.append("Thousand ");
            if (count == 2 && isNotZero(num))
                part.append("Million ");
            if (count == 3 && isNotZero(num))
                part.append("Billion ");

            num /= 1000;
            count++;
            result.insert(0, part);
        }

        return result.toString()
                .trim();
    }

    private boolean isNotZero(int num) {
        return num % 1000 != 0;
    }
}
