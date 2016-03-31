/*
complete the function KDifference which takes an array A of n unique positive integers and an integer K as arguments and returns the 
count the total pairs of numbers whose difference is k.
Constraints:
5<=n<=10^5
All the n numbers are distinct and are <=2 *10^9
0<k<=10^9
*/

import java.util.HashMap;
import java.util.Map;


public class DifferenceK {

    public static void main(String[] args) {
        // TODO code application logic here
        int[] a = {1,3,4,2,5};
        int res = KDifference(a, 3);
        System.out.println(res);
    }
    
    static int KDifference(int[] a, int k){
        
        for(int i = 0; i< a.length; i++){
       if(a[i]<0 || a.length<5 || a.length>100000){
       System.out.println("Please input positive number 5<=n<=100000 ");
       return 0;
       }
       if(k<0||k==0||k>1000000000){
        System.out.println("Please input positive number k: 0<k<=10^9");
       return 0;
       } 
         if( a[i]>2000000000){
        System.out.println("Please input positive number: 0<n<=2*10^9");
       return 0;
       }       
      
        }
        
       int pairCount = 0;
       int[] result;
       Map<Integer, Integer> map = new HashMap<>();
       for(int i = 0; i<a.length; i++){
           int x = a[i];
           //check duplicate
           if(map.containsKey(x)){
           System.out.println("input must be distinct");
           return 0;
           }
       if(map.containsKey(x+k)){
       continue;
       }   
         if(map.containsKey(x-k)){
         //   result = new int[]{map.get(a[i]),i};
         //   System.out.println(result);
          pairCount++;
       }
           map.put(x, i);
       }
       return pairCount;
        
    }
    
   
        
    }

