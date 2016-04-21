public class Fibo {
    public static void main(String[] args) {
        System.out.println("Please input pair of integers");
         Scanner in = new Scanner(System.in);
         int[] input = new int[4];
          HashMap lastPair = new HashMap<>();
          HashMap lastRes = new HashMap<>();
         for(int i = 0; i < input.length; i++){
          input[i] = Integer.parseInt(in.nextLine());
          if( i == input.length - 1){
           lastPair.put(input[i-1], input[i]);
          }
         }
         
        ArrayList<Integer> a = new ArrayList<Integer>();
        
        int j = 2;
        while(true){
            int tmp = a.get(j-1)+a.get(j-2);
            if(tmp>=1 && tmp<=1000){
                a.add(tmp);
                j++;
                int fibo = fibo(tmp);
                 
                
            }
            else{
                System.out.println("Please input between 1 and 1000");
            
    }       
          
            if(j == input.length-1){      
                int last = a.get(j-1)+a.get(j-2);
                int lastpair = fibo(tmp);
               
                lastRes.put(a.get(j-1),lastpair);
              
                
            }
            if(lastPair.containsKey(input[input.length-2])==lastRes.containsKey(a.get(j-1))){
            System.out.println("Yes");
            }else{
            System.out.println("No");
            }
            
            
        }}
    
    static int fibo(int n){
        if(n == 0){
            return 0;
        }else if(n == 1){
        return 1;
        }else if(n > 1){
        return fibo(n-1) + fibo(n-2);
        }else{
        return -1;
        }
    
    }
    
}
