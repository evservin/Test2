package org.example;


import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
//

public class Main {
    public static void main(String[] args) {
        int[] arr = {7,2,9,11,3,7};
        int target = 7;
        System.out.println(ans(arr,target));


    }
    public static boolean ans(int[] arr, int tar){
        int [] armin = new int[arr.length-1];
        int [] armax = new int[arr.length-1];
        AtomicInteger sum = new AtomicInteger();
        Arrays.stream(arr).forEach(num -> {
            sum.addAndGet(num);
        });
        System.out.println(sum);
        if(arr.length==0){
            return false;
        }
        else if(tar> sum.get()){
            return false;
        } else if (tar== sum.get()) {
            return true;
        } else if (arr.length==2&&arr[0]-arr[1]==tar) {
            System.out.println("-");
            return true;
        } else {
            for (int i = 1; i < armax.length; i++) {
                armax[0]= arr[0]+arr[1];
                armin[0]= arr[0]-arr[1];
                armax[i]=arr[i+1];
                armin[i]=arr[i+1];
            }
            if (ans(armax,tar)){
                System.out.println("+");
                return true;
            } else if (ans(armin, tar)) {
                System.out.println("-");
                return true;
            }
            else return false;
        }
    }

}