package com.arlask;

import java.util.Random;

public class CLI {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        MaxHeapSort heap = new MaxHeapSort(n);

        Random rand = new Random();
        int[] values = new int[n];


        for (int i = 0; i < n; i++) {
            values[i] = rand.nextInt(1000);
        }

        //insert
        heap.metrics.reset();
        heap.metrics.startTimer();
        for (int value : values) {
            heap.insert(value);
        }
        heap.metrics.stopTimer();
        heap.metrics.log("Insert", n);

        //getmax
        heap.metrics.reset();
        heap.metrics.startTimer();
        heap.getMax();
        heap.metrics.stopTimer();
        heap.metrics.log("GetMax", n);

        //increase key
        int indexToIncrease = rand.nextInt(n);
        int newValue = heap.heap[indexToIncrease] + 50;

        heap.metrics.reset();
        heap.metrics.startTimer();
        heap.IncreaseKey(indexToIncrease, newValue);
        heap.metrics.stopTimer();
        heap.metrics.log("IncreaseKey", n);

        //extract max
        heap.metrics.reset();
        heap.metrics.startTimer();
        while (heap.size > 0) {
            heap.extractMax();
        }
        heap.metrics.stopTimer();
        heap.metrics.log("ExtractMax", n);

        System.out.println("Metrics saved to results.csv");
    }
}
