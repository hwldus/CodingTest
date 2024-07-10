import java.io.*;

public class Main {
    static int n;
    static int[] board;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n];
        nQueen(0);
        System.out.println(count);
    }
    static void nQueen(int row) {
        if(row == n) {
            count++;
            return;
        }
        for(int col=0; col<n; col++) {
            if(isSafe(row, col)) {
                board[row] = col;
                nQueen(row+1);
            }
        }
    }
    static boolean isSafe(int row, int col) {
        for(int i=0; i<row; i++) {
            if(board[i] == col) {
                return false;
            }
            if(Math.abs(board[i]-col) == Math.abs(i-row)) {
                return false;
            }
        }
        return true;
    }
}