package Heaps;

import java.util.ArrayList;
class MinHeap {
    int[] harr;
    int capacity;
    int heap_size;

    MinHeap(int cap) {
        heap_size = 0; // Initially, the heap is empty
        capacity = cap;
        harr = new int[cap];
    }

    int parent(int i) { return (i - 1) / 2; }
    int left(int i) { return (2 * i + 1); }
    int right(int i) { return (2 * i + 2); }

    void swap(int first, int second) {
        int temp = harr[first];
        harr[first] = harr[second];
        harr[second] = temp;
    }

    int extractMin() {
        if (heap_size <= 0) {
            return -1; // Return -1 for an empty heap
        }
        if (heap_size == 1) {
            heap_size--;
            return harr[0];
        }

        int min = harr[0];
        harr[0] = harr[heap_size - 1];
        heap_size--;
        MinHeapify(0);

        return min;
    }


    void insertKey(int k) {
        if (heap_size == capacity) {
            System.out.println("Heap overflow");
            return;
        }

        harr[heap_size] = k;
        heap_size++;
        upHeap(heap_size - 1); // Ensure heap property is maintained
    }

    private void upHeap(int index) {
        while (index != 0 && harr[parent(index)] > harr[index]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    void deleteKey(int i) {
        if (i < 0 || i >= heap_size) {
            System.out.println("Index out of bounds");
            return;
        }

        decreaseKey(i, Integer.MIN_VALUE); // Reduce the value to minimum
        extractMin(); // Remove the root (which is now at index `i`)
    }

    void decreaseKey(int i, int new_val) {
        harr[i] = new_val;
        upHeap(i); // Move the new value to its proper position
    }

    void MinHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;

        if (l < heap_size && harr[l] < harr[i]) {
            smallest = l;
        }
        if (r < heap_size && harr[r] < harr[smallest]) {
            smallest = r;
        }
        if (smallest != i) {
            swap(i, smallest);
            MinHeapify(smallest);
        }
    }
}