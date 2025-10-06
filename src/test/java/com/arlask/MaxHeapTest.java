package com.arlask;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


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

}
