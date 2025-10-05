package com.arlask;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Metrics {
    private int comparisons = 0;
    private int swaps = 0;
    private int arrayAccesses = 0;
    private int memoryAllocations = 0;

    private long startTime;
    private long endTime;

    public void startTimer() {
        startTime = System.nanoTime();
    }

    public void stopTimer() {
        endTime = System.nanoTime();
    }

    public long getTime() {
        return (endTime - startTime);
    }

    
    public void incComp() { 
        comparisons++;
    }

    public void incSwaps() {
         swaps++; 
    }

    public void incArrAcces() {
         arrayAccesses++; 
        }

    public void incAlloc() {
         memoryAllocations++; 
        }

    public int getComparisons() { 
        return comparisons; 
        }

    public int getSwaps() {
         return swaps;
         }

    public int getArrayAccesses() {
         return arrayAccesses; 
        }

    public int getMemoryAllocations() {
         return memoryAllocations;
         }

    public void reset() {
        comparisons = 0;
        swaps = 0;
        arrayAccesses = 0;
        memoryAllocations = 0;
        startTime = 0;
        endTime = 0;
    }

    public void log(String label, int n) {
        File file = new File("results.csv");
        boolean fileExists = file.exists();

        try (PrintWriter pw = new PrintWriter(new FileWriter(file, true))) {
            if (!fileExists) {
                pw.println("operation,n,timeNs");
            }
            pw.printf("%s,%d,%d%n", label, n, getTime());
        } catch (IOException e) {
            throw new RuntimeException("Failed to write metrics", e);
        }
    }

}
