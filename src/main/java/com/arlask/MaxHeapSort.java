package com.arlask;

public class MaxHeapSort{
    int [] heap;
    int capacity;
    int size;
    Metrics metrics;
    int n;

    public MaxHeapSort(int capacity) {
        this.capacity = capacity;
        this.n=capacity;
        heap = new int[capacity];
        size = 0;
        metrics=new Metrics();
        metrics.incAlloc();
    }

    public int parent(int i){
        return (i-1)/2;
    }

    public int left(int i){
        return 2*i+1;
    }

    public int right(int i){
        return 2*i+2;
    }

    public void insert(int key){
        metrics.reset();
        metrics.startTimer();

        if (size == capacity) {
            expand();
            
        }

        heap[size]=key;
        metrics.incArrAcces();
        metrics.incAlloc();

        int i=size;
        size++;

        while (i!=0 && heap[parent(i)]<heap[i]) {
            int temp=heap[parent(i)];
            heap[parent(i)]=heap[i];
            heap[i]=temp;
            metrics.incComp();
            metrics.incArrAcces();
            metrics.incArrAcces();

            i=parent(i);
            metrics.incSwaps();

        }
        metrics.stopTimer();
        
    }

    public int getMax(){
        metrics.reset();
        metrics.startTimer();

         if(size==0){
            throw new IllegalStateException("Heap is empty");
        }

        metrics.incArrAcces();

        metrics.stopTimer();

        return heap[0];


    }

    public int extractMax(){
        metrics.reset();
        metrics.startTimer();

        if(size==0){
            throw new IllegalStateException("Heap is empty");
        }

        int max=heap[0];
        metrics.incArrAcces();

        heap[0]=heap[size-1];
        metrics.incArrAcces();
        metrics.incArrAcces();

        size--;
        MaxHeapify(0);

        metrics.stopTimer();

        return max;

    }


    public void IncreaseKey(int ind,int newValue){
        metrics.reset();
        metrics.startTimer();

        if (newValue < heap[ind]) {
             throw new IllegalArgumentException("New value is smaller than current value");
        }

        metrics.incArrAcces();
        heap[ind]=newValue;
        metrics.incArrAcces();

        while(ind!=0 && heap[parent(ind)]<heap[ind]){
            metrics.incComp(); 
            metrics.incArrAcces(); 
            metrics.incArrAcces(); 

            int temp=heap[parent(ind)];
            heap[parent(ind)]=heap[ind];
            heap[ind]=temp;
            metrics.incSwaps();
            ind=parent(ind);
        }

        metrics.stopTimer();
    
    }


    public void MaxHeapify(int i){
        metrics.reset();
        metrics.startTimer();

        int largest=i;

        int l=left(i);

        int r=right(i);


        while(true){
            if(l<size && heap[l]>heap[largest]){
                metrics.incComp();
                metrics.incArrAcces();
                metrics.incArrAcces();
                largest=l;
            }

            if(r<size && heap[r]>heap[largest]){
                metrics.incComp();
                metrics.incArrAcces();
                metrics.incArrAcces();
                largest=r;
            }

           if (largest == i) {
            break;
            }

            int temp = heap[i];
            heap[i] = heap[largest];
            heap[largest] = temp;
            metrics.incSwaps();

            i = largest;
        }
            metrics.stopTimer();

    }


    public void expand(){
        int newCap=capacity*2;
        int [] newHeap=new int[newCap];
        System.arraycopy(heap, 0, newHeap,0,capacity);
        heap=newHeap;
        capacity=newCap;

    }

}




