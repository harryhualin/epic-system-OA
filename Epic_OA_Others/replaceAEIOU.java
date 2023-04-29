import java.util.*;
/*
 * Replace a,e,i,o,u with A,E,I,O,U.
 * At most four eligible letters from the rear of the string are replaced.
 * The first three eligible letters in the string are always exempted 
 * from replacement.
 */

public class replaceAEIOU{
	public static void main(String[] args){
		String test = "abebobaaaeioup";
		replace(test);
	}

	public static void replace(String input){
		char[] list = input.toCharArray();
		int count = 0;
		int pos = 0;
		for(int i=0;i<list.length;i++){
			if(list[i]=='a' || list[i] =='e' || list[i] =='i' || list[i] =='o' || list[i] == 'u'){
				count++;
			}
			if(count>=3){ // omit the first three
				pos = i;
				break;
			}
		}
		if(pos==list.length-1) {System.out.println(input);return;}
		count = 0;
		for(int i=list.length-1;i>pos;i--){
			if(list[i]=='a' || list[i] =='e' || list[i] =='i' || list[i] =='o' || list[i] == 'u'){
				list[i] +='A'-'a';
				count++;
			}
			if(count>=4) break; //no more than 4
		}
		System.out.println(Arrays.toString(list));
	}
}