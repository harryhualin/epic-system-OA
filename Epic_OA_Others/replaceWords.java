import java.util.*;
/*
 * Given a string. Replace the words whose length>=4 and is even, 
 * with a space between the two equal halves of the word. Consider 
 * only alphabets for finding the evenness of the word 
 * I/P "A person can't walk in this street" 
 * O/P "A per son ca n't wa lk in th is str eet"
 */

public class replaceWords{
	public static void main(String[] agrs){
		String test = "A person can't walk in this street";
		replace(test);
	}

	public static void replace(String input){
		String[] list = input.split(" ");
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<list.length;i++){
			sb.append(handle(list[i])+" ");
		}
		System.out.println(sb.toString());
	}

	public static String handle(String input){
		int count = 0;
		char[] list = input.toCharArray();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<list.length;i++){
			if(Character.isAlphabetic(list[i])){
				count++;
			}
		}
		if(count>=4 && count%2==0){
			for(int i=0;i<list.length;i++){
				sb.append(list[i]);
				if(i+1==count/2){
					sb.append(" ");
				}
			}
			return sb.toString();
		}else{
			return input;
		}
	}


}