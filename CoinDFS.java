import java.util.Arrays;
import java.util.Scanner;

public class CoinDFS {

  private static int k;
  private static char[][] board;
  private static int[][] costs;
  private static int solve(){
  dfs(0,0,0,0);
   for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '*') {
                    int minCost = costs[i][j];
                    return minCost == Integer.MAX_VALUE ? -1 : minCost;
                }
            }
        }

        return -1;
  
  }
  
  private static void dfs(int i, int j, int cost, int time){
  if(!inBox(i,j)||cost>=costs[i][j]){
      return;
  }
  costs[i][j] = cost;
  if(board[i][j] == '*'){
      return;
  }
  if(time == k){
      return;
  }
  //recursive
  dfs(i-1,j,board[i][j] == 'U'? cost:cost+1,time+1);
 dfs(i,j-1,board[i][j] == 'L'? cost:cost+1,time+1);     
  dfs(i+1,j,board[i][j] == 'D'? cost:cost+1,time+1);
  dfs(i,j+1,board[i][j] == 'R'? cost:cost+1,time+1);
  }
  
  private static boolean inBox(int i , int j){
      return i>=0 && i<board.length && j >=0 && j<board[i].length;
  }
    public static void main(String[] args) {
        // TODO code application logic here
         Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        k = scanner.nextInt();
        scanner.nextLine();
        board = new char[n][];

        for (int i = 0; i < n; i++) {
            board[i] = scanner.nextLine().toCharArray();
        }
        costs = new int[n][m];
        for (int i = 0; i < costs.length; i++) {
            Arrays.fill(costs[i], Integer.MAX_VALUE);
        }

        System.out.println(solve());
        
        scanner.close();
    }
    
}
