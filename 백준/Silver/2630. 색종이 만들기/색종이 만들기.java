import java.io.*;
import java.util.*;

public class Main {
    public static int white = 0;
    public static int blue = 0;
    public static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<n; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }
        paper(0,0,n);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void paper(int row, int col, int size) {
        if(color(row, col, size)) {
            if(board[row][col] == 0) white++;
            else blue++;
            return;
        }

        int newSize = size / 2;
        paper(row, col, newSize);
        paper(row, col + newSize, newSize);
        paper(row + newSize, col, newSize);
        paper(row + newSize, col + newSize, newSize);
    }
    public static boolean color(int row, int col, int size) {
        int c = board[row][col];
        for(int i = row; i < row + size; i++) {
            for(int j = col; j < col + size; j++) {
                if(board[i][j] != c) return false;
            }
        }
        return true;
    }
}