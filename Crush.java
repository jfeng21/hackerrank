import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Crush {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // System.out.println(256<<1); //512, move highes 1 to left, means multiple 2:   1 0000 0000 0
          //  System.out.println(256<<10); //262144 
           
        	Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in), 256 << 10));
               
		int n = in.nextInt();
		long[] delta = new long[n+1];
		int m = in.nextInt();
		for (int q = 0; q < m; q++) {
			int l = in.nextInt();
			int r = in.nextInt();
			int k = in.nextInt();
      //store value of diff from current and prev
			delta[l-1] += k;
			delta[r] -= k;
		}
		long max = 0;
		long c = 0;
		for (int i = 0; i < n; i++) {
			c += delta[i];
			if (c > max) max = c;
		}
		System.out.println(max);
	}
    }
    

