/*
 * In 1-9 keypad one key is not working. If someone enters a password 
 * then not working key will not be entered. You have given expected 
 * password and entered password. Check that entered password is valid 
 * or not. Ex: entered 164, expected 18684 (you need to take care as 
 * when u enter 18684 and 164 only both will be taken as 164 input)
 */

public class validPassword{

	public static void main(String[] agrs){
		check("18684","164");
	}

	public static void check(String expected, String entered){
		char key = '8'; //assume the fail key is 8, can also determine which key is bad by find the first miss
		int pos1=0, pos2=0;
		boolean res = true;
		while(pos1<expected.length() && pos2<entered.length()){
			if(expected.charAt(pos1)==key){
				pos1++;
			}else{
				if(expected.charAt(pos1) != entered.charAt(pos2)){
					res = false;
					break;
				}else{
					pos1++;
					pos2++;
				}
			}
		}
		if(pos2 != entered.length() || pos1 != expected.length()){
			res = false;
		}
		if(res){
			System.out.println("Pass!");
		}else{
			System.out.println("Fail!");
		}
	}

}