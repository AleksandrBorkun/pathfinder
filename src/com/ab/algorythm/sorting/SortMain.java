package com.ab.algorythm.sorting;

public class SortMain {

    public static void main(String[] args) {
        long endTime, startTime = System.nanoTime();

        int [] arr = {23,345,542,1,56,4,2,17,6,};

        Sort.pasteSort(arr);
        endTime = System.nanoTime();

        System.out.println("Code took "+(endTime-startTime)*(1e-6) +" mseconds");
    }
}
