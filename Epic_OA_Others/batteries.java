import java.util.*;
/*
 * http://blog.csdn.net/lsdtc1225/article/details/39949367
 * 问题14：
 * 电池有6节包装，9节包装，20节包装三种，input需要多少节电池，
 * 如果可以刚好用3种包装的凑到这个数，就输出这个解， 忘了是不是要输出所有的解。
 * e.g 输入20， 答{20} 输入17 答没有 输入18，那可能是{6,6,6}也可能是{9,9}。 
 * 有点像找钱的问题，似乎是从集合中找到所有集合值等于一个target这个题的简化版，因为集合只有6 9 20。
 * 如果是要求输出所有可能：DFS
 */

public class batteries{
	public static void main(String[] args){
		check(18);
	}

	public static void check(int input){
		int[] batteries = {6,9,20};
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> curr = new ArrayList<Integer>();
		find(res, batteries, curr, input);
		if(res.size()>0){
			System.out.println(res);
		}else{
			System.out.println("No solution!");
		}
		
	}

	public static void find(List<List<Integer>> res, int[] batteries, List<Integer> curr, int input){
		if(input<0){
			return;
		}
		if(input == 0){
			res.add(new ArrayList<Integer>(curr)); // be very careful here
			return;
		}
		for(int i=0;i<batteries.length;i++){
			curr.add(batteries[i]);
			find(res,batteries,curr,input-batteries[i]);
			curr.remove(curr.size()-1);
		}
		// for(int i=0;i<batteries.length;i++){
		// 	if(input<batteries[i]) return;
		// 	if(input == batteries[i]){
		// 		curr.add(batteries[i]);
		// 		res.add(new ArrayList<Integer>(curr));
		// 		curr.remove(curr.size()-1);
		// 	}else{
		// 		curr.add(batteries[i]);
		// 		find(res, batteries,curr,input-batteries[i]);
		// 		curr.remove(curr.size()-1);
		// 	}
		// }
	}

	

	// public static void check(int input){
	// 	int[][] map = new int[4][input+1];
	// 	int[] batteries = {0,6,9,20};
	// 	for(int i=0;i<=input;i++){
	// 		map[0][i] = 0;
	// 	}
	// 	for(int j=0;j<4;j++){
	// 		map[j][0] = 0;
	// 	}
	// 	for(int i=1;i<4;i++){
	// 		for(int j=1;j<=input;j++){
	// 			if(j==batteries[i]){
	// 				map[i][j] = 1;
	// 			}else{
	// 				if(j<batteries[i]){
	// 					map[i][j] = 0;
	// 				}else{
	// 					map[i][j] = Math.min(map[i][j-batteries[i]]+1,map[i][j-1]);
	// 				}
	// 			}
				
	// 		}
	// 	}
	// 	System.out.println(map[3][input]);
	// }
}