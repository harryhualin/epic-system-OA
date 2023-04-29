import java.util.*;
/*
 * Let the user enter a decimal number. The range allowed is 0.0001 to 0.9999.
 * Only four decimal places are allowed. The output should be an irreducible 
 * fraction. E.g.: If the user enters 0.35,the irreducible fraction will be 7/20.
 */

public class decimalNumber{
	public static void main(String[] args){
		transform();
	}

	public static void transform(){
		Scanner in = new Scanner(System.in);
		double num = in.nextDouble();
		String temp = String.valueOf(num);
		char[] list = temp.toCharArray();
		char[] list_valid = new char[6];
		for(int i=0;i<list_valid.length && i<list.length;i++){
			list_valid[i] = list[i];
		}
		//double n = Double.parseDouble(Arrays.toString(list_valid));
		String number = String.valueOf(list_valid);
		double d = Double.parseDouble(number);
		int up = (int)(d*10000); // careful, (int) will valid on the next symbol
		int gcd = GCD(10000,up); 
		System.out.println((up/gcd)+"/"+(10000/gcd));
	}

	public static int GCD(int a, int b){
		if(a<b){
			int temp = a;
			a = b;
			b = temp;
		}
		if(a%b==0){
			return b;
		}else{
			return GCD(b,a%b);
		}
	}
}