import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoinOnTable {

    public static void main(String[] args) throws IOException {
  
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                System.in));
        String line = reader.readLine();
        String[] tokens = line.split("\\s+");
        int n, m, k;
        n = Integer.parseInt(tokens[0]);
        m = Integer.parseInt(tokens[1]);
        k = Integer.parseInt(tokens[2]);
        char[][] board = new char[n][m];
        for (int i = 0; i < n; ++i) {
            line = reader.readLine();
            for (int j = 0; j < m; ++j) {
                board[i][j] = line.charAt(j);
            }
        }
        System.out.println(solve(board, k));
    }

    public static int solve(char[][] board, int K) {
        int[][][] results = new int[board.length][board[0].length][K + 1];
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (board[i][j] == '*') {
                    results[i][j][0] = 0;
                } else {
                    results[i][j][0] = -1;
                }
            }
        }

        for (int k = 1; k <= K; ++k) {
            for (int i = 0; i < board.length; ++i) {
                for (int j = 0; j < board[i].length; ++j) {
                    if (board[i][j] == '*') {
                        results[i][j][k] = 0;
                        continue;
                    }
                    int minCost = -1;
                    if (i > 0 && results[i - 1][j][k - 1] >= 0) {
                    //??????????????????????
                        int cost = results[i - 1][j][k - 1] + ((board[i][j] == 'U') ? 0 : 1);
                        if (minCost < 0 || cost < minCost) {
                            minCost = cost;
                        }
                    }
                    if (i < board.length - 1 && results[i + 1][j][k - 1] >= 0) {
                        int cost = results[i + 1][j][k - 1] + ((board[i][j] == 'D') ? 0 : 1);
                        if (minCost < 0 || cost < minCost) {
                            minCost = cost;
                        }
                    }
                    if (j > 0 && results[i][j - 1][k - 1] >= 0) {
                        int cost = results[i][j - 1][k - 1] + ((board[i][j] == 'L') ? 0 : 1);
                        if (minCost < 0 || cost < minCost) {
                            minCost = cost;
                        }
                    }
                    if (j < board[i].length - 1 && results[i][j + 1][k - 1] >= 0) {
                        int cost = results[i][j + 1][k - 1] + ((board[i][j] == 'R') ? 0 : 1);
                        if (minCost < 0 || cost < minCost) {
                            minCost = cost;
                        }
                    }
                    results[i][j][k] = minCost;
                }
            }
        }

        int min = -1;
        for (int k = 0; k <= K; ++k) {
            if (min < 0 || (results[0][0][k] >= 0 && results[0][0][k] < min)) {
                min = results[0][0][k];
            }
        }

        return min;
    }

}
