import java.util.*;
/*
 * You know a password is well-ordered string. 
 * Well-ordered string means that the order of the 
 * characters is in an alphabetical increasing order.
 * Like abEm is a well-ordered number. However,
 * abmE is not a well-order number. Given an input # that 
 * tells you also how many digits are in the password, 
 * print all possible passwords.
 */

public class wellOrderedString{
	//recursive method
	public static void main(String[] args){
		generate(3);
	}

	public static void generate(int num){
		List<String> res = new ArrayList<String>();
		generate(0,num,res,"");
		for(String s:res){
			System.out.print(s+",");
		}
	}

	public static void generate(int pos, int num, List<String> res, String pre){
		if(num == 0){
			res.add(pre);
			return;
		}
		for(int i=pos;i<26;i++){
			generate(i+1,num-1,res,pre+(char)('a'+i));
			generate(i+1,num-1,res,pre+(char)('A'+i));
		}
	}
}