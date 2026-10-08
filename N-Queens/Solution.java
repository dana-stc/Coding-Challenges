import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        place(0, n, new int[n], new boolean[n], new boolean[2 * n], new boolean[2 * n], result);
        return result;
    }

    private static void place(int row, int n, int[] cols, boolean[] usedCol,
                              boolean[] diag, boolean[] anti, List<List<String>> result) {
        if (row == n) {
            List<String> board = new ArrayList<>();
            for (int r = 0; r < n; r++) {
                char[] line = new char[n];
                Arrays.fill(line, '.');
                line[cols[r]] = 'Q';
                board.add(new String(line));
            }
            result.add(board);
            return;
        }
        for (int c = 0; c < n; c++) {
            int d = row - c + n, a = row + c;
            if (usedCol[c] || diag[d] || anti[a]) continue;
            usedCol[c] = diag[d] = anti[a] = true;
            cols[row] = c;
            place(row + 1, n, cols, usedCol, diag, anti, result);
            usedCol[c] = diag[d] = anti[a] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
        System.out.println(solveNQueens(8).size()); // 92
    }
}
