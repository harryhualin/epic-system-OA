/*
 * N*N matrix is given with input red or black.You can move horizontally, 
 * vertically or diagonally. If 3 consecutive same color found, that color 
 * will get 1 point. So if 4 red are vertically then point is 2. Find the winner.
 */

public class ticTacTow{
	public static void main(String[] args){
		char[][] matrix = { 
			{ 'r', 'r', 'r', 'b' }, 
			{ 'b', 'r', 'b', 'r' },
			{ 'b', 'r', 'r', 'b' }, 
			{ 'b', 'r', 'b', 'b' } 
		};
		game(matrix);
	}

	public static void game(char[][] map){
		int score_red = check(map,'r');
		int score_black = check(map,'b');
		if(score_red>score_black){
			System.out.println("Red wins!");
		}else{
			System.out.println("Black wins!");
		}
	}

	public static int check(char[][] map, char c){
		int count = 0;
		//horizontally
		for(int i=0;i<map.length;i++){
			for(int j=0;j<map[0].length-2;j++){
				if(map[i][j] == c && map[i][j+1] == c && map[i][j+2] == c){
					count++;
				}
			}
		}
		//vertically
		for(int j=0;j<map[0].length;j++){
			for(int i=0;i<map.length-2;i++){
				if(map[i][j] == c && map[i+1][j] == c && map[i+2][j] == c){
					count++;
				}
			}
		}
		//top left to bottom right
		for(int i=0;i<map.length-2;i++){
			for(int j=0;j<map[0].length-2;j++){
				if(map[i][j] == c && map[i+1][j+1] == c && map[i+2][j+2] == c){
					count++;
				}
			}
		}
		//top right to bottom left
		for(int i=0;i<map.length-2;i++){
			for(int j=map[0].length-1;j>=2;j--){
				if(map[i][j] == c && map[i+1][j-1] == c && map[i+2][j-2] == c){
					count++;
				}
			}
		}
		return count;
	}
}