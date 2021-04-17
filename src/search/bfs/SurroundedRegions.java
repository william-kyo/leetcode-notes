package search.bfs;

import org.junit.Assert;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
    private final int[][] direction = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public void solve(char[][] board) {
        if(board==null || board.length==0 || board[0].length==0){
            return;
        }
        int m = board.length;
        int n = board[0].length;
        int[][] marked = new int[m][n];
        // 1.marked all the 'O' that are connected to the border
        Queue<int[]> queue = new LinkedList<>();
        // 1.1 add the border 'O' to a queue
        for(int i=0; i<m; i++){
            if(board[i][0]=='O'){
                queue.add(new int[]{i, 0});
            }
            if(board[i][n-1]=='O'){
                queue.add(new int[]{i, n-1});
            }
        }
        for(int j=1; j<n-1; j++){
            if(board[0][j]=='O'){
                queue.add(new int[]{0, j});
            }
            if(board[m-1][j]=='O'){
                queue.add(new int[]{m-1, j});
            }
        }

        // 1.2 remove a 'O' and check 4 direction of current 'O'
        while(!queue.isEmpty()){
            int[] current = queue.remove();
            marked[current[0]][current[1]] = 1;
            for(int[] dir : direction){
                int x = current[0] + dir[0];
                int y = current[1] + dir[1];
                // 1.3 any 'O' add into the queue
                if(x>=0 && x<m && y>=0 && y<n){
                    if(marked[x][y]==0 && board[x][y]=='O'){
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }

        // 2.check all the 'O' that are not connected to the border
        for(int i=1; i<m-1; i++){
            for(int j=1; j<n-1; j++){
                if(board[i][j]=='O'&&marked[i][j]==0){
                    // 3.flip these not connected 'O'
                    board[i][j] = 'X';
                }
            }
        }

    }


    public static void main(String[] args) {
        SurroundedRegions sr = new SurroundedRegions();

        char[][] board = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        char[][] expected = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'}, {'X', 'O', 'X', 'X'}};
        sr.solve(board);

        int len = board.length;
        for (int i = 0; i < len; i++) {
            Assert.assertArrayEquals(expected[i], board[i]);
        }
    }
}