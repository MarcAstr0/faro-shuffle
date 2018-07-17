package com.marcastr0;

public class FaroShuffleJava {

    public static int[] inFaro(int[] deck) {
        int[] result = new int[deck.length];

        int j = 0;

        for (int i = 0; i < deck.length; i++) {
            if (i == 0 || i % 2 == 0) {
                result[i] = deck[j];
            } else {
                result[i] = deck[(deck.length / 2) + j];
                j++;
            }
        }

        return result;
    }
}
