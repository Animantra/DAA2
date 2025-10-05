package com.arlask;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

public class MaxHeapTest {

    private MaxHeapSort heap;

    @BeforeEach
    public void setUp() {
        heap = new MaxHeapSort(10);
    }

    @Test
    public void testEmptyHeap() {
        assertThrows(IllegalStateException.class, () -> heap.extractMax(), "Heap is empty");
        assertThrows(IllegalStateException.class, () -> heap.getMax(), "Heap is empty");
    }

    @Test
    public void testSingleElement() {
        heap.insert(10);
        assertEquals(10, heap.getMax());
        assertEquals(10, heap.extractMax());
        assertThrows(IllegalStateException.class, () -> heap.getMax(), "Heap is empty");
    }

    @Test
    public void testSorted() {
        heap.insert(10);
        heap.insert(20);
        heap.insert(30);
        heap.insert(40);
        assertEquals(40, heap.getMax());
        assertEquals(40, heap.extractMax());
        assertEquals(30, heap.getMax());
    }


    @Test
    public void testHeapSortWithJavaSort() {
         int[] arr = {30, 20, 40, 10};

        MaxHeapSort heap = new MaxHeapSort(arr.length);
        for (int num : arr) {
            heap.insert(num);
        }

        int[] heapSorted = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
             heapSorted[i] = heap.extractMax();
        }

        int[] javaSorted = arr.clone();
        Arrays.sort(javaSorted);

        int[] javaSortedDesc = new int[javaSorted.length];
        for (int i = 0; i < javaSorted.length; i++) {
            javaSortedDesc[i] = javaSorted[javaSorted.length - i - 1];
        }

        for (int i = 0; i < arr.length; i++) {
            assertEquals(javaSortedDesc[i], heapSorted[i]);
        }
    }
}
