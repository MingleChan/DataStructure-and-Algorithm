package cn.superming.utils;

import java.util.Random;

public class utils {
    public static int[] generateArray(int n){
        int[] arr = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++){
            arr[i] = rand.nextInt(n);
        }
        return arr;
    }

    public static void printArray(int[] arr){
        for (int i : arr) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
