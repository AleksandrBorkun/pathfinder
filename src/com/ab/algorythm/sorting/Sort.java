package com.ab.algorythm.sorting;

import java.util.Arrays;

public class Sort {

    public static int[] sortMerge(int[] arr) {
        int len = arr.length;
        if (len < 2) return arr;
        int middle = len / 2;
        return merge(sortMerge(Arrays.copyOfRange(arr, 0, middle)),
                sortMerge(Arrays.copyOfRange(arr, middle, len)));
    }

    private static int[] merge(int[] arr1, int[] arr2) {
        int len1 = arr1.length, len2 = arr2.length;
        int a = 0, b = 0, len = len1 + len2;

        int[] result = new int[len];

        for (int i = 0; i < len; i++) {
            if (b < len2 && a < len1) {
                if (arr1[a] > arr2[b]) {
                    result[i] = arr2[b++];
                } else {
                    result[i] = arr1[a++];
                }
            } else if (b < len2) {
                result[i] = arr2[b++];
            } else {
                result[i] = arr1[a++];
            }
        }
        return result;
    }

    public static void sortMergeNoRecurcive(int[] arr) {
        int len = arr.length;
        int n = 1;
        int shift;
        int twoSize;
        int arr2[];
        while (n < len) {
            shift = 0;
            while (shift < len) {
                if (shift + n >= len) {
                    break;
                }
                twoSize = (shift + n * 2 > len) ? (len - (shift + n)) : n;
                arr2 = merge(Arrays.copyOfRange(arr, shift, shift + n),
                        Arrays.copyOfRange(arr, shift + n, shift + n + twoSize));
                System.out.println(Arrays.toString(arr2));
                for (int i = 0; i < n + twoSize; i++) {
                    arr[shift + i] = arr2[i];
                }
                shift += n * 2;
            }
            n *= 2;
        }
    }

    private static int partition(int arr[], int p, int r) {
        int q = p;
        for (int u = p; u < r; u++) {
            if (arr[u] < arr[r]) {
                int b = arr[u];
                arr[u] = arr[q];
                arr[q] = b;
                q++;
            }
        }
        int b = arr[r];
        arr[r] = arr[q];
        arr[q] = b;
        return q;
    }

    public static void quickSort(int [] arr, int p, int r){
        if(p >= r){
            return;
        }
        int q = partition(arr, p, r);
        quickSort(arr, p, q - 1);
        quickSort(arr,q + 1, r);
    }

    public static void pasteSort(int [] arr){
        for(int i = 1; i< arr.length; i++){
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

}
