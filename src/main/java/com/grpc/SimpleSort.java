package com.grpc;

import java.util.Arrays;
import java.util.Random;

public class SimpleSort {

    private final int[] unsortedLine = new Random().ints(1, 500).limit(50).toArray();

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        SimpleSort sort = new SimpleSort();
        sort.sort();
        System.out.println("Result: " + Arrays.toString(sort.unsortedLine));
        System.out.println("Result: " + (System.currentTimeMillis() - start));
    }

    private void sort() throws InterruptedException {
        for (int i = 0; i < unsortedLine.length; i++) {
            for (int j = i + 1; j < unsortedLine.length; j++) {
                //Thread.sleep(1);
                if (unsortedLine[i] > unsortedLine[j]) swap(i, j);
            }
        }
    }

    private void swap(int left, int right) throws InterruptedException {
        Thread.sleep(1);
        int temp = unsortedLine[left];
        unsortedLine[left] = unsortedLine[right];
        unsortedLine[right] = temp;
    }
}
