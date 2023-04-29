import java.util.*;
/*
 * Given a string that has{},[],() and characters.Check if the string is 
 * balanced. E.g. {a[(b)]} is balanced. {a[(b])} is unbalanced.
 */

public class balancedString{
	public static void main(String[] args){
		String s = "{a[(b])}";
		String s1 = "{a[(b)]}";
		check(s);
		check(s1);
	}

	public static void check(String input){
		Stack<Character> stack = new Stack<Character>();
		for(int i=0;i<input.length();i++){
			char curr = input.charAt(i);
			if(isValid(curr)){
				if(isLeft(curr)){
					stack.push(curr);
				}else{
					if(!stack.isEmpty()){
						char last = stack.pop();
						if(isMatched(last,curr)){
							continue;
						}else{
							System.out.println("Unbalanced!");
							return;
						}
					}else{
						System.out.println("Unbalanced!");
						return;
					}
				}
			}
		}
		//should check if the stack is empty
		if(!stack.isEmpty()){
			System.out.println("Unbalanced!");
			return;
		}
		System.out.println("Balanced!");
	}

	public static boolean isMatched(char c1, char c2){
		if((c1=='{' && c2=='}') || (c1=='[' && c2==']') || (c1=='(' && c2==')')){
			return true;
		}else{
			return false;
		}
	}

	public static boolean isValid(char c){
		if(c == '{' || c == '}' || c == '[' || c == ']' || c == '(' || c == ')'){
			return true;
		}else{
			return false;
		}
	}

	public static boolean isLeft(char c){
		if(c == '{' || c == '[' || c == '('){
			return true;
		}else{
			return false;
		}
	}

	public static boolean isRight(char c){
		if(c == '}' || c == ']' || c == ')'){
			return true;
		}else{
			return false;
		}
	}
}