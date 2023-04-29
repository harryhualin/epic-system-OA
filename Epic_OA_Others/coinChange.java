import java.util.*;

/*
 * Something cost $10.25 and the customer pays with a $20 bill, the 
 * program will print out the most efficient "change-breakdown" which 
 * is 1 five, 4 ones, and 3quarters. Find the minimum number of coins 
 * required to make change for a given sum (given unlimited number of N 
 * different denominations coin)
 */

public class coinChange{
	public static void main(String[] args){
		changeCoins(20,12);
	}

	public static void change(int bill, double cost){
		//be careful about the critical situations
		int[] coins = {1, 5, 10, 25, 100, 400, 500};
		int len = (int)(bill-cost)*100;
		int[] dp = new int[len+1];
		Arrays.fill(dp,0);
		for(int i=1;i<=len;i++){
			int min = Integer.MAX_VALUE;
			for(int j=0;j<coins.length;j++){
				if(coins[j] <= i){
					min = Math.min(dp[i-coins[j]]+1,min);
				}
			}
			dp[i] = min;
		}
		System.out.println(dp[len]);
	}

	public static void changeCoins(int bill, double cost){
		double[] coins = {5.0, 4.0, 1.0, 0.25, 0.1, 0.05, 0.01};
		double change =  bill - cost;
		List<String> res = new ArrayList<String>();
		int pos = 0;
		while(change>0 && pos<=coins.length){
			int count = (int)(change/coins[pos]);
			if(count>0){
				change = change - (int)(change/coins[pos])*coins[pos];
				res.add(""+count+" "+coins[pos]);
			}
			pos++;
		}
		System.out.println(res);
	}
}