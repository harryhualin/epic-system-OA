/*
 * Addictive Number
 * 
 * Problem:Additive numbers are defined to be a positive 
 * integer whose digits form an additive sequence. 
 * E.g. 11235 (1+1=2, 1+2=3, 2+3=5). What makes it difficult
 * is that 12,122,436 is also one (12+12=24, 12+24=36). 
 * Given a range of integers, find all the additive 
 * numbers in that range.
 */

public class addictiveNumber{
	public static void main(String[] args){
		if(isAddictive("11235")) System.out.println("Valid!");
		if(isAddictive("12122436")) System.out.println("Valid!");
		if(isAddictive("12234246")) System.out.println("Valid!");
		else System.out.println("Invalid!");
	}

	public static boolean isAddictive(String s){
		//search for all combination of the first numbers and continue add until length > s
		for(int i=1;i<s.length();i++){
			for(int j=i+1;j<s.length();j++){
				String s1 = s.substring(0,i);
				String s2 = s.substring(i,j);
				int length = s1.length()+s2.length();
				int last1 = Integer.parseInt(s1);
				int last2 = Integer.parseInt(s2);
				int next = last1+last2;
				String nexts = String.valueOf(next);
				String now = s1+s2+nexts;
				length += nexts.length();
				while(length < s.length()){
					last1 = last2;
					last2 = next;
					next = last1+last2;
					nexts = String.valueOf(next);
					now += nexts;
					length = now.length();
				}
				if(now.equals(s)){
					return true;
				}
			}
		}
		return false;
	}
}