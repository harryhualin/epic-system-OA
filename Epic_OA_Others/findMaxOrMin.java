import java.util.Scanner;
/*
 * Take a series of integers as input till a zero is entered. 
 * Among these given integers, find the maximum of the odd numbers and 
 * the minimum of the even integers (not including zero) and print them.
 */

public class findMaxOrMin{
	public static void main(String[] args){
		find();
	}

	public static void find(){
		int maxOdd=Integer.MIN_VALUE, minEven=Integer.MAX_VALUE;
		Scanner in = new Scanner(System.in);
		while(in.hasNextInt()){
			int curr = in.nextInt();
			if(curr == 0) break;
			if(curr%2==0){
				minEven = Math.min(minEven, curr);
			}else{
				maxOdd = Math.max(maxOdd, curr);
			}
		}
		System.out.println("minEven: " + minEven);
		System.out.println("maxOdd: " + maxOdd);
		in.close();
	}
}