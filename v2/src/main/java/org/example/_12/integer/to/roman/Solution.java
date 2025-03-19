package org.example._12.integer.to.roman;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final List<Rule> RULES = buildRules();

    private static List<Rule> buildRules() {
        List<Rule> rules = new ArrayList<>();
        rules.add(buildRule(1_000, "M"));
        rules.add(buildRule(900, "CM"));
        rules.add(buildRule(500, "D"));
        rules.add(buildRule(400, "CD"));
        rules.add(buildRule(100, "C"));
        rules.add(buildRule(90, "XC"));
        rules.add(buildRule(50, "L"));
        rules.add(buildRule(40, "XL"));
        rules.add(buildRule(10, "X"));
        rules.add(buildRule(9, "IX"));
        rules.add(buildRule(5, "V"));
        rules.add(buildRule(4, "IV"));
        rules.add(buildRule(1, "I"));
        return rules;
    }

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            for (Rule rule : RULES) {
                if (num >= rule.getValue()) {
                    sb.append(rule.getSymbol());
                    num -= rule.getValue();
                    break;
                }
            }
        }
        return sb.toString();
    }

    private static Rule buildRule(int value, String symbol) {
        return new Rule(value, symbol);
    }

    private static class Rule {
        private int value;
        private String symbol;

        public Rule(int number, String symbol) {
            this.value = number;
            this.symbol = symbol;
        }

        public int getValue() {
            return value;
        }

        public String getSymbol() {
            return symbol;
        }
    }
}
