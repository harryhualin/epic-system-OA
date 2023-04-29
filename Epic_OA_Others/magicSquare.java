/*
 * A magic square of order n is an arrangement of the numbers from 1 to n^2 
 * in an n by n matrix with each number occurring exactly once so that each row, 
 * each column and each main diagonal has the same sum. The n should be an odd 
 * number. In the middle cell of the top row, fill number 1.Then go to above 
 * row and right column, and fill following number 2. If it’s out of boundary, 
 * go to the opposite row or column. If the next cell is already occupied, go 
 * to the cell below this cell and fill following number. An example 
 * of 5*5 grid is like this for the first 9 numbers:
 * 0 0 1 8 0
 * 0 5 7 0 0
 * 4 6 0 0 0
 * 0 0 0 0 3
 * 0 0 0 2 9
 */

public class magicSquare{
	//start from position(n/2,n)
	//next position is (x-1,y+1)
	//if occupied (x-2)(y+1)
	//if x==-1 then x=n-1
	//if y==n then y=0
	public static void main(String[] args){
		fill(5);
	}

	public static void fill(int n){
		int[][] map = new int[n][n];
		if(n<=0 || n%2 == 0){
			System.out.println("Wrong input!");
			return;
		}
		int x = n/2, y = n-1;
		for(int i=1;i<=n*n;i++){
			if(x==-1){
				x=n-1;
			}
			if(y==n){
				y=0;
			}
			if(map[x][y] != 0){
				x -= 1;
				if(x==-1){
					x = n-1;
				}
				map[x][y] = i;
				x--; // compute for the next round
				y++;
			}else{
				map[x][y] = i;
				x--; // compute for the next round
				y++;
			}
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(map[i][j]+",");
			}
			System.out.println();
		}
	}
}