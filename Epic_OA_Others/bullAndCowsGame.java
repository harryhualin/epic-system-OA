import java.util.*;
/*
 * There’s a word guessing game. One person think a word, and the other 
 * one guess a word, both words have the same length.The person should 
 * return the number of bulls and cows for the guessing. Bulls represent 
 * the number of same characters in the same spots, whereas cows represent 
 * the number of characters guessed right but in the wrong spots. Write a 
 * program with two input strings, return the number of bulls and cows.
 */

public class bullAndCowsGame{
	public static void main(String[] args){
		String str1 = "dusts";
		String str2 = "studs";
		game(str1,str2);
	}

	public static void game(String guess, String code){
		int bulls = 0, cows = 0;
		if(guess.length() != code.length()){
			System.out.println("Wrong input, not same length!");
			return;
		}
		for(int i=0;i<code.length();i++){
			if(guess.charAt(i) == code.charAt(i)){
				bulls++;
			}
		}
		char[] code_left = new char[code.length()-bulls];
		char[] guess_left = new char[code.length()-bulls];
		int pos =0;
		for(int i=0;i<code.length();i++){
			if(guess.charAt(i) != code.charAt(i)){
				code_left[pos] = code.charAt(i);
				guess_left[pos] = guess.charAt(i);
				pos++;
			}
		}
		Arrays.sort(code_left);
		Arrays.sort(guess_left);
		for(int i=0;i<code_left.length;i++){
			for(int j=0;j<guess_left.length;j++){
				if(code_left[i] == guess_left[j]){
					guess_left[j] = '*';
					cows++;
				}
			}
		}
		System.out.println("Bulls: "+bulls+" Cows: "+cows);
	}
}