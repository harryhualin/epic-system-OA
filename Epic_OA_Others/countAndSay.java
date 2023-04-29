import java.util.*;
/*
 * First,let user input a number, say 1. Then, the function will 
 * generate the next 10 numbers which satisfy this condition: 
 * 1,11,21,1211,111221,312211... 
 * explanation: first number 1, second number is one 1, so 11. 
 * Third number is two1(previous number), so 21. next number one 
 * 2 one 1, so 1211 and so on...
 */

public class countAndSay{

	public static void main(String[] args){
		count("2");
	}

	public static void count(String number){
		String num = String.valueOf(number);
		List<String> res = new ArrayList<String>();
		res.add(num);
		String currs = "";
		char curr = num.charAt(0);
		for(int k=0;k<9;k++){
			curr = num.charAt(0);
			int count = 1;
			for(int i=1;i<num.length();i++){
				if(num.charAt(i)==curr){
					count++;
				}else{
					currs = currs+count+curr;
					curr = num.charAt(i);
					count = 1;
				}
			}
			currs = currs+count+curr;
			res.add(currs);
			num = currs;
			currs = "";
		}
		System.out.println(res);
}
}