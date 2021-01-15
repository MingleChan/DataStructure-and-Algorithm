package cn.superming.Algorithm.sort;


import cn.superming.utils.utils;
import cn.superming.DataStructure.MinHeap;

public class Sort {
    private static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void selectSort(int[] arr){
        int n = arr.length;
        if (n < 2) return;
        for (int i = 0; i < n; ++i){
            int minIndex = i;
            for (int j = i + 1; j < n; ++j){
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }
            swap(arr, i, minIndex);
        }
    }

    public static void insertSort(int[] arr){
        int n = arr.length;
        if (n < 2) return;
        for (int i = 1; i < n; ++i){
            int temp = arr[i];
            int j = i;
            while (j > 0 && temp < arr[j-1]){
                arr[j] = arr[--j];
            }
            arr[j] = temp;
        }
    }

    public static void mergeSort(int[] arr){
        int n = arr.length;
        if (n < 2) return;
        int mid = n / 2;
        _mergeSort(arr, 0, mid);
        _mergeSort(arr, mid + 1, n - 1);
        if (arr[mid] > arr[mid+1])
              _merge(arr,0, mid, n-1);
    }

    private static void _mergeSort(int[] arr, int l, int r){
        if (l >= r)
            return;
        int mid = l + (r - l) / 2;
        _mergeSort(arr, l, mid);
        _mergeSort(arr, mid + 1, r);
        if (arr[mid] > arr[mid+1])
            _merge(arr, l, mid, r);
    }

    private static void _merge(int[] arr, int l, int mid, int r) {
        int[] tempArray = new int[r - l + 1];
        int lp = l, rp = mid + 1;
        int index = 0;
        while (lp <= mid && rp <= r){
            tempArray[index++] = arr[lp] <= arr[rp] ? arr[lp++] : arr[rp++];
        }
        while (lp <= mid)   tempArray[index++] = arr[lp++];
        while (rp <= r)     tempArray[index++] = arr[rp++];
        System.arraycopy(tempArray, 0, arr, l, r - l + 1);
    }

    public static void quickSort(int[] arr){
        int n = arr.length;
        if (n < 2) return;
        _quickSort(arr, 0, n-1);
    }

    private static void _quickSort(int[] arr, int l, int r ) {
        if (l >= r) return;
        int pivot = _partition(arr, l, r);
        _quickSort(arr, l, pivot - 1);
        _quickSort(arr, pivot + 1, r);
    }

    private static int _partition(int[] arr, int l, int r) {
        int pivot = r;
        int count = l;
        for (int i = l; i < r; ++i){
            if (arr[i] < arr[pivot]) {
                swap(arr, i, count++);
            }
        }
        swap(arr, pivot, count);
        return count;
    }

    public static void quickSort2ways(int[] arr){
        int n = arr.length;
        if (n < 2) return;
        _quickSort2ways(arr, 0, n-1);
    }

    private static void _quickSort2ways(int[] arr, int l, int r ) {
        if (l >= r) return;
        int pivot = _partition2ways(arr, l, r);
        _quickSort2ways(arr, l, pivot - 1);
        _quickSort2ways(arr, pivot + 1, r);
    }

    private static int _partition2ways(int[] arr, int l, int r) {
        int pivot = r;
        int lp = l, rp = r - 1;
        while (true){
            while (lp <= r - 1 && arr[lp] < arr[pivot]) lp++;
            while (rp >= l && arr[rp] > arr[pivot]) rp--;
            if (lp >= rp) break;
            swap(arr, lp, rp);
            lp++;
            rp--;
        }
        swap(arr, pivot, lp);
        return lp;
    }

    public static void quickSort3ways(int[] arr){
        int n = arr.length;
        if (n < 2) return;
        _quickSort3ways(arr, 0, n-1);
    }

    private static void _quickSort3ways(int[] arr, int l, int r) {
        if (l >= r) return;
        int pivot = r;
        int lp = l - 1, rp = r; // arr[l...lp] < arr[pivot], arr[rp...r-1] > 0
        int i = l;
        while (i < rp){
            if (arr[i] < arr[pivot]) {
                swap(arr, i++, ++lp);
            } else if (arr[i] > arr[pivot]) {
                swap(arr, i, --rp);
            } else {
                i++;
            }
        }
        swap(arr, rp, pivot);
        _quickSort3ways(arr, l, lp);
        _quickSort3ways(arr, rp+1, r);
    }

    public static void heapSort(int[] arr){
        int[] temp = new int[arr.length];
        System.arraycopy(arr, 0, temp, 0, arr.length);
        MinHeap m = new MinHeap(temp);
        for (int i = 0; i < arr.length; i++)
            arr[i] = m.extractMin();
    }


    public static void main(String[] args) {
        int n = 20;
        int[] arr = utils.generateArray(n);
//        Sort.selectSort(arr);
//        Sort.insertSort(arr);
//        Sort.mergeSort(arr);
//        Sort.quickSort2ways(arr);
//        Sort.quickSort3ways(arr);
        Sort.heapSort(arr);
        utils.printArray(arr);
    }


}
