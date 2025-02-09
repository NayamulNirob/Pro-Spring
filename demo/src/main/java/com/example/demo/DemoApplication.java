package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Random;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
//        SpringApplication.run(DemoApplication.class, args);

        int numbs[]={2,3,4,5,6,7,8,9,10,11,12,13,14};

//        int numbs[]= new int[1000];
//        Random random = new Random();
//
//        for (int numb=0;numb<numbs.length;numb++) {
//            numbs[numb]=random.nextInt(1000);
//
//        }
//        System.out.println(Arrays.toString(numbs));

        int terget=14;

        int result= linerSearch( numbs,terget);

        if(result != -1){
            System.out.println("Element found Leaner Search At index "+result);
        }
        else{
            System.out.println("Element not  found Leaner Search ");
        }

        int result1= bainarySearch( numbs,terget,0,numbs.length-1);

        if(result1 != -1){
            System.out.println("Element found BinarySearch At index "+result1);
        }
        else{
            System.out.println("Element not found BinarySearch ");
        }
    }

    private static int linerSearch(int[] numbs, int terget) {

        int steps=0;

        for (int i = 0; i < numbs.length; i++) {
            steps++;
            if (numbs[i] == terget) {
                System.out.println("Steps taken By Linear :"+steps);
                return i;
            }
        }
        System.out.println("Steps taken By Linear :"+steps);
        return -1;
    }

    private static int bainarySearch(int[] numbs, int terget,int left, int right) {

//        int left = 0;
//        int right = numbs.length - 1;
//
        int steps=0;

        // Printing valu as While loop

//        while (left <= right) {
//            int mid = (right + left) / 2;
//            steps++;
//
//            if (numbs[mid] == terget) {
//
//                System.out.println("Steps taken By Binary"+steps);
//                return mid;
//            }
//            else if (numbs[mid] < terget) {
//                left = mid + 1;
//            }
//            else {
//                right = mid - 1;
//            }
//        }


        // Working As a Recarsive Methods
        if (left <= right) {
            steps++;
           int mid = (right + left) / 2;

            System.out.println("Steps taken By Binary"+steps);
            if (numbs[mid] == terget) {

                return mid;
            }
            else if (numbs[mid] < terget) {

               return bainarySearch(numbs, terget, mid+1, right);
            }
            else {

                return bainarySearch(numbs, terget, left, mid-1);
            }
            }


       System.out.println("Steps taken By Binary"+steps);
        return -1;
    }

}
