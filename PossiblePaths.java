import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PossiblePaths {

    public static void main(String[] args) throws IOException {
        	BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(f.readLine().trim());
		for (int tt = 0; tt < t; tt++) {
			StringTokenizer st = new StringTokenizer(f.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			long x = Long.parseLong(st.nextToken());
			long y = Long.parseLong(st.nextToken());
			System.out.println(gcd(a,b)==gcd(x,y)?"YES":"NO");
		}
    }
    //greatest common divider
    	public static long gcd(long x, long y) {
		if (y == 0)
			return x;
		return gcd(y, x%y);
	}
    
}
