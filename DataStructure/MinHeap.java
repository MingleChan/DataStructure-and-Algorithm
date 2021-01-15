package cn.superming.DataStructure;

import cn.superming.utils.utils;


public class MinHeap {
    private int[] data;
    private int capacity;
    private int size;

    public MinHeap(int capacity) {
        this.data = new int[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    public MinHeap(int[] arr){
        this.data = new int[arr.length];
        this.size = arr.length;
        this.capacity = arr.length;
        System.arraycopy(arr, 0, data, 0, arr.length);
        if (size > 1) heapify();
    }

    private void heapify() {
        for (int i = (size - 2) / 2; i >= 0; i--)
            shiftDown(i);
    }

    public void insert(int e){
        if (size >= capacity )
            throw new RuntimeException("Over capacity.");
        data[size] = e;
        shiftUp(size);
        size++;
    }

    public int extractMin(){
        if (size == 0)
            throw new RuntimeException("No more element.");
        int res = data[0];
        swap(data, 0, --size);
        shiftDown(0);
        return res;
    }

    private void shiftDown(int i) {
        int k;
        while (2 * i + 1 < size){
            k = 2 * i + 1;
            if (k + 1 < size && data[k + 1] < data[k]) k = k + 1;
            if (data[i] > data[k]) {
                swap(data, i, k);
                i = k;
            } else {
                break;
            }
        }
    }

    private void shiftUp(int i) {
        int k;
        while (i > 0 ) {
            k = (i - 1) / 2;
            if (data[i] < data[k]) {
                swap(data, i, k);
                i = k;
            } else {
                break;
            }
        }
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void print(){
        for (int i = 0; i < size; ++i) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    private void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
