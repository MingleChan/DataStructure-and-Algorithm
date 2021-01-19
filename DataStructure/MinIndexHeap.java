package cn.superming.DataStructure;

public class MinIndexHeap {
    private int[] data;
    private int[] indexes;

    private int capacity;
    private int size;

    public MinIndexHeap(int capacity) {
        this.data = new int[capacity];
        this.indexes = new int[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void insert(int e){
        if (size + 1 > capacity)
            throw new RuntimeException("capacity overed.");
        data[size] = e;
        indexes[size] = size;
        shiftUp(size);
        size++;
    }

    public int extractMin(){
        if (size <= 0)
            throw new RuntimeException("no more element.");
        int ret = data[indexes[0]];
        swap(indexes, 0, --size);
        shiftDown(0);
        return ret;
    }

    public int extractMinIndex(){
        if (size <= 0)
            throw new RuntimeException("no more element.");
        int ret = indexes[0];
        swap(indexes, 0, --size);
        shiftDown(0);
        return ret;
    }

    public int getItem(int i){
        return data[i];
    }

    public void change(int i, int e){
        if (i >= size)
            throw new RuntimeException("i is larger than size.");
        data[i] = e;
        for (int j = 0; j < size; j++){
            if (indexes[j] == i){
                shiftUp(j);
                shiftDown(j);
                return;
            }
        }
    }

    private void shiftDown(int i) {
        int c;
        while (2 * i + 1 < size){
            c = 2 * i + 1;
            if (c + 1 < size && data[indexes[c + 1]] < data[indexes[c]]) c = c + 1;
            if (data[indexes[c]] < data[indexes[i]]){
                swap(indexes, i , c);
                i = c;
            } else {
                break;
            }
        }
    }

    private void shiftUp(int i) {
        while (i > 0 && data[indexes[i]] < data[indexes[(i - 1) / 2]]){
            swap(indexes, i, (i-1)/2);
            i = (i - 1) / 2;
        }
    }


    private void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
