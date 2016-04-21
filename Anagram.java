import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Anagram {

    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
     int numCases = in.nextInt();
		in.nextLine();
		for(int t = 0; t < numCases; t ++)
		{
			String s = in.nextLine();
			if(s.length() % 2 == 1)
			{
				System.out.println(-1);
			}
			else
			{
				String s1 = s.substring(0, s.length()/2);
				String s2 = s.substring(s.length()/2,s.length());
				int[] count = new int[26];
				for(int i = 0; i < s1.length(); i ++)
				{     //for the same letter, put its count as value
					count[s1.charAt(i) - 'a'] ++;
				}
				int change = 0;
				for(int i = 0; i < s2.length(); i ++)
				{       //it for the same letter, it appears at least once, then remove it once
					if(count[s2.charAt(i) - 'a'] > 0)
					{
						count[s2.charAt(i) - 'a']--;
					}
					else
					{
						change ++;
					}
				}
				System.out.println(change);
			}
		}
	}
    }
    

