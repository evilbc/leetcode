package org.example._433.minimum.genetic.mutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<String> genes = new LinkedList<>();
        genes.offer(startGene);
        List<String> bankList = toList(bank);
        int count = 0;
        while (!genes.isEmpty() && !bankList.isEmpty()) {
            count++;
            if (checkCurrentStep(endGene, genes, bankList))
                return count;

        }
        return -1;
    }

    private boolean checkCurrentStep(String endGene, Queue<String> genes, List<String> bankList) {
        int howMany = genes.size();
        for (int i = 0; i < howMany; i++) {
            String gene = genes.remove();
            if (checkGene(endGene, genes, bankList, gene))
                return true;
        }
        return false;
    }

    private boolean checkGene(String endGene, Queue<String> genes, List<String> bankList, String gene) {
        Iterator<String> it = bankList.iterator();
        while (it.hasNext()) {
            String possibleMutation = it.next();
            if (canMutate(gene, possibleMutation)) {
                if (possibleMutation.equals(endGene)) {
                    return true;
                }
                genes.offer(possibleMutation);
                it.remove();
            }
        }
        return false;
    }

    private boolean canMutate(String startGene, String endGene) {
        int differences = 0;
        for (int i = 0; i < startGene.length(); i++) {
            if (startGene.charAt(i) != endGene.charAt(i) && ++differences > 1) {
                return false;
            }
        }
        return true;
    }

    private List<String> toList(String[] arr) {
        return new ArrayList<>(Arrays.asList(arr));
    }
}
