/*
 * There’s a N*N board, two players join the jump game. The chess 
 * could go vertically and horizontally. If the adjacent chess is 
 * opponent player’s and the spot beside that is empty, then the 
 * chess could jump to that spot. One chess could not been jumped twice.
 * Given the position of the spot on the board, write the program to 
 * count the longest length that chess could go.
 */

public class jumpChess{
	public static void main(String[] args){
		int[][] board = {{0, 1, 2, 0, 0},{0, 0, 0, 2, 0},{0, 0, 0, 0, 2},{0, 1, 0, 2, 0},{0, 0, 1, 0, 1}};
		int max = 0;
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				if(board[i][j] != 0){
					max = Math.max(jump(board,i,j),max);
				}
			}
		}
		System.out.println(max);
	}

	public static int jump(int[][] board, int x, int y){
		//should be careful about the symbol which used to mark the positions which are jumped
		int count1 = 0, count2=0, count3=0, count4=0;
		if(y<board[0].length-2 && board[x][y] != board[x][y+1] && board[x][y+2] == 0 && board[x][y+1]!=0 &&board[x][y+1]!=-1){
			board[x][y+2] = board[x][y];
			board[x][y] = 0;
			int temp = board[x][y+1];
			board[x][y+1] = -1;
			count1 = count1+1+jump(board,x,y+2);
			board[x][y] = board[x][y+2];
			board[x][y+2] = 0;
			board[x][y+1] = temp;
		}
		if(y>=2 && board[x][y] != board[x][y-1] && board[x][y-2] == 0 && board[x][y-1]!=0 && board[x][y-1]!=-1){
			board[x][y-2] = board[x][y];
			board[x][y] = 0;
			int temp = board[x][y-1];
			board[x][y-1] = -1;
			count2 = count2+1+jump(board,x,y-2);
			board[x][y] = board[x][y-2];
			board[x][y-2] = 0;
			board[x][y-1] = temp;
		}
		if(x<board.length-2 && board[x][y] != board[x+1][y] && board[x+2][y] == 0&& board[x+1][y]!=0&&board[x+1][y]!=-1){
			board[x+2][y] = board[x][y];
			board[x][y] = 0;
			int temp = board[x+1][y];
			board[x+1][y] = -1;
			count3 = count3+1+jump(board,x+2,y);
			board[x][y] = board[x+2][y];
			board[x+2][y] = 0;
			board[x+1][y] = temp;
		}
		if(x>=2 && board[x][y] != board[x-1][y] && board[x-2][y] == 0&& board[x-1][y]!=0&&board[x-1][y]!=-1){
			board[x-2][y] = board[x][y];
			board[x][y] = 0;
			int temp = board[x-1][y];
			board[x-1][y] = -1;
			count4 = count4+1+jump(board,x-2,y);
			board[x][y] = board[x-2][y];
			board[x-2][y] = 0;
			board[x-1][y] = temp;
		}
		return Math.max(Math.max(count1,count2),Math.max(count3,count4));
	}
}