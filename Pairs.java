/*
Given N integers, count the total pairs of integers that have a difference of K
Input Format
The 1st line contains two integers N and K
The 2nd line contains N integers that form the set. All the numbers are distince
Output Format
An integer that gives the number of pairs of numbers that have a difference of K
Constraints:
N<=10^5
0<K<10^9
Each integer will be greater than 0 and least K smaller than 2^31-1
*/

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Pairs{
public static void main(String[] args) {
   Scanner sc = new Scanner(System.in);
        System.out.println("Please enter size of list, and k:");

        int size = sc.nextInt();
        int k = sc.nextInt();
        //check k
        if (k < 0 || k == 0 || k > 1000000000) {
            System.out.println("Please input positive number k: 0<k<=10^9");
            return;
        }
        System.out.println("the size of element and k are: " + size + " and " + k);
        System.out.println("Please enter all the integers");
        Map<Integer, Integer> map = new HashMap<>();
        int[] list = new int[size];

        for (int i = 0; i < size; i++) {
            list[i] = sc.nextInt();
            if (list[i] < 0 || list.length < 0 || list.length > 100000) {
                System.out.println("Please input positive number 0<=n<=100000 ");
                return;
            }
            //check duplicate
            if (map.containsKey(list[i])) {
                System.out.println("input must be distinct");
                return;
            } else {
                map.put(list[i], i);
            }

        }
        System.out.print("All the integers are: ");
        for (int i = 0; i < size; i++) {
            System.out.print(list[i] + ",");
        }
        System.out.println();
        //Difference K

        int pairCount = 0;
        int[] result;
        for (int i = 0; i < list.length; i++) {
            int x = list[i];
            if (map.containsKey(x + k)) {
                continue;
            }
            if (map.containsKey(x - k)) {
                //   result = new int[]{map.get(a[i]),i};
                //   System.out.println(result);
                pairCount++;
            }
            map.put(x, i);
        }
        System.out.println("total number of pairs for difference" + k + " is " + pairCount);

    }
}
