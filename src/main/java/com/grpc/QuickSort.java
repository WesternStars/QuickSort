package com.grpc;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    private final int[] unsortedLine = new Random().ints(1, 500).limit(50).toArray();

    private void quickSort(int left, int right) throws InterruptedException {
        if (right - left > 0) {
            int partitionPoint = partition(left, right, unsortedLine[right]);
            quickSort(left, partitionPoint - 1);
            quickSort(partitionPoint + 1, right);
        }
    }

    private int partition(int left, int right, int pivot) throws InterruptedException {
        //System.out.println("Partition: " + Arrays.toString(Arrays.copyOfRange(UNSORTED, left, right + 1)));
        int leftPointer = left - 1;
        int rightPointer = right;
        while (leftPointer < rightPointer) {
            while (unsortedLine[++leftPointer] < pivot) {
                //Thread.sleep(1);
                //do nothing
            }
            while (rightPointer > 0 && unsortedLine[--rightPointer] > pivot) {
                //Thread.sleep(1);
                //do nothing
            }
            if (leftPointer < rightPointer) {
                swap(leftPointer, rightPointer);
            }
        }
        swap(leftPointer, right);
        return leftPointer;
    }

    private void swap(int left, int right) throws InterruptedException {
        Thread.sleep(1);
        int temp = unsortedLine[left];
        unsortedLine[left] = unsortedLine[right];
        unsortedLine[right] = temp;
    }

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        QuickSort sort = new QuickSort();
        sort.quickSort(0, sort.unsortedLine.length - 1);
        System.out.println("Result: " + Arrays.toString(sort.unsortedLine));
        System.out.println("Result: " + (System.currentTimeMillis() - start));
    }
}